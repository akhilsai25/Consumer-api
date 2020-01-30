package org.consumer.utility;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import org.consumer.factory.RestTemplateFactory;
import org.consumer.model.CommunityWiseIncome;
import org.consumer.utility.exceptions.ConnectionException;
import org.consumer.utility.workers.HighPerCapitaCalculator;
import org.consumer.utility.workers.LowPerCapitaCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;

public class UtilityImplementation implements Utility{

    private Subject<CommunityWiseIncome[]> messages;
    public static ConcurrentHashMap<String,Integer> community = new ConcurrentHashMap<>();

    public UtilityImplementation(){
        messages = PublishSubject.create();
        messages.buffer(10, TimeUnit.SECONDS,1).subscribe(this::addMaps);
    }

    private void addMaps(List<CommunityWiseIncome[]> responseEntities) {

        CommunityWiseIncome[] temp=responseEntities.get(0);
        System.out.println(temp[1].getCommunity_area_name());
        for(CommunityWiseIncome c:temp){
            community.put(c.getCommunity_area_name(),c.getPer_capita_income_());
        }
    }

    @Override
    public void performWork()  {
        RestTemplate restTemplate = RestTemplateFactory.INSTANCE.getInstance();
        String url = "https://data.cityofchicago.org/resource/kn9c-c2s2.json?$select=community_area_name,per_capita_income_";
        try {
            CommunityWiseIncome[] responseEntity = restTemplate.getForObject(url, CommunityWiseIncome[].class);
        }
        catch(Exception c){
            throw new ConnectionException("Connection not established");
        }
        messages.onNext(restTemplate.getForObject(url, CommunityWiseIncome[].class));

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(new HighPerCapitaCalculator());
        executorService.submit(new LowPerCapitaCalculator());
        executorService.shutdown();
    }

}

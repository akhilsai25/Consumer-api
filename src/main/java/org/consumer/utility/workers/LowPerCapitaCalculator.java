package org.consumer.utility.workers;

import org.consumer.utility.UtilityImplementation;

import java.util.concurrent.ConcurrentHashMap;

public class LowPerCapitaCalculator implements Runnable{

    public static ConcurrentHashMap<String,Integer> lowcomm=new ConcurrentHashMap();
    @Override
    public void run() {

        UtilityImplementation.community.entrySet().stream().filter(e -> e.getValue() < 31000).forEach(e->lowcomm.put(e.getKey(),e.getValue()));
        System.out.println("Communities with per-capita income less than chicago's average per-capita");
        System.out.println(LowPerCapitaCalculator.lowcomm);
    }
}

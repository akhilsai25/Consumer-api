package org.consumer.utility.workers;

import org.consumer.utility.UtilityImplementation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighPerCapitaCalculator implements Runnable{

    public static ConcurrentHashMap<String,Integer> highcomm=new ConcurrentHashMap();
    @Override
    public void run() {
        UtilityImplementation.community.entrySet().stream().filter(e -> e.getValue() > 31000).forEach(e->highcomm.put(e.getKey(),e.getValue()));
        System.out.println("Communities with per-capita income greater than chicago's average per-capita");
        System.out.println(HighPerCapitaCalculator.highcomm);
    }
}

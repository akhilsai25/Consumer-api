package org.consumer;

import org.consumer.factory.RestTemplateFactory;
import org.consumer.utility.Utility;
import org.consumer.utility.UtilityImplementation;
import org.springframework.web.client.RestTemplate;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Utility utility = new UtilityImplementation();
        utility.performWork();
    }
}

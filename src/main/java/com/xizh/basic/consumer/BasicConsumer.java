package com.xizh.basic.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.xizh.basic.Basic;

@Component
public class BasicConsumer {
    
    //
    @KafkaListener(topics = "${kafka.topic.basictopic}", containerFactory = "basicKafkaListenerContainerFactory")
    public void recive(Basic basic) {
        System.out.println(basic.toString());
    }
}

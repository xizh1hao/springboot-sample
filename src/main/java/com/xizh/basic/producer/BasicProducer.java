package com.xizh.basic.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.xizh.basic.Basic;

@Component
public class BasicProducer {

    @Autowired
    @Qualifier("basicKafkaTemplate")
    private KafkaTemplate<String, Basic> kafkaTemplate;
    
    public void sender(String topic, Basic basic) {
        kafkaTemplate.send(topic, basic);
    }
    
}

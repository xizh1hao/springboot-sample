package com.xizh.advanced.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * 新加入的groupid可以通过设置offset来设置读取位置
 * 已经加入的会抛异常
 * @author xizh
 * @date: 2018年3月28日 下午3:45:47
 */
@Component
public class AdvancedConsumer {

    @KafkaListener(topics = "${kafka.topic.advancedtopic}", containerFactory = "advancedKafkaListenerContainerFactory")
    public void receive(@Payload String payload, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(String.format("From partition %d : %s", partition, payload));
    }


    @KafkaListener(containerFactory = "advancedKafkaListenerContainerFactory",
                    topicPartitions = @TopicPartition(topic = "${kafka.topic.advancedtopic}",
                   partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0")))
    public void receiveFromBegin(@Payload String payload, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println(String.format("Read all message from partition %d : %s", partition, payload));
    }

}

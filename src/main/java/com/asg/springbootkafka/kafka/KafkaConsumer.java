package com.asg.springbootkafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = Logger.getLogger(KafkaConsumer.class.getName());
    @KafkaListener(topics = "topic", groupId = "${kafka-consumer-group}")
    public void consume(String message) {
        LOGGER.info(String.format("#### -> Consumed message -> %s", message));
    }
}

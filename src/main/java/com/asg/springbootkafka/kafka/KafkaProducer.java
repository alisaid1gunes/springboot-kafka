package com.asg.springbootkafka.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = Logger.getLogger(KafkaProducer.class.getName());
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send("topic", message);
    }
}

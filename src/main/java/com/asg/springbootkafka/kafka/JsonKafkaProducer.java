package com.asg.springbootkafka.kafka;

import com.asg.springbootkafka.payload.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = Logger.getLogger(JsonKafkaProducer.class.getName());
    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        LOGGER.info(String.format("#### -> Producing message -> %s", user));
        Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "topic_json").build();
        this.kafkaTemplate.send(message);
    }
}

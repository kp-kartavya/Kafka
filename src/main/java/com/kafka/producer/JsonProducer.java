package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.payload.User;

@Service
public class JsonProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	@Value("${spring.kafka.json.topic.name}")
	private String jsonTopic;

	public void sendMessage(User data) {
		LOGGER.info(String.format("Message sent :: %s", data.toString()));
		Message<User> msg = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, jsonTopic).build();
		kafkaTemplate.send(msg);
	}
}

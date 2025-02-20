package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.payload.User;

@Service
public class JsonConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumer.class);

	@KafkaListener(topics = "${spring.kafka.json.topic.name}", groupId = "GroupKP")
	public void consume(User user) {
		LOGGER.info(String.format("Json Message Received :: %s", user.toString()));
	}
}

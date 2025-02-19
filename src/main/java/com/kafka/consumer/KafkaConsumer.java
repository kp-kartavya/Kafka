package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	@KafkaListener(topics = "Kartavya-Topic-1", groupId = "GroupKP")
	public void consume(String msg) {
		LOGGER.info(String.format("Message Received :: %s", msg));
	}
}

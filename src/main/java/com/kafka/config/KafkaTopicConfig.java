package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	@Value("${spring.kafka.topic.name}")
	private String topic;
	@Value("${spring.kafka.json.topic.name}")
	private String jsonTopic;

	@Bean
	NewTopic myFirstTopic() {
		return TopicBuilder.name(topic)
//              .partitions(10)
//              .replicas(1)
				.build();
	}

	@Bean
	NewTopic jsonTopic() {
		return TopicBuilder.name(jsonTopic)
//              .partitions(10)
//              .replicas(1)
				.build();
	}
}
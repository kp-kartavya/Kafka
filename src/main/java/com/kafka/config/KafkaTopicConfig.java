package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
	@Bean
	NewTopic myFirstTopic() {
		return TopicBuilder.name("Kartavya-Topic-1")
//              .partitions(10)
//              .replicas(1)
				.build();
	}
}
package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.payload.User;
import com.kafka.producer.JsonProducer;
import com.kafka.producer.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/v1/kafka/")
public class KafkaController {
	@Autowired
	private KafkaProducer kProducer;
	@Autowired
	private JsonProducer jProducer;

	@GetMapping("publish")
	public ResponseEntity<String> publish(@RequestParam String msg) {
		kProducer.sendMessage(msg);
		return ResponseEntity.ok("Message Sent to the Topic");
	}

	@PostMapping("publish")
	public ResponseEntity<String> postMethodName(@RequestBody User user) {
		jProducer.sendMessage(user);
		return ResponseEntity.ok("Message Sent to Kafka Topic");
	}

}

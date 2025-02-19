package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/v1/kafka/")
public class KafkaController {
	@Autowired
	private KafkaProducer kProducer;

	@GetMapping("publish")
	public ResponseEntity<String> publish(@RequestParam String msg) {
		kProducer.sendMessage(msg);
		return ResponseEntity.ok("Message Sent to the Topic");
	}

}

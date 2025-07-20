package com.example.batch.KafkaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.batch.KafkaService.KafkaProducerService;
import com.example.batch.dto.Producer;

@RestController
public class KafkaProducerController {
	
	@Autowired
	KafkaProducerService service;
	
	
	
	
	@RequestMapping("/kafkaProducer")
	public String sendMessage(@RequestBody String msg) throws Exception {
		for(int i=0;i<10000;i++) {
		service.sendMsgToTopic(msg);
		}
		
		return "success";
	}
	
	@RequestMapping("/kafkaProducerWithCustomClass")
	public String sendMessage(@RequestBody Producer msg) throws Exception {
		
		service.sendMsgToTopicWithCustomClass(msg);
		service.sendMsgToTopicWithCustomClassForId(msg);
		service.sendMsgToTopicWithCustomClassForName(msg);
		
		return "success";
	}

}

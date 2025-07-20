package com.example.batch.KafkaService;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.example.batch.config.KafkaTopicConfiguration;
import com.example.batch.dto.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProducerService {
	
	@Autowired
	public KafkaTemplate<String,Object> template;
	
	@Autowired
	KafkaTopicConfiguration config;
	
	public void sendMsgToTopic(String msg) throws Exception{
		//config.createTopic("new-topic-3", 2, (short)2);
	CompletableFuture<SendResult<String, Object>> s=template.send("new-topic-3",msg);
	s.whenComplete((result,exception) ->{
		if(exception==null) {
			System.out.println("Message is sent to topic successfully with offset"+result.getRecordMetadata().offset());
			ObjectMapper objmap = new ObjectMapper();
			try {
				
				System.out.println(objmap.writeValueAsString(result.getRecordMetadata().toString()));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("message is not sent because::"+exception.getMessage());
		}
	});
	
	}
	
	public void sendMsgToTopicWithCustomClass(Producer msg) throws Exception{
		//config.createTopic("new-topic-3", 2, (short)2);
	CompletableFuture<SendResult<String, Object>> s=template.send("new-topic-custom",0,null,msg);
	s.whenComplete((result,exception) ->{
		if(exception==null) {
			System.out.println("Message is sent to topic successfully with offset"+result.getRecordMetadata().offset()+" with request ::"+msg.toString());
			ObjectMapper objmap = new ObjectMapper();
			try {
				
				System.out.println(objmap.writeValueAsString(result.getRecordMetadata().toString()));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("message is not sent because::"+exception.getMessage());
		}
	});
	
	}
	public void sendMsgToTopicWithCustomClassForId(Producer msg) throws Exception{
		//config.createTopic("new-topic-3", 2, (short)2);
	CompletableFuture<SendResult<String, Object>> s=template.send("new-topic-custom",1,null,msg);
	s.whenComplete((result,exception) ->{
		if(exception==null) {
			System.out.println("Message is sent to topic successfully with offset"+result.getRecordMetadata().offset()+" with request ::"+msg.toString());
			ObjectMapper objmap = new ObjectMapper();
			try {
				
				System.out.println(objmap.writeValueAsString(result.getRecordMetadata().toString()));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("message is not sent because::"+exception.getMessage());
		}
	});
	
	}
	public void sendMsgToTopicWithCustomClassForName(Producer msg) throws Exception{
		//config.createTopic("new-topic-3", 2, (short)2);
	CompletableFuture<SendResult<String, Object>> s=template.send("new-topic-custom",2,null,msg);
	s.whenComplete((result,exception) ->{
		if(exception==null) {
			System.out.println("Message is sent to topic successfully with offset"+result.getRecordMetadata().offset()+" with request ::"+msg.toString());
			ObjectMapper objmap = new ObjectMapper();
			try {
				
				System.out.println(objmap.writeValueAsString(result.getRecordMetadata().toString()));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("message is not sent because::"+exception.getMessage());
		}
	});
	
	}

}

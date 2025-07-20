package com.example.batch.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import com.example.batch.dto.Producer;

@Service
public class ConsumerService {
	
	@KafkaListener(topics ="new-topic-3",groupId = "g-1",topicPartitions= {@TopicPartition(topic="new-topic-custom",partitions= {"2"}) })
	public void getMessage(String message) {
		System.out.println("received msg is::"+message);
	}
	@KafkaListener(topics ="new-topic-3",groupId = "g-1")
	public void getMessage1(String message) {
		System.out.println("received msg is 1::"+message);
	}
	
	@KafkaListener(topics ="new-topic-custom",groupId = "g-2",topicPartitions= {@TopicPartition(topic="new-topic-custom",partitions= {"2"}) })
	public void getMessageWithCustomClass(Producer message) {
		System.out.println("received msg with custom class name is::"+message.name);
	}
	@KafkaListener(topics ="new-topic-custom",groupId = "g-2",topicPartitions= {@TopicPartition(topic="new-topic-custom",partitions= {"1"}) })
	public void getMessageWithCustomClassForId(Producer message) {
		System.out.println("received msg with custom class Id is::"+message.Id);
	}
	
	@KafkaListener(topics ="new-topic-custom",groupId = "g-2",topicPartitions= {@TopicPartition(topic="new-topic-custom",partitions= {"0"}) })
	public void getMessageWithCustomClassForBoth(Producer message) {
		System.out.println("received msg with custom class both is::"+message.Id);
		System.out.println("received msg with custom class both is::"+message.name);
	}

}

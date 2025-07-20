package com.example.batch.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaTopicConfiguration {
	
	@Bean
	public NewTopic createTopic() {
		System.out.println("creating the topic");
		NewTopic nt = new  NewTopic("new-topic-custom",3,(short) 1);
		System.out.println(nt.numPartitions());
		System.out.println(nt.numPartitions());
		return nt;
	}
	
	@Bean
	public Map<String,Object> putConfigurations(){
		Map<String,Object> configs = new HashMap<String,Object>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		return configs;

	}
	
	@Bean
	public ProducerFactory<String,Object> producerConfig(){
		
		return new DefaultKafkaProducerFactory<>(putConfigurations());
		
	}
	@Bean
	public KafkaTemplate<String,Object> kafkaTemplate(){
		return new KafkaTemplate<>(producerConfig());
	}
	

}

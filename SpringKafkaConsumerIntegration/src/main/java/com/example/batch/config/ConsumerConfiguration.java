package com.example.batch.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class ConsumerConfiguration {
	
	@Bean
	public Map<String,Object> putConfigurations(){
		Map<String,Object> configs = new HashMap<String,Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
		configs.put(JsonDeserializer.TRUSTED_PACKAGES,"*");

		return configs;

	}
	
	@Bean
	public ConsumerFactory<String,Object> consumerConfig(){
		
		return new DefaultKafkaConsumerFactory<>(putConfigurations());
		
	}
	
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String,Object> list = new ConcurrentKafkaListenerContainerFactory<>();
		list.setConsumerFactory(consumerConfig());
		return list;
	}

}

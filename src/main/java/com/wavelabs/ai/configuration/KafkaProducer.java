package com.wavelabs.ai.configuration;

import java.util.HashMap;
import java.util.Map;

import com.wavelabs.ai.model.MarketData;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * The type Kafka producer.
 */
@Configuration
public class KafkaProducer {

	/**
	 * Gets producer properties.
	 *
	 * @return the producer properties
	 */
	@Bean
	public static ProducerFactory<String, MarketData> getProducerProperties() {

		Map<String, Object> props = new HashMap<>();

		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, "300");
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, "900000");
		props.put(ProducerConfig.ACKS_CONFIG, "1");
		props.put(ProducerConfig.RETRIES_CONFIG, "3");

		return new DefaultKafkaProducerFactory<String, MarketData>(props);

	}

	/**
	 * Kafka template kafka template.
	 *
	 * @return the kafka template
	 */
	@Bean
	public static KafkaTemplate<String, MarketData> kafkaTemplate() {
		return new KafkaTemplate<String, MarketData>(getProducerProperties());
	}

}

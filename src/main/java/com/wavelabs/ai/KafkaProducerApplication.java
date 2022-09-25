package com.wavelabs.ai;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The type Kafka producer application.
 */
@EnableScheduling
@SpringBootApplication
public class KafkaProducerApplication {
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {

		SpringApplication.run(KafkaProducerApplication.class, args);
	}
}

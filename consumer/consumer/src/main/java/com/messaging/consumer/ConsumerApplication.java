package com.messaging.consumer;

import com.messaging.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}


	@Bean
	public Consumer<Student> consume() {
		System.out.println("received");
		return student -> System.out.println("student "+student);
	}

}

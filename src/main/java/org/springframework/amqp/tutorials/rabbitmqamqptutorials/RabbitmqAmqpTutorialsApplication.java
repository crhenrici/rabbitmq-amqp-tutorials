package org.springframework.amqp.tutorials.rabbitmqamqptutorials;

import org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1.RabbitAmqpTutorialRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqAmqpTutorialsApplication {

	@Profile("usage_message")
	@Bean
	public CommandLineRunner usage() {
		return args -> {
			System.out.println("This app uses Spring profiles to" +
					"control its behaviour\n");
			System.out.println("Sample usage: java -jar rabbit-tutorials.jar" +
					"--spring.profiles.active=hello-world,sender");
		};
	}

	@Profile("!usage_message")
	@Bean
	public CommandLineRunner tutorial() {
		return new RabbitAmqpTutorialRunner();
	}

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqAmqpTutorialsApplication.class, args);
	}

}

package gg.code.projectrabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ProjectrabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectrabbitApplication.class, args);
	}

}

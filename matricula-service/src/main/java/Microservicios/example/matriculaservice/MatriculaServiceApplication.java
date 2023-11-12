package Microservicios.example.matriculaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MatriculaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatriculaServiceApplication.class, args);
	}

}

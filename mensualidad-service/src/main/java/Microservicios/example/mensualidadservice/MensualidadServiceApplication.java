package Microservicios.example.mensualidadservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MensualidadServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MensualidadServiceApplication.class, args);
	}

}

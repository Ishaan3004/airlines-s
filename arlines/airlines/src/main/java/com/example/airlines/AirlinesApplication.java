package com.example.airlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@SpringBootApplication
@RestController
public class AirlinesApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirlinesApplication.class, args);
	}
	@GetMapping("/hello")
	public Mono<String> getData() {
		WebClient webClient = WebClient.create();
		String apiUrl = "http://api.aviationstack.com/v1/airlines?access_key=82cc11043b4979aa8762da7d347c03e8";
		Mono<String> response;
		response = webClient.get().uri(apiUrl).retrieve().bodyToMono(String.class);
		return response;
	}


}



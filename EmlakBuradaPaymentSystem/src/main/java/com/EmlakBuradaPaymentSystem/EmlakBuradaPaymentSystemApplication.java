package com.EmlakBuradaPaymentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.core.mapping.Document;

@SpringBootApplication
public class EmlakBuradaPaymentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakBuradaPaymentSystemApplication.class, args);

	}
}

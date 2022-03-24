package com.AdvertStatus;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class EmlakBuradaAdvertStatusApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakBuradaAdvertStatusApplication.class, args);
	}

}

package com.ewangclarks.orderservice;

import com.ewangclarks.orderservice.common.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:${user.dir}/.env")
@Import({ AxonConfig.class })
public class OrderserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}

}

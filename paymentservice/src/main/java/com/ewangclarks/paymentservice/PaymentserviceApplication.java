package com.ewangclarks.paymentservice;

import com.ewangclarks.paymentservice.core.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:${user.dir}/.env")
@Import({ AxonConfig.class })
public class PaymentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentserviceApplication.class, args);
	}

}

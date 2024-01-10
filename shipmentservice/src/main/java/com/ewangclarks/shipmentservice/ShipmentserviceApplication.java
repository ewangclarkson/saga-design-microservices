package com.ewangclarks.shipmentservice;

import com.ewangclarks.shipmentservice.core.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:${user.dir}/.env")
@Import({ AxonConfig.class })
public class ShipmentserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShipmentserviceApplication.class, args);
	}

}

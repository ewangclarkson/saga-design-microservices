package com.ewangclarks.userservice;

import com.ewangclarks.userservice.common.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("file:${user.dir}/.env")
@Import({ AxonConfig.class })
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}

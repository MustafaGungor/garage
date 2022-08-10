package com.vodafone.garage;

import com.vodafone.garage.config.BaseConfig;
import com.vodafone.garage.config.BaseConfigFactory;
import com.vodafone.garage.exception.NotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageApplication.class, args);
	}

}

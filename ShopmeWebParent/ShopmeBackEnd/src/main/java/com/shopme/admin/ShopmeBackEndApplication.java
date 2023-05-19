package com.shopme.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import java.util.Map;

@SpringBootApplication
@EntityScan({"com.shopme.common.entity"})
public class ShopmeBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopmeBackEndApplication.class, args);
		// Retrieve all environment variables
      
	}

}

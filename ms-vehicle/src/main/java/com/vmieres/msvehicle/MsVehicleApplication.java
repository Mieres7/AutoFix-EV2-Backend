package com.vmieres.msvehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsVehicleApplication.class, args);
	}

}

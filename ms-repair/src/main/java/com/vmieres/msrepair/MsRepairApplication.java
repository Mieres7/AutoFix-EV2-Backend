package com.vmieres.msrepair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsRepairApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRepairApplication.class, args);

	}

}

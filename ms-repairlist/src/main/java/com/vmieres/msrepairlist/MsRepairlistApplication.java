package com.vmieres.msrepairlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.vmieres.msreport.clients")
public class MsRepairlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRepairlistApplication.class, args);
	}

}

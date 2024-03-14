package com.aristomobileapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class AristoMobileApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AristoMobileApiApplication.class, args);
	}

}


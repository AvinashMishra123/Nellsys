package com.example.NellsysServerApplicant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class NellsysServerApplicantApplication {
	public static void main(String[] args) {
		SpringApplication.run(NellsysServerApplicantApplication.class, args);
	}
}

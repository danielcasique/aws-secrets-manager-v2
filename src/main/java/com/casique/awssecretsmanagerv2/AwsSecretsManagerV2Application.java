package com.casique.awssecretsmanagerv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.casique.awssecretsmanagerv2.*")
@SpringBootApplication
public class AwsSecretsManagerV2Application {

	public static void main(String[] args) {
		SpringApplication.run(AwsSecretsManagerV2Application.class, args);
	}

}

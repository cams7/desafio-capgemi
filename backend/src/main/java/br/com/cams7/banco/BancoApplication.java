package br.com.cams7.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class BancoApplication {

	@Bean
	public Module module() {
		return new Hibernate5Module();
	}

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);
	}

}

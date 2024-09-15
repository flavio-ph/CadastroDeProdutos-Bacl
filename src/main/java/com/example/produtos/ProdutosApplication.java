package com.example.produtos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class ProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProdutosApplication.class, args);
	}

}

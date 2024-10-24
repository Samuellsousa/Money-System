package com.moneySystem; // Certifique-se de que o pacote esteja correto

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.moneySystem")  // Isso garante que todos os componentes em "com.moneySystem" sejam escaneados
public class MoneySystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoneySystemApplication.class, args);
	}
}
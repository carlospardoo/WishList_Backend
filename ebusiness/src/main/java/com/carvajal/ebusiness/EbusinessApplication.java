package com.carvajal.ebusiness;

import com.carvajal.ebusiness.service.impl.ClientServiceImpl;
import com.carvajal.ebusiness.service.impl.ProductServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbusinessApplication {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(EbusinessApplication.class, args);
	}

	@Bean
	public CommandLineRunner initApp(ClientServiceImpl clService, ProductServiceImpl plService){
		return args ->{
			logger.debug("Products and Client Default");
			plService.saveProducts(plService.productsDefault());
			clService.addClient(clService.clientDefault());
		};
	}

}

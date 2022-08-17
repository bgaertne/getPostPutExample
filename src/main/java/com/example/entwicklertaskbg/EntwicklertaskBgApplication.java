package com.example.entwicklertaskbg;

import com.example.entwicklertaskbg.banking.Banking;
import com.example.entwicklertaskbg.banking.BankingRepository;
import com.example.entwicklertaskbg.company.Company;
import com.example.entwicklertaskbg.company.CompanyRepository;
import com.example.entwicklertaskbg.enums.Legal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class EntwicklertaskBgApplication {

	public static void main(String[] args) {
				SpringApplication.run(EntwicklertaskBgApplication.class, args);
	}

}

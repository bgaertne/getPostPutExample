package com.example.entwicklertaskbg.banking;

import com.example.entwicklertaskbg.banking.Banking;
import com.example.entwicklertaskbg.banking.BankingRepository;
import com.example.entwicklertaskbg.company.Company;
import com.example.entwicklertaskbg.company.CompanyRepository;
import com.example.entwicklertaskbg.enums.Legal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankingConfig {
    @Bean
    CommandLineRunner bankingCommandLineRunner(BankingRepository repository) {
        return args ->
        {
            Banking b1 = new Banking("TestBIC2","TestIBAN2");
            repository.save(b1);
        };
    }
}

package com.example.entwicklertaskbg.company;

import com.example.entwicklertaskbg.banking.Banking;
import com.example.entwicklertaskbg.banking.BankingRepository;
import com.example.entwicklertaskbg.enums.Legal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CompanyConfig {
    @Bean
    CommandLineRunner companyCommandLineRunner(CompanyRepository repository, BankingRepository bankingRepository) {
        return args ->
        {
            Banking b1 = new Banking("TestBIC","TestIBAN");
            bankingRepository.save(b1);
            Company c1 = new Company("KMHarnau",Legal.NONE);
            c1.addBanking(b1);
            Company c2 = new Company("YoursTruly",Legal.GMBH);
            repository.saveAll(List.of(c1,c2));
        };
    }
}

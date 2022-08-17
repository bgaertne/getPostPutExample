package com.example.entwicklertaskbg.banking;

import com.example.entwicklertaskbg.company.Company;
import com.example.entwicklertaskbg.company.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class BankingService {

    private final BankingRepository repository;

    @Autowired
    public BankingService(BankingRepository repository) {

        this.repository = repository;
    }

    public List<Banking> getAllBankings() {
        return (List<Banking>) repository.findAll();
    }

    public Banking addNewBanking(Banking b) {

        Banking banking = repository.save(b);
        return banking;
    }

    @Transactional
    public void updateBanking(Long bankingId, String BIC, String IBAN) {
        Banking banking = repository.findById(bankingId)
                .orElseThrow(() -> new IllegalStateException(
                        "Angestellter mit Id "+ bankingId+ " existiert nicht!"));

        if(BIC != null &&
                BIC.length()>0 &&
                !Objects.equals(banking.getBIC(),BIC)){
            banking.setBIC(BIC);
        }

        if(IBAN != null &&
                IBAN.length()>0 &&
                !Objects.equals(banking.getIBAN(),IBAN)){
            banking.setIBAN(IBAN);
        }
    }
}

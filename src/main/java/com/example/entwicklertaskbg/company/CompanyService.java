package com.example.entwicklertaskbg.company;

import com.example.entwicklertaskbg.banking.Banking;
import com.example.entwicklertaskbg.enums.Legal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository) {

        this.repository = repository;
    }

    public List<Company> getAllCompanies() {
        return (List<Company>) repository.findAll();
    }

    public Company addNewCompany(Company c) {

        Company company = repository.save(c);
        return company;
    }

    @Transactional
    public void updateCompany(Long companyId, String name, Legal legal) {
        Company company = repository.findById(companyId)
                .orElseThrow(() -> new IllegalStateException(
                        "Company mit Id "+ companyId+ " existiert nicht!"));

        if(name != null &&
                name.length()>0 &&
                !Objects.equals(company.getName(),name)){
            company.setName(name);
        }

        if(legal != null &&
                !Objects.equals(company.getLegal(),legal)){
            company.setLegal(legal);
        }
    }
}

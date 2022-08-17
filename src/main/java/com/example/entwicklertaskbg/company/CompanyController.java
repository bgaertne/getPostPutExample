package com.example.entwicklertaskbg.company;

import com.example.entwicklertaskbg.banking.Banking;
import com.example.entwicklertaskbg.banking.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="api/company")
public class CompanyController {

    private final CompanyService service;
    private final BankingService bservice;

    @Autowired
    public CompanyController(CompanyService service, BankingService bservice) {
        this.service = service;
        this.bservice = bservice;
    }

    @GetMapping
    public List<Company> getCompanies()
    {
        return service.getAllCompanies();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerCompany(@RequestBody Company company)
    {
        List<Banking> bankings = new ArrayList<Banking>();
        for(Banking b:company.getBanking())
        {
            b = bservice.addNewBanking(b);
            bankings.add(b);
        };
        company.setBanking(bankings);
        service.addNewCompany(company);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,path="/update/{id}")
    public void updatebanking(@RequestBody Company company, @PathVariable Long id) {
        service.updateCompany(id, company.getName(), company.getLegal());
    }
}

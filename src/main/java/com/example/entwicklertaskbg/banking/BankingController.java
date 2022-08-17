package com.example.entwicklertaskbg.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/banking")
public class BankingController {

    private final BankingService service;

    @Autowired
    public BankingController(BankingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Banking> getBankings()
    {
        return service.getAllBankings();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registerBanking(@RequestBody Banking banking)
    {
        service.addNewBanking(banking);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,path="/update/{id}")
    public void updatebanking(@RequestBody Banking banking, @PathVariable Long id) {
        service.updateBanking(id, banking.getBIC(), banking.getIBAN());
    }
}

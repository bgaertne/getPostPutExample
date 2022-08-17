package com.example.entwicklertaskbg.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepository extends CrudRepository<Banking,Long> {

}

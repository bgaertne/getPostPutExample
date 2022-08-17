package com.example.entwicklertaskbg.company;

import com.example.entwicklertaskbg.banking.Banking;
import com.example.entwicklertaskbg.enums.Legal;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Legal legal;
    @OneToMany
    private List<Banking> banking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company(){};
    public Company(String name, Legal legal) {
        this.name = name;
        this.legal = legal;
        this.banking = new ArrayList<Banking>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Legal getLegal() {
        return legal;
    }

    public void setLegal(Legal legal) {
        this.legal = legal;
    }

    public List<Banking> getBanking() {
        return banking;
    }

    public void setBanking(List<Banking> banking) {
        this.banking = banking;
    }

    public void addBanking(Banking b){
        banking.add(b);
    }

    @Override
    public String toString() {
        String string="";
        string+="Company{" +
                "name='" + name + '\'' +
                ", legal=" + legal + '\''+

       ", banking={";
        for(Banking b:banking)
        {
          string+=banking;
       }
        string +="}}";
        return string;
    }
}

package com.example.entwicklertaskbg.banking;

import javax.persistence.*;

@Entity
public class Banking {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String BIC;
    private String IBAN;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Banking(String BIC, String IBAN) {
        this.BIC = BIC;
        this.IBAN = IBAN;
    }

    public String getBIC() {
        return BIC;
    }

    public void setBIC(String BIC) {
        this.BIC = BIC;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Banking() {
    }

    @Override
    public String toString() {
        return "Banking{" +
                "BIC='" + BIC + '\'' +
                ", IBAN='" + IBAN + '\'' +
                '}';
    }
}

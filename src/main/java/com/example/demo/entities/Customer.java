package com.example.demo.entities;

import java.util.List;

public class Customer {
    private long idCustomer;
    private String nomCustomer;
    private String contactCustomer;
    List<Entreprise> entreprises;

    public Customer(long idCustomer, String nomCustomer, String contactCustomer, List<Entreprise> entreprises) {
        this.idCustomer = idCustomer;
        this.nomCustomer = nomCustomer;
        this.contactCustomer = contactCustomer;
        this.entreprises = entreprises;
    }

    public long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNomCustomer() {
        return nomCustomer;
    }

    public void setNomCustomer(String nomCustomer) {
        this.nomCustomer = nomCustomer;
    }

    public String getContactCustomer() {
        return contactCustomer;
    }

    public void setContactCustomer(String contactCustomer) {
        this.contactCustomer = contactCustomer;
    }

    public List<Entreprise> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<Entreprise> entreprises) {
        this.entreprises = entreprises;
    }
}

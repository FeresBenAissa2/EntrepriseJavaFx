package com.example.demo.entities;

import java.util.List;

public class Entreprise {
    private long idEntreprise;
    private String nomEntreprise;
    private String adresseEntreprise;

    private String typeEntreprise;
    private String descriptionEntreprise;

    List<Employee> employees;

    List<Customer>customers;
    public Entreprise(){

    }
    public Entreprise(long idEntreprise, String nomEntreprise, String adresseEntreprise, String typeEntreprise, String descriptionEntreprise, List<Employee> employees, List<Customer> customers) {
        this.idEntreprise = idEntreprise;
        this.nomEntreprise = nomEntreprise;
        this.adresseEntreprise = adresseEntreprise;
        this.typeEntreprise = typeEntreprise;
        this.descriptionEntreprise = descriptionEntreprise;
        this.employees = employees;
        this.customers = customers;
    }

    public long getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getAdresseEntreprise() {
        return adresseEntreprise;
    }

    public void setAdresseEntreprise(String adresseEntreprise) {
        this.adresseEntreprise = adresseEntreprise;
    }

    public String getTypeEntreprise() {
        return typeEntreprise;
    }

    public void setTypeEntreprise(String typeEntreprise) {
        this.typeEntreprise = typeEntreprise;
    }

    public String getDescriptionEntreprise() {
        return descriptionEntreprise;
    }

    public void setDescriptionEntreprise(String descriptionEntreprise) {
        this.descriptionEntreprise = descriptionEntreprise;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

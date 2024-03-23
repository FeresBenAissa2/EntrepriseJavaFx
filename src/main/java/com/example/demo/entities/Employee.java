package com.example.demo.entities;

public class Employee extends Salaire {
    public int Matricule;
    public String Nom;
    public String Email;
    public String Cat;
    public double AnneRecruit;

    public Employee(int matricule, String nom, String email, String cat, double anneRecruit,double salaire,double hSupp, double pHsupp) {
        super(salaire,hSupp,pHsupp);
        Matricule = matricule;
        Nom = nom;
        Email = email;
        Cat = cat;
        AnneRecruit = anneRecruit;
    }

    public Employee(int matricule, String nom, String email, String cat, double anneRecruit,double salaire) {
        super(matricule, nom, email, cat, anneRecruit, salaire);
        Matricule = matricule;
        Nom = nom;
        Email = email;
        Cat = cat;
        AnneRecruit = anneRecruit;

    }

    public int getMatricule() {
        return Matricule;
    }

    public void setMatricule(int matricule) {
        Matricule = matricule;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCat() {
        return Cat;
    }

    public void setCat(String cat) {
        Cat = cat;
    }

    public double getAnneRecruit() {
        return AnneRecruit;
    }

    public void setAnneRecruit(double anneRecruit) {
        AnneRecruit = anneRecruit;
    }
}

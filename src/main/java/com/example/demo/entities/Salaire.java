package com.example.demo.entities;

public class Salaire {
    private double Salaire;
    private double HSupp;
    private double PHsupp;

    public Salaire(double salaire, double HSupp, double PHsupp) {
        Salaire = salaire;
        this.HSupp = HSupp;
        this.PHsupp = PHsupp;
    }

    public Salaire(int matricule, String nom, String email, String cat, double anneRecruit, double salaire) {
        Salaire = salaire;
    }

    public double getSalaire() {
        return Salaire;
    }

    @Override
    public String toString() {
        return "Salaire{" +
                "Salaire=" + Salaire +
                ", HSupp=" + HSupp +
                ", PHsupp=" + PHsupp +
                '}';
    }

    public void setSalaire(double salaire) {
        Salaire = salaire;
    }

    public double getHSupp() {
        return HSupp;
    }

    public void setHSupp(double HSupp) {
        this.HSupp = HSupp;
    }

    public double getPHsupp() {
        return PHsupp;
    }

    public void setPHsupp(double PHsupp) {
        this.PHsupp = PHsupp;
    }
}

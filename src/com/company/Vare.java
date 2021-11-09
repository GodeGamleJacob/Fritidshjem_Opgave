package com.company;

import java.io.Serializable;

public class Vare implements Serializable {

    private int antal;
    private String varer;
    private double pris;

    //Default
    public Vare() {
    }

    //Constructor
    public Vare(int antal, String varer, double pris) {
        this.antal = antal;
        this.varer = varer;
        this.pris = pris;
    }

    //Getters & Setters
    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public String getVarer() {
        return varer;
    }

    public void setVarer(String varer) {
        this.varer = varer;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
}

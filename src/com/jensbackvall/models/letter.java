package com.jensbackvall.models;

public class letter {

    private char theLetter;
    private int occurances;
    private double percentage;

    public letter(char theLetter) {
        this.theLetter = theLetter;
    }

    public char getTheLetter() {
        return theLetter;
    }

    public void setTheLetter(char theLetter) {
        this.theLetter = theLetter;
    }

    public int getOccurances() {
        return occurances;
    }

    public void setOccurances(int occurances) {
        this.occurances = occurances;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}

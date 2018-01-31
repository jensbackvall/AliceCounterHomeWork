package com.jensbackvall.models;

import java.util.Comparator;

public class word implements Comparator<word>, Comparable<word> {

    private String theWord;
    private int occurances;
    private int ranking;

    public word() {
    }

    public word(String theWord) {
        this.theWord = theWord;
    }

    public String getTheWord() {
        return theWord;
    }

    public void setTheWord(String theWord) {
        this.theWord = theWord;
    }

    public int getOccurances() {
        return occurances;
    }

    public void setOccurances(int occurances) {
        this.occurances = occurances;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public int compare(word w, word w1) {
        return w.occurances - w1.occurances;
    }

    @Override
    public int compareTo(word w) {
        return (this.theWord).compareTo(w.theWord);
    }
}

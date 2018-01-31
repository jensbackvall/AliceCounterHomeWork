package com.jensbackvall;

import com.jensbackvall.models.letter;
import com.jensbackvall.models.word;
import com.jensbackvall.services.counters;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        int counter = 0;
        ArrayList<letter> letterList = counters.letterNumberAndPercentage();
        for (letter thisLetter: letterList) {
            counter++;
            System.out.println("Letter number " + counter + ": " + thisLetter.getTheLetter());
            System.out.println("Letter number " + counter + " occurs: " + thisLetter.getOccurances() + " times in the text");
            System.out.println("Letter number " + counter + " constitutes: " + thisLetter.getPercentage() + "% of all " +
                    "letters in the text.");
        }

        ArrayList<word> wordList = counters.wordNumberAndRankings();
        System.out.println("Most occuring words in descending order:\n");
        for (word aWord: wordList) {
            System.out.println("The word: '" +  aWord.getTheWord() + "' occurs " + aWord.getOccurances() + " times.");
        }


    }
}

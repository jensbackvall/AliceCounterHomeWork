package com.jensbackvall.services;


import com.jensbackvall.models.letter;
import com.jensbackvall.models.word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class counters {
    
    private static String getTextString() {
        String alice = "";
        try {
            URL urlName = new URL("http://www.gutenberg.org/files/11/11-0.txt");
            BufferedReader readFile = new BufferedReader(new InputStreamReader(urlName.openStream()));
            String currentLine = readFile.readLine();
            while (currentLine != null) {
                alice = alice + currentLine + " ";
                currentLine = readFile.readLine();
            }
            readFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alice;
    }



    private static int countAllLetters() {
        int numberOfCharacters = 0;
        String alice = getTextString();
        alice = alice.replaceAll("[^a-zA-Z]+","");
        for (char aLetter: alice.toCharArray()) {
            numberOfCharacters++;
        }
        return numberOfCharacters;
    }



    private static int countSingleLetter(char letter) {
        String alice = getTextString();
        alice = alice.replaceAll("[^a-zA-Z]+","");
        int letterCounter = 0;
        for (char aLetter: alice.toCharArray()) {
            if (Character.toLowerCase(aLetter) == letter) {
                letterCounter++;
            }
        }
        return letterCounter;
    }



    public static ArrayList<word> wordNumberAndRankings() {
        String alice = getTextString();
        ArrayList<String> allOccurancesOfAllWords = new ArrayList<>();
        for (String thisWord: alice.split(" ")) {
            if (!thisWord.equals("")) {
                thisWord = thisWord.toLowerCase();
                thisWord = thisWord.replaceAll("--", " ");
                thisWord = thisWord.replaceAll("'s", "");
                thisWord = thisWord.replaceAll("[^a-zA-Z]+","");
                allOccurancesOfAllWords.add(thisWord);
            }
        }

        ArrayList<word> allWords = new ArrayList<>();
        ArrayList<String> checkListSingleWords = new ArrayList<>();

        for (String theWord: allOccurancesOfAllWords) {
            int checkListCounter = 0;
            if (!checkListSingleWords.isEmpty()) {
                for (String aWord: checkListSingleWords) {
                    if (aWord.equals(theWord)) {
                        checkListCounter++;
                    }
                }
            }
            if (checkListCounter == 0) {
                checkListSingleWords.add(theWord);
            }
        }
        for (String word: checkListSingleWords) {
            int freq = Collections.frequency(allOccurancesOfAllWords, word);
            word theWord = new word(word);
            theWord.setOccurances(freq);
            allWords.add(theWord);
        }

        Collections.sort(allWords, new word());
        Collections.reverse(allWords);

        return allWords;
    }


    public static ArrayList<letter> letterNumberAndPercentage() {
        int numberOfLetters;
        int totalNumberOfCharacters = counters.countAllLetters();
        ArrayList<letter> listOfAllLetterObjects = new ArrayList<>();
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            numberOfLetters = counters.countSingleLetter(alphabet);
            double percentage = (((double)numberOfLetters / (double)totalNumberOfCharacters) * 100.0);
            DecimalFormat dfPercentage = new DecimalFormat("#.##");
            double thePercentage = Double.parseDouble(dfPercentage.format(percentage));
            letter thisLetter = new letter(alphabet);
            thisLetter.setOccurances(numberOfLetters);
            thisLetter.setPercentage(thePercentage);
            listOfAllLetterObjects.add(thisLetter);
        }
        return listOfAllLetterObjects;
    }
}

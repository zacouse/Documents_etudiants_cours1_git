package com.example.exercicecours1;

import java.util.Random;

public class GuessedNumber {
    private int currentNumber;
    private int maxNumber;

    public enum guessState{BIGGER, EQUAL, SMALLER};

    public GuessedNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        GenerateNewNumber();
    }

    public guessState TestNumber(int numberToTest){
        return (numberToTest > currentNumber)? guessState.BIGGER : (numberToTest < currentNumber)? guessState.SMALLER : guessState.EQUAL ;
    }

    public void GenerateNewNumber(){
        currentNumber = new Random().nextInt(maxNumber+1);
    }
}

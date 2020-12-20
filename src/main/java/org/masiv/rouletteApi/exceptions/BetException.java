package org.masiv.rouletteApi.exceptions;

public class BetException extends Exception{
    public static final String INVALID_BET = "The amount of money bet is invalid";
    public BetException(String message){
        super(message);
    }
}

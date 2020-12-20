package org.masiv.rouletteApi.exceptions;
public class RouletteException extends Exception{
    public static final String CLOSED_ROULETTE= "The roulette is already closed";
    public static final String OPENED_ROULETTE = "The roulette is already opened";
    public RouletteException(String message){
        super(message);
    }
    public RouletteException(String message, Throwable throwable){
        super(message, throwable);
    }
}

package org.masiv.rouletteApi.exceptions;

public class RouletteServicesException extends Exception{
    public static final String ROULETTE_NOT_FOUND ="The roulette with the given id does not exist";
    public RouletteServicesException(String message){
        super(message);
    }
    public RouletteServicesException(String message, Throwable throwable){
        super(message, throwable);
    }
}

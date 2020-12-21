package org.masiv.rouletteApi.services;
import org.masiv.rouletteApi.exceptions.RouletteServicesException;
import org.masiv.rouletteApi.model.Bet;
import org.masiv.rouletteApi.model.Roulette;
import org.masiv.rouletteApi.model.User;
import java.util.List;
public interface RouletteServices {
    String createRoulette();
    void openRouletteById(String id) throws RouletteServicesException;
    void addBetById(String id, Bet bet, User user) throws RouletteServicesException;
    List<Bet> closeRouletteById(String id) throws RouletteServicesException;
    List<Roulette> getAllRoulettes();
}

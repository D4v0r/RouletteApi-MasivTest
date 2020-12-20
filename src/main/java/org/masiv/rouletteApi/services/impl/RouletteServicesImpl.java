package org.masiv.rouletteApi.services.impl;
import org.masiv.rouletteApi.exceptions.BetException;
import org.masiv.rouletteApi.exceptions.RouletteException;
import org.masiv.rouletteApi.exceptions.RouletteServicesException;
import org.masiv.rouletteApi.model.Bet;
import org.masiv.rouletteApi.model.Roulette;
import org.masiv.rouletteApi.persistence.RouletteRepository;
import org.masiv.rouletteApi.services.RouletteServices;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
public class RouletteServicesImpl implements RouletteServices {
    @Autowired
    private RouletteRepository repository;
    @Override
    public String createRoulette() {
        Roulette roulette = new Roulette();
        repository.save(roulette);
        return roulette.getId();
    }
    @Override
    public void openRouletteById(String id) throws RouletteServicesException {
        Roulette roulette = repository.findById(id).orElseThrow(()->new RouletteServicesException(RouletteServicesException.ROULETTE_NOT_FOUND));
        try {
            roulette.open();
        } catch (RouletteException e){
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }
    @Override
    public void addBetById(String id, Bet bet) throws RouletteServicesException {
        Roulette roulette = repository.findById(id).orElseThrow(()->new RouletteServicesException(RouletteServicesException.ROULETTE_NOT_FOUND));
        try {
            roulette.addBet(bet);
        }catch (RouletteException e){
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }
    @Override
    public List<Bet> closeRouletteById(String id) throws RouletteServicesException {
        Roulette roulette = repository.findById(id).orElseThrow(()->new RouletteServicesException(RouletteServicesException.ROULETTE_NOT_FOUND));
        try{
            roulette.close();
        }catch (RouletteException e){
            throw new RouletteServicesException(e.getMessage(), e);
        }
        return roulette.getBets();
    }
    @Override
    public List<Roulette> getAllRoulettes() {
        ArrayList<Roulette> roulettes = new ArrayList<>();
        repository.findAll().forEach(roulettes::add);
        return roulettes;
    }
}

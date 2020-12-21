package org.masiv.rouletteApi.model;
import lombok.Getter;
import lombok.Setter;
import org.masiv.rouletteApi.exceptions.RouletteException;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@RedisHash("Roulette")
@Getter @Setter
public class Roulette implements Serializable {
    private final static long serializableVersionUID = 3L;
    @Id
    private String id;
    private RouletteState state;
    private List<Bet> bets;
    public Roulette(){
        bets = new ArrayList<>();
        setState(RouletteState.CLOSE);
    }
    public void open() throws RouletteException {
        if(state.equals(RouletteState.OPEN)) throw new RouletteException(RouletteException.OPENED_ROULETTE);
        setState(RouletteState.OPEN);
    }
    public void close() throws RouletteException{
        if(state.equals(RouletteState.CLOSE)) throw  new RouletteException(RouletteException.CLOSED_ROULETTE);
        Random random = new Random();
        int winnerNumber = random.nextInt(37);
        bets.forEach(bet -> bet.calculatePrize(winnerNumber));
        setState(RouletteState.CLOSE);
    }
    public void addBet(Bet bet) throws RouletteException{
        if (state.equals(RouletteState.CLOSE)) throw  new RouletteException(RouletteException.CLOSED_ROULETTE);
        bets.add(bet);
    }
}

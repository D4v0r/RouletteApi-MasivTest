package org.masiv.rouletteApi.model;
import lombok.Getter;
import lombok.Setter;
import org.masiv.rouletteApi.exceptions.RouletteException;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class Roulette {
    @Id
    private String id;
    private RouletteState state;
    private List<Bet> bets;
    public Roulette(){
        setState(RouletteState.CLOSE);
    }
    public void open() throws RouletteException {
        if(state.equals(RouletteState.OPEN)) throw new RouletteException(RouletteException.OPENED_ROULETTE);
        setState(RouletteState.OPEN);
        setBets(new ArrayList<>());
    }
    public void close() throws RouletteException{
        if(state.equals(RouletteState.CLOSE)) throw  new RouletteException(RouletteException.CLOSED_ROULETTE);
    }
    public void addBet(Bet bet) throws RouletteException{
        if (state.equals(RouletteState.CLOSE)) throw  new RouletteException(RouletteException.CLOSED_ROULETTE);
        bets.add(bet);
    }
}

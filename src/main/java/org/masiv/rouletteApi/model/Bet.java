package org.masiv.rouletteApi.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.masiv.rouletteApi.exceptions.BetException;
import org.springframework.data.annotation.Id;
@Getter @Setter
public abstract class Bet {
    @Id
    private String id;
    private User user;
    private double money;
    private double prize;
    public Bet(double money, User user){
        this.money = money;
        this.user = user;
    }
    public abstract void calculatePrize(int winnerNumber);
    public void setMoney(@NonNull double money) throws BetException{
        if(money < 0 || money > 10000)throw new BetException(BetException.INVALID_BET);
        this.money = money;
    }
}

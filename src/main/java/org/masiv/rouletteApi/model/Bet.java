package org.masiv.rouletteApi.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.masiv.rouletteApi.exceptions.BetException;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ColorBet.class, name = "color"),
        @JsonSubTypes.Type(value = NumberBet.class, name = "number")
})
@Getter @Setter
public abstract class Bet {
    private User user;
    private double money;
    private double prize;
    public Bet(double money){
        this.money = money;
    }
    public abstract void calculatePrize(int winnerNumber);
    public void setMoney(@NonNull double money) throws BetException{
        if(money < 0 || money > 10000)throw new BetException(BetException.INVALID_BET);
        this.money = money;
    }
}

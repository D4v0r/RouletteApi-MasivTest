package org.masiv.rouletteApi.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.masiv.rouletteApi.exceptions.BetException;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME, property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BetColor.class, name = "color"),
        @JsonSubTypes.Type(value = User.class, name = "user")
})
@Getter @Setter
public abstract class Bet {
    @Indexed
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

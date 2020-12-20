package org.masiv.rouletteApi.model;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class NumberBet extends Bet{
    private int number;
    public NumberBet(double money, User user, int number) {
        super(money, user);
        this.number = number;
    }
    @Override
    public void calculatePrize(int winnerNumber) {
        if(number == winnerNumber){
            setPrize(getMoney() *5);
        }else{
            setPrize(0);
        }
    }
}

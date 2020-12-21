package org.masiv.rouletteApi.model;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class NumberBet extends Bet{
    private int number;
    public NumberBet(double money, int number) {
        super(money);
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

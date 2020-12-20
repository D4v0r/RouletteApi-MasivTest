package org.masiv.rouletteApi.model;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class ColorBet extends Bet{
    private BetColor color;
    public ColorBet(double money, User user, BetColor color) {
        super(money, user);
        setColor(color);
    }
    @Override
    public void calculatePrize(int winnerNumber) {
        if((color.equals(BetColor.RED) && winnerNumber % 2 == 0 ) || (color.equals(BetColor.BLACK) && winnerNumber % 2 == 1) ){
            setPrize(getMoney() * 1.8);
        }else {
            setPrize(0);
        }
    }
}

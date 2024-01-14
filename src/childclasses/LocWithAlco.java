package childclasses;

import enums.AMOUNT;
import interfaces.hasAlcohol;
import parentclasses.Location;

public class LocWithAlco extends Location implements hasAlcohol {

    AMOUNT alcoholAmount;

    public LocWithAlco(String locname, AMOUNT alcoholAmount){
        super(locname);
        this.alcoholAmount = alcoholAmount;
    }

    @Override
    public AMOUNT getAlcoholAmount() {
        return alcoholAmount;
    }

    @Override
    public void setAlcoholAmount(AMOUNT newAmount) {
        this.alcoholAmount = newAmount;
    }
}

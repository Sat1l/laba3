package ChildClasses;

import Enums.AMOUNT;
import Interfaces.hasAlcohol;
import Interfaces.hasOccasion;
import ParentClasses.Location;

public class LadlowHome extends Location  implements hasOccasion, hasAlcohol {
    private String occasion;

    private AMOUNT alcoholAmount;

    public LadlowHome(String locname, String occasion, AMOUNT alcoholAmount){
        super(locname);
        this.occasion = occasion;
        this.alcoholAmount = alcoholAmount;
    }

    @Override
    public String getOccasion() {
        return occasion;
    }

    @Override
    public AMOUNT getAlcoholAmount(){
        return alcoholAmount;
    }

    @Override
    public void setAlcoholAmount(AMOUNT newAmount){
        this.alcoholAmount = newAmount;
    }

}

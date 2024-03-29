package actions;

import childclasses.Beverage;
import childclasses.LocWithAlco;
import childclasses.Person;
import enums.Amount;
import enums.Condition;
import interfaces.HasAlcohol;
import parentclasses.Action;

public class DrinkAlco extends Action {
    public DrinkAlco(String actionName) {
        super(actionName);
    }

    public void drinkAlco(Person person, Beverage beverage, Amount amount){
        person.addDoing(this);
        if (person.getLocation() instanceof HasAlcohol) {
            LocWithAlco locWithAlco = (LocWithAlco) person.getLocation();
            int alcoholAmount = beverage.getAmount().toInt();
            if (alcoholAmount > 0 && (beverage.getLocation() == locWithAlco)){
                if (alcoholAmount - amount.toInt() > 0){
                    beverage.setAmount(Amount.fromInt(alcoholAmount - amount.toInt()));
                    person.setCondition(Condition.DRUNK);
                    System.out.println(person.getName() + " drank " + amount + " " + beverage.getTare() + " " + beverage.getName() + ", and now " + person.getCondition().toString());
                    System.out.println("At " + locWithAlco.getLocname() + " there is " + locWithAlco.countAlcohol() + " of alcohol");
                } else if (alcoholAmount - amount.toInt() <= 0) {
                    beverage.setAmount(Amount.NONE);
                    locWithAlco.removeAlcohol(beverage);
                    person.setCondition(Condition.DRUNK);
                    System.out.println(person.getName() + " drank all of the remaining alcohol and there was " + Amount.fromInt(alcoholAmount) + " of it and now this person is " + person.getCondition().toString());
                    System.out.println(locWithAlco.getLocname() + " now does not have any alcohol");
                } else {
                    System.out.println(person.getName() + " wanted to drink but " + person.getLocation().getLocname() + " had no alcohol ");
                }

            }
        } else {
            System.out.println(person.getName() + " wanted to drink but " + person.getLocation().getLocname() + " had no alcohol or it's not there");
        }
        person.removeDoing(this);
    }

}

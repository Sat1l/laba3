package actions;

import childclasses.Person;
import enums.Condition;
import parentclasses.Action;
import parentclasses.UObject;

import java.util.Random;

public class EatSedative extends Action {

    public EatSedative(String actionName) {
        super(actionName);
    }

    public void eatSedative(Person person) {
        UObject res = hasSedative(person);
        if(res != null){
            person.addDoing(this);
            Random random = new Random();
            float f = random.nextFloat();
            person.removeInventory(res);
            if (f > 0.1f){
                person.setCondition(Condition.CALM);
                System.out.println(person.getName() + " is now calm");
            } else {
                person.setCondition(Condition.BUYANIT);
                System.out.println(person.getName() + " is now buyanit");
            }
            person.removeDoing(this);
        }
    }
    private UObject hasSedative(Person person){
        UObject toret = null;
        for (UObject item : person.getInventory()) {
            if (item.getName().equalsIgnoreCase("sedative")) {
                toret = item;
                break;
            }
        }
        return toret;
    }
}

package actions;

import ChildClasses.Person;
import ParentClasses.Action;
import ParentClasses.Location;
import ParentClasses.Object;

import java.util.Random;

public class Bring extends Action {

     void bring(Person person, Object object, Location location){
        if (person.getInventory().contains(object)){
            person.addDoing(this);
            Random random = new Random();
            float f = random.nextFloat();
            if (f > 0.9){
                person.removeInventory(object);
                person.removeDoing(this);
                location.addObject(object);
                System.out.println(person.getName() + " brought " + object.getName() + " to " + location.getLocname());
            } else {
                person.removeInventory(object);
                person.removeDoing(this);
                System.out.println(person.getName() + " lost " + object.getName() + " on its way to the " + location.getLocname());
            }
        }
    }
}

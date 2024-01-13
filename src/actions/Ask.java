package actions;

import ChildClasses.Person;
import Enums.INTEREST;
import ParentClasses.Action;

public class Ask extends Action {

    public Ask(String actionName) {
        super(actionName);
    }

    public void ask(Person whoAsks, Person whoGetsAsked, String phrase, INTEREST whoAsksInterest){
        whoAsks.addDoing(this);
        System.out.println(whoAsks.getName() + " asks " + whoGetsAsked.getName() + " " + phrase + " with " + whoAsksInterest.toString());
        whoAsks.removeDoing(this);
    }

}

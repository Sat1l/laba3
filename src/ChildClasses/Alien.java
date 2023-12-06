package ChildClasses;

import Enums.AMOUNT;
import Enums.CONDITION;
import Enums.INTEREST;
import ParentClasses.Item;
import ParentClasses.Location;
import ParentClasses.Person;
import com.sun.source.tree.IfTree;

public class Alien extends Person {

    public Alien(String name, Location location){
        super(name, location);
    }

    @Override
    public void give(Item item, Person person) {
        System.out.println(this.getName() + " дало " + person.getName() + " " + item.getName());
    }
    @Override
    public void findItem(Item item){
        System.out.println(this.getName() + " отыскало " + item);
    }
    @Override
    public void zip(Clothing clothing){
        if(clothing.getIsZipepd()){
            System.out.println(this.getName() + "попыталось застегнуть " + clothing.getName() + ", но она уже была застегнута");
        }
        else {
            clothing.setIsZipped(true);
        }
    }

    @Override
    public void bring(Item item){
        System.out.println(this.getName() + " принесло " + item.getName());
    }
    @Override
    public void say(String phrase){
        System.out.println(" - " + phrase + " сказало " + this.getName());
    }
    @Override
    public void drinkAlcohol(Beverage beverage, AMOUNT amount){
        if (this.location instanceof OuterPlace) {
            OuterPlace outerPlace = (OuterPlace) this.location;
            int alcoholAmount = outerPlace.getAlcoholAmount().toInt();
            if (alcoholAmount > 0){
                if (alcoholAmount - amount.toInt() > 0){
                    outerPlace.setAlcoholAmount(AMOUNT.fromInt(alcoholAmount - amount.toInt()));
                    this.setCondition(CONDITION.DRUNK);
                    System.out.println(this.getName() + " выпило " + amount.toString() + " " + beverage.getTare() + " " + beverage.getName() + ", и теперь " + this.getCondition().toString());
                    System.out.println("В " + outerPlace.getLocname() + " осталось " + outerPlace.getAlcoholAmount() + " выпивки");
                } else if (alcoholAmount - amount.toInt() < 0) {
                    outerPlace.setAlcoholAmount(AMOUNT.NONE);
                    this.setCondition(CONDITION.DRUNK);
                    System.out.println(this.getName() + " выпил всю оставшуюся выпивку, которой было " + AMOUNT.fromInt(alcoholAmount-amount.toInt()) + ", и теперь" + this.getCondition().toString());
                    System.out.println("В " + outerPlace.getLocname() + " не осталось выпивки");
                } else {
                    System.out.println(this.getName() + " хотело было выпить, но в " + this.location.getLocname() + " не оказалось выпивки ");
                }

            }
        } else {
            System.out.println(this.getName() + " хотело было выпить, но в " + this.location.getLocname() + " не оказалось выпивки ");
        }
    }
    @Override
    public void think(String thought){
        System.out.println(this.getName() + " подумало: " + thought);
    }
    @Override
    public void ask(String phrase, INTEREST interest){
        System.out.println(" - " + phrase + " - спросило " + this.getName() + " " + interest);
    }
    @Override
    public void putOn(Clothing clothing){
        this.wears.add(clothing);
        System.out.println(this.getName() + " надело " + clothing.getName());
    }

}

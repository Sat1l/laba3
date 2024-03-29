package parentclasses;

public class UObject {

    protected final String name;

    protected Location location;

    public UObject(String name, Location location){
        this.name = name;
        this.location = location;
        this.location.addObject(this);
    }

    public String getName(){
        return this.name;
    }

    public Location getLocation(){
        return location;
    }

    public void setLocation(Location newLocation){
        this.location.removeUObject(this);
        this.location = newLocation;
        newLocation.addObject(this);
    }

}

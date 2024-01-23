package Estate.RealEstate.Rooms;

import Estate.RealEstate.Person;

import java.util.UUID;

public abstract class Room {

    private int area;
    private UUID id;


    Person primaryTenant;

    public Room() {

        this.id = UUID.randomUUID();

    }

    public UUID getId() {
        return id;
    }

    public int getArea() {
        return area;
    }

    public Person getPrimaryTenant() {
        return primaryTenant;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return " o identyfikatorze " + id+" "+ " i  powierzchni "
                 + area;
    }
}

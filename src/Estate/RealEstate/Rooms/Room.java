package Estate.RealEstate.Rooms;

import Estate.RealEstate.Person;
import Estate.RealEstate.Technical.TechTime;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.UUID;

public abstract class Room {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (getArea() != room.getArea()) return false;
        if (!getId().equals(room.getId())) return false;
        return getPrimaryTenant() != null ? getPrimaryTenant().equals(room.getPrimaryTenant()) : room.getPrimaryTenant() == null;
    }

    @Override
    public int hashCode() {
        int result = getArea();
        result = 31 * result + getId().hashCode();
        result = 31 * result + (getPrimaryTenant() != null ? getPrimaryTenant().hashCode() : 0);
        return result;
    }

    private int area;
    private final UUID id;

    private final LocalDate[] endDate;

    Person primaryTenant;



    public Room() {

        this.id = UUID.randomUUID();

        endDate=new LocalDate[1];


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

    public void setPrimaryTenant(Person primaryTenant) {
        this.primaryTenant = primaryTenant;
    }



    public LocalDate[] getEndDate(){
        return endDate;
    }
    public LocalDate[] setEndDate(LocalDate endT){
       endDate[0]=endT;
        return endDate;
    }

    @Override
    public String toString() {
        return " o identyfikatorze " + id+" "+ " i  powierzchni "
                 + area + " "+ Arrays.toString(endDate);
    }
}

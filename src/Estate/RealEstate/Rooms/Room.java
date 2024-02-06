package Estate.RealEstate.Rooms;

import Estate.RealEstate.Person;
import Estate.RealEstate.Technical.TechTime;

import java.time.LocalDate;

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

    private final LocalDate[] endDate={LocalDate.now()};

    Person primaryTenant;
    TechTime techTime;


    public Room() {

        this.id = UUID.randomUUID();
        //this.endDate=new LocalDate[1];
        //techTime=new TechTime(en);


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

   // public void setEndDate(int rentalDays){
     //   endDate[0]=LocalDate.now().plusDays(rentalDays);
    //}


    public LocalDate[] getEndDate(){
        return endDate;
    }
    public LocalDate[] setEndDate(long daysOfRent){
       // endDate[0]=techTime.currentTime[0].plusDays(daysOfRent);
        return endDate;
    }

    @Override
    public String toString() {
        return " o identyfikatorze " + id+" "+ " i  powierzchni "
                 + area;
    }
}

package Estate.RealEstate.Rooms;

import Estate.RealEstate.Person;

import java.time.LocalDate;

import java.util.UUID;

public abstract class Room {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

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
    private UUID id;

    private LocalDate dateOfRent;
    private LocalDate dateOfLeave;

    public LocalDate getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(LocalDate dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public LocalDate getDateOfLeave() {
        return dateOfLeave;
    }

    public void setDateOfLeave(LocalDate dateOfLeave) {
        this.dateOfLeave = dateOfLeave;
    }

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

    public void setPrimaryTenant(Person primaryTenant) {
        this.primaryTenant = primaryTenant;
    }

    @Override
    public String toString() {
        return " o identyfikatorze " + id+" "+ " i  powierzchni "
                 + area;
    }
}

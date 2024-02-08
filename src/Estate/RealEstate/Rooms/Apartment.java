package Estate.RealEstate.Rooms;

import Estate.RealEstate.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Apartment extends Room {

    private Set<Person> personsInApartment;



    public Apartment(int area) {
        super.setArea(area);


        personsInApartment=new HashSet<>();


    }

    @Override
    public String toString() {


        return " Mieszkanie "+ super.toString();

    }

    public Set<Person> getPersonsInApartment() {
        return personsInApartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Apartment)) return false;
        if (!super.equals(o)) return false;

        Apartment apartment = (Apartment) o;

        return getPersonsInApartment() != null ? getPersonsInApartment().equals(apartment.getPersonsInApartment()) : apartment.getPersonsInApartment() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPersonsInApartment() != null ? getPersonsInApartment().hashCode() : 0);
        return result;
    }

}

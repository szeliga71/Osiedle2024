package Estate.RealEstate.Rooms;

import Estate.RealEstate.Person;

import java.util.ArrayList;
import java.util.List;

public class Apartment extends Room {




    List<Person> personsInApartment;

    public Apartment(int area) {
        super.setArea(area);

        personsInApartment=new ArrayList<>();
        if(super.primaryTenant!=null){
            personsInApartment.add(primaryTenant);
        }
    }

    @Override
    public String toString() {


        return " Mieszkanie "+ super.toString();

    }
}

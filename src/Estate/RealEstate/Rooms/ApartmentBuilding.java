package Estate.RealEstate.Rooms;

import Estate.RealEstate.Rooms.Apartment;

import java.util.ArrayList;
import java.util.List;

public class ApartmentBuilding {

    private final String street;
    private final int number;
    private final String postal;

    private List<Apartment> apartmentsList;

    public ApartmentBuilding(String street, int number, String postal) {
        this.street = street;
        this.number = number;
        this.postal = postal;

        apartmentsList=new ArrayList<>();
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getPostal() {
        return postal;
    }

    public List<Apartment> getApartmentsList() {
        return apartmentsList;
    }
}

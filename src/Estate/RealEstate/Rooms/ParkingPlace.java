package Estate.RealEstate.Rooms;

import Estate.RealEstate.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class ParkingPlace extends Room {

    private List<Item>items;

    public ParkingPlace(int area) {
        super.setArea(area);

        items=new ArrayList<>();
    }

    @Override
    public String toString() {


        return " Garaz "+ super.toString();

    }

    public List<Item> getItems() {
        return items;
    }
}

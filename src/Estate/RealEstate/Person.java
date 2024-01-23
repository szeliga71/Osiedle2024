package Estate.RealEstate;

import Estate.RealEstate.Items.Item;
import Estate.RealEstate.Rooms.Room;

import java.util.ArrayList;
import java.util.List;

public class Person {

    String name;
    String surname;
    int pesel;
    Nation nationality;

    File[]files;
    Room[]rooms;
    //List<File> files;
    //List<Room>rooms;

    public Person(String name, String surname, int pesel, Nation nationality) {
        this.name = name;
        this.surname = surname;
        this.pesel=pesel;
        this.nationality = nationality;

        files=new File[3];
        rooms=new Room[5];
    }

    public void addPerson(Person person){}

    public void addThingOrCar(Item item){}

    @Override
    public String toString() {
        return name + " " + surname + " " +
                " pesel " + pesel +
                " nation " + nationality;
    }
}

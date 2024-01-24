package Estate.RealEstate;

import Estate.RealEstate.Items.Item;
import Estate.RealEstate.Rooms.Room;

public class Person {

    private String name;
    private String surname;
    private int pesel;
    private Nation nationality;

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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPesel() {
        return pesel;
    }

    public Nation getNationality() {
        return nationality;
    }
}

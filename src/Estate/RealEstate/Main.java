package Estate.RealEstate;

import Estate.RealEstate.Items.Veihcle.Paliwo;
import Estate.RealEstate.Items.Veihcle.Samochod_Miejski;
import Estate.RealEstate.Rooms.Apartment;
import Estate.RealEstate.Rooms.ParkingPlace;
import Estate.RealEstate.Rooms.Room;
import Estate.RealEstate.Technical.Enviroment;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        //Set<Room> roomSet=new HashSet<>();
        //Set<Person>personSet=new HashSet<>();





        //Person person = new Person("Jan", "Kowalski", 43, Nation.POLISH);


        //System.out.println(person.nationality);

        //Apartment ap=new Apartment(120);
        //Apartment ap1=new Apartment(159);
        //ParkingPlace pp1=new ParkingPlace(30);

//testowanie

        //System.out.println(ap.getId());
        //System.out.println(ap1.getId());
        //System.out.println(ap.getArea());
        //System.out.println();
        //System.out.println(pp1.getId());
        //System.out.println(ap.getPrimaryTenant());
        //Samochod_Miejski sm1=new Samochod_Miejski(6,"Suzuki","Swift", Paliwo.BENZYNA,1000,true,"White");

        //System.out.println(sm1.getPaliwo());
        //System.out.println(sm1.getMarka()+" "+sm1.getModel());
        //System.out.println(sm1);

        // testowanie koniec



        Enviroment en = new Enviroment();


       //en.getRoomSet().add(ap);
        //en.getRoomSet().add(ap1);
        //en.getRoomSet().add(pp1);
        //en.getPersonSet().add(person);
        en.run();


    }

}

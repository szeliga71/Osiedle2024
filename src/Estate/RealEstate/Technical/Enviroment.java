package Estate.RealEstate.Technical;

import Estate.RealEstate.Items.Item;
import Estate.RealEstate.Items.Thing;
import Estate.RealEstate.Items.Veihcle.Amfibia;
import Estate.RealEstate.Items.Veihcle.Paliwo;
import Estate.RealEstate.Items.Veihcle.Samochod_Miejski;
import Estate.RealEstate.Items.Veihcle.Samochod_Terenowy;
import Estate.RealEstate.Nation;
import Estate.RealEstate.Person;
import Estate.RealEstate.Rooms.Apartment;
import Estate.RealEstate.Rooms.ParkingPlace;
import Estate.RealEstate.Rooms.Room;

import java.time.LocalDate;
import java.util.*;

public class Enviroment {


    private Set<Person> personSet;
    private Map<Room, Person> estate;

    private Set<Item> itemsGlobal;

    public Enviroment() {


        personSet = new HashSet<>();
        estate = new HashMap<>();
        itemsGlobal = new HashSet<>();


        // dane do pracy
        Person p1 = new Person("Jan", "Kowalski", 43, Nation.POLISH);
        Person p2 = new Person("Bronislaw", "Cieslak", 45, Nation.FRENCH);
        Person p3 = new Person("Kamil", "Nowak", 44, Nation.DEUTSCH);




        Apartment ap = new Apartment(120);
        Apartment ap1 = new Apartment(159);
        Apartment ap2 = new Apartment(220);
        Apartment ap3 = new Apartment(123);
        ParkingPlace pp1 = new ParkingPlace(30);
        ParkingPlace pp2 = new ParkingPlace(35);
        Samochod_Miejski sm1 = new Samochod_Miejski(6, "Suzuki", "Swift", Paliwo.BENZYNA, 1000, true, "White");
        Samochod_Terenowy st1=new Samochod_Terenowy(28,"Toyota","RAV4",Paliwo.DIESEL,2500,16);
        Amfibia am1=new Amfibia(15,"UNIMAG","AM!",Paliwo.PRAD,150,true,true);
        Thing t1=new Thing(1,"grabie");
        Thing t2=new Thing(1,"lopata");
        Thing t3=new Thing(3,"kosiarka");
        Thing t4=new Thing(8,"betoniarka");

        itemsGlobal.add(t1);
        itemsGlobal.add(t2);
        itemsGlobal.add(t3);
        itemsGlobal.add(t4);

        itemsGlobal.add(sm1);
        itemsGlobal.add(st1);
        itemsGlobal.add(am1);


        // tu automat ladowanie z pliku


        personSet.add(p1);
        personSet.add(p2);
        personSet.add(p3);
        //p1.addThingOrCar(sm1,pp1);

        estate.put(ap, null);
        estate.put(ap1, null);
        estate.put(ap2, null);
        estate.put(pp1, null);
        estate.put(pp2, null);
        estate.put(ap3, null);


    }


    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }


    public Set<Person> getPersonSet() {
        return personSet;
    }

    public Map<Room, Person> getEstate() {
        return estate;
    }


    public void setEstate(Map<Room, Person> estate) {
        this.estate = estate;
    }


    public void run() {




        Scanner scan = new Scanner(System.in);
        Person user = null;
        Person temPerson = null;
        Apartment apartment = null;
        ParkingPlace parkingPlace = null;
        Item item=null;

        String choice = null;

        while (true) {

            int licznik = 0;
            String licz=null;
            String wybor = null;


            if (user==null) {
                System.out.println(" Aby prawidlowo korzystac z programu musisz byc zalogowany !");
                choice = String.valueOf(1);
            } else {

                System.out.println();
                System.out.println(" wybierz odpowiednia cyfre " + '\n');
                System.out.println("  1. Pokaz wszystkie osoby / Zaloguj sie ");
                System.out.println("  2. Pokaz wszystkie mieszkania");
                System.out.println("  3. Pokaz wszystkie garaze");
                System.out.println("  4. Pokaz wolne mieszkania/ Wynajem mieszkania !");
                System.out.println("  5. Zwolnij mieszkanie");
                System.out.println("  6. Pokaz lokatorow w mieszkaniu");
                System.out.println("  7. Dodaj lokatora do mieszkania");
                System.out.println("  8. Usun lokatora z mieszkanaia ");
                System.out.println("  9. Pokaz wolne garaze/ Wynajem garazu !");
                System.out.println("  10. Zwolnij garaz");
                System.out.println("  11. Pokaz wszystkie przedmioty w garazu");
                System.out.println("  12. Dodaj przedmiot do garazu");
                System.out.println("  13. Usun przedmiot z garazu");
                System.out.println("  14. Pokaz wszyskie nieruchomosci wynajmowane przez osobe");
                System.out.println("  15. Pokaz wszystkie przedmioty danej osoby");
                System.out.println("  16. EXIT");


                // M E N U

//zakończenia programu w dowolnym momencie
// wybrania którą jest osobą (nie jest potrzebne żadne logowanie, wystarczy wskazanie
                //             np. unikalnego numeru osoby
                // wypisania swoich danych łącznie z wynajętymi pomieszczeniami
// wyświetlenia wolnych pomieszczeń
// wynajęcia nowego pomieszczenia, po uprzednim jego wybraniu
// wybrania pomieszczenia które wynajmuje dana osoba oraz wyświetlenia zawartości

// wykonania polecenia zapisującego aktualny stan osiedla do pliku


                try {
                    choice = scan.nextLine();


                } catch (InputMismatchException e) {
                    System.out.println(" nie podales odpowiedniej cyfry !");
                }
            }

            switch (choice) {


                case "1" -> {
                    int podajPesel = 0;
                    System.out.println();
                    System.out.println(" Lista osob \n");


                    for (Person p : personSet) {
                        System.out.println((++licznik) + ". " + p);
                    }
                    System.out.println();
                    System.out.println("Zaloguj sie ,podajac pesel ");

                    try {
                        podajPesel = scan.nextInt();
                        scan.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println(" prosze podac prawidlowy pesel !");
                        scan.nextLine();
                    }

                    for (Person p : personSet) {
                        if (p.getPesel() == podajPesel) {
                            user = p;
                        }
                    }
                    System.out.println();
                    if (user == null) {
                        System.out.println(" UWAGA ! , nie jestes zalogowany , sprobuj ponownie !");
                    } else {
                        System.out.println(" Jestes zalogowany jako : " + user);
                    }
                }

                case "2" -> {
                    System.out.println(" Wszystkie mieszkania " + '\n');
                    showRooms(Apartment.class);
                }

                case "3" -> {
                    System.out.println(" Wszystkie garaze " + '\n');
                    showRooms(ParkingPlace.class);
                }

                case "4" -> {

                    System.out.println(" Jestes zalogowany jako " + user + '\n');
                    System.out.println(" lista wolnych mieszkan " + '\n');


                    if (showVacantRooms(Apartment.class) == 0) {
                        System.out.println(" brak wolnych mieszkan na wynajem !");
                        break;
                    }

                    wybor = wybor(scan);




                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass().equals(Apartment.class)) && (entry.getValue() == null)) {
                            ++licznik;

                        }
                        licz=String.valueOf(licznik);

                        if (wybor.equals(licz)) {
                            apartment=(Apartment)entry.getKey();
                            entry.setValue(user);

                            entry.getKey().setPrimaryTenant(user);
                            apartment.getPersonsInApartment().add(user);

                            apartment.setDateOfRent(LocalDate.now());

                            //System.out.println(apartment.getPersonsInApartment());
                            System.out.println(user + " wynaja " + entry.getKey());

                            break;

                        }
                    }


                }

                case "5" -> {


                    System.out.println(" Zwolnij mieszkanie Uzytkownik " + user);


                    if (showOccupiedRooms(Apartment.class,user)== 0) {
                        System.out.println(" Nie posiadasz wynajetych mieszkan !");
                        break;
                    }

                    wybor = wybor(scan);




                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {

                        if ((entry.getKey().getClass().equals(Apartment.class)) && (entry.getValue() == user)) {
                            ++licznik;
                            licz=String.valueOf(licznik);
                            if (licz.equals(wybor)) {
                                apartment = (Apartment) entry.getKey();
                                entry.setValue(null);
                                entry.getKey().setPrimaryTenant(null);
                                apartment.getPersonsInApartment().clear();
                                System.out.println(user + " zwolnil " + entry.getKey());


                            }
                        }
                    }


                }
                case "6" -> {

                    showOccupiedRooms(Apartment.class,user);
                    wybor=wybor(scan);


                    for(Map.Entry<Room,Person>entry:estate.entrySet()){
                        if((entry.getKey().equals(Apartment.class))&&(entry.getValue()==user)){
                            ++licznik;}

                        licz=String.valueOf(licznik);
                            if(licz.equals(wybor)){
                                apartment=(Apartment) entry.getKey();
                                break;
                            }
                    }

                            if(apartment!=null) {
                                //assert apartment != null;
                                System.out.println(apartment.getPersonsInApartment());
                            }
                            else {
                                System.out.println("apartament jest pusty");
                            }
                        }



                case "7" ->{
                    showOccupiedRooms(Apartment.class,user);

                        wybor=wybor(scan);
                        for(Map.Entry<Room,Person>entry:estate.entrySet()){
                            if((entry.getKey().equals(Apartment.class))&&(entry.getValue()==user)){
                                ++licznik;}

                            licz=String.valueOf(licznik);
                            if(licz.equals(wybor)){
                                apartment=(Apartment) entry.getKey();
                                break;
                            }
                        }
                        licznik=0;

                        for(Person p:personSet){

                            System.out.println(++licznik+". "+p);
                        }

                    System.out.println(" podaj pesel wybranej osoby ");
                        wybor=wybor(scan);

                        for(Person p:personSet){
                            if(wybor.equals(String.valueOf(p.getPesel()))){
                                temPerson=p;
                            }
                        }
                        if((apartment!=null)&&(temPerson!=null)){
                        user.addPerson(temPerson,apartment);}

                    }

                case "8" -> {

                    System.out.println( " usuwanie lokatora ");

                    showOccupiedRooms(Apartment.class, user);

                    wybor = wybor(scan);

                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().equals(Apartment.class)) && (entry.getValue() == user)) {
                            ++licznik;
                        }

                        licz=String.valueOf(licznik);
                        if (licz.equals(wybor)) {
                            apartment = (Apartment) entry.getKey();
                            break;
                        }
                    }
                    licznik = 0;

                    for (Person p : personSet) {

                        System.out.println(++licznik + ". " + p);
                    }

                    System.out.println(" podaj pesel wybranej osoby ");
                    wybor = wybor(scan);

                    for (Person p : personSet) {
                        if (wybor.equals(String.valueOf(p.getPesel()))) {
                            temPerson = p;
                        }
                    }
                    if ((apartment != null) && (temPerson != null)) {

                        apartment.getPersonsInApartment().remove(temPerson);
                    }
                }
                case "9" -> {

                    System.out.println(" Wynajem garazu " + '\n');
                    System.out.println(" lista wolnych garazy " + '\n');
                    System.out.println(" Jestes zalogowany jako " + user);


                    if (showVacantRooms(ParkingPlace.class) == 0) {
                        System.out.println(" brak wolnych garazy na wynajem !");
                        break;
                    }


                    wybor=wybor(scan);

                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass().equals(ParkingPlace.class)) && (entry.getValue() == (null))) {
                            ++licznik;
                            //System.out.println(licznik+" "+entry.getKey());

                        }
                        licz=String.valueOf(licznik);
                        if (licz.equals(wybor)) {
                            entry.setValue(user);
                            System.out.println(user + " wynaja " + entry.getKey());

                            break;

                        }
                    }
                }
                case "10" -> {
                    System.out.println(" Zwolnij garaz Uzytkownik " + user);

                    if (showOccupiedRooms(ParkingPlace.class,user) == 0) {
                        System.out.println(" Nie posiadasz wynajetych garazy !");
                        break;
                    }


                    wybor=wybor(scan);




                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {

                        if ((entry.getKey().getClass().equals(ParkingPlace.class)) && (entry.getValue()==user)) {
                            ++licznik;
                            licz=String.valueOf(licznik);
                            if (licz.equals(wybor)) {
                                parkingPlace = (ParkingPlace) entry.getKey();
                                entry.setValue(null);
                                parkingPlace.getItems().clear();

                                System.out.println(user + " zwolnil " + entry.getKey());


                            }
                        }
                    }


                }
                case "11" -> {
                    showOccupiedRooms(ParkingPlace.class,user);
                    wybor=wybor(scan);


                    for(Map.Entry<Room,Person>entry:estate.entrySet()){
                        if((entry.getKey().equals(ParkingPlace.class))&&(entry.getValue()==user)){
                            ++licznik;}
                        licz=String.valueOf(licznik);

                        if(licz.equals(wybor)){
                            parkingPlace=(ParkingPlace) entry.getKey();
                            break;
                        }
                    }

                    if(parkingPlace!=null) {
                        //assert apartment != null;
                        System.out.println(parkingPlace.getItems());
                    }
                    else {
                        System.out.println("garaz jest pusty");
                    }
                }


                case "12" -> {

                    showOccupiedRooms(ParkingPlace.class,user);

                    wybor=wybor(scan);
                    for(Map.Entry<Room,Person>entry:estate.entrySet()){
                        if((entry.getKey().equals(ParkingPlace.class))&&(entry.getValue()==user)){
                            ++licznik;}

                        licz=String.valueOf(licznik);

                        if(licz.equals(wybor)){
                            parkingPlace=(ParkingPlace) entry.getKey();
                            break;
                        }
                    }
                    licznik=0;
//=======================================================================
                    for(Item it:itemsGlobal){

                        System.out.println(++licznik+". "+it);
                    }

                    wybor=wybor(scan);

                    for(Item it:itemsGlobal){
                        ++licznik;
                        licz=String.valueOf(licznik);
                        if(wybor==licz){
                            item=it;
                        }
                    }
                    parkingPlace.getItems().add(item);


//=========================================================================================================
                }

                case "13" -> {
                    showOccupiedRooms(ParkingPlace.class,user);

                    wybor=wybor(scan);
                    for(Map.Entry<Room,Person>entry:estate.entrySet()){
                        if((entry.getKey().equals(ParkingPlace.class))&&(entry.getValue()==user)){
                            ++licznik;}

                        licz=String.valueOf(licznik);

                        if(licz.equals(wybor)){
                            parkingPlace=(ParkingPlace) entry.getKey();
                            break;
                        }
                    }
                    licznik=0;

                    //=======================================================================
                    for(Item itpp:parkingPlace.getItems()){

                        System.out.println(++licznik+". "+itpp);
                    }

                    wybor=wybor(scan);

                    for(Item itpp:parkingPlace.getItems()){
                        ++licznik;
                        licz=String.valueOf(licznik);
                        if(wybor==licz){
                            item=itpp;
                        }
                    }
                    parkingPlace.getItems().remove(item);


//=========================================================================================================
                }
                case "14" -> {


                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if (entry.getValue() == user) {
                            System.out.println((++licznik) + ". " + entry.getKey());
                        }
                    }


                    if (licznik == 0) {
                        System.out.println(" Nie posiadasz wynajetych mieszkan !");
                    }

                }
                case "15" -> {


                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getValue() == user) && (entry.getKey().getClass().equals(ParkingPlace.class))) {
                            parkingPlace = (ParkingPlace) entry.getKey();
                            System.out.println(/*parkingPlace+" "+*/parkingPlace.getItems());
                        }
                    }
                }

                case "16" -> {
                    System.exit(0);
                }


                default -> System.out.println(" prosze podac prawidlowa liczbe !");


            }
        }
    }

    void showRooms(Class<?> clas) {
        int licznik=0;
        for (Map.Entry<Room, Person> entry : estate.entrySet()) {
            if (entry.getKey().getClass().equals(clas)) {
                System.out.println((++licznik) + ". " + entry.getKey());
            }
        }
    }



            int showVacantRooms(Class<?> clas) {
        int licznik=0;
        for (Map.Entry<Room, Person> entry : estate.entrySet()) {
            if ((entry.getKey().getClass().equals(clas)) && (entry.getValue() == null)) {
                System.out.println((++licznik) + ". " + entry.getKey());
            }
        }
        return licznik;
    }
    int showOccupiedRooms(Class<?> clas,Person user) {
        int licznik=0;
        for (Map.Entry<Room, Person> entry : estate.entrySet()) {
            if ((entry.getKey().getClass().equals(clas)) && (entry.getValue()==user)) {
                System.out.println((++licznik) + ". " + entry.getKey());
            }
        }
        return licznik;
    }

    String wybor(Scanner scan){

        String wybor=null;

        try{
        System.out.println(" podaj numer pod ktorym znajduje sie interesujaca Cie  pozycja  ");
        wybor=scan.nextLine();

        System.out.println(" wybrales numer "+ wybor);}

    catch(InputMismatchException e){
        System.out.println(" nie podales odpowiedniego numeru !!!");
        scan.nextLine();
        }
    return wybor;
    }

}




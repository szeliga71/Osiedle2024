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

    TechTime techTime;

    private Set<Person> personSet;
    private Map<Room, Person> estate;


    public Set<Person> getPersonSet() {
        return personSet;
    }

    private Set<Item> itemsGlobal;








    public Enviroment() {


        personSet = new HashSet<>();
        estate = new HashMap<>();
        itemsGlobal = new HashSet<>();

        techTime=new TechTime(this);



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
        Samochod_Terenowy st1 = new Samochod_Terenowy(28, "Toyota", "RAV4", Paliwo.DIESEL, 2500, 16);
        Amfibia am1 = new Amfibia(15, "UNIMAG", "AM!", Paliwo.PRAD, 150, true, true);
        Thing t1 = new Thing(1, "grabie");
        Thing t2 = new Thing(1, "lopata");
        Thing t3 = new Thing(3, "kosiarka");
        Thing t4 = new Thing(8, "betoniarka");

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


        estate.put(ap, null);
        estate.put(ap1, null);
        estate.put(ap2, null);
        estate.put(pp1, null);
        estate.put(pp2, null);
        estate.put(ap3, null);


    }




    public void run() {

        techTime.timeRun(this);


        Scanner scan = new Scanner(System.in);
        Person user = null;
        Person temPerson = null;
        Apartment apartment = null;
        //Room room=null;
        UUID id=null;
        ParkingPlace parkingPlace = null;
        //Item item = null;

        String choice = null;
        List<Apartment> apartmentOperationList = new ArrayList<>();
        List<ParkingPlace>parkingOperationList=new ArrayList<>();
        List<Item>itemOperationList=new ArrayList<>();
        List<Person>personOperationList=new ArrayList<>();

        while (true) {

            int pesel=0;
            int licznik = 0;


            if (user == null) {
                System.out.println(" Aby prawidlowo korzystac z programu musisz byc zalogowany !");
                choice = String.valueOf(1);
            } else {

                System.out.println();
                System.out.println(" wybierz odpowiednia cyfre " + '\n');
                System.out.println("  1. Pokaz wszystkie osoby / Zaloguj sie ");
                System.out.println("  2. Pokaz wszystkie wolne mieszkania i garaze");
                System.out.println("  3. Pokaz wszystkie mieszkania");
                System.out.println("  4. Pokaz wszystkie garaze");
                System.out.println("  5. Pokaz wolne mieszkania/ Wynajem mieszkania !");
                System.out.println("  6. Zwolnij mieszkanie");
                System.out.println("  7. Pokaz lokatorow w mieszkaniu");
                System.out.println("  8. Dodaj lokatora do mieszkania");
                System.out.println("  9. Usun lokatora z mieszkanaia ");
                System.out.println("  10. Pokaz wolne garaze/ Wynajem garazu !");
                System.out.println("  11. Zwolnij garaz");
                System.out.println("  12. Pokaz wszystkie przedmioty w garazu");
                System.out.println("  13. Dodaj przedmiot do garazu");
                System.out.println("  14. Usun przedmiot z garazu");
                System.out.println("  15. Pokaz wszyskie nieruchomosci wynajmowane przez osobe");
                System.out.println("  16. Pokaz wszystkie przedmioty danej osoby");
                System.out.println("  17. Pokaz dane uzytkownika i wszystkie nieruchomosci i wszystkie przedmioty");
                System.out.println("  18. EXIT");


                // M E N U

//zakończenia programu w dowolnym momencie


// wyświetlenia wolnych pomieszczeń


// wykonania polecenia zapisującego aktualny stan osiedla do pliku


                try {
                    choice = scan.nextLine();


                } catch (InputMismatchException e) {
                    System.out.println(" nie podales odpowiedniej cyfry !");
                }
            }

            switch (choice) {


                case "1" -> {


                    System.out.println(" LISTA OSOB \n");

                    personOperationList.addAll(personSet);

                    for (Person p : personOperationList) {
                        System.out.println((++licznik) + ". " + p);
                    }
                    System.out.println();
                    System.out.println("Zaloguj sie ,podajac nr pod ktorym widnieje interesujaca Cie pozycja  ");

                    int position=choose(scan);


                    if ((position > -1) && (position < personOperationList.size() + 2)) {
                        pesel = personOperationList.get(position - 1).getPesel();
                    }

                    for(Person p:personSet){
                        if(p.getPesel()==pesel){
                            user=p;
                        }
                    }



                    if (user == null) {
                        System.out.println(" UWAGA ! , nie jestes zalogowany , sprobuj ponownie !");
                    } else {
                        System.out.println(" Jestes zalogowany jako : " + user);

                    }


                    personOperationList.clear();
                }


                case "2"->{

                    System.out.println(" WSZYSTKIE WOLNE OBIEKTY W OBREBIE OSIEDLA"+'\n');

                    showVacantRooms();

                }


                case "3" -> {
                    System.out.println(" WSZYSTKIE MIESZKANIA " + '\n');
                    showAllRooms(Apartment.class);
                }

                case "4" -> {
                    System.out.println(" WSZYSTKIE GARAZE " + '\n');
                    showAllRooms(ParkingPlace.class);
                }




                case "5" -> {

                    //usuniecie file

                    System.out.println(" Jestes zalogowany jako " + user + '\n');
                    System.out.println(" lista wolnych mieszkan " + '\n');

                    licznik=showVacantApartments(apartmentOperationList);



                   /* for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass().equals(Apartment.class)) && (entry.getValue() == null)) {
                            apartmentOperationList.add((Apartment) entry.getKey());
                        }
                    }

                    for (Apartment a : apartmentOperationList) {
                        System.out.println(++licznik + ". " + a);
                    }*/

                    if(licznik==0){
                        System.out.println(" brak wolnych mieszkan !");
                    }else{
                    int position = choose(scan);
                        if ((position < 0) || (position > apartmentOperationList.size())) {
                            System.out.println(" podaj prawidlowa wartosc !");
                        } else {

                            if ((position > -1) && (position < apartmentOperationList.size() + 2)) {
                                id = apartmentOperationList.get(position - 1).getId();


                                System.out.println(" Podaj ilosc dni , na ktore chcesz zawrzec umowe najmu.");
                                int howManyDays=0;
                                howManyDays=scan.nextInt();



                                for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                    if (entry.getKey().getId().equals(id)) {
                                        entry.setValue(user);
                                        entry.getKey().setPrimaryTenant(user);

                                        apartment = (Apartment) entry.getKey();
                                        apartment.getPersonsInApartment().add(entry.getKey().getPrimaryTenant());


                                        LocalDate endOfRent=techTime.getCurrentTime()[0];

                                        endOfRent=endOfRent.plusDays(howManyDays);

                                        entry.getKey().setEndDate(endOfRent);


                                    }
                                }
                                System.out.println(user + " wynaja mieszkanie " + apartmentOperationList.get(position - 1));
                            }


                        }
                }
                    apartmentOperationList.clear();
                }


                case "6" -> {

                    //usuniecie file

                    System.out.println(" Zwolnij mieszkanie " + '\n' + "Jestes zalogowany jako : " + user);


                    /*for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass().equals(Apartment.class)) && (entry.getValue() == user)) {
                            apartmentOperationList.add((Apartment) entry.getKey());
                        }
                    }

                    for (Apartment a : apartmentOperationList) {
                        System.out.println(++licznik + ". " + a);
                    }*/

                    licznik=showUserApartments(apartmentOperationList,user);

                    if (licznik == 0) {
                        System.out.println(" nie masz jeszcze wynajetego mieszkania !");
                    } else {

                        int position = choose(scan);

                        if ((position < 0) || (position > apartmentOperationList.size())) {
                            System.out.println(" podaj prawidlowa wartosc !");
                        } else {
                            if ((position > -1) && (position < apartmentOperationList.size() + 2)) {
                                id = apartmentOperationList.get(position - 1).getId();
                            }

                            for (Map.Entry<Room, Person> entry : estate.entrySet()) {

                                if (entry.getKey().getId().equals(id)) {
                                    entry.setValue(null);
                                    //entry.getKey().setDateOfRent(null);
                                    //entry.getKey().setDateOfLeave(null);
                                    apartment = (Apartment) entry.getKey();
                                    apartment.getPersonsInApartment().clear();

                                }
                            }
                            System.out.println(user + " zwolnil mieszkanie " + apartmentOperationList.get(position - 1));
                        }
                    }

                        apartmentOperationList.clear();

                    }

                    case "7" -> {

                        System.out.println(" POKAZ LOKATOROW Z MIESZKANIA ");

                        System.out.println(" wskaz mieszkanie z ktorego chcesz pokazac lokatorow !");

                        /*for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                            if ((entry.getKey().getClass() == Apartment.class) && (entry.getValue() == user)) {
                                System.out.println(++licznik + ". " + entry.getKey());
                                apartmentOperationList.add((Apartment) entry.getKey());
                            }
                        }*/
                        licznik=showUserApartments(apartmentOperationList,user);

                        if (licznik == 0) {
                            System.out.println(" nie masz jeszcze wynajetego mieszkania !");
                        } else {

                            int position = choose(scan);

                            if ((position < 0) || (position > apartmentOperationList.size())) {
                                System.out.println(" podaj prawidlowa wartosc !");
                            } else {
                                if ((position > -1) && (position < apartmentOperationList.size() + 2)) {
                                    id = apartmentOperationList.get(position - 1).getId();
                                }

                                for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                    if (entry.getKey().getId().equals(id)) {
                                        apartment = (Apartment) entry.getKey();
                                    }
                                }
                                licznik = 0;
                                for (Person p : apartment.getPersonsInApartment()) {
                                    System.out.println(++licznik + ". " + p);
                                }




                            }
                        }
                        apartment = null;
                        apartmentOperationList.clear();
                    }



                case "8" -> {      System.out.println(" DODAJ LOKATORA DO MIESZKANIA ");

                    System.out.println(" wskaz mieszkanie do ktorego chcesz dodac lokatora !");

                   /* for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass() == Apartment.class) && (entry.getValue() == user)) {
                            System.out.println(++licznik + ". " + entry.getKey());
                            apartmentOperationList.add((Apartment) entry.getKey());
                        }
                    }*/

                    licznik=showUserApartments(apartmentOperationList,user);

                    if(licznik==0){
                        System.out.println(" nie masz jeszcze wynajetych mieszkan !");
                    }else {
                        int position = choose(scan);

                        if ((position < 0) || (position > apartmentOperationList.size())) {
                            System.out.println(" podaj prawidlowa wartosc !");
                        } else {

                            if ((position > -1) && (position < apartmentOperationList.size() + 2)) {
                                id = apartmentOperationList.get(position - 1).getId();
                            }

                            for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                if (entry.getKey().getId().equals(id)) {

                                    apartment = (Apartment) entry.getKey();
                                }
                            }


                            licznik = 0;

                            personOperationList = personSet.stream().toList();

                            for (Person p : personOperationList) {
                                System.out.println(++licznik + ". " + p);
                            }

                            position = choose(scan);

                            if ((position > -1) && (position < personOperationList.size() + 2)) {
                                pesel = personOperationList.get(position - 1).getPesel();
                            }

                            for (Person p : personOperationList) {
                                if (p.getPesel() == pesel) {
                                    temPerson = p;
                                }
                            }


                            apartment.getPersonsInApartment().add(temPerson);

                            licznik = 0;

                            for (Person p : apartment.getPersonsInApartment()) {
                                System.out.println(++licznik + ". " + p);
                            }
                        }
                    }


                    apartment=null;
                    apartmentOperationList.clear();
                    temPerson=null;





                }


                case "9" -> {
                    System.out.println(" USUN LOKATORA Z MIESZKANIA ");

                    System.out.println(" wskaz mieszkanie z ktorego chcesz usunac lokatora !");

                   /* for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass() == Apartment.class) && (entry.getValue() == user)) {
                            System.out.println(++licznik + ". " + entry.getKey());
                            apartmentOperationList.add((Apartment) entry.getKey());
                        }
                    }*/
                    licznik=showUserApartments(apartmentOperationList,user);

                    if(licznik==0){

                        System.out.println(" nie masz jeszcze wynajetych mieszkan !");
                    }else {
                        int position = choose(scan);

                        if ((position < 0) || (position > apartmentOperationList.size())) {
                            System.out.println(" podaj prawidlowa wartosc !");
                        } else {

                            if ((position > -1) && (position < apartmentOperationList.size() + 2)) {
                                id = apartmentOperationList.get(position - 1).getId();
                            }

                            for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                if (entry.getKey().getId().equals(id)) {

                                    apartment = (Apartment) entry.getKey();
                                }
                            }
                            licznik = 0;

                            personOperationList = apartment.getPersonsInApartment().stream().toList();

                            for (Person p : personOperationList) {
                                System.out.println(++licznik + ". " + p);
                            }
                            position = choose(scan);

                            if ((position > -1) && (position < personOperationList.size() + 2)) {
                                pesel = personOperationList.get(position - 1).getPesel();
                            }
                            int pes = pesel;

                            Optional<Person> foundedPersons = apartment.getPersonsInApartment().stream().filter(person -> person.getPesel() == pes).findFirst();

                            Person pers = foundedPersons.get();
                            apartment.getPersonsInApartment().remove(pers);

                            licznik = 0;

                            for (Person p : apartment.getPersonsInApartment()) {
                                System.out.println(++licznik + ". " + p);
                            }

                        }
                    }
                    apartment=null;
                    apartmentOperationList.clear();



                }

                case "10" -> {
                    System.out.println(" WYNAJEM GARAZU");
                    System.out.println();
                    System.out.println(" Jestes zalogowany jako " + user + '\n');
                    System.out.println(" lista wolnych Garyz " + '\n');


                    /*for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass().equals(ParkingPlace.class)) && (entry.getValue() == null)) {
                            parkingOperationList.add((ParkingPlace) entry.getKey());
                        }
                    }

                    for (ParkingPlace p : parkingOperationList) {
                        System.out.println(++licznik + ". " + p);
                    }*/

                   licznik= showVacantParkingPlace(parkingOperationList);

                    if (licznik == 0) {
                        System.out.println(" brak wolnych garazy !");

                    } else {

                        int position = choose(scan);

                        if ((position < 0) || (position > parkingOperationList.size())) {
                            System.out.println(" podaj prawidlowa wartosc !");
                        } else {


                            if ((position > -1) && (position < parkingOperationList.size() + 2)) {
                                id = parkingOperationList.get(position - 1).getId();
                            }


                            for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                if (entry.getKey().getId().equals(id)) {
                                    entry.setValue(user);
                                    entry.getKey().setPrimaryTenant(user);
                                    //entry.getKey().setDateOfRent(LocalDate.now());
                                    //entry.getKey().setDateOfLeave(LocalDate.now());
                                    parkingPlace = (ParkingPlace) entry.getKey();

                                }
                            }
                            System.out.println(user + " wynaja garaz " + parkingOperationList.get(position - 1));
                        }

                }
                    parkingOperationList.clear();


                }

                case "11" -> {


                    System.out.println(" ZWOLNIJ GARAZ "+'\n'+ "Jestes zalogowany jako : " + user);




                    /*for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass().equals(ParkingPlace.class)) && (entry.getValue() == user)) {
                            parkingOperationList.add((ParkingPlace) entry.getKey());
                        }
                    }

                    for (ParkingPlace p:parkingOperationList) {
                        System.out.println(++licznik + ". " + p);
                    }*/
                    licznik=showUserParkingPlace(parkingOperationList,user);
                    if (licznik == 0) {
                        System.out.println(" brak wolnych garazy !");

                    } else {

                        int position = choose(scan);

                        if ((position < 0) || (position > parkingOperationList.size())) {
                            System.out.println(" podaj prawidlowa wartosc !");
                        } else {


                            if ((position > -1) && (position < parkingOperationList.size() + 2)) {
                                id = parkingOperationList.get(position - 1).getId();


                                for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                    if (entry.getKey().getId().equals(id)) {
                                        entry.setValue(null);
                                        //entry.getKey().setDateOfRent(null);
                                        //entry.getKey().setDateOfLeave(null);
                                        parkingPlace = (ParkingPlace) entry.getKey();
                                        itemsGlobal.addAll(new HashSet<>(parkingPlace.getItems()));
                                        parkingPlace.getItems().clear();
                                        parkingPlace.setCurrentLevel(0);

                                    }
                                }
                                System.out.println(user + " zwolnil garaz " + parkingOperationList.get(position - 1));
                            }
                        }
                    }
                    parkingOperationList.clear();

                }


                case "12" -> {


                    System.out.println(" POKAZ PRZEDMIOTY Z GARAZU ");

                    System.out.println(" wskaz garaz z ktorego chcesz pokazac przedmioty !");

                    /*for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass() == ParkingPlace.class) && (entry.getValue() == user)) {
                            System.out.println(++licznik + ". " + entry.getKey());
                            parkingOperationList.add((ParkingPlace) entry.getKey());
                        }
                    }*/
                    licznik=showUserParkingPlace(parkingOperationList,user);

                    if (licznik == 0) {
                        System.out.println(" brak wolnych garazy !");

                    } else {

                        int position = choose(scan);

                        if ((position < 0) || (position > parkingOperationList.size())) {
                            System.out.println(" podaj prawidlowa wartosc !");
                        } else {

                            if ((position > -1) && (position < parkingOperationList.size() + 2)) {
                                id = parkingOperationList.get(position - 1).getId();
                            }

                            for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                if (entry.getKey().getId().equals(id)) {

                                    parkingPlace = (ParkingPlace) entry.getKey();
                                }
                            }
                            licznik = 0;

                            for (Item it : parkingPlace.getItems()) {
                                System.out.println(++licznik + ". " + it);
                            }
                            if (licznik == 0) {
                                System.out.println(" Garaz jest jeszcze pusty ");
                            }

                        }
                    }
                            parkingPlace = null;
                            parkingOperationList.clear();


                        }

                        case "13" -> {
                            System.out.println(" DODAJ PRZEDMIOT DO GARAZU ");

                            System.out.println(" wskaz garaz do ktorego chcesz dodac przedmiot !");

                           /* for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                if ((entry.getKey().getClass() == ParkingPlace.class) && (entry.getValue() == user)) {
                                    System.out.println(++licznik + ". " + entry.getKey());
                                    parkingOperationList.add((ParkingPlace) entry.getKey());
                                }
                            }*/
                            licznik=showUserParkingPlace(parkingOperationList,user);

                            if (licznik == 0) {
                                System.out.println(" nie masz jeszcze wynajetego garazu !");
                            } else {
                                int position = choose(scan);

                                if ((position < 0) || (position > itemOperationList.size())) {
                                    System.out.println(" podaj prawidlowa wartosc !");
                                } else {
                                    if ((position > -1) && (position < parkingOperationList.size() + 2)) {
                                        id = parkingOperationList.get(position - 1).getId();
                                    }

                                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                        if (entry.getKey().getId().equals(id)) {

                                            parkingPlace = (ParkingPlace) entry.getKey();
                                        }
                                    }
                                    licznik = 0;

                                    itemOperationList.addAll(itemsGlobal);

                                    for (Item it : itemOperationList) {
                                        System.out.println(++licznik + ". " + it);
                                    }

                                    position = choose(scan);

                                    System.out.println(position);

                                    if ((position < 0) || (position > itemOperationList.size())) {
                                        System.out.println(" podaj prawidlowa wartosc !");
                                    } else {

                                        if ((position > -1) && (position < itemOperationList.size() + 2)) {
                                            id = itemOperationList.get(position - 1).getItemId();
                                        }

                                        UUID idItemTemp = id;


                                        Optional<Item> foundedItem = itemsGlobal.stream().filter(it -> it.getItemId() == idItemTemp).findFirst();

                                        Item itemm = foundedItem.get();
                                        if ((parkingPlace.getCurrentLevel() + itemm.getVolume()) >= parkingPlace.getArea()) {
                                            System.out.println(" nie mozesz wlozyc wybranej rzeczy do garazu , poniewaz nie wystarczy juz miejsca !!!");
                                        } else {
                                            parkingPlace.getItems().add(itemm);
                                            parkingPlace.setCurrentLevel(parkingPlace.getCurrentLevel() + itemm.getVolume());
                                            itemsGlobal.remove(itemm);

                                            licznik = 0;

                                            for (Item it : parkingPlace.getItems()) {
                                                System.out.println(++licznik + ". " + it);
                                            }


                                        }
                                    }
                                }
                            }


                    parkingPlace = null;
                    parkingOperationList.clear();
                    itemOperationList.clear();
                }

                case "14" -> {
                    System.out.println(" USUN PRZEDMIOT Z GARAZU ");

                    System.out.println(" wskaz garaz z ktorego chcesz usunac przedmiot !");

                    /*for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getKey().getClass() == ParkingPlace.class) && (entry.getValue() == user)) {
                            System.out.println(++licznik + ". " + entry.getKey());
                            parkingOperationList.add((ParkingPlace) entry.getKey());
                        }
                    }*/

                    licznik=showUserParkingPlace(parkingOperationList,user);

                    if (licznik == 0) {
                        System.out.println(" nie masz jeszcze wynajetego garazu !");
                    } else {
                        int position = choose(scan);

                        if ((position < 0) || (position > parkingOperationList.size())) {
                            System.out.println(" podaj prawidlowa wartosc !");
                        } else {

                            if ((position > -1) && (position < parkingOperationList.size() + 2)) {
                                id = parkingOperationList.get(position - 1).getId();
                            }

                            for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                                if (entry.getKey().getId().equals(id)) {
                                    parkingPlace = (ParkingPlace) entry.getKey();
                                }
                            }
                            licznik = 0;


                            for (Item it : parkingPlace.getItems()) {
                                System.out.println(++licznik + ". " + it);
                            }

                            position = choose(scan);

                            if ((position > -1) && (position < parkingPlace.getItems().size() + 2)) {
                                id = parkingPlace.getItems().get(position - 1).getItemId();
                            }

                            UUID itemIdTemp = id;

                            Optional<Item> foundedItem = parkingPlace.getItems().stream().filter(itemx -> itemx.getItemId() == itemIdTemp).findFirst();

                            Item itemm = foundedItem.get();
                            parkingPlace.getItems().remove(itemm);
                            parkingPlace.setCurrentLevel(parkingPlace.getCurrentLevel() - itemm.getVolume());
                            itemsGlobal.add(itemm);

                        }
                    }



                    parkingPlace=null;
                    parkingOperationList.clear();
                    itemOperationList.clear();



                }


                case "15" -> {


                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if (entry.getValue() == user) {
                            System.out.println((++licznik) + ". " + entry.getKey());
                        }
                    }


                    if (licznik == 0) {
                        System.out.println(" Nie posiadasz wynajetych mieszkan !");
                    }

                }
                case "16" -> {


                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getValue()==user) && (entry.getKey().getClass()==ParkingPlace.class)) {
                            parkingPlace=(ParkingPlace) entry.getKey();
                            System.out.println(/*parkingPlace+" "+*/parkingPlace.getItems());
                        }
                    }
                }

                case "17"->{
                    System.out.println(" DANE UZYTKOWNIKA ,NIERUCHOMOSCI I PRZEDMIOTY"+'\n');
                    System.out.println(user);

                }

                case "18" -> System.exit(0);
                     //scheduledExecutorService.shutdown();

                case "19"->{

                    //   TEST CASE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    System.out.println("TEST CASE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

                    //showForAllVacantRooms(Apartment.class,null);

                 /*   System.out.println("  sprawdzanie dat ");


                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {

                        //entry.getKey().setEndDate(LocalDate.now());
                        System.out.println(Arrays.toString(entry.getKey().getEndDate()));

                        if(entry.getKey().getEndDate()!=null && entry.getKey().getEndDate()[0]!=null) {
                            if (entry.getKey().getEndDate()[0].equals(LocalDate.now())) { //|| (entry.getKey().getEndDate()[0].isAfter(temp[0]))) {
                                System.out.println("Ta nieruchomosc ma przekroczony czas wynajmu! " + entry.getKey());
                            }
                        }else{
                            System.out.println(" nie ustawiono daty ");
                        }



                }

                    System.out.println(" przeszlo po mapie");*/
                }


                default -> System.out.println(" prosze podac prawidlowa liczbe !");


            }
        }
    }

    void showForAllVacantRooms(Class<?> clas,Person person) {
        int licznik = 0;
        for (Map.Entry<Room, Person> entry : estate.entrySet()) {
            if ((entry.getKey().getClass().equals(clas))&&(entry.getValue().equals(person)))  {
                System.out.println((++licznik) + ". " + entry.getKey());
            }
        }
    }

    UUID choosePositon(int licznik,Scanner scan,List<Apartment>apartmentTemporaryList){
        UUID id=null;
        if (licznik == 0) {
            System.out.println(" nie masz jeszcze wynajetego mieszkania !");
        } else {

            int position = choose(scan);

            if ((position < 0) || (position > apartmentTemporaryList.size())) {
                System.out.println(" podaj prawidlowa wartosc !");
            } else {
                if ((position > -1) && (position < apartmentTemporaryList.size() + 2)) {
                    id = apartmentTemporaryList.get(position - 1).getId();
                }
    }
        }
    return id;}

    int showVacantParkingPlace(List<ParkingPlace>parkingPlaceTemporaryList){
        int licznik=0;

        for (Map.Entry<Room, Person> entry : estate.entrySet()) {
            if ((entry.getKey().getClass().equals(ParkingPlace.class)) && (entry.getValue() == null)) {
                parkingPlaceTemporaryList.add((ParkingPlace) entry.getKey());
            }
        }

        for (ParkingPlace p : parkingPlaceTemporaryList) {
            System.out.println(++licznik + ". " + p);
        }

        return licznik;
    }
    int showUserParkingPlace(List<ParkingPlace>parkingPlaceTemporaryList,Person user){
        int licznik=0;

                       for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                           if ((entry.getKey().getClass().equals(ParkingPlace.class)) && (entry.getValue() == user)) {
                               parkingPlaceTemporaryList.add((ParkingPlace) entry.getKey());
                           }
                       }

                           for (ParkingPlace p : parkingPlaceTemporaryList) {
                               System.out.println(++licznik + ". " + p);
                           }

                    return licznik;
    }

    int showUserApartments(List<Apartment>listOperationTemp,Person user){
        int licznik=0;
          for (Map.Entry<Room, Person> entry : estate.entrySet()) {
        if ((entry.getKey().getClass().equals(Apartment.class)) && (entry.getValue() == user)) {
            listOperationTemp.add((Apartment) entry.getKey());
        }
    }
          for (Apartment a : listOperationTemp) {
        System.out.println(++licznik + ". " + a);
    }
          return licznik;
    }

    int showVacantApartments(List<Apartment>listOperationTemp) {

        int licznik=0;
        for (Map.Entry<Room, Person> entry : estate.entrySet()) {

            if ((entry.getKey().getClass().equals(Apartment.class)) && (entry.getValue() == null)) {
                listOperationTemp.add((Apartment) entry.getKey());
            }
        }

        for (Apartment a : listOperationTemp) {
            System.out.println(++licznik + ". " + a);
        }
    return licznik;
    }

    void showVacantRooms(){
        int licznik=0;
        for (Map.Entry<Room, Person> entry : estate.entrySet()) {
            if (entry.getValue() == null) {
                System.out.println(++licznik+". "+entry.getKey());
            }
        }
    }
    void showAllRooms(Class<?> clas) {
        int licznik = 0;
        for (Map.Entry<Room, Person> entry : estate.entrySet()) {
            if (entry.getKey().getClass().equals(clas)) {
                System.out.println((++licznik) + ". " + entry.getKey());
            }
        }
    }


    int choose(Scanner scan){

        int wybor=-1;

        try{
            System.out.println(" podaj numer pod ktorym znajduje sie interesujaca Cie  pozycja  ");
            wybor = scan.nextInt();
            scan.nextLine();
            System.out.println(" wybrales numer " + wybor);
        } catch (InputMismatchException e) {
            System.out.println(" nie podales odpowiedniego numeru !!!");
            scan.nextLine();
            return wybor;
        }

        return wybor;
    }



    public Map<Room, Person> getEstate() {
        return estate;
    }


    public void setEstate(Map<Room, Person> estate) {
        this.estate = estate;
    }
    public void setItemsGlobal(Set<Item> itemsGlobal) {
        this.itemsGlobal = itemsGlobal;
    }
    public Set<Item> getItemsGlobal() {
        return itemsGlobal;
    }

    public boolean fiveRoomRentLimitation(Person user){

        int count=0;

        for(Map.Entry<Room,Person>entry:estate.entrySet()){

        if(entry.getValue().equals(user)){
        ++count;}
        }
        return count > 5;
    }
}




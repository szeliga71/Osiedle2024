package Estate.RealEstate.Technical;

import Estate.RealEstate.Items.Item;
import Estate.RealEstate.Items.Veihcle.Paliwo;
import Estate.RealEstate.Items.Veihcle.Samochod_Miejski;
import Estate.RealEstate.Nation;
import Estate.RealEstate.Person;
import Estate.RealEstate.Rooms.Apartment;
import Estate.RealEstate.Rooms.ParkingPlace;
import Estate.RealEstate.Rooms.Room;

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

        Apartment ap = new Apartment(120);
        Apartment ap1 = new Apartment(159);
        Apartment ap2 = new Apartment(220);
        ParkingPlace pp1 = new ParkingPlace(30);
        ParkingPlace pp2 = new ParkingPlace(35);
        Samochod_Miejski sm1 = new Samochod_Miejski(6, "Suzuki", "Swift", Paliwo.BENZYNA, 1000, true, "White");


        // tu automat ladowanie z pliku


        personSet.add(p1);
        personSet.add(p2);
        //p1.addThingOrCar(sm1,pp1);

        estate.put(ap, null);
        estate.put(ap1, null);
        estate.put(ap2, null);
        estate.put(pp1, null);
        estate.put(pp2, null);


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


        Apartment ap3 = new Apartment(123);
        Person p1 = new Person("Kamil", "Nowak", 44, Nation.DEUTSCH);


        personSet.add(p1);
        estate.put(ap3, p1);
        System.out.println();

        Scanner scan = new Scanner(System.in);
        Person user = null;
        Person temPerson = null;
        Apartment apartment = null;
        ParkingPlace parkingPlace = null;

        int choice = 0;

        while (true) {

            int licznik = 0;
            int wybor = 0;

            if (user == null) {
                System.out.println(" Aby prawidlowo korzystac z programu musisz byc zalogowany !");
                choice = 1;
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
                    choice = scan.nextInt();

                } catch (InputMismatchException e) {
                    System.out.println(" nie podales odpowiedniej cyfry !");
                    scan.next();
                }
            }


            switch (choice) {


                case 1 -> {
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
                    } catch (InputMismatchException e) {
                        System.out.println(" prosze podac prawidlowy pesel !");
                        scan.next();
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

                case 2 -> {
                    System.out.println(" Wszystkie mieszkania " + '\n');
                    showRooms(Apartment.class);
                }

                case 3 -> {
                    System.out.println(" Wszystkie garaze " + '\n');
                    showRooms(ParkingPlace.class);
                }

                case 4 -> {

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
                        if (wybor == licznik) {
                            apartment=(Apartment)entry.getKey();
                            entry.setValue(user);

                            entry.getKey().setPrimaryTenant(user);
                            apartment.getPersonsInApartment().add(user);

                            System.out.println(apartment.getPersonsInApartment());
                            System.out.println(user + " wynaja " + entry.getKey());

                            break;

                        }
                    }


                }

                case 5 -> {


                    System.out.println(" Zwolnij mieszkanie Uzytkownik " + user);


                    if (showOccupiedRooms(Apartment.class,user)== 0) {
                        System.out.println(" Nie posiadasz wynajetych mieszkan !");
                        break;
                    }

                    wybor = wybor(scan);




                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {

                        if ((entry.getKey().getClass().equals(Apartment.class)) && (entry.getValue() == user)) {
                            ++licznik;
                            if (licznik == wybor) {
                                apartment = (Apartment) entry.getKey();
                                entry.setValue(null);
                                entry.getKey().setPrimaryTenant(null);
                                apartment.getPersonsInApartment().clear();
                                System.out.println(user + " zwolnil " + entry.getKey());


                            }
                        }
                    }


                }
                case 6 -> {

                    showOccupiedRooms(Apartment.class,user);
                    wybor=wybor(scan);


                    for(Map.Entry<Room,Person>entry:estate.entrySet()){
                        System.out.println(" dupa1");
                        if((entry.getKey().equals(Apartment.class))&&(entry.getValue()==user)){
                            ++licznik;}

                            if(licznik==wybor){
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



                case 7 ->{}
                case 8 -> {
                }
                case 9 -> {

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
                        if (licznik == wybor) {
                            entry.setValue(user);
                            System.out.println(user + " wynaja " + entry.getKey());

                            break;

                        }
                    }
                }
                case 10 -> {
                    System.out.println(" Zwolnij garaz Uzytkownik " + user);

                    if (showOccupiedRooms(ParkingPlace.class,user) == 0) {
                        System.out.println(" Nie posiadasz wynajetych garazy !");
                        break;
                    }


                    wybor=wybor(scan);




                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {

                        if ((entry.getKey().getClass().equals(ParkingPlace.class)) && (entry.getValue()==user)) {
                            ++licznik;
                            if (licznik == wybor) {
                                parkingPlace = (ParkingPlace) entry.getKey();
                                entry.setValue(null);
                                parkingPlace.getItems().clear();

                                System.out.println(user + " zwolnil " + entry.getKey());


                            }
                        }
                    }


                }
                case 11 -> {
                }
                case 12 -> {
                }
                case 13 -> {
                }
                case 14 -> {

                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if (entry.getValue() == user) {
                            System.out.println((++licznik) + ". " + entry.getKey());
                        }
                    }
                    if (licznik == 0) {
                        System.out.println(" Nie posiadasz wynajetych mieszkan !");
                    }

                }
                case 15 -> {


                    for (Map.Entry<Room, Person> entry : estate.entrySet()) {
                        if ((entry.getValue() == user) && (entry.getKey().getClass().equals(ParkingPlace.class))) {
                            parkingPlace = (ParkingPlace) entry.getKey();
                            System.out.println(/*parkingPlace+" "+*/parkingPlace.getItems());
                        }
                    }
                }

                case 16 -> {
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

    int wybor(Scanner scan){

        int wybor=0;

        try{
        System.out.println(" podaj numer pod ktorym znajduje sie interesujaca Cie  pozycja  ");
        wybor=scan.nextInt();

        System.out.println(" wybrales numer "+wybor);}

    catch(InputMismatchException e){
        System.out.println(" nie podales odpowiedniego numeru !!!");
        scan.next();
        }
    return wybor;
    }

}




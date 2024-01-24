package Estate.RealEstate.Technical;

import Estate.RealEstate.Items.Veihcle.Paliwo;
import Estate.RealEstate.Items.Veihcle.Samochod_Miejski;
import Estate.RealEstate.Nation;
import Estate.RealEstate.Person;
import Estate.RealEstate.Rooms.Apartment;
import Estate.RealEstate.Rooms.ParkingPlace;
import Estate.RealEstate.Rooms.Room;

import java.util.*;

public class Enviroment {

    private Set<Room> roomSet;
    private Set<Person>personSet;
    private Map<Room,Person>estate;

    public Enviroment() {

        roomSet=new HashSet<>();
        personSet=new HashSet<>();
        estate=new HashMap<>();



        // dane do pracy
        Person person = new Person("Jan", "Kowalski", 43, Nation.POLISH);

        Apartment ap=new Apartment(120);
        Apartment ap1=new Apartment(159);
        ParkingPlace pp1=new ParkingPlace(30);
        Samochod_Miejski sm1=new Samochod_Miejski(6,"Suzuki","Swift", Paliwo.BENZYNA,1000,true,"White");


        // tu automat ladowanie z pliku

        roomSet.add(ap);
        roomSet.add(ap1);
        roomSet.add(pp1);
        personSet.add(person);
        person.addThingOrCar(sm1);



    }

    public void setRoomSet(Set<Room> roomSet) {
        this.roomSet = roomSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public Set<Room> getRoomSet() {
        return roomSet;
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


    public void run(){


        Apartment ap3=new Apartment(123);
        Person p1=new Person("Kamil","Nowak",44,Nation.DEUTSCH);

        personSet.add(p1);
        estate.put(ap3,p1);
        System.out.println();
       // for(Map.Entry entryset : estate.entrySet()){
         //   System.out.println(entryset);
       // }
           //Set<Room> roomSet=new HashSet<>();
           //Set<Person>personSet=new HashSet<>();
        Scanner scan=new Scanner(System.in);
        Person user=null;
        int choice=0;

           while(true){

               if(user==null){
                   System.out.println(" Aby prawidlowo korzystac z programu musisz byc zalogowany !");
                   choice=1;
               }else {

                   System.out.println();
                   System.out.println(" wybierz odpowiednia cyfre ");
                   System.out.println("  1. Pokaz wszystkie osoby / Zaloguj sie ");
                   System.out.println("  2. Pokaz wszystkie mieszkania");
                   System.out.println("  3. Pokaz wszystkie garaze");
                   System.out.println("  4. Pokaz wolne mieszkania");
                   System.out.println("  5. Wynajmij mieszkanie");
                   System.out.println("  6. Zwolnij mieszkanie");
                   System.out.println("  7. Pokaz lokatorow w mieszkaniu");
                   System.out.println("  8. Dodaj lokatora do mieszkania");
                   System.out.println("  9. Usun lokatora z mieszkanaia ");
                   System.out.println("  10. Pokaz wolne garaze");
                   System.out.println("  11. Pokaz zajete garaze");
                   System.out.println("  12. Wynajmij garaz");
                   System.out.println("  13. Zwolnij garaz");
                   System.out.println("  14. Pokaz wszystkie przedmioty w garazu");
                   System.out.println("  15. Dodaj przedmiot do garazu");
                   System.out.println("  16. Usun przedmiot z garazu");
                   System.out.println("  17. Pokaz wszyskie nieruchomosci wynajmowane przez osobe");
                   System.out.println("  18. Pokaz wszystkie przedmioty danej osoby");

                   System.out.println("  19. EXIT");


               // M E N U

//zakończenia programu w dowolnym momencie
// wybrania którą jest osobą (nie jest potrzebne żadne logowanie, wystarczy wskazanie
  //             np. unikalnego numeru osoby
               // wypisania swoich danych łącznie z wynajętymi pomieszczeniami
// wyświetlenia wolnych pomieszczeń
// wynajęcia nowego pomieszczenia, po uprzednim jego wybraniu
// wybrania pomieszczenia które wynajmuje dana osoba oraz wyświetlenia zawartości
  //                     pomieszczenia
// włożenia nowych pojazdów/przedmiotów pamiętając, aby nie przepełnić pomieszczenia
// wyjęcia przedmiotów lub pojazdów.
// wykonania polecenia zapisującego aktualny stan osiedla do pliku



        choice=scan.nextInt();

               }


    switch (choice){



        case   1  -> {
            System.out.println();
            System.out.println(" Lista osob ");
            System.out.println();
            int i = 1;

            for (Person p : personSet) {
                System.out.println((i++) + ". " + p);
            }
            System.out.println();
            System.out.println("Zaloguj sie ,podajac pesel ");
            int podajPesel= scan.nextInt();
            for (Person p : personSet) {
                if(p.getPesel()==podajPesel){
                    user=p;
                }
            }
            System.out.println();
            if(user==null){
                System.out.println(" UWAGA ! , nie jestes zalogowany , sprobuj ponownie !");
            }else {
                System.out.println(" Jestes zalogowany jako : " + user);
            }
        }

        case  2 ->{
            for(Room r:roomSet){
                if(r.getClass().equals(Apartment.class))
                System.out.println(r);
            }

            System.out.println(user);
        }

        case 3 ->{  for(Room r:roomSet){
            if(r.getClass().equals(ParkingPlace.class))
                System.out.println(r);
        }}

        case 4->{}
        case 5->{


        }
        case 6->{}
        case 7->{}
        case 8->{}
        case 9->{}
        case 10->{}
        case 11->{}
        case 12->{}
        case 13->{}
        case 14->{}
        case 15->{}
        case 16->{}
        case 17->{}
        case 18->{}
        case 19->{System.exit(0);}

        default -> System.out.println(" prosze podac prawidlowa liczbe !");


    }}}}




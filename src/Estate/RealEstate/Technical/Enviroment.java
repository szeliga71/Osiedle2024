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


    private Set<Person>personSet;
    private Map<Room,Person>estate;

    public Enviroment() {


        personSet=new HashSet<>();
        estate=new HashMap<>();



        // dane do pracy
        Person person = new Person("Jan", "Kowalski", 43, Nation.POLISH);
        Person p2=new Person("Bronislaw","Cieslak",45,Nation.FRENCH);

        Apartment ap=new Apartment(120);
        Apartment ap1=new Apartment(159);
        Apartment ap2 =new Apartment(220);
        ParkingPlace pp1=new ParkingPlace(30);
        ParkingPlace pp2=new ParkingPlace(35);
        Samochod_Miejski sm1=new Samochod_Miejski(6,"Suzuki","Swift", Paliwo.BENZYNA,1000,true,"White");


        // tu automat ladowanie z pliku


        personSet.add(person);
        personSet.add(p2);
        person.addThingOrCar(sm1);

        estate.put(ap,null);
        estate.put(ap1,null);
        estate.put(ap2,null);
        estate.put(pp1,null);



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


    public void run(){


        Apartment ap3=new Apartment(123);
        Person p1=new Person("Kamil","Nowak",44,Nation.DEUTSCH);

        personSet.add(p1);
        estate.put(ap3,p1);
        System.out.println();
        //for(Map.Entry entryset : estate.entrySet()){
          //  System.out.println(entryset);
        //}
           //Set<Room> roomSet=new HashSet<>();
           //Set<Person>personSet=new HashSet<>();

        Scanner scan=new Scanner(System.in);
        Person user=null;

        int choice=0;

           while(true){

               int licznik=0;

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
                   //System.out.println("  5. Wynajmij mieszkanie");
                   System.out.println("  6. Zwolnij mieszkanie");
                   System.out.println("  7. Pokaz lokatorow w mieszkaniu");
                   System.out.println("  8. Dodaj lokatora do mieszkania");
                   System.out.println("  9. Usun lokatora z mieszkanaia ");
                   System.out.println("  10. Pokaz wolne garaze");
                   System.out.println("  11. Pokaz zajete garaze");
                   //System.out.println("  12. Wynajmij garaz");
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


        try{
        choice=scan.nextInt();

               }
        catch(InputMismatchException e){
        System.out.println(" nie podales odpowiedniej cyfry !");
        scan.next();}
               }


    switch (choice){



        case   1  -> {
            int podajPesel=0;
            System.out.println();
            System.out.println(" Lista osob \n");



            for (Person p : personSet) {
                System.out.println((++licznik) + ". " + p);
            }
            System.out.println();
            System.out.println("Zaloguj sie ,podajac pesel ");

            try {
                podajPesel = scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println(" prosze podac prawidlowy pesel !");
                scan.next();
            }

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


            for(Map.Entry<Room,Person>entry:estate.entrySet()){
                if(entry.getKey().getClass().equals(Apartment.class)){
                System.out.println((++licznik)+". "+entry.getKey());}
            }


        }

        case 3 ->{

            for(Map.Entry<Room,Person>entry:estate.entrySet()){
                if(entry.getKey().getClass().equals(ParkingPlace.class)){
                    System.out.println((++licznik)+". "+entry.getKey());}
            }
        }

        case 4->{
            System.out.println(" lista wolnych mieszkan ");
            System.out.println(" Jestes zalogowany jako " + user);
            int wybor=0;


            for(Map.Entry<Room,Person>entry:estate.entrySet()){

                if((entry.getKey().getClass().equals(Apartment.class))&&(entry.getValue()==null)){
                    System.out.println((++licznik)+". "+entry.getKey());
                }}
                if(licznik==0){
                    System.out.println(" brak wolnych mieszkan na wynajem !");
                    break;}



            try{
                System.out.println(" podaj numer pod ktorym znajduje sie mieszkanie ktore chcesz wynajac ");
                wybor=scan.nextInt();

                System.out.println(" wybrales numer "+wybor);}

            catch(InputMismatchException e){
                System.out.println(" nie podales odpowiedniego numeru !!!");
            scan.next();}

            licznik=0;


            for(Map.Entry<Room,Person>entry:estate.entrySet()){
                if((entry.getKey().getClass().equals(Apartment.class))&&(entry.getValue()==null)){
                    licznik++;
                    if(licznik==wybor){
                    estate.put(entry.getKey(),user);
                    entry.getKey().setPrimaryTenant(user);
                    user.getRooms().add(entry.getKey());
                    System.out.println( user +" wynaja "+ entry.getKey());


                }
                }
            }


            System.out.println(" taki wynajem "+ user.getRooms());


        }

        case 5->{



        }
        case 6->{

            int wybor=0;

            System.out.println(" Zwolnij mieszkanie Uzytkownik "+ user);

            for(Map.Entry<Room,Person>entry:estate.entrySet()){
                if((entry.getValue()==user)&&(entry.getKey().getClass()==Apartment.class)){
                    System.out.println((++licznik)+". "+entry.getKey());
                }}
            if(licznik==0){
                System.out.println(" Nie posiadasz wynajetych mieszkan !");
            }

            try{
                System.out.println(" podaj numer pod ktorym znajduje sie mieszkanie ktore chcesz zwolnic ");
                wybor=scan.nextInt();

                System.out.println(" wybrales numer "+wybor);}

            catch(InputMismatchException e){
                System.out.println(" nie podales odpowiedniego numeru !!!");
                scan.next();}

            licznik=0;


            for(Map.Entry<Room,Person>entry:estate.entrySet()){
                if((entry.getKey().getClass().equals(Apartment.class))){
                    licznik++;
                    if(licznik==wybor){
                        estate.remove(entry.getKey());
                        entry.getKey().setPrimaryTenant(null);
                        user.getRooms().remove(entry.getKey());
                        System.out.println( user +" zwolnil "+ entry.getKey());


                    }
                }
            }


        }
        case 7->{}
        case 8->{}
        case 9->{}
        case 10->{
            for(Map.Entry<Room,Person>entry:estate.entrySet()){
            if((entry.getKey().getClass().equals(ParkingPlace.class))&&(entry.getValue()==null)){
                System.out.println((++licznik)+". "+entry.getKey());}
            }
        }
        case 11->{}
        case 12->{}
        case 13->{}
        case 14->{}
        case 15->{}
        case 16->{}
        case 17->{

            for(Map.Entry<Room,Person>entry:estate.entrySet()){
                if(entry.getValue()==user){
                    System.out.println((++licznik)+". "+entry.getKey());
                }}
                if(licznik==0){
                    System.out.println(" Nie posiadasz wynajetych mieszkan !");
                }

        }
        case 18->{}
        case 19->{System.exit(0);}

        default -> System.out.println(" prosze podac prawidlowa liczbe !");


    }}}}




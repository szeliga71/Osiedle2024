package Estate.RealEstate;

import Estate.RealEstate.Technical.Enviroment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

        LocalDate[] endDate={LocalDate.now().plusDays(4)};

        Enviroment en = new Enviroment();
        ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(en.getEstate().size());
                //Executors.newFixedThreadPool(en.getEstate().size());

        final LocalDate[] presentDay={LocalDate.now()};

        Runnable time =()->{
        presentDay[0]=presentDay[0].plusDays(1);
            System.out.println(" aktualna watkowa data "+presentDay[0]);};

        Runnable check1=()->{
            System.out.println(" tu bede sprawdzal terminy");
            if(presentDay[0].isEqual(endDate[0])||(presentDay[0].isAfter(endDate[0]))){
            boolean juz=true;

            endDate[0]=null;
            if(juz){
                System.out.println(" koniec wynajmu");

            }}
        };



        scheduledExecutorService.scheduleAtFixedRate(time,0,5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(check1,0,10,TimeUnit.SECONDS);
        //executorService.submit(()->startRent());




       //en.getRoomSet().add(ap);
        //en.getRoomSet().add(ap1);
        //en.getRoomSet().add(pp1);
        //en.getPersonSet().add(person);
        en.run();


    }

}

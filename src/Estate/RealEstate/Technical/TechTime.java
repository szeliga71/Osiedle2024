package Estate.RealEstate.Technical;

import Estate.RealEstate.Person;
import Estate.RealEstate.Rooms.Room;

import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TechTime {


    public Enviroment en;

    final LocalDate[] currentTime = {LocalDate.now()};

    public TechTime(Enviroment en){
        this.en=en;
    }

    public LocalDate[] getCurrentTime() {
        return currentTime;
    }

    public void timeRun(Enviroment en) {

        //final LocalDate[] currentTime = {LocalDate.now()};


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(en.getEstate().size());

        //Executors.newFixedThreadPool(en.getEstate().size());
        //executorService.submit(()->startRent());

        // to jest symulacja czasu

        Runnable time = () -> {
            currentTime[0] = currentTime[0].plusDays(1);
            System.out.println(" aktualna data " + currentTime[0]);
        };



        // tu sprawdzanie daty konca wynajmu
        Runnable check1 = () -> {

            LocalDate[] temp=new LocalDate[1];
            temp[0]=currentTime[0];


            System.out.println(" data z watku sprawdzajacego  "+temp[0]);

            for (Map.Entry<Room, Person> entry : en.getEstate().entrySet()) {

                if(entry.getKey().getEndDate()!=null&&entry.getKey().getEndDate()[0]!=null){
                    System.out.println(" wlazlo do pierwszego ifa  ");
                    System.out.println(entry.getKey().getEndDate()[0]);
                    System.out.println(temp[0]);
                    System.out.println(currentTime[0]);
                if (entry.getKey().getEndDate()[0].equals(temp[0])){
                    System.out.println(" dzisiaj konczy sie wynajem !!!");
                    }
                    if(entry.getKey().getEndDate()[0].isAfter(temp[0])) {
                   System.out.println("Ta nieruchomosc ma przekroczony czas wynajmu!!! " + entry.getKey());
                }
            }else{
                    System.out.println(" lokal jeszcze nie wynajety !!!");
                }
            }

        };

        scheduledExecutorService.scheduleAtFixedRate(time, 0, 5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(check1, 0, 10, TimeUnit.SECONDS);


        //scheduledExecutorService.shutdown();
    }
}

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

    public TechTime(Enviroment en){
        this.en=en;
    }

    final LocalDate[] currentTime = {LocalDate.now()};
   public void timeRun(Enviroment en) {

       // final LocalDate[] currentTime = {LocalDate.now()};


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(en.getEstate().size());

        //Executors.newFixedThreadPool(en.getEstate().size());
        //executorService.submit(()->startRent());

        // to jest symulacja czasu
        Runnable time = () -> {
            currentTime[0] = currentTime[0].plusDays(1);
            System.out.println(" aktualna watkowa data " + currentTime[0]);
        };

        // tu sprawdzanie daty konca wynajmu
        Runnable check1 = () -> {

            System.out.println(" tu bede sprawdzal terminy");

            for (Map.Entry<Room, Person> entry : en.getEstate().entrySet()) {

                if ((entry.getKey().getEndDate()[0].equals(currentTime[0])) || (entry.getKey().getEndDate()[0].isAfter(currentTime[0]))) {
                    System.out.println(" dzialamy na datach ");
                }
            }
        };

        scheduledExecutorService.scheduleAtFixedRate(time, 0, 5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(check1, 0, 5, TimeUnit.SECONDS);


    }
}

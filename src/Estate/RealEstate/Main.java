package Estate.RealEstate;

import Estate.RealEstate.Rooms.Room;
import Estate.RealEstate.Technical.Enviroment;
import Estate.RealEstate.Technical.TechTime;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {





        Enviroment en = new Enviroment();
       // TechTime techTime=new TechTime(en);

        //techTime.timeRun(en);
        en.run();

        //final LocalDate[] currentTime = {LocalDate.now()};

      //  ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(en.getEstate().size());

        //Executors.newFixedThreadPool(en.getEstate().size());
        //executorService.submit(()->startRent());

        // to jest symulacja czasu
      /*  Runnable time = () -> {
            en.getCurrentTime() = en.getCurrentTime().plusDays(1);
            System.out.println(" aktualna watkowa data " + currentTime[0]);
        };

        // tu sprawdzanie daty konca wynajmu
        Runnable check1 = () -> {

            System.out.println(" tu bede sprawdzal terminy");

            for (Map.Entry<Room, Person> entry : en.getEstate().entrySet()) {

                if (entry.getKey().getEndDate().equals(currentTime[0]) || (entry.getKey().getEndDate().isAfter(currentTime[0]))) {
                    System.out.println(" dzialamy na datach ");
                }
            }
        };

        scheduledExecutorService.scheduleAtFixedRate(time, 0, 5, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(check1, 0, 10, TimeUnit.SECONDS);

        */





        }

    }


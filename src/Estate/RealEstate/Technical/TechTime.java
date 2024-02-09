package Estate.RealEstate.Technical;

import Estate.RealEstate.File;
import Estate.RealEstate.Person;
import Estate.RealEstate.Rooms.Room;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
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

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(en.getEstate().size());

        //Executors.newFixedThreadPool(en.getEstate().size());
        //executorService.submit(()->startRent());

        // to jest symulacja czasu

        Runnable time = () -> {
            currentTime[0] = currentTime[0].plusDays(1);

        };



        // tu sprawdzanie daty konca wynajmu
        Runnable check1 = () -> {

            LocalDate[] startOfLimitPerioid=new LocalDate[1];
            long daysBetween=0;


            for (Map.Entry<Room, Person> entry : en.getEstate().entrySet()) {

                if (entry.getKey().getEndDate() != null && entry.getKey().getEndDate()[0] != null) {

                    if (entry.getKey().getEndDate()[0].equals(currentTime[0]) || (entry.getKey().getEndDate()[0].isBefore(currentTime[0]))) {

                        //for(UUID id:entry.getValue().getFiles().)
                        //sprawdzic czy juz jest file
                        startOfLimitPerioid[0] = entry.getKey().getEndDate()[0];
                        File file = new File(entry.getKey().getId(), entry.getValue().getPesel(), startOfLimitPerioid[0]);
                        entry.getValue().getFiles().add(file);
                        //======================do sprawdzenia file


                        daysBetween = Chronounit.DAYS.between(entry.getKey().getEndDate()[0], currentTime[0]);


                        //entry.getKey().getEndDate()[0] = null;


                        //long daysBetween= ChronoUnit.DAYS.between(entry.getKey().getEndDate()[0],currentTime[0]);
                        //System.out.println(" jest juz "+daysBetween+ " dni po zakonczeniu terminu najmu !!!");
                    }
                    if(daysBetween>=30){
                        entry.getKey().getEndDate()[0] = null;
                    }

                } else {
                    System.out.println(" lokal jest niewynajety !!!");
                }
            }

            //UUID idRoom=

            for(Person person: en.getPersonSet()) {

                for(File file:person.getFiles()){
                    //if(file.getRoomId().equals())
                }

               // if(UUID toFind = person.getFiles().contains())

            }


            // sprawdzenie person pod katem obecnosci file i przedawbiene tzn daysbetwwen >30





        };

        //scheduledExecutorService.scheduleAtFixedRate(time, 0, 5, TimeUnit.SECONDS);
        //scheduledExecutorService.scheduleAtFixedRate(check1, 0, 10, TimeUnit.SECONDS);


        //scheduledExecutorService.shutdown();
    }
}

package Estate.RealEstate;

import java.time.LocalDate;
import java.util.UUID;

public class File {

    private UUID roomId;
    private int personPesel;
    private final LocalDate[] fileStartOfLimitPerioid=new LocalDate[1];

    public File(UUID roomId, int personPesel,LocalDate fileStartOfLimitPeriod) {
        this.roomId = roomId;
        this.personPesel = personPesel;
        this.fileStartOfLimitPerioid[0]=fileStartOfLimitPeriod;
    }

    public UUID getRoomId() {
        return roomId;
    }

    public int getPersonPesel() {
        return personPesel;
    }

    public LocalDate[] getFileStartOfLimitPerioid() {
        return fileStartOfLimitPerioid;
    }
}

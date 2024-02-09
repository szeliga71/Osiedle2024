package Estate.RealEstate.Items;

import java.util.UUID;

public abstract class Item {

    private final UUID itemId;
    private final int volume;


    public Item(int volume) {
        this.volume = volume;
        this.itemId = UUID.randomUUID();
    }

    public UUID getItemId() {
        return itemId;
    }

    public int getVolume() {
        return volume;
    }
}

package Estate.RealEstate.Items.Veihcle;

import Estate.RealEstate.Items.Item;

public class Szybowiec extends Item {

    int dlugoscSkrzydla;

    public Szybowiec(int volume,int dlugoscSkrzydla) {
        super(volume);
        this.dlugoscSkrzydla=dlugoscSkrzydla;
    }
}

package Estate.RealEstate.Items.Veihcle;

import Estate.RealEstate.Items.Item;

public abstract class Vehicle extends Item {

    private String marka;

    private String model;

    private Paliwo paliwo;

    private int pojemnoscSilnika;

    public Vehicle(int volume,String marka, String model, Paliwo paliwo, int pojemnoscSilnika) {
        super(volume);
        this.marka = marka;
        this.model = model;
        this.paliwo = paliwo;
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public Paliwo getPaliwo() {
        return paliwo;
    }

    public int getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", paliwo=" + paliwo +
                ", pojemnoscSilnika=" + pojemnoscSilnika +
                '}';
    }
}

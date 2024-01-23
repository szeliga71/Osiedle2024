package Estate.RealEstate.Items.Veihcle;

public class Motocykl extends Vehicle implements Terrain{


    public Motocykl(int volume,String marka, String model, Paliwo paliwo, int pojemnoscSilnika) {
        super(volume,marka, model, paliwo, pojemnoscSilnika);
    }

    @Override
    public void drive() {
        System.out.println(" bzyyyk, bzyyk");
    }
}

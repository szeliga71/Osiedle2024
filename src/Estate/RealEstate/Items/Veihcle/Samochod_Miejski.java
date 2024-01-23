package Estate.RealEstate.Items.Veihcle;

public class Samochod_Miejski extends Vehicle implements Terrain{

    private boolean parkAssistant;
    private String kolor;

    public Samochod_Miejski(int volume,String marka, String model, Paliwo paliwo, int pojemnoscSilnika,boolean parkAssistant,String kolor) {
        super(volume,marka, model, paliwo, pojemnoscSilnika);
        this.parkAssistant=parkAssistant;
        this.kolor=kolor;
    }


    @Override
    public void drive() {
        System.out.println(" brum  , brummmm");
    }

    public boolean isParkAssistant() {
        return parkAssistant;
    }

    public String getKolor() {
        return kolor;
    }

    @Override
    public String toString() {
        return super.toString() +"Samochod_Miejski{" +
                "parkAssistant=" + parkAssistant +
                ", kolor='" + kolor + '\'' +
                '}';
    }
}

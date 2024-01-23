package Estate.RealEstate.Items.Veihcle;

public class Amfibia extends Vehicle implements Terrain,Water{

    boolean kotwica;
    boolean kolo_zapasowe;

    public Amfibia(int volume,String marka, String model, Paliwo paliwo, int pojemnoscSilnika,boolean kotwica,boolean kolo_zapasowe) {
        super(volume,marka, model, paliwo, pojemnoscSilnika);
        this.kotwica=kotwica;
        this.kolo_zapasowe=kolo_zapasowe;
    }


    @Override
    public void drive() {
        System.out.println(" brr , brr");
    }

    @Override
    public void plyn() {
        System.out.println(" plusk");


    }
}

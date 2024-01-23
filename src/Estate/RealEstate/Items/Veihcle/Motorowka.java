package Estate.RealEstate.Items.Veihcle;

public class Motorowka extends Vehicle implements Water{

    boolean kotwica;

    public Motorowka(int volume,String marka, String model, Paliwo paliwo, int pojemnoscSilnika,boolean kotwica) {
        super(volume,marka, model, paliwo, pojemnoscSilnika);
        this.kotwica=kotwica;
    }

    @Override
    public void plyn() {
        System.out.println(" plusk");
    }
}

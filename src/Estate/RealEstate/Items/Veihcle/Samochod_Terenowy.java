package Estate.RealEstate.Items.Veihcle;

public class Samochod_Terenowy extends Vehicle implements Terrain {


    int ilosc_halogenow;

    public Samochod_Terenowy(int volume,String marka,String model,Paliwo paliwo,int pojemnoscSilnika,int ilosc_halogenow) {
        super(volume,marka,model,paliwo,pojemnoscSilnika);
        this.ilosc_halogenow = ilosc_halogenow;
    }

    @Override
    public void drive() {

        System.out.println(" brrrrrrrum");
    }
}

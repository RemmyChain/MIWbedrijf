package model;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class Vrijwilliger extends Persoon implements Oproepbaar{
    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling){
        super(naam, woonplaats, afdeling);
    }
    @Override
    public void huurIn(int aantalUren){
        setUrenGewerkt(aantalUren);
    }

    public void setUrenGewerkt(int urenGewerkt) {
        this.urenGewerkt = urenGewerkt;
    }

    @Override
    public double berekenJaarInkomen() {
        return 0.00;
    }

    @Override
    public String toString() {
        return super.toString() + " en is een vrijwilliger.";
    }
}

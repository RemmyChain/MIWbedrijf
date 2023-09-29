package model;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class ZZPer extends Persoon{
    private static final int DEFAULT_UREN_GEWERKT = 0;
    private double uurtarief;
    private int urenGewerkt;

    public ZZPer(String naam, String woonplaats, Afdeling afdeling, double uurtarief){
        super(naam, woonplaats, afdeling);
        this.uurtarief = uurtarief;
        this.urenGewerkt = DEFAULT_UREN_GEWERKT;
    }
    public void huurIn(int aantalUren){
        setUrenGewerkt(aantalUren);
    }
    @Override
    public String toString(){
        return String.format("%s en is een ZZPer met een uurtarief van %.2f.", super.toString(), getUurtarief());
    }

    @Override
    public double berekenJaarInkomen() {
        return getUurtarief() * getUrenGewerkt();
    }

    public double getUurtarief() {
        return uurtarief;
    }

    public void setUurtarief(double uurtarief) {
        this.uurtarief = uurtarief;
    }

    public int getUrenGewerkt() {
        return urenGewerkt;
    }

    public void setUrenGewerkt(int urenGewerkt) {
        this.urenGewerkt = urenGewerkt;
    }
}

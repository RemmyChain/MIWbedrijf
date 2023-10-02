package model;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class Werknemer extends Persoon{
    private static final double GRENSWAARDE_BONUS = 4500.00;
    private static final double DEFAULT_SALARIS = 0.0;
    private double maandSalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double salaris){
        super(naam, woonplaats, afdeling);
        setMaandSalaris(salaris);
    }
    public Werknemer(String naam){
        super(naam);
        setMaandSalaris(DEFAULT_SALARIS);
    }
    public Werknemer(){
        this(DEFAULT_NAAM);
    }

    public boolean heeftRechtOpBonus(){
        return getMaandSalaris() > GRENSWAARDE_BONUS;
    }
    public double berekenJaarInkomen(){
        double jaarinkomen = MAANDEN_PER_JAAR * getMaandSalaris();
        if (heeftRechtOpBonus()){
            jaarinkomen += getMaandSalaris();
        }
        return jaarinkomen;
    }

    public String toString(){
        return String.format("%s en is een werknemer %s recht op bonus.", super.toString(),
                heeftRechtOpBonus() ? "met" : "zonder");
    }

    public double getMaandSalaris() {
        return maandSalaris;
    }

    public void setMaandSalaris(double maandSalaris) {
        if (maandSalaris < 0){
            System.out.println("Salaris mag niet negatief dus wordt op 1 gezet!");
            this.maandSalaris = 0.0;
        } else {
            this.maandSalaris = maandSalaris;
        }
    }


}

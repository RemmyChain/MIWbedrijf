package model;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class Persoon {
    private static final double GRENSWAARDE_BONUS = 4500;
    private static final String DEFAULT_WOONPLAATS = "onbekend";
    private static final String DEFAULT_NAAM = "onbekend";
    private static final double DEFAULT_MAAND_SALARIS = 0.0;
    private static final int MAANDEN_PER_JAAR = 12;
    public static int aantalPersonen = 0;
    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private double maandSalaris;
    private Afdeling afdeling;

    public Persoon(String naam, String woonplaats, double maandSalaris, Afdeling afdeling) {
        this.personeelsNummer = ++aantalPersonen;
        setNaam(naam);
        setWoonplaats(woonplaats);
        setMaandSalaris(maandSalaris);
        setAfdeling(afdeling);
    }
    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, DEFAULT_MAAND_SALARIS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }
    public double berekenJaarInkomen() {

        return this.maandSalaris * MAANDEN_PER_JAAR;
    }
    public boolean heeftRechtOpBonus() {
        return getMaandSalaris() >= GRENSWAARDE_BONUS;
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    public void setPersoneelsNummer(int personeelsNummer) {
        this.personeelsNummer = personeelsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public double getMaandSalaris() {
        return maandSalaris;
    }

    public void setMaandSalaris(double maandSalaris) {
        if (maandSalaris < 0) {
            System.err.println("Salaris mag niet negatief! Wordt op '0' gezet!");
            this.maandSalaris = 0;
        } else {
        this.maandSalaris = maandSalaris;
        }
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }
}

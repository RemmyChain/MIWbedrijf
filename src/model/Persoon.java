package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public abstract class Persoon implements Comparable<Persoon>{
    private static final String DEFAULT_WOONPLAATS = "onbekend";
    protected static final String DEFAULT_NAAM = "onbekend";
    protected static final int MAANDEN_PER_JAAR = 12;
    public static int aantalPersonen = 0;
    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private Afdeling afdeling;

    public Persoon(String naam, String woonplaats, Afdeling afdeling) {
        this.personeelsNummer = ++aantalPersonen;
        setNaam(naam);
        setWoonplaats(woonplaats);
        setAfdeling(afdeling);
    }
    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, new Afdeling());
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }
    public abstract double berekenJaarInkomen();

    @Override
    public String toString(){
        return String.format("%s woont in %s en werkt op %s", this.naam, this.woonplaats, this.afdeling);
    }

    public int compareTo(Persoon anderpersoon){
        return this.naam.compareTo(anderpersoon.naam);
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }
}

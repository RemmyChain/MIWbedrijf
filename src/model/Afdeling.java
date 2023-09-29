package model;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class Afdeling {
    private static final String DEFAULT_AFDELINGSNAAM = "onbekend";
    private static final String DEFAULT_AFDELINGSPLAATS = "onbekend";
    private String afdelingsNaam;
    private String afdelingsPlaats;


    public Afdeling(String afdelingsNaam, String afdelingsPlaats){
        setAfdelingsNaam(afdelingsNaam);
        setAfdelingsPlaats(afdelingsPlaats);
    }
    public Afdeling(){
        this(DEFAULT_AFDELINGSNAAM, DEFAULT_AFDELINGSPLAATS);
    }

    public void setAfdelingsNaam(String afdelingsNaam) {
        this.afdelingsNaam = afdelingsNaam;
    }

    public String getAfdelingsNaam() {
        return afdelingsNaam;
    }
    @Override
    public String toString(){
        return "afdeling " + getAfdelingsNaam() + " te " + getAfdelingsPlaats();
    }

    public void setAfdelingsPlaats(String afdelingsPlaats) {
        this.afdelingsPlaats = afdelingsPlaats;
    }

    public String getAfdelingsPlaats() {
        return afdelingsPlaats;
    }
}

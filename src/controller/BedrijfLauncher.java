package controller;

import model.Afdeling;
import model.Persoon;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class BedrijfLauncher {
  public static void main(String[] args) {

    Afdeling[] afdelingen = new Afdeling[4];

    afdelingen[0] = new Afdeling("Uitvoering", "Hilversum");
    afdelingen[1] = new Afdeling("Support", "Amsterdam");
    afdelingen[2] = new Afdeling("Management", "Almere");
    afdelingen[3] = new Afdeling("Documentatie", "Gouda");

    Persoon baas = new Persoon("Mark", "Den Haag", 10000, afdelingen[2]);
    Persoon medewerker = new Persoon("Caroline", "Delft", 4000, afdelingen[1]);
    Persoon assistent = new Persoon ("Klaas");

    System.out.printf("In dit fantastische bedrijf werken %d personen!\n", Persoon.aantalPersonen);

    geefSalarisData(baas);
    geefSalarisData(medewerker);
    geefSalarisData(assistent);


  }

  private static void geefSalarisData(Persoon medewerker) {
    System.out.printf("\n%s verdient %.2f, werkt op de afdeling %s in %s en heeft %s recht op een bonus!",
            medewerker.getNaam(), medewerker.getMaandSalaris(), medewerker.getAfdeling().getAfdelingsNaam(),
            medewerker.getAfdeling().getAfdelingsPlaats(),
            medewerker.heeftRechtOpBonus() ? "wel" : "geen");
  }
}

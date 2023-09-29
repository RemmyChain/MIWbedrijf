package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.ZZPer;

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

    Werknemer baas = new Werknemer("Mark", "Den Haag", afdelingen[2], 10000.00 );
    Werknemer medewerker = new Werknemer("Caroline", "Delft", afdelingen[1], 4000.00 );
    ZZPer assistent = new ZZPer("Klaas", "Diemen", afdelingen[3], 50.00);
    ZZPer projectLeider = new ZZPer("Ronald", "Zaandam", afdelingen[0], 80.00);

    assistent.huurIn(160);
    projectLeider.huurIn(320);

    Persoon[] personen = new Persoon[4];
    personen[0] = baas;
    personen[1] = medewerker;
    personen[2] = assistent;
    personen[3] = projectLeider;

    for (int persoon = 0; persoon < personen.length; persoon++) {
      toonJaarinkomen(personen[persoon]);
    }


  }
  public static void toonJaarinkomen(Persoon persoon){
    System.out.printf("\n%-9s verdient %-9.2f per jaar.", persoon.getNaam(), persoon.berekenJaarInkomen());
  }
}

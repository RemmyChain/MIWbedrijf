package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class BedrijfLauncher {
  static Scanner toetsenbord = new Scanner(System.in);
  public static Afdeling[] afdelingen = new Afdeling[5];
  public static void main(String[] args) {

    afdelingen[0] = new Afdeling("Uitvoering", "Hilversum");
    afdelingen[1] = new Afdeling("Support", "Amsterdam");
    afdelingen[2] = new Afdeling("Management", "Almere");
    afdelingen[3] = new Afdeling("Documentatie", "Gouda");



    System.out.print(genereerWerknemer());

//    ArrayList<Persoon> personen = new ArrayList<>();
//
//    personen.add(new Werknemer("Mark", "Den Haag", afdelingen[2], 10000));
//    personen.add(new Werknemer("Angelique", "Rotterdam", afdelingen[2], 5000));
//    personen.add(new Werknemer("Caroline", "Delft", afdelingen[1], 4000));
//    personen.add(new ZZPer("Klaas", "Diemen", afdelingen[3], 50.00));
//    personen.add(new ZZPer("Ronald", "Zaandam", afdelingen[0], 80.00));
//    personen.add(new ZZPer("Jannie", "Utrecht", afdelingen[0], 60.00));
//    personen.add(new ZZPer("Anne", "Zwolle", afdelingen[0], 40.00));
//
//    personen.add(new Vrijwilliger("Ambi", "Amsterdam", afdelingen[0]));
//    personen.add(new Vrijwilliger("Naledi", "Gaborone", afdelingen[1]));
//    personen.add(new Vrijwilliger("Ceren", "Istanboel", afdelingen[2]));
//    personen.add(new Vrijwilliger("Haining", "Shaoxing", afdelingen[3]));
//
//    for (Persoon persoon : personen) {
//      if (persoon instanceof ZZPer){
//        ((ZZPer) persoon).huurIn(320);
//      } else if (persoon instanceof Vrijwilliger){
//        ((Vrijwilliger) persoon).huurIn(160);
//      }
//    }
//    Collections.sort(personen);
//
//    for (Persoon persoon : personen){
//      System.out.println(persoon);
//      toonJaarinkomen(persoon);
//    }
    


  }
  public static void toonJaarinkomen(Persoon persoon){
    System.out.printf("%s verdient %.2f per jaar.\n", persoon.getNaam(), persoon.berekenJaarInkomen());
  }
  public static Werknemer genereerWerknemer(){
    Werknemer werknemer = new Werknemer();
    System.out.println("Geef de naam van de werknemer:");
    String naam = toetsenbord.nextLine();
    System.out.println("Geef de woonplaats van de werknemer:");
    String woonplaats = toetsenbord.nextLine();
    System.out.println("Geef de Afdeling van de werknemer:");
    String afdeling = toetsenbord.nextLine();
    System.out.println("Geef de plaats van de afdeling van de werknemer:");
    String afdelingPlaats = toetsenbord.nextLine();
    afdelingen[4] = new Afdeling(afdeling, afdelingPlaats);

    boolean illegaleInvoer = true;
    while (illegaleInvoer) {
      System.out.println("Geef het maandsalaris van de werknemer:");
      double salaris = toetsenbord.nextDouble();
      try {
        werknemer = new Werknemer(naam, woonplaats, afdelingen[4], salaris);
        illegaleInvoer = false;

      } catch (IllegalArgumentException negatiefsalaris){
        System.out.println(negatiefsalaris.getMessage());
      } finally {
        System.out.println("Je invoer is op de juiste wijze afgehandeld.");
      }

    }


    return werknemer;

  }
}

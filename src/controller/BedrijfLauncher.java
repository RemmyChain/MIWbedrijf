package controller;

import database.AfdelingDAO;
import database.DBaccess;
import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class BedrijfLauncher {

  public static void main(String[] args) {

//    AfdelingDAO inpropper = new AfdelingDAO();
//
//    inpropper.slaAfdelingOp(new Afdeling("HR", "Hilversum"));

    AfdelingDAO interfees = new AfdelingDAO();

    System.out.println(interfees.geefAfdelingenMetPlaats("Amsterdam"));

//    ArrayList<Afdeling> afdelingen = new ArrayList<>();
//
//    File leesbestand = new File("resources/Afdelingen.txt");
//
//    try (Scanner bestandsvreter = new Scanner(leesbestand)){
//      while (bestandsvreter.hasNextLine()){
//        afdelingen.add(new Afdeling(bestandsvreter.next(), bestandsvreter.next()));
//      }
//    } catch (FileNotFoundException geenbestand) {
//      System.out.println("Woepsie, geen bestand :(");
//    }
//
//    ArrayList<Persoon> personen = new ArrayList<>();
//
//    ArrayList<String> bestandsregels = new ArrayList<>();
//
//    File personenbestand = new File("resources/Personen.csv");
//
//    try (Scanner bestandtsjapper = new Scanner(personenbestand)){
//      while (bestandtsjapper.hasNextLine()){
//        bestandsregels.add(bestandtsjapper.nextLine());
//
//      }
//
//    } catch (FileNotFoundException nichtsda) {
//      System.out.println("Waah, geen bestand!");
//    }
//
//      for (String bestandsregel : bestandsregels) {
//          String[] persoonrecept = bestandsregel.split(",");
//          if (persoonrecept[0].equals("Werknemer")) {
//              personen.add(new Werknemer(
//                      persoonrecept[1],
//                      persoonrecept[2],
//                      afdelingen.get(Integer.parseInt(persoonrecept[3])),
//                      Double.parseDouble(persoonrecept[4])
//              ));
//          } else if (persoonrecept[0].equals("Zzper")) {
//              personen.add(new ZZPer(
//                      persoonrecept[1],
//                      persoonrecept[2],
//                      afdelingen.get(Integer.parseInt(persoonrecept[3])),
//                      Double.parseDouble(persoonrecept[4])
//              ));
//          } else {
//              personen.add(new Vrijwilliger(
//                      persoonrecept[1],
//                      persoonrecept[2],
//                      afdelingen.get(Integer.parseInt(persoonrecept[3]))));
//
//          }
//      }
//    Collections.sort(personen);
//
//    for (Persoon persoon : personen) {
//      System.out.println(persoon);
//    }
//    System.out.println();
//
//    File personenPerAfdeling = new File("resources/PersonenPerAfdeling.txt");
//    try (PrintWriter schrijver = new PrintWriter(personenPerAfdeling)){
//      for (Afdeling afdeling : afdelingen) {
//        schrijver.printf("Afdeling: %s\n", afdeling.getAfdelingsNaam());
//        for (Persoon persoon : personen) {
//          if (persoon.getAfdeling().equals(afdeling)){
//            schrijver.println("--" + persoon);
//          }
//
//        }
//        schrijver.println();
//      }
//    } catch (FileNotFoundException e) {
//      System.out.println("Oi, kan niet schrijven!");
//    }
//
//    for (Afdeling afdeling : afdelingen) {
//      System.out.printf("Afdeling: %s\n", afdeling.getAfdelingsNaam());
//      for (Persoon persoon : personen) {
//        if (persoon.getAfdeling().equals(afdeling)){
//          System.out.println("--" + persoon);
//        }
//
//      }
//      System.out.println();
//    }

  }
  public static void toonJaarinkomen(Persoon persoon){
    System.out.printf("%s verdient %.2f per jaar.\n", persoon.getNaam(), persoon.berekenJaarInkomen());
  }
  public static void geefAfdelingenMetPlaats(String plaats){
    AfdelingDAO zuiger = new AfdelingDAO();

    ArrayList<Afdeling> afdelingen = zuiger.leesAfdelingen();

    for (Afdeling afdeling : afdelingen) {
      if (afdeling.getAfdelingsPlaats().equals(plaats)){
        System.out.printf("Afdeling: %s\n", afdeling);
      }

    }

  }


}

package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class BedrijfLauncher {

  public static void main(String[] args) {

    ArrayList<Afdeling> afdelingen = new ArrayList<>();

    File leesbestand = new File("resources/Afdelingen.txt");

    try (Scanner bestandsvreter = new Scanner(leesbestand);){
      while (bestandsvreter.hasNextLine()){
        afdelingen.add(new Afdeling(bestandsvreter.next(), bestandsvreter.next()));
      }
    } catch (FileNotFoundException geenbestand) {
      System.out.println("Woepsie, geen bestand :(");
    }

    ArrayList<Persoon> personen = new ArrayList<>();

    ArrayList<String> bestandsregels = new ArrayList<>();

    File personenbestand = new File("resources/Personen.csv");

    try (Scanner bestandtsjapper = new Scanner(personenbestand);){
      while (bestandtsjapper.hasNextLine()){
        bestandsregels.add(bestandtsjapper.nextLine());

      }

    } catch (FileNotFoundException nichtsda) {
      System.out.println("Waah, geen bestand!");;
    }

    for (int entry = 0; entry < bestandsregels.size(); entry++) {
      String[] persoonrecept = bestandsregels.get(entry).split(",");
      if (persoonrecept[0].equals("Werknemer")){
        personen.add(new Werknemer(
             persoonrecept[1],
             persoonrecept[2],
             afdelingen.get(Integer.parseInt(persoonrecept[3])),
             Double.parseDouble(persoonrecept[4])
        ));
      } else if (persoonrecept[0].equals("Zzper")){
        personen.add(new ZZPer(
                persoonrecept[1],
                persoonrecept[2],
                afdelingen.get(Integer.parseInt(persoonrecept[3])),
                Double.parseDouble(persoonrecept[4])
        ));
      } else {
        personen.add(new Vrijwilliger(
                persoonrecept[1],
                persoonrecept[2],
                afdelingen.get(Integer.parseInt(persoonrecept[3]))));

      }
    }

    System.out.println(personen);

  }
  public static void toonJaarinkomen(Persoon persoon){
    System.out.printf("%s verdient %.2f per jaar.\n", persoon.getNaam(), persoon.berekenJaarInkomen());
  }


}

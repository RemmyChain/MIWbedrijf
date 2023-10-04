package controller;

import database.AfdelingDAO;
import database.DBaccess;
import database.PersoonDAO;
import database.WerknemerDAO;
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

  private static final String DATABASE_NAAM = "Bedrijf";
  private static final String DATABASE_USER = "userBedrijf";
  private static final String DATABASE_PW = "userBedrijfPW";


  public static void main(String[] args) {

    Afdeling Support = new Afdeling("Support", "Amsterdam");

    Werknemer Lodewijk = new Werknemer("Lodewijk", "Zaandam", Support, 2500.00);

    DBaccess dBaccess = new DBaccess(DATABASE_NAAM, DATABASE_USER, DATABASE_PW);
    PersoonDAO persoonDAO = new PersoonDAO(dBaccess);
    WerknemerDAO werknemerDAO = new WerknemerDAO(dBaccess);

    int personeelsnummer = persoonDAO.voegPersoonToe(Lodewijk);
    werknemerDAO.voegWerkNemerToe(personeelsnummer, Lodewijk);

  }
  public static void toonJaarinkomen(Persoon persoon){
    System.out.printf("%s verdient %.2f per jaar.\n", persoon.getNaam(), persoon.berekenJaarInkomen());
  }


}

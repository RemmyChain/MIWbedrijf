package database;

import model.Afdeling;

import java.sql.*;
import java.util.ArrayList;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class AfdelingDAO {


    public void slaAfdelingOp(Afdeling afdeling){

        String afdelingsnaam = afdeling.getAfdelingsNaam();
        String afdelingsplaats = afdeling.getAfdelingsPlaats();

        DBaccess toegang = new DBaccess("Bedrijf", "userBedrijf", "userBedrijfPW");

        toegang.openConnection();

        Connection verbinding = toegang.getConnection();

        String sql2 = "INSERT INTO afdeling VALUES(?, ?);";
        try {
            PreparedStatement preparedStatement =
                    toegang.getConnection().prepareStatement(sql2);
            preparedStatement.setString(1, afdelingsnaam);
            preparedStatement.setString(2, afdelingsplaats);

            preparedStatement.executeUpdate();
        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }


        toegang.closeConnection();

    }
    public ArrayList<Afdeling> leesAfdelingen(){
        DBaccess toegang = new DBaccess("Bedrijf", "userBedrijf", "userBedrijfPW");

        toegang.openConnection();

        Connection verbinding = toegang.getConnection();

        ArrayList<Afdeling> returnlist = new ArrayList<>();

        if (verbinding != null) {
            System.out.println("De verbinding is gemaakt!");
            String sql = "SELECT * FROM afdeling;";
            try {
                PreparedStatement preparedStatement = verbinding.prepareStatement(sql);
                ResultSet resultaat = preparedStatement.executeQuery();
                while (resultaat.next()){
                    String naam = resultaat.getString("afdelingsnaam");
                    String plaats = resultaat.getString("afdelingsplaats");
                    returnlist.add(new Afdeling(naam, plaats));
                }



                verbinding.close();
            } catch (SQLException sqlFout) {
                System.out.println(sqlFout);
            }
        }

        return returnlist;


    }
    public ArrayList<Afdeling> geefAfdelingenMetPlaats(String plaats){
        ArrayList<Afdeling> gefilterd = new ArrayList<>();
        DBaccess toegang = new DBaccess("Bedrijf", "userBedrijf", "userBedrijfPW");

        toegang.openConnection();

        Connection verbinding = toegang.getConnection();

        ArrayList<Afdeling> returnlist = new ArrayList<>();

        if (verbinding != null) {
            System.out.println("De verbinding is gemaakt!");
            String sql = "SELECT * FROM afdeling WHERE afdelingsplaats = ?";

            try {
                PreparedStatement preparedStatement = verbinding.prepareStatement(sql);
                preparedStatement.setString(1, plaats);
                ResultSet resultaat = preparedStatement.executeQuery();
                while (resultaat.next()){
                    String naam = resultaat.getString("afdelingsnaam");
                    String plaatsafd = resultaat.getString("afdelingsplaats");
                    gefilterd.add(new Afdeling(naam, plaatsafd));
                }



                verbinding.close();
            } catch (SQLException sqlFout) {
                System.out.println(sqlFout);
            }
        }

        return gefilterd;
    }


}

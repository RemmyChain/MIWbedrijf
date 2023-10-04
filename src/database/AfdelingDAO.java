package database;

import model.Afdeling;

import java.sql.*;
import java.util.ArrayList;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class AfdelingDAO extends AbstractDAO{


    public AfdelingDAO(DBaccess dBaccess) {
        super(dBaccess);
    }

    public void slaAfdelingOp(Afdeling afdeling){

        String afdelingsnaam = afdeling.getAfdelingsNaam();
        String afdelingsplaats = afdeling.getAfdelingsPlaats();

        dBaccess.openConnection();

        Connection verbinding = dBaccess.getConnection();

        String sql2 = "INSERT INTO afdeling VALUES(?, ?);";
        try {
            setupPreparedStatement(sql2);
            preparedStatement.setString(1, afdelingsnaam);
            preparedStatement.setString(2, afdelingsplaats);

            executeManipulateStatement();
        } catch (SQLException sqlFout) {
            System.out.println(sqlFout);
        }


        dBaccess.closeConnection();

    }
    public ArrayList<Afdeling> leesAfdelingen(){

        dBaccess.openConnection();

        Connection verbinding = dBaccess.getConnection();

        ArrayList<Afdeling> returnlist = new ArrayList<>();

        if (verbinding != null) {
            System.out.println("De verbinding is gemaakt!");
            String sql = "SELECT * FROM afdeling;";
            try {
               setupPreparedStatement(sql);
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

        dBaccess.openConnection();

        Connection verbinding = dBaccess.getConnection();

        ArrayList<Afdeling> returnlist = new ArrayList<>();

        if (verbinding != null) {
            System.out.println("De verbinding is gemaakt!");
            String sql = "SELECT * FROM afdeling WHERE afdelingsplaats = ?";

            try {
                setupPreparedStatement(sql);
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

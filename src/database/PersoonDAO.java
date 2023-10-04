package database;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class PersoonDAO extends AbstractDAO{
    public PersoonDAO(DBaccess dBaccess) {
        super(dBaccess);
    }


    public int voegPersoonToe(Werknemer werknemer){
        dBaccess.openConnection();
        int personeelsnummer = 0;

        String sql = "INSERT into persoon " +
                "(`naam`, `woonplaats`, `afdeling`) values (?, ?, ?);";
        try {
            setupPreparedStatementWithKey(sql);
            String naam = werknemer.getNaam();
            String woonplaats = werknemer.getWoonplaats();
            String afdeling = werknemer.getAfdeling().getAfdelingsNaam();
            preparedStatement.setString(1, naam);
            preparedStatement.setString(2, woonplaats);
            preparedStatement.setString(3, afdeling);
            personeelsnummer = executeInsertStatementWithKey();
        } catch (SQLException sqlException) {
            System.out.println("SQL fout: " + sqlException.getMessage());
        }
        dBaccess.closeConnection();

        return personeelsnummer;

    }
}

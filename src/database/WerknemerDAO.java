package database;

import model.Persoon;
import model.Werknemer;

import java.sql.SQLException;

/**
 * Author: Remco Ketting
 * Purpose of program:
 */
public class WerknemerDAO extends AbstractDAO{
    public WerknemerDAO(DBaccess dBaccess) {
        super(dBaccess);
    }
    public void voegWerkNemerToe(int personeelsnummer, Werknemer werknemer){
        dBaccess.openConnection();

        String sql = "INSERT into werknemer values (?, ?);";

        try {
            setupPreparedStatement(sql);
            double salaris = werknemer.getMaandSalaris();
            preparedStatement.setInt(1, personeelsnummer);
            preparedStatement.setDouble(2, salaris);
            executeManipulateStatement();
        } catch (SQLException e) {
            System.out.println("SQL doet raar...");
        }
        dBaccess.closeConnection();
    }
}

package com.teo.store.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teodora
 */
public class JdbcService {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public JdbcService(){
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/TicketsDB", "teodora", "teodora");

            statement = connection.createStatement();

            String qrySQL = "select * from events e join locations l on (e.location_id = l.id)";
            resultSet = statement.executeQuery(qrySQL);

            while(resultSet.next())
                System.out.println(resultSet.getString("name") + " " + resultSet.getString("description")
                        + " " + resultSet.getDate("start_date")
                        +  " " + resultSet.getDate("end_date")
                        + " " + resultSet.getString("city"));
        } catch (SQLException ex) {
            System.out.println("Eroare la conectarea la BD: ");
            Logger.getLogger(JdbcService.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(statement!=null)
                statement.close();
            if(connection!=null)
                connection.close();
            if(resultSet!=null)
                resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JdbcService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}

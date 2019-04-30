/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDB 
{
    private static final String URL = "jdbc:derby://localhost:1527/AdminUserDatabase";
    private static final String USERNAME = "app";
    private static final String PASSWORD = "app";
    private Connection connection = null; // manages connection
    private PreparedStatement insertNewPerson = null; 
    
    public UserDB()
    {
        try 
        {
         connection = 
            DriverManager.getConnection( URL, USERNAME, PASSWORD );
         
         // create insert that adds a new entry into the database
         insertNewPerson = connection.prepareStatement( 
            "INSERT INTO Users " + 
            "( Email, FirstName, LastName, Password, Credit_Card ) " + 
            "VALUES ( ?, ?, ?, ? , ? )" );
         
        } // end try
        catch ( SQLException sqlException )
        {
         sqlException.printStackTrace();
         System.exit( 1 );
        } // end catch
    }
    
    public int insert(String email, String firstName, String lastName, String password, int creditCard)
    {
        try
        {
            insertNewPerson.setString(1, email);
            insertNewPerson.setString(2, firstName);
            insertNewPerson.setString(3, lastName);
            insertNewPerson.setString(4, password);
            insertNewPerson.setInt(5, creditCard);
        
            insertNewPerson.executeUpdate();
        }
        catch ( SQLException sqlException )
        {
            return 0;
        }
        return 1;
    }
}

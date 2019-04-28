/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.InputStream;
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
    private PreparedStatement updateCurrency = null;
    private int currency;
    private String email;
    
    public UserDB()
    {
        currency = 0;
        email = null;
        
        try 
        {
         connection = 
            DriverManager.getConnection( URL, USERNAME, PASSWORD );
         
         // create insert that adds a new entry into the database
         insertNewPerson = connection.prepareStatement( 
            "INSERT INTO Users " + 
            "( Email, FirstName, LastName, Password, Currency, Credit_Card ) " + 
            "VALUES ( ?, ?, ?, ? , ? , ?)" );
         
         updateCurrency = connection.prepareStatement(
            "Update Users Set Currency = ?" +
                 "Where Email = ?" );
         
        } // end try
        catch ( SQLException sqlException )
        {
         sqlException.printStackTrace();
         System.exit( 1 );
        } // end catch
    }
    
    public int insert(String email, String firstName, String lastName, String password, double currency, int creditCard)
    {
        try
        {
            insertNewPerson.setString(1, email);
            insertNewPerson.setString(2, firstName);
            insertNewPerson.setString(3, lastName);
            insertNewPerson.setString(4, password);
            insertNewPerson.setDouble(5, currency);
            insertNewPerson.setInt(6, creditCard);
        
            insertNewPerson.executeUpdate();
        }
        catch ( SQLException sqlException )
        {
            return 0;
        }
        return 1;
    }
    
    public void updateCurrency(int currency)
    {
        this.currency = this.currency + currency;
        try
        {
            updateCurrency.setInt(1, this.currency);
            updateCurrency.setString(2, this.email);
        }
        catch ( SQLException sqlException )
        {
            System.out.print("hello!5");
            System.out.print(sqlException);
        }
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setCurrency(int currency)
    {
        this.currency = currency;
    }
    
    public int getCurrency()
    {
        return currency;
    }
}

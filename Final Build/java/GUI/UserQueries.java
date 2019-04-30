package GUI;

// Fig. 28.31: PersonQueries.java
// PreparedStatements used by the Address Book application

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class UserQueries 
{
   private static String className = null;
   private static String URL = null;
   private static String USERNAME = null;
   private static String PASSWORD = null;

   private Connection connection = null; // manages connection
   private PreparedStatement selectAllPeople = null; 
   private PreparedStatement selectPeopleByLastName = null; 
   private PreparedStatement insertNewUser = null; 
   private PreparedStatement deleteUser = null;
    
   // constructor
    public UserQueries()
    {
        try
        {
            ResourceBundle resources;
            InputStream in = null;
            ResourceBundle newResources;

            in = ClassLoader.getSystemResourceAsStream("db.properties");
            
            resources = new PropertyResourceBundle(in);
            
            in.close();
            
            className = resources.getString("jdbc.driver");
            URL = resources.getString("jdbc.url");
            System.out.println(URL);
            USERNAME = resources.getString("jdbc.user");
            PASSWORD = resources.getString("jdbc.password");
        }
        catch (Exception exp)
        {
            System.out.println("Couldn't load resources." + exp);
            System.exit(-1);
        }
       
        try
        {
            System.out.print(className);
            Class.forName(className);
            
        }
        catch (Exception e) 
        {
            System.out.println("Failed to load  driver.");
            return;
        }
      try 
      {
         connection = 
            DriverManager.getConnection( URL, USERNAME, PASSWORD );

         // create query that selects all entries in the AddressBook
         selectAllPeople = 
            connection.prepareStatement( "SELECT * FROM Users" );
         
         // create query that selects entries with a specific last name
         selectPeopleByLastName = connection.prepareStatement( 
            "SELECT * FROM Users WHERE LastName = ?" );
         
         // create insert that adds a new entry into the database
         insertNewUser = connection.prepareStatement( 
            "INSERT INTO Users " + 
            "( Email, FirstName, LastName, Password, Credit_Card ) " + 
            "VALUES ( ?, ?, ?, ? , ? )" );
         
         // create delete that gets rid of current entry
         deleteUser = connection.prepareStatement(
                 "DELETE FROM APP.Users WHERE EMAIL = ?");
         
      } // end try // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         System.exit( 1 );
      } // end catch
    } // end PersonQueries constructor
   
    // select all of the addresses in the database
    public List< User > getAllPeople()
    {
        List< User > results = null;
        ResultSet resultSet = null;
      
        try 
        {
            // executeQuery returns ResultSet containing matching entries
            resultSet = selectAllPeople.executeQuery(); 
            results = new ArrayList< User >();
         
            while ( resultSet.next() )
            {
                results.add( new User(
                    resultSet.getString( "Email" ),
                    resultSet.getString( "FirstName" ),
                    resultSet.getString( "LastName" ),
                    resultSet.getString( "Password" ),
                    resultSet.getString( "Credit_Card" ) ) );
            } // end while
        } // end try
        catch ( SQLException sqlException )
        {
            sqlException.printStackTrace();         
        } // end catch
        finally
        {
            try 
            {
                resultSet.close();
            } // end try
            catch ( SQLException sqlException )
            {
                sqlException.printStackTrace();         
                close();
            } // end catch
        } // end finally
      
        return results;
    } // end method getAllPeople
   
   // select person by last name   
    public List< User > getPeopleByLastName( String name )
    {
        List< User > results = null;
        ResultSet resultSet = null;

        try 
        {
         selectPeopleByLastName.setString( 1, name ); // specify last name

         // executeQuery returns ResultSet containing matching entries
         resultSet = selectPeopleByLastName.executeQuery(); 
	 
         results = new ArrayList< User >();
         
         while ( resultSet.next() )
         {
            results.add( new User( resultSet.getString( "Email" ), 
                    resultSet.getString( "FirstName" ), 
                    resultSet.getString( "LastName" ), 
                    resultSet.getString( "Password" ),
                    resultSet.getString( "Credit_Card" )) );
         } // end while
        } // end try
        catch ( SQLException sqlException )
        {
         sqlException.printStackTrace();
        } // end catch
        finally
        {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
        } // end finally
      
        return results;
    } // end method getPeopleByName
   
   // add an entry
    public int addUser( 
        String email, String fname, String lname, String pass , String creditCard )
    {
        int result = 0;
      
        // set parameters, then execute insertNewPerson
        try 
        {
         insertNewUser.setString( 1, email );
         insertNewUser.setString( 2, fname );
         insertNewUser.setString( 3, lname );
         insertNewUser.setString( 4, pass );
         insertNewUser.setString( 5, creditCard);

         // insert the new entry; returns # of rows updated
         result = insertNewUser.executeUpdate(); 
        } // end try
        catch ( SQLException sqlException )
        {
         sqlException.printStackTrace();
         close();
        } // end catch
      
        return result;
    } // end method addPerson
   
   // close the database connection
    public void close()
    {
        try 
        {
         connection.close();
        } // end try
        catch ( SQLException sqlException )
        {
         sqlException.printStackTrace();
        } // end catch
    } // end method close
   
    public int deleteUser( String email )
    {
        int result = 0;
        // set parameters, then execute insertNewPerson
        try 
        {
         deleteUser.setString( 1, email );
        
         result = deleteUser.executeUpdate(); 
         
        } // end try // end try
        catch ( SQLException sqlException )
        {
         sqlException.printStackTrace();
         close();
        } // end catch
      
        return result;
    } // end method deleteUser
   
    private class action1 implements ActionListener
    {
        public void actionPerformed(ActionEvent myEvent)
        {
           System.exit(0);
        }
    }
} // end class UserQueries

 
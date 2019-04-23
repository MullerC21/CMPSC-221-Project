package newpackage;

// Fig. 28.31: PersonQueries.java
// PreparedStatements used by the Address Book application
import java.awt.FlowLayout;
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
import javax.swing.JFrame;
import javax.swing.*;

public class PersonQueries 
{
   private static String className = null;
   private static String URL = null;
   private static String USERNAME = null;
   private static String PASSWORD = null;

   private Connection connection = null; // manages connection
   private PreparedStatement selectAllPeople = null; 
   private PreparedStatement selectPeopleByLastName = null; 
   private PreparedStatement insertNewPerson = null; 
   private PreparedStatement deletePerson = null;
    
   // constructor
    public PersonQueries()
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
         insertNewPerson = connection.prepareStatement( 
            "INSERT INTO Users " + 
            "( Email, FirstName, LastName, Password, Currency ) " + 
            "VALUES ( ?, ?, ?, ? , ? )" );
         
         // create delete that gets rid of current entry
         deletePerson = connection.prepareStatement(
                 "DELETE FROM APP.Users WHERE EMAIL = ?");
         
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         System.exit( 1 );
      } // end catch
    } // end PersonQueries constructor
   
    // select all of the addresses in the database
    public List< Person > getAllPeople()
    {
        List< Person > results = null;
        ResultSet resultSet = null;
      
        try 
        {
            // executeQuery returns ResultSet containing matching entries
            resultSet = selectAllPeople.executeQuery(); 
            results = new ArrayList< Person >();
         
            while ( resultSet.next() )
            {
                results.add( new Person(
                    resultSet.getString( "Email" ),
                    resultSet.getString( "FirstName" ),
                    resultSet.getString( "LastName" ),
                    resultSet.getString( "Password" ),
                    resultSet.getString( "Currency" ) ) );
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
    public List< Person > getPeopleByLastName( String name )
    {
        List< Person > results = null;
        ResultSet resultSet = null;

        try 
        {
         selectPeopleByLastName.setString( 1, name ); // specify last name

         // executeQuery returns ResultSet containing matching entries
         resultSet = selectPeopleByLastName.executeQuery(); 
	 
         results = new ArrayList< Person >();
         
         while ( resultSet.next() )
         {
            results.add( new Person( resultSet.getString( "Email" ), 
                    resultSet.getString( "FirstName" ), 
                    resultSet.getString( "LastName" ), 
                    resultSet.getString( "Password" ), 
                    resultSet.getString( "Currency" ) ) );
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
    public int addPerson( 
        String email, String fname, String lname, String pass , String currency )
    {
        int result = 0;
      
        // set parameters, then execute insertNewPerson
        try 
        {
         insertNewPerson.setString( 1, email );
         insertNewPerson.setString( 2, fname );
         insertNewPerson.setString( 3, lname );
         insertNewPerson.setString( 4, pass );
         insertNewPerson.setString( 5, currency);

         // insert the new entry; returns # of rows updated
         result = insertNewPerson.executeUpdate(); 
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
   
    public int deletePerson( String email )
    {
        int result = 0;
        // set parameters, then execute insertNewPerson
        try 
        {
         deletePerson.setString( 1, email );
        
         result = deletePerson.executeUpdate(); 
         
        } // end try
        catch ( SQLException sqlException )
        {
         sqlException.printStackTrace();
         close();
        } // end catch
      
        return result;
    } // end method addPerson
   
    private class action1 implements ActionListener
    {
        public void actionPerformed(ActionEvent myEvent)
        {
           System.exit(0);
        }
    }
} // end class PersonQueries



/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

 
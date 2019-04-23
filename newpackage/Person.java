package newpackage;

// Fig. 28.30: Person.java
// Person class that represents an entry in an address book.
public class Person
{
   private String email;
   private String firstName;
   private String lastName;
   private String password;
   private String currency;
   private String credit_card;

   // no-argument constructor
   public Person()
   {
   } // end no-argument Person constructor

   // constructor
   public Person( String emailAddress, String first, String last, 
      String password, String currency, String creditCard )
   {
      setEmail( emailAddress );
      setFirstName( first );
      setLastName( last );
      setPassword( password );
      setCurrency( currency );
      setCreditCard( creditCard );
   } // end five-argument Person constructor 

   // sets the addressID
   public void setEmail( String email )
   {
      this.email = email;
   } // end method setAddressID

   // returns the addressID 
   public String getEmail()
   {
      return email;
   } // end method getAddressID
   
   // sets the firstName
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // returns the first name 
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName
   
   // sets the lastName
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // returns the last name 
   public String getLastName()
   {
      return lastName;
   } // end method getLastName
   
   // sets the email address
   public void setPassword( String password )
   {
      this.password = password;
   } // end method setEmail

   // returns the email address
   public String getPassword()
   {
      return password;
   } // end method getEmail
   
   // sets the phone number
   public void setCurrency( String phone )
   {
      currency = phone;
   } // end method setPhoneNumber

   // returns the phone number
   public String getCurrency()
   {
      return currency;
   } // end method getPhoneNumber

    private void setCreditCard(String creditCard) 
    {
        credit_card = creditCard;
    }
    
    public String getCreditCard()
    {
        return credit_card;
    }
} // end class Person


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

 
package GUI;

// User.java
// User class that represents an entry
public class User
{
   private String email;
   private String firstName;
   private String lastName;
   private String password;
   private String credit_card;

   // no-argument constructor
   public User()
   {
   } // end no-argument User constructor

   // constructor
   public User( String emailAddress, String first, String last, 
      String password, String creditCard )
   {
      setEmail( emailAddress );
      setFirstName( first );
      setLastName( last );
      setPassword( password );
      setCreditCard( creditCard );
   } // end five-argument User constructor 

   // sets the email
   public void setEmail( String email )
   {
      this.email = email;
   } // end method setEmail

   // returns the email
   public String getEmail()
   {
      return email;
   } // end method getEmail
   
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
   
   // sets the password
   public void setPassword( String password )
   {
      this.password = password;
   } // end method setPassword

   // returns the password
   public String getPassword()
   {
      return password;
   } // end method getPassword
   
    private void setCreditCard(String creditCard) 
    {
        credit_card = creditCard;
    }// end method setCreditCard
    
    public String getCreditCard()
    {
        return credit_card;
    }// end method getCreditCard
} // end class User
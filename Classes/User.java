/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

public class User implements Serializable
{
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Double currency;
    private Integer creditCard;
    
    public User()
    {
        email = "";
        firstName = "";
        lastName = "";
        password = "";
        currency = 0.0;
        creditCard = 0;
    }
    
    public User(String email, String firstName, String lastName, String password, Double currency, Integer creditCard)
    {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.currency = currency;
        this.creditCard = creditCard;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setFName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setCurrency(Double currency)
    {
        this.currency = currency;
    }
    
    public void setCreditCard(Integer creditCard)
    {
        this.creditCard = creditCard;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getFName()
    {
        return firstName;
    }
    
    public String getLName()
    {
        return lastName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public Double getCurrency()
    {
        return currency;
    }
    
    public Integer getCreditCard()
    {
        return creditCard;
    }
}

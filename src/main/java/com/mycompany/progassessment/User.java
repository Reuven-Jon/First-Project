/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progassessment;

/**
 *
 * @author Reuven-Jon
 */
public class User {
    
    //strings are used to store the user's personal information
    
    private String userName;
    private String passWord;
    private String firstName;
    private String lastName;
    
    //user is public which allows for it to be accessed and used by other classes in the same package.
    public User(){
        firstName = "";
        lastName = "";
        userName = "";
        passWord = "";
        
    }
    
    public User(String firstName, String lastName, String userName, String passWord){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
        
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassWord(){
        return passWord;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setUserName(String userName){
       this.userName = userName;
    }
    
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }
    
    
}

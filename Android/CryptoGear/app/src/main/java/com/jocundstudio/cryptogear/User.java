package com.jocundstudio.cryptogear;

/**
 * Created by josecanizares on 3/2/16.
 */
public class User {

    String First_Name;
    String Last_Name;
    String Username;
    String Password;
    String Email;
    String City;
    String State;
    String User_ID;
    String Games_Won;
    String Games_Lost;
    String Experience;
    String Reliability;



    public User (String email, String username, String password) {

        this.First_Name = "NULL";
        this.Last_Name = "NULL";
        this.Username = username;
        this.Password = password;
        this.Email = email;
        this.City = "NULL";
        this.State = "NULL";
        this.User_ID = "NULL";
        this.Games_Won = "NULL";
        this.Games_Lost = "NULL";
        this.Experience = "NULL";
        this.Reliability = "NULL";

    }


    public User (String email, String password) {

        this.First_Name = "NULL";
        this.Last_Name = "NULL";
        this.Username = "NULL";
        this.Password = password;
        this.Email = email;
        this.City = "NULL";
        this.State = "NULL";
        this.User_ID = "NULL";
        this.Games_Won = "NULL";
        this.Games_Lost = "NULL";
        this.Experience = "NULL";
        this.Reliability = "NULL";

    }




}

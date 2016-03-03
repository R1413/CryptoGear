package com.jocundstudio.cryptogear;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by josecanizares on 3/2/16.
 */
public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    //allows us to store data on the phone
    SharedPreferences userLocalDatabase;

    //constructor
    //to instantiate a sharedPreference, pass in Context
    public UserLocalStore(Context context) {

        //
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);


    }


    //store user data
    public void storeUserData(User user) {

        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        //store the attributes
        //updates what's stored in sharedPreferences
        spEditor.putString("email", user.email);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);

        //whenever you make changes to sharedPreferences, you commit it in the end
        spEditor.commit();

    }

    //get the logged in user
    public User getLoggedInUser() {

        //default value if there is no email, is an empty string
        String email = userLocalDatabase.getString("email", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");

        User storedUser = new User(email, username, password);


        return storedUser;



    }


    //pass false if logged out
    //pass true if logged in
    public void setUserLoggedIn(boolean loggedIn) {


        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();


    }

    //get the status of the user, logged in or logged out
    public boolean getUserLoggedIn() {

        if (userLocalDatabase.getBoolean("loggedIn", false) == true) {

            return true;

        }

        else {

            return false;
        }


    }

    public void clearUserData() {


        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();






    }
}

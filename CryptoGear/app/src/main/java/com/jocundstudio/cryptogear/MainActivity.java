package com.jocundstudio.cryptogear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends WelcomeScreen {



    TextView email;
    TextView username;
    TextView password;

    Button LogOut;

    UserLocalStore userLocalStore;


    TextView Output;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (TextView) findViewById(R.id.email);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);

        LogOut = (Button) findViewById(R.id.LogOut);


        Output = (TextView) findViewById(R.id.Output);


        userLocalStore = new UserLocalStore(this);


        //when user clicks log out, LoggedIn is set to false
        //and you are sent to the login page
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //clearing data will clear sharedPreferences
                //userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);

                startActivity(new Intent(MainActivity.this, Login.class));



            }
        });





    }







    //At the beginning, this function runs
    //Another verification, but this one is within MainActivity.
    @Override
    protected void onStart() {
        super.onStart();

        if (authenticate() == true) {

            //tell the user that he/she is logged in
            Output.setText("You are logged in!");
            //display user details
            displayUserDetails();


        }


        else {


            email.setText("Not an account.");

        }


    }




    //authentication function
    //here we can have a timeout for the login session
    //or something like that.
    private boolean authenticate() {

        return userLocalStore.getUserLoggedIn();

    }


    //display the user's details
    private void displayUserDetails() {


        User user = userLocalStore.getLoggedInUser();

        email.setText(user.email);
        username.setText(user.username);
        password.setText(user.password);




    }




}

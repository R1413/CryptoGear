package com.jocundstudio.cryptogear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//for json parsing


public class MainActivity extends WelcomeScreen {



    TextView email;
    TextView username;
    TextView password;

    Button LogOut;

    UserLocalStore userLocalStore;


    TextView Output;

    Button Connect;

    EditText UserInput;

    Button Post;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //set up keyboard hiding
        setupUI(findViewById(R.id.mainactivity));



        email = (TextView) findViewById(R.id.email);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);

        LogOut = (Button) findViewById(R.id.LogOut);


        Output = (TextView) findViewById(R.id.Output);


        Connect = (Button) findViewById(R.id.Connect);


        UserInput = (EditText) findViewById(R.id.UserInput);
        Post = (Button) findViewById(R.id.Post);


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






        Connect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                startActivity(new Intent(MainActivity.this, GameActivity.class));



            }

        });




        Post.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {





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
            Output.setText("You are logged in! This is Crypto, an app all about encryption. " +
                    " You will start with learning about Huffman codes, a way of encoding the alphabet into 1's and 0's. " +
                    "Huffman codes use less bits than something like Ascii (where everything is 8-bits) by taking into " +
                    "consideration how often a letter from the alphabet is used (e is the most common in the English " +
                    "language). MP3 and jpeg compression schemes take advantage of this Huffman encoding.");
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

        email.setText(user.Email);
        username.setText(user.Username);
        password.setText(user.Password);




    }





























    //hideKeyboard function
    public static void hideSoftKeyboard(Activity activity) {



        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);



        if (activity.getCurrentFocus() != null) {
            //leave last parameter 0
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }

    }




    //function for hiding keyboard when user clicks away from EditText
    public void setupUI(View view) {




        //Set up touch listener for non-text box views to hide keyboard.
        if(!(view instanceof EditText)) {

            view.setOnTouchListener(new View.OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    //Log.d("TAG", "You clicked on the sign up activity.");
                    hideSoftKeyboard(MainActivity.this);
                    return false;
                }

            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

                View innerView = ((ViewGroup) view).getChildAt(i);

                setupUI(innerView);
            }
        }
    }





























}

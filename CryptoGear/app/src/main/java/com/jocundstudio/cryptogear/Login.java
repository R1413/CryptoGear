package com.jocundstudio.cryptogear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends WelcomeScreen {


    EditText Password;
    EditText Email;


    Button Login;


    TextView Output;


    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set up keyboard hiding
        setupUI(findViewById(R.id.loginpage));


        Email = (EditText) findViewById(R.id.EnterEmail);

        Password = (EditText) findViewById(R.id.EnterPassword);





        Login = (Button) findViewById(R.id.Login);


        Output = (TextView) findViewById(R.id.Output);










        //
        userLocalStore = new UserLocalStore(this);










        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String emailAddress = Email.getText().toString();

                String password = Password.getText().toString();

                //This is where we will connect to Node.js


                String Answer = emailAddress + password;




                Output.setText(Answer);



                //Login verification
                User user = new User(emailAddress, "RANDOM", password);


                User registeredUser = userLocalStore.getLoggedInUser();


                Log.d("TAG", "FIRST");


                //Compare the passwords of the registered user and the user logging in
                if (user.password.equals(registeredUser.password)) {


                    Log.d("TAG", "SECOND");
                    //set user loggedIn to true

                    userLocalStore.setUserLoggedIn(true);


                    //go to the main activity page
                    startActivity(new Intent(Login.this, MainActivity.class));


                }

                else {

                    Output.setText("Something is wrong with your username or password.");

                }












            }
        });





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
                    //Log.d("TAG", "You clicked on the login activity.");
                    hideSoftKeyboard(Login.this);
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

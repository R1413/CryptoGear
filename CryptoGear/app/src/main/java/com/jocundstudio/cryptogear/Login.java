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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Login extends WelcomeScreen {

//declared text field variables
    EditText Password;
    EditText Email;

// declare login button
    Button Login;

//declare output textview
    TextView Output;

//declare userLocalStore for dealing with share preference
    UserLocalStore userLocalStore;
//oncreate is called when login page (activity) loads
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //set up keyboard hiding
        setupUI(findViewById(R.id.loginpage));

// reference the text field (Edit text) form the content_login.xml
        //initialize them to our variable
        Email = (EditText) findViewById(R.id.EnterEmail);

        Password = (EditText) findViewById(R.id.EnterPassword);




// reference the login button
        Login = (Button) findViewById(R.id.Login);

// refeence the output textView
        Output = (TextView) findViewById(R.id.Output);










        //
        userLocalStore = new UserLocalStore(this);








// setup onclick listener to login button

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //get whatever typed in the textfield
                //and store them to local variable

                String emailAddress = Email.getText().toString();

                String password = Password.getText().toString();

                //This is where we will connect to Node.js








                //Login verification

                //Make a new user
                //User user = new User(emailAddress, password);

                //get the registered user
                //User registeredUser = userLocalStore.getLoggedInUser();

                //user regex for validating email
                String myPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

                //regex pattern
                Pattern p = Pattern.compile(myPattern);

                //Check if emailAddress matches a valid email
                Matcher m = p.matcher(emailAddress);




                if (emailAddress.equals("") && password.equals("")) {

                    Output.setText("Please type in your email and password");

                }

                else if (emailAddress.equals("")) {

                    Output.setText("Please type in your email.");
                }

                else if (password.equals("")) {

                    Output.setText("Please type in your password.");

                }


                else if (m.matches()) {

                    //Log.d("TAG", "Logged in");
                    //set user loggedIn to true

                    userLocalStore.setUserLoggedIn(true);


                    //This is where we will connect to our database

                    //first create json-formatted info of the user
                    JSONObject json = new JSONObject();


                    try {
                        json.put("email", emailAddress);
                    } catch (JSONException e) {
                        Log.e("Crypto", "Unexpected JSON exception.", e);
                    }


                    try {
                        json.put("password", password);
                    } catch (JSONException e) {
                        Log.e("Crypto", "Unexpected JSON exception.", e);
                    }


                    //use the DatabaseConnector class
                    //create a new instance of that inner class AddNewAccountTask
                    DatabaseConnector DC = new DatabaseConnector("10.0.0.8");
                    DatabaseConnector.VerifyLoginTask LoginTask = DC.new VerifyLoginTask();

                    //execute it with the json
                    //this will make a new account in the database
                    LoginTask.execute(json);


                    while (DC.Done == false) {
                        //wait for background task to finish
                    }

                    if (DC.VerifyStatus().equals("IncorrectEmail")) {

                        Output.setText("Invalid email.");

                    } else if (DC.VerifyStatus().equals("CorrectEmail")) {

                        Output.setText("Something is wrong with your password.");

                    } else if (DC.VerifyStatus().equals("CorrectPassword")) {

                        Output.setText("You are logging in!");
                        //go to the main activity page
                        startActivity(new Intent(Login.this, MainActivity.class));

                    }


                }



                else {

                    //regex validation
                    Output.setText("Invalid email address.");


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







    //clearing functions to clear text field when
    //user hits the x's

    public void clearEmail(View v) {

        Email.setText("");

    }
    

    public void clearPassword(View v) {

        Password.setText("");

    }








}

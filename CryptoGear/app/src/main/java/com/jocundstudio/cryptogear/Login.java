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


                //String Answer = emailAddress + password;




                //Output.setText(Answer);






                //Login verification

                //Make a new user
                User user = new User(emailAddress, "RANDOM", password);

                //get the registered user
                User registeredUser = userLocalStore.getLoggedInUser();





                //user regex for validating email
                String myPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

                //regex pattern
                Pattern p = Pattern.compile(myPattern);

                //Check if emailAddress matches a valid email
                Matcher m = p.matcher(emailAddress);




                //Compare the passwords and emails
                // of the registered user and the user logging in
                if (user.password.equals(registeredUser.password) && user.email.equals(registeredUser.email) && m.matches()) {


                    //Log.d("TAG", "Logged in");
                    //set user loggedIn to true

                    userLocalStore.setUserLoggedIn(true);


                    //go to the main activity page
                    startActivity(new Intent(Login.this, MainActivity.class));


                }

                else if (user.password.equals(registeredUser.password) && user.email.equals(registeredUser.email)) {


                    Output.setText("Something is wrong with your email.");

                }


                else {

                    Output.setText("Something is wrong with your email or password.");

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

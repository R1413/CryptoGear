package com.jocundstudio.cryptogear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class WelcomeScreen extends AppCompatActivity {





    Button Login;
    Button SignUp;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);




        //





        //Hide the keyboard when the enter key is pressed.
        //in XML file
        //android:imeOptions="actionDone"
        //android:singleLine="true"
        //on the EditTexts



        //This will hide keyboard when user clicks outside of an EditText
        //Loops through all EditTexts so that they all have this property
        setupUI(findViewById(R.id.parent));


















        Login = (Button) findViewById(R.id.Login);
        SignUp = (Button) findViewById(R.id.SignUp);































        //set OnClick Event on the Login button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Load the login page
                startActivity(new Intent(WelcomeScreen.this, Login.class));



            }
        });





        //set OnClick Event on the Sign Up button
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //load the sign-up page
                startActivity(new Intent(WelcomeScreen.this, SignUp.class));

            }
        });













    }



















    //Function Definitions






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

            view.setOnTouchListener(new OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
                    //Log.d("TAG", "You clicked on the main activity.");
                    hideSoftKeyboard(WelcomeScreen.this);
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


        //How to print in Android Studio
            //Log.d("TAG", "This is what you just typed in:" + loginName);















}

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
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SignUp extends WelcomeScreen {



    EditText UserName;
    EditText Password;
    EditText Email;


    Button SignUp;




    TextView Output;


    UserLocalStore userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        //set up keyboard hiding
        setupUI(findViewById(R.id.signuppage));



        //used to access sharedPreferences
        userLocalStore = new UserLocalStore(this);






        Email = (EditText) findViewById(R.id.EnterEmail);

        UserName = (EditText) findViewById(R.id.EnterUserName);

        Password = (EditText) findViewById(R.id.EnterPassword);





        SignUp = (Button) findViewById(R.id.SignUp);





        Output = (TextView) findViewById(R.id.Output);







        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailAddress = Email.getText().toString();

                String username = UserName.getText().toString();

                String password = Password.getText().toString();

                //registered data
                User registeredData = new User (emailAddress, username, password);


                //store data in sharedPreferences
                userLocalStore.storeUserData(registeredData);







                //This is where we will connect to Node.js





                String Answer = emailAddress + username + password;

                Output.setText(Answer);



                //dynamically create button
                Button Login = new Button(SignUp.this);
                Login.setText("Login");

                RelativeLayout ll = (RelativeLayout)findViewById(R.id.signuppage);

                //layout
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.BELOW, R.id.password);
                lp.addRule(RelativeLayout.CENTER_VERTICAL);
                lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
                ll.addView(Login, lp);


                Login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        //go to the main activity page
                        startActivity(new Intent(SignUp.this, Login.class));


                    }
                });

                //hide the sign up button.
                SignUp.setVisibility(View.GONE);







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
                    //Log.d("TAG", "You clicked on the sign up activity.");
                    hideSoftKeyboard(SignUp.this);
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

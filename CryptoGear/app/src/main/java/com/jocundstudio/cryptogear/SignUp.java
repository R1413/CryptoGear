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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends WelcomeScreen {


    //Declare text field variables
    EditText UserName;
    EditText Password;
    EditText Email;



    //Declare SignUp Button
    Button SignUp;



    //declare Output TextView
    TextView Output;


    //Declare UserLocalStore for dealing with sharedPreferences
    UserLocalStore userLocalStore;




    //onCreate is called when SignUp page (activity) loads
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        //set up keyboard hiding
        setupUI(findViewById(R.id.signuppage));



        //used to access sharedPreferences
        userLocalStore = new UserLocalStore(this);



        //Reference the text fields (EditTexts) from the content_sign_up.xml
        //initialize them to our variables

        Email = (EditText) findViewById(R.id.EnterEmail);

        UserName = (EditText) findViewById(R.id.EnterUserName);

        Password = (EditText) findViewById(R.id.EnterPassword);




        //Reference the signUp button
        SignUp = (Button) findViewById(R.id.SignUp);




        //Reference the Output TextView
        Output = (TextView) findViewById(R.id.Output);





        //Set up an onClickListener for the SignUp button

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Get whatever is typed in the text fields
                // and store them to local variables
                String emailAddress = Email.getText().toString();

                String username = UserName.getText().toString();

                String password = Password.getText().toString();





                //user regex for validating email
                String myPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

                //regex pattern
                Pattern p = Pattern.compile(myPattern);

                //Check if emailAddress matches a valid email
                Matcher m = p.matcher(emailAddress);







                //if the user is signing up with a valid email address
                if(m.matches()) {


                    //registered data (the new user)
                    User registeredData = new User(emailAddress, username, password);


                    //store data in sharedPreferences
                    userLocalStore.storeUserData(registeredData);


                    //This is where we will connect to Node.js


                    //String Answer = emailAddress + username + password;

                    //Output.setText(Answer);


                    //dynamically create button
                    Button Login = new Button(SignUp.this);
                    Login.setText("Login");

                    RelativeLayout ll = (RelativeLayout) findViewById(R.id.signuppage);

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



                else {


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

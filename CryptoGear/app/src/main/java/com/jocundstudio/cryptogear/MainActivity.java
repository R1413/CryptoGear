package com.jocundstudio.cryptogear;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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


                //specify url with port number
                //example url: http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo
                //example url: "http://10.202.14.104:8080"
                //can't use localhost since localhost in the emulator
                //is the emulator itself

                new JSONTask().execute("http://10.0.0.2:8080/");


            }

        });




        Post.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                JSONObject json = new JSONObject();


                String input = UserInput.getText().toString();

                try {
                    json.put("user", input);
                } catch (JSONException e) {
                    Log.e("Crypto", "Unexpected JSON exception.", e);
                }

                try {
                    json.put("password", input);
                } catch (JSONException e) {
                    Log.e("Crypto", "Unexpected JSON exception.", e);
                }




                new PostTask().execute(json);


            }

        });






    }



    //write to database
    public class PostTask extends AsyncTask<JSONObject, String, JSONObject> {

        @Override
        protected JSONObject doInBackground(JSONObject... params) {


            //make an Http connection
            HttpURLConnection connection = null;
            BufferedReader reader = null;






            JSONObject jData = params[0];









            try {

                URL url = new URL("http://10.0.0.2:8080/Signup");

                connection = (HttpURLConnection) url.openConnection();



                Log.d("TAG", "Before requesting post.");

                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

                //Post
                connection.setRequestMethod("POST");

                //connection.connect();


                connection.setDoOutput(true);
                connection.setChunkedStreamingMode(0);

                Log.d("TAG4", jData.toString());


                connection.getOutputStream().write(jData.toString().getBytes("UTF-8"));


                // Check the error stream first, if this is null then there have been no issues with the request
                InputStream inputStream = connection.getErrorStream();
                if (inputStream == null)
                    inputStream = connection.getInputStream();

                // Read everything from our stream
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

                String inputLine;
                StringBuffer response = new StringBuffer();

                    while ((inputLine = responseReader.readLine()) != null) {

                        response.append(inputLine);
                    }

                responseReader.close();

                connection.disconnect();


                JSONObject json2 = new JSONObject();




                try {
                    json2.put("success", "success2");
                } catch (JSONException e) {
                    Log.e("Crypto", "Unexpected JSON exception.", e);
                }

                return json2;



            } catch(MalformedURLException e) {

                e.printStackTrace();

            } catch(IOException e) {

                e.printStackTrace();

            } finally

            {
                //can't disconnect something that's null

                if (connection != null) {

                    connection.disconnect();
                    Log.d("TAG", "Connection disconnected.");
                }


                //to close reader you need a try catch block
                try {
                    //can't close something that's null
                    if (reader != null) {

                        reader.close();
                        Log.d("TAG", "Reader closed.");
                    }

                } catch (IOException e) {

                    e.printStackTrace();
                }


            }

            //passed to onPostExecute method
            return null;



        }

        @Override
        protected void onPostExecute(JSONObject result) {

            String result2 = result.toString();
            super.onPostExecute(result);
            //take from our buffer and output it
            Log.d("TAG2", result2);
            Output.setText(result2);
        }


    }










    //read json from nodejs which makes a GET request to our mysql database
    public class JSONTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {


            //make an Http connection
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {

                URL url = new URL(params[0]);

                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                Log.d("TAG", "Before getting input stream.");
                InputStream stream = connection.getInputStream();
                Log.d("TAG", "Before getting input stream.");
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";

                Log.d("TAG", "Before while loop.");

                //read in data
                while ((line = reader.readLine()) != null) {

                    Log.d("TAG", "In while loop.");
                    buffer.append(line);

                }

                //passed to onPostExecute method
                Log.d("TAG", buffer.toString() + "<--json data from url.");
                return buffer.toString();

            } catch(MalformedURLException e) {

                e.printStackTrace();

            } catch(IOException e) {

                e.printStackTrace();

            } finally

            {
                //can't disconnect something that's null
                if (connection != null) {

                    connection.disconnect();
                    Log.d("TAG", "Connection disconnected.");
                }


                //to close reader you need a try catch block
                try {
                    //can't close something that's null
                    if (reader != null) {


                        reader.close();
                        Log.d("TAG", "Reader closed.");
                    }

                } catch (IOException e) {

                    e.printStackTrace();

                }

            }

            //passed to onPostExecute method
            return null;


        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //take from our buffer and output it
            Log.d("TAG2", result);
            Output.setText(result);
        }
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

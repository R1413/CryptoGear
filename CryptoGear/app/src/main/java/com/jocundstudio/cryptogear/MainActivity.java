package com.jocundstudio.cryptogear;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (TextView) findViewById(R.id.email);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);

        LogOut = (Button) findViewById(R.id.LogOut);


        Output = (TextView) findViewById(R.id.Output);


        Connect = (Button) findViewById(R.id.Connect);


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


                //specify url
                //example url: http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo
                //
                new JSONTask().execute("http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo");

            }

        });





















    }


    //read json from nodejs
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

                //Log.d("TAG", "Before getting input stream.");

                InputStream stream = connection.getInputStream();

                //Log.d("TAG", "Before getting input stream.");

                reader = new BufferedReader(new InputStreamReader(stream));


                StringBuffer buffer = new StringBuffer();

                String line = "";

                //Log.d("TAG", "Before while loop.");

                //read in data
                while ((line = reader.readLine()) != null) {

                    //Log.d("TAG", "In while loop.");
                    buffer.append(line);


                }

                //passed to onPostExecute method
                //Log.d("TAG", buffer.toString() + "<--json data from url.");
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

        email.setText(user.email);
        username.setText(user.username);
        password.setText(user.password);




    }




































}

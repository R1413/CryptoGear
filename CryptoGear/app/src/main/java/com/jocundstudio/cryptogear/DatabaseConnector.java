package com.jocundstudio.cryptogear;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by josecanizares on 3/13/16.
 */
public class DatabaseConnector extends AsyncTask<String, String, String> {






    /**
     * Created by josecanizares on 3/13/16.
     */
//read json from nodejs
//extends AsyncTask (it's a background task)



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
            //Output.setText(result);

            //Log.d("TAG", result);
        }





}

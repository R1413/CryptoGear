package com.jocundstudio.cryptogear;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

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

public class DatabaseConnector {

    Boolean validAccount;
    Boolean Done;

    String BaseUrl;
    String Verify;


    public DatabaseConnector(String BaseUrl) {

        validAccount = true;
        this.BaseUrl = BaseUrl;
        this.Done = false;
        this.Verify = "";

    }

    //get whether or not account is valid
    public Boolean isAccountValid() {

        return validAccount;

    }

    //setter for setting validAccount
    public void setValidAccount(Boolean validAccount) {

        this.validAccount = validAccount;

    }


    //get verification status
    public String VerifyStatus() {

        return Verify;

    }

    //setter for setting validAccount
    public void setVerify(String Verify) {

        this.Verify = Verify;

    }





    //add a new account to the database
    //verify that the username or email isn't taken
    //in express
    public class AddNewAccountTask extends AsyncTask<JSONObject, String, JSONObject> {

        @Override
        protected JSONObject doInBackground(JSONObject... params) {


            //make an Http connection
            HttpURLConnection connection = null;
            BufferedReader reader = null;






            JSONObject jData = params[0];









            try {

                URL url = new URL("http://" + BaseUrl + ":8080/Signup");

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

                Log.d("response1", response.toString());
                Log.d("response2", "false");
                Log.d("response3", response.toString().trim());

                //use .equals in Java
                //use == in js
                if (response.toString().trim().equals("false")) {

                    //Display text that says username or email is already taken
                    Log.d("valid", "Setting validAccount to false.");
                    setValidAccount(false);


                }

                Done = true;

                connection.disconnect();


                JSONObject json2 = new JSONObject();




                try {
                    json2.put("success", response.toString());
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

        }


    }




















    //make POST request to our mysql database to verify login
    public class VerifyLoginTask extends AsyncTask<JSONObject, String, JSONObject> {

        @Override
        protected JSONObject doInBackground(JSONObject... params) {


            //make an Http connection
            HttpURLConnection connection = null;
            BufferedReader reader = null;






            JSONObject jData = params[0];









            try {

                URL url = new URL("http://" + BaseUrl + ":8080/Login");

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

                Log.d("response1", response.toString());
                Log.d("response2", "false");
                Log.d("response3", response.toString().trim());


                String response2 = response.toString().replaceAll("\"", "");


                Log.d("response4", response2);

                //Cases

                //use .equals in Java
                //use == in js
                //Careful! use twice the number of quotes
                if (response2.trim().equals("IncorrectEmail")) {

                    //Display text that says username or email is already taken
                    Log.d("verify", "Setting verify to Incorrect Email.");
                    setVerify("IncorrectEmail");


                }

                if (response2.trim().equals("CorrectEmail")) {

                    //Display text that says username or email is already taken
                    Log.d("valid", "Setting verify to Correct Email.");
                    setVerify("CorrectEmail");


                }

                if (response2.trim().equals("CorrectPassword")) {

                    //Display text that says username or email is already taken
                    Log.d("valid", "Setting verify to Correct Password.");
                    setVerify("CorrectPassword");


                }








                Done = true;

                connection.disconnect();


                JSONObject json2 = new JSONObject();




                try {
                    json2.put("success", response.toString());
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

        }


    }













}
package com.jocundstudio.cryptogear;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.inputmethod.InputMethodManager;
import android.app.Activity;
import android.view.ViewGroup;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;


public class MainActivity extends AppCompatActivity {

    TextView Output;
    EditText UserName;
    EditText Password;
    SeekBar adjustFontSize;




    String loginName;
    String loginPassword;

    float font_size;

    String text_info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);









        //Hide the keyboard when the enter key is pressed.
        //in XML file
        //android:imeOptions="actionDone"
        //android:singleLine="true"
        //on the EditTexts



        //This will hide keyboard when user clicks outside of an EditText
        //Loops through all EditTexts so that they all have this property
        setupUI(findViewById(R.id.parent));








        //Reference the text field and text view
        Output = (TextView) findViewById(R.id.Output);
        UserName = (EditText) findViewById(R.id.EnterUserName);

        Password = (EditText) findViewById(R.id.EnterPassword);

        //reference the seekbar
        adjustFontSize = (SeekBar) findViewById(R.id.adjustFontSize);









    //whenever user starts the application, we want to load the preferences
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);

        //specify a default value
        text_info = sharedPreferences.getString(getString(R.string.TEXT_INFO), "");

        //set the text
        UserName.setText(text_info);



        font_size = sharedPreferences.getFloat(getString(R.string.FONT_SIZE), 25);

        //set the text size
        UserName.setTextSize(TypedValue.COMPLEX_UNIT_PX, font_size);

        if (font_size == 25) {

            //initiate seekbar from the start
            adjustFontSize.setProgress(0);

        }

        else {

            //initiate seekbar with the saved font_size
            adjustFontSize.setProgress((int) font_size);

        }















        adjustFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar adjustFontSize, int progress, boolean fromUser) {

                //Change text size depending on the progress of the seekbar
                UserName.setTextSize(TypedValue.COMPLEX_UNIT_PX, progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar adjustFontSize) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar adjustFontSize) {

                font_size = UserName.getTextSize();


            }
        });



        Button EncryptButton = (Button) findViewById(R.id.Login);
        //set OnClick Event on the Encrypt Button
        EncryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = UserName.getText().toString();
                String Answer = "Ok. Cool.";

                Output.setText(Answer);

            }
        });











    }







    public void saveSettings(View view)
    {
        //MODE_PRIVATE
        //no other application can use this data
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat(getString(R.string.FONT_SIZE), font_size);

        editor.putString(getString(R.string.TEXT_INFO), UserName.getText().toString());

        //save all this information in the sharedPreferences
        editor.commit();


    }

    

    public void clearSettings(View view)
    {

        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();

        editor.commit();



    }




    //hideKeyboard function
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }




    //function for hiding keyboard when user clicks away from EditText
    public void setupUI(View view) {

        //Set up touch listener for non-text box views to hide keyboard.
        if(!(view instanceof EditText)) {

            view.setOnTouchListener(new OnTouchListener() {

                public boolean onTouch(View v, MotionEvent event) {
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

    //method called when user presses login
    public void userLogin(View view) {

            //save the username to the string loginName
            loginName = UserName.getText().toString();
            loginPassword = Password.getText().toString();

            String method = "login";

            //new BackgroundTask instance
            //Async task                                    //pass in context
            BackgroundTask backgroundTask = new BackgroundTask(this);

            backgroundTask.execute(method, loginName, loginPassword);


            //Added comment.








    }








}

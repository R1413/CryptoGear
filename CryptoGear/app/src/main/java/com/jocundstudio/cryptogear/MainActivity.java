package com.jocundstudio.cryptogear;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    TextView Output;
    EditText Message;
    SeekBar adjustFontSize;

    float font_size;

    String text_info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference the text field and text view
        Output = (TextView) findViewById(R.id.Output);
        Message = (EditText) findViewById(R.id.EnterMessage);

        //reference the seekbar
        adjustFontSize = (SeekBar) findViewById(R.id.adjustFontSize);



    //whenever user starts the application, we want to load the preferences
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(getString(R.string.PREF_FILE), MODE_PRIVATE);

        //specify a default value
        text_info = sharedPreferences.getString(getString(R.string.TEXT_INFO), "");

        //set the text
        Message.setText(text_info);



        font_size = sharedPreferences.getFloat(getString(R.string.FONT_SIZE), 25);

        //set the text size
        Message.setTextSize(TypedValue.COMPLEX_UNIT_PX, font_size);

        if (font_size == 25) {

            //initiate seekbar from the start
            adjustFontSize.setProgress(0);

        }

        else {

            //initiate seekbar with the saved font_size
            adjustFontSize.setProgress((int) font_size);

        }


        //set the font color







        adjustFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar adjustFontSize, int progress, boolean fromUser) {

                //Change text size depending on the progress of the seekbar
                Message.setTextSize(TypedValue.COMPLEX_UNIT_PX, progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar adjustFontSize) {



            }

            @Override
            public void onStopTrackingTouch(SeekBar adjustFontSize) {

                font_size = Message.getTextSize();


            }
        });



        Button EncryptButton = (Button) findViewById(R.id.EncryptButton);
        //set OnClick Event on the Encrypt Button
        EncryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String message = Message.getText().toString();
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

        editor.putString(getString(R.string.TEXT_INFO), Message.getText().toString());

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



}

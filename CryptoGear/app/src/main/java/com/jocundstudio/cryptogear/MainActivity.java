package com.jocundstudio.cryptogear;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView Output;
    EditText EnterMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Output = (TextView) findViewById(R.id.Output);
        EnterMessage = (EditText) findViewById(R.id.EnterMessage);

        Button EncryptButton = (Button) findViewById(R.id.EncryptButton);
        //set OnClick Event on the Encrypt Button
        EncryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Message = EnterMessage.getText().toString();
                String Answer = "Ok. Cool.";

                Output.setText(Answer);

            }
        });
    }






}

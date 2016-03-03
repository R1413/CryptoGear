package com.jocundstudio.cryptogear;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {



    EditText UserName;
    EditText Password;
    EditText Email;


    Button SignUp;


    TextView Output;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);










        Email = (EditText) findViewById(R.id.EnterEmail);

        UserName = (EditText) findViewById(R.id.EnterUserName);

        Password = (EditText) findViewById(R.id.EnterPassword);





        SignUp = (Button) findViewById(R.id.SignUp);





        Output = (TextView) findViewById(R.id.Output);







        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailaddress = Email.getText().toString();

                String username = UserName.getText().toString();

                String password = Password.getText().toString();







                //This is where we will connect to Node.js





                String Answer = emailaddress + username + password;

                Output.setText(Answer);




            }
        });















    }









}

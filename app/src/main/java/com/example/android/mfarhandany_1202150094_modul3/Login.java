package com.example.android.mfarhandany_1202150094_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText user, pass;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText)findViewById(R.id.editText_username);
        pass = (EditText)findViewById(R.id.editTextpassword);
        btnlogin = (Button)findViewById(R.id.buttonlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernamekey = user.getText().toString();
                String passwordkey = pass.getText().toString();

                if (usernamekey.equals("EAD") && passwordkey.equals("MOBILE")) {
                    Intent login = new Intent(Login.this, DaftarMinuman.class);
                    startActivity(login);
                    Toast.makeText(Login.this, "Login Sukses", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(Login.this, "Login gagal", Toast.LENGTH_LONG).show();

                }
            }
        });
    }}
package com.example.ali.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity implements View.OnClickListener {
    Button bRegister;
    EditText etName, etUserName, etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etName = (EditText) findViewById(R.id.etName);
        etUserName = (EditText) findViewById(R.id.etUserName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bRegister:
                if(etName.getText().toString() == null){
                    etName.setError("Please Enter Your Name");
                    etName.requestFocus();
                }
                if(etUserName.getText().toString() == null){
                    etUserName.setError("Please Enter Your User Name");
                    etName.requestFocus();
                }
                if(!validatePassword(etPassword.getText().toString())){
                    etPassword.setError("Please Enter Valid Password");
                    etName.requestFocus();
                } if(!validateEmail(etEmail.getText().toString())){
                    etEmail.setError("Please Enter Valid Email");
                    etName.requestFocus();
                }

                String name = etName.getText().toString();
                String username = etUserName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                User new_user = new User(name, username, password, email);
                new_user.addUser();
                break;
        }
    }
    protected boolean validateEmail(String email) {
        String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
    protected boolean validatePassword(String password) {
        if(password!=null && password.length()<10) {
            return true;
        } else {
            return false;
        }
    }
}

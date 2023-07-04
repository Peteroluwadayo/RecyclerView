package com.example.lessononrecyclerviewbybossnero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpPage extends AppCompatActivity {
private EditText firstName,lastName,phoneNumber,emailAddress,userNameEditText,passWordEditText;
private Button login;

public String passWord,userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_up_page);
        initView();
        initListner();
    }
    public void initView(){
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        phoneNumber = findViewById(R.id.phone_number);
        emailAddress = findViewById(R.id.email_address);
        userNameEditText = findViewById(R.id.user_name);
        login = findViewById(R.id.login_1);
        passWordEditText = findViewById(R.id.pass_word);
    }
    public void initListner(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidatepassWord()&validateuserName()){
                    Intent intent = new Intent(SignUpPage.this,SignIn.class);
                    startActivity(intent);
                    savaData();
                    Toast.makeText(SignUpPage.this, "Save Data", Toast.LENGTH_SHORT).show();
                    startActivity(intent);


                }else{
                    Toast.makeText(SignUpPage.this, "provide correct pin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loadData();
        updateData();
    }
    public void savaData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        SharedPreferences.Editor myEditor = peterSharedPreference.edit();
        myEditor.putString(AppConstantBody.userName,userNameEditText.getText().toString());
        myEditor.putString(AppConstantBody.passWord,passWordEditText.getText().toString());
        myEditor.apply();

    }
    public void loadData(){
        SharedPreferences peterSharedPreference = getSharedPreferences(getString(R.string.my_preferences), Context.MODE_PRIVATE);
        passWord = peterSharedPreference.getString(AppConstantBody.passWord,"");
        userName = peterSharedPreference.getString(AppConstantBody.userName,"");

    }
    public void updateData(){
            passWordEditText.setText(passWord);
            userNameEditText.setText(userName);
    }
    private boolean ValidatepassWord() {
        String phoneNumberInput = passWordEditText.getText().toString().trim();
        String acceptableNumber =  "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            passWordEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            passWordEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            passWordEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }
    private boolean validateuserName() {
        String phoneNumberInput = userNameEditText.getText().toString().trim();
        String acceptableNumber =  "^([a-zA-Z@$+._\\d]*)$";

        if (phoneNumberInput.isEmpty()) {
            userNameEditText.setError("field cant be empty");
            return false;
        }
        if (phoneNumberInput.length() < 11) {
            userNameEditText.setError("invalid number");
            return false;
        }
        if (!phoneNumberInput.matches(acceptableNumber)) {
            userNameEditText.setError("incorrect input typed");
            return false;
        }
        return true;
    }
}
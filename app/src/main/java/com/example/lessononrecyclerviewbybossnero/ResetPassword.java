package com.example.lessononrecyclerviewbybossnero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ResetPassword extends AppCompatActivity {
    private EditText resetPassword,passWord;
    private Button login;
    private ImageView arrowImage1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

        initView();
        initListner();
    }
    public void initView(){
        resetPassword = findViewById(R.id.reset_password);
        passWord = findViewById(R.id.password);
        login = findViewById(R.id.btn_login);
        arrowImage1 = findViewById(R.id.back_image1);

    }
    public void initListner(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this,MainActivity.class);
                startActivity(intent);
            }
        });
        arrowImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this,SignIn.class);
                startActivity(intent);
            }
        });
    }
}
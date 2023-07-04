package com.example.lessononrecyclerviewbybossnero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignIn extends AppCompatActivity {
    private EditText userName,passWordEditText;
    private Button next;
    private ImageView arrowBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        initView();
        initListner();
    }
    public void initView(){
        userName = findViewById(R.id.user_name);
        passWordEditText = findViewById(R.id.pass_word);
        next = findViewById(R.id.sign);
        arrowBack = findViewById(R.id.back_image);
    }
    public void initListner(){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this,ResetPassword.class);
                startActivity(intent);
            }
        });
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this,SignUpPage.class);
                startActivity(intent);
            }
        });

    }
}
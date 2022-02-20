package com.example.attaaa;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    EditText em, pass;
    Button log;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        em = findViewById(R.id.emaild);
        pass = findViewById(R.id.passid);
        log = findViewById(R.id.button);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em1 = em.getText().toString().trim();
                String password1 = pass.getText().toString().trim();

                if (em1.isEmpty()){
                    em.setError("user email is required");
                    em.requestFocus();
                    return;
                }//if empty email

                if (!Patterns.EMAIL_ADDRESS.matcher(em1).matches()){
                    em.setError("please enter a valid email");
                    em.requestFocus();
                    return;
                }//em patt

                if (password1.isEmpty()){
                    pass.setError("password is required");
                    pass.requestFocus();
                    return;
                }//empty pass

                if (password1.length() < 8){
                    pass.setError("passwords should be more than 8 characters");
                    pass.requestFocus();
                    return;




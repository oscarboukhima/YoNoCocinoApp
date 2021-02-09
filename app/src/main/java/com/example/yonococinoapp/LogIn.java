package com.example.yonococinoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {

    private EditText correoLogin;
    private EditText passwordLogin;
    private Button botonLogin;
    private  FirebaseAuth firebaseAuth;

    private String email = "";
    private String password = "";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        correoLogin = (EditText) findViewById(R.id.editTextEmailLogin);
        passwordLogin = (EditText) findViewById(R.id.editTextContraseñaLogin);
        botonLogin = (Button) findViewById(R.id.buttonLogIn);

        firebaseAuth = FirebaseAuth.getInstance();


        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = correoLogin.getText().toString();
                password = passwordLogin.getText().toString();

                if ( !email.isEmpty() && !password.isEmpty()){

                    loginUser();

                } else {
                    Toast.makeText(LogIn.this, "Campos sin rellenar", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }


    private void loginUser(){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(LogIn.this, Inicio.class));
                    finish();
                } else {
                    Toast.makeText(LogIn.this, "No hemos podido iniciar sesion", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
package com.example.yonococinoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SingIn extends AppCompatActivity {

    private EditText editTextNombre;
    private EditText editTextCorreo;
    private EditText editTextContraseña;
    private Button buttonCrear;
    private Button buttonLogin;
    private ImageView logo;


        private String nombre = "";
        private String email = "";
        private String password = "";



    FirebaseAuth YoNoCocinofirebaseAuth;
    DatabaseReference YoNoCocinoDatabase;
    //FirebaseAuth.AuthStateListener YoNoCocinoAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        YoNoCocinofirebaseAuth = FirebaseAuth.getInstance();
        YoNoCocinoDatabase = FirebaseDatabase.getInstance().getReference();


        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();

        editTextNombre = (EditText) findViewById(R.id.editNombreDeUsuario);
        editTextCorreo = (EditText) findViewById(R.id.editCorreo);
        editTextContraseña = (EditText) findViewById(R.id.editPassword);
        buttonCrear = (Button) findViewById(R.id.CrearUsuario);
        buttonLogin = (Button) findViewById(R.id.LogIn);
        logo = (ImageView) findViewById(R.id.imageView2);

        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = editTextNombre.getText().toString();
                email = editTextCorreo.getText().toString();
                password = editTextContraseña.getText().toString();

                if (!nombre.isEmpty() && !email.isEmpty() && !password.isEmpty()){

                    if ((password.length() >= 6) ){
                        registerUser();
                    }else {
                        Toast.makeText(SingIn.this, "Al menos debe contener 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(SingIn.this, "Campos sin rellenar", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingIn.this, LogIn.class));
            }
        });







    }


    private void logInUser(){
        startActivity(new Intent(SingIn.this, LogIn.class));
        finish();
    }

    private void registerUser(){
        YoNoCocinofirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Map<String, Object> map = new HashMap<>();
                    map.put("Nombre", nombre);
                    map.put("Correo", email);
                    map.put("Contraseña", password);

                    String id = YoNoCocinofirebaseAuth.getCurrentUser().getUid();

                    YoNoCocinoDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> taskCrearMapa) {
                            if (taskCrearMapa.isSuccessful()){
                                startActivity(new Intent(SingIn.this, Inicio.class));
                                Toast.makeText(SingIn.this, "Campos correctos", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                Toast.makeText(SingIn.this, "Datos no correctos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SingIn.this, "registro no completado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
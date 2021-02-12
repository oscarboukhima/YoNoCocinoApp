package com.example.yonococinoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.yonococinoapp.fragmentos.RestaurantesFragment;
import com.example.yonococinoapp.fragmentos.ajustesFragment;
import com.example.yonococinoapp.fragmentos.carritoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Inicio extends AppCompatActivity {



    private FirebaseAuth firebaseAuth;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.menuNavegacion);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                if (menuItem.getItemId() == R.id.restaurantes){
                    showSelectedFragment(new RestaurantesFragment());
                }
                if (menuItem.getItemId() == R.id.carrito){
                    showSelectedFragment(new carritoFragment());
                }
                if (menuItem.getItemId() == R.id.ajustes){
                    showSelectedFragment(new ajustesFragment());
                }
                return true;
            }
        });
    }

    private void showSelectedFragment (Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
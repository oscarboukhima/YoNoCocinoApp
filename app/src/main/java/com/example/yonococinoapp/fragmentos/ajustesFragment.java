package com.example.yonococinoapp.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yonococinoapp.Inicio;
import com.example.yonococinoapp.R;
import com.example.yonococinoapp.SingIn;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ajustesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

// VERSION OSCAR 0.3

public class ajustesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ajustesFragment() {
        // Required empty public constructor
    }


    public static ajustesFragment newInstance(String param1, String param2) {
        ajustesFragment fragment = new ajustesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final FirebaseAuth firebaseAuth;
        Button botonCerrarSesion;
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseDatabase baseDeDatos = FirebaseDatabase.getInstance();

        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_ajustes, container, false);

        EditText textEditCambioNombre = (EditText) v.findViewById(R.id.textEditnuevoNombre);
        TextView prueba = (TextView) v.findViewById(R.id.textViewprueba);
        String nuevoNombre = textEditCambioNombre.toString();

        EditText textEditCambioContraseña = (EditText) v.findViewById(R.id.textEditnuevaContraseña);
        String nuevaContraseña = textEditCambioNombre.toString();

        botonCerrarSesion = (Button) v.findViewById(R.id.buttonCerrarSesion);

        FirebaseUser usuario =  firebaseAuth.getInstance().getCurrentUser();
        DatabaseReference nombreDeUsuario;
        String stringUsuario = usuario.toString();

        textEditCambioNombre.setHint(stringUsuario);
        prueba.setText(stringUsuario);


        botonCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                startActivity(new Intent(getActivity(), SingIn.class));

            }
        });
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }




}
package com.example.yonococinoapp.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.yonococinoapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BurguerKing#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BurguerKing extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    final double precioInicial = 0;
    double precioTotalFinal;

    

    final double precioWopper = 7.99 ;
    double precioBigKing = 6.99;
    double precioLongChicken = 5.99;
    double precioBacon = 6.99;
    int numeroDeProductos = 0;

     
    
    public BurguerKing() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BurguerKing.
     */
    // TODO: Rename and change types and number of parameters
    public static BurguerKing newInstance(String param1, String param2) {
        BurguerKing fragment = new BurguerKing();
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
        // Inflate the layout for this fragment
        
       



        final View v =  inflater.inflate(R.layout.fragment_burguer_king, container, false);

        final RadioButton radioButtonWopper = (RadioButton) v.findViewById(R.id.radioButtonWopper) ;
        final RadioButton radioButtonBacon = (RadioButton) v.findViewById(R.id.radioButtonBacon) ;
        final RadioButton radioButtonLongChicken = (RadioButton) v.findViewById(R.id.radioButtonLongChicken) ;
        final RadioButton radioButtonBigKing = (RadioButton) v.findViewById(R.id.radioButtonBigKing) ;

        Button botonAñadir = (Button) v.findViewById(R.id.buttonAñadirFinal);

        
        
        
        
        
        botonAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1 ; i++) {
                    if (radioButtonWopper.isSelected()){
                        precioTotalFinal =+ precioWopper;
                        numeroDeProductos = numeroDeProductos+1;
                    } else if (radioButtonBigKing.isSelected()){
                        precioTotalFinal =+ precioBigKing;
                        numeroDeProductos = numeroDeProductos+1;
                    } else if (radioButtonLongChicken.isSelected()){
                        precioTotalFinal =+ precioLongChicken;
                        numeroDeProductos = numeroDeProductos+1;
                    } else if (radioButtonBacon.isSelected()){
                        precioTotalFinal =+ precioBacon;
                        numeroDeProductos = numeroDeProductos+1;
                    } else {
                        precioTotalFinal = 0;
                    }
                    
                    setPrecioTotalFinal(precioTotalFinal);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductos + "Productos  : " + precioTotalFinal, Toast.LENGTH_SHORT).show();

                }
            }
        });
        
        return v;
    }

    
    
    public double getPrecioTotalFinal() {
        return precioTotalFinal;
    }

    public void setPrecioTotalFinal(double precioTotalFinal) {
        this.precioTotalFinal = precioTotalFinal;
    }
    
}
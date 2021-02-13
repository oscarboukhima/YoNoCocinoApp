package com.example.yonococinoapp.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yonococinoapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link carritoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class carritoFragment extends Fragment {





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public carritoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment carritoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static carritoFragment newInstance(String param1, String param2) {
        carritoFragment fragment = new carritoFragment();
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
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v =  inflater.inflate(R.layout.fragment_carrito, container, false);


        BurguerKing bk = new BurguerKing();
        System.out.println(bk.getPrecioTotalFinal());
        final Bundle bundle = this.getArguments();
        //final Bundle bundle2 = this.getArguments();


        final String precioFinalProducto = bundle.getString("key");
        //final String tiempoDeEsperaFinal =  bundle2.getString("TiE");




          TextView totalAPagar = (TextView) v.findViewById(R.id.textViewTotal);
         // TextView tiempoDeEspera = (TextView) v.findViewById(R.id.textViewTiempoEspera);

         if (totalAPagar == null){
             totalAPagar.setText("0 €");
         } else {
             totalAPagar.setText(precioFinalProducto);

         }

        //if (tiempoDeEspera == null){
        //            tiempoDeEspera.setText(" ");
        //        } else {
        //            tiempoDeEspera.setText(tiempoDeEsperaFinal);
        //        }

     return v;
    }
}
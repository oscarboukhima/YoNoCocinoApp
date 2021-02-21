package com.example.yonococinoapp.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yonococinoapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Goiko#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Goiko extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    final double precioInicialCienMon = 0;

    double precioTotalFinalGoiko = 0;
    double precioProductoGoiko1 = 15.40 ;
    double precioProductoGoiko2 = 11.90 ;
    double precioProductoGoiko3 = 8.9 ;
    double precioProductoGoiko4 = 11.9 ;
    String tiempoDeEsperaGoiko;
    String conjuntoPedidoGoiko;
    String totalProductosPedidosGoiko ="";

    public Goiko() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Goiko.
     */
    // TODO: Rename and change types and number of parameters
    public static Goiko newInstance(String param1, String param2) {
        Goiko fragment = new Goiko();
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
        final View v =  inflater.inflate(R.layout.fragment_goiko, container, false);

        final RadioButton radioGoiko1 = (RadioButton) v.findViewById(R.id.radioButtonGoiko1) ;
        final RadioButton radioGoiko2 = (RadioButton) v.findViewById(R.id.radioButtonGoiko2) ;
        final RadioButton radioGoiko3 = (RadioButton) v.findViewById(R.id.radioButtonGoiko3) ;
        final RadioButton radioGoiko4 = (RadioButton) v.findViewById(R.id.radioButtonGoiko4) ;

        final TextView tvGoikoProducto1 = (TextView) v.findViewById(R.id.textViewGoikoProducto1);
        final TextView tvGoikoProductos2 = (TextView) v.findViewById(R.id.textViewGoikoProducto2);
        final TextView tvGoikoProducto3 = (TextView) v.findViewById(R.id.textViewGoikoProducto3);
        final TextView tvGoikoProducto4 = (TextView) v.findViewById(R.id.textViewGoikoProducto4);


        Button botonAñadirGoiko = (Button) v.findViewById(R.id.buttonAñadirFinalGoiko);


        botonAñadirGoiko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1 ; i++) {
                    precioTotalFinalGoiko =0;
                    int numeroDeProductosGoiko = 0;

                    if (radioGoiko1.isChecked()){
                        precioTotalFinalGoiko = precioTotalFinalGoiko + precioProductoGoiko1;
                        numeroDeProductosGoiko = numeroDeProductosGoiko+1;
                        totalProductosPedidosGoiko = " Kevin Goster";
                    }
                    if (radioGoiko2.isChecked()){
                        precioTotalFinalGoiko = precioTotalFinalGoiko + precioProductoGoiko2;
                        numeroDeProductosGoiko = numeroDeProductosGoiko+1;
                        totalProductosPedidosGoiko = totalProductosPedidosGoiko + " \n Pigma Burger ";
                    }
                    if (radioGoiko3.isChecked()){
                        precioTotalFinalGoiko = precioTotalFinalGoiko + precioProductoGoiko3;
                        numeroDeProductosGoiko = numeroDeProductosGoiko+1;
                        totalProductosPedidosGoiko = totalProductosPedidosGoiko + " \n Chrispy Wings ";
                    }
                    if (radioGoiko4.isChecked()){
                        precioTotalFinalGoiko = precioTotalFinalGoiko + precioProductoGoiko4;
                        numeroDeProductosGoiko = numeroDeProductosGoiko+1;
                        totalProductosPedidosGoiko = totalProductosPedidosGoiko + " \n Cangrebuguer  ";
                    }



                    setPrecioTotalFinalGoiko(precioTotalFinalGoiko);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductosGoiko + "Productos  : " + precioTotalFinalGoiko, Toast.LENGTH_SHORT).show();

                    switch(numeroDeProductosGoiko) {
                        case 1:
                            tiempoDeEsperaGoiko = "30 MINUTOS";
                            setTiempoDeEsperaGoiko(tiempoDeEsperaGoiko);
                            conjuntoPedidoGoiko = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEsperaGoiko = "45 MINUTOS";
                            setTiempoDeEsperaGoiko(tiempoDeEsperaGoiko);
                            conjuntoPedidoGoiko = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEsperaGoiko = "50 MINUTOS";
                            setTiempoDeEsperaGoiko(tiempoDeEsperaGoiko);
                            conjuntoPedidoGoiko = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEsperaGoiko = "1 HORA Y 10 MINUTOS";
                            conjuntoPedidoGoiko = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEsperaGoiko(tiempoDeEsperaGoiko);
                            break;
                        default:
                            tiempoDeEsperaGoiko = "0";
                            setTiempoDeEsperaGoiko(tiempoDeEsperaGoiko);
                    }

                    radioGoiko1.setChecked(false);
                    radioGoiko2.setChecked(false);
                    radioGoiko3.setChecked(false);
                    radioGoiko4.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinalGoiko()));
                    bundle.putString("key2", getTiempoDeEsperaGoiko());
                    bundle.putString("key3", getTotalProductosPedidosGoiko());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :"+ getPrecioTotalFinalGoiko());
            }
        });



        return v;
    }

    public String getTotalProductosPedidosGoiko() {
        return totalProductosPedidosGoiko;

    }

    public void setTotalProductosPedidosGoiko(String totalProductosPedidosGoiko) {
        this.totalProductosPedidosGoiko = totalProductosPedidosGoiko;
    }

    public double getPrecioTotalFinalGoiko() {

        return precioTotalFinalGoiko;

    }

    public  void setPrecioTotalFinalGoiko(double precioTotalFinalGoiko) {
        this.precioTotalFinalGoiko = precioTotalFinalGoiko;
        System.out.println(precioTotalFinalGoiko);
    }


    public String getTiempoDeEsperaGoiko() {
        return tiempoDeEsperaGoiko;
    }

    public void setTiempoDeEsperaGoiko(String tiempoDeEsperaGoiko) {
        this.tiempoDeEsperaGoiko = tiempoDeEsperaGoiko;
    }
}
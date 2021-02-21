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



    double precioTotalFinal = 0;
    double precioWopper = 7.99 ;
    double precioBigKing = 6.99;
    double precioLongChicken = 5.99;
    double precioBacon = 6.99;
    String tiempoDeEspera ;
    String conjuntoPedido;
    String totalProductosPedidos ="";
    int unNumero = 100;


     
    
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

        final TextView textViewWopper = (TextView) v.findViewById(R.id.textViewWopper);
        final TextView textViewBacon = (TextView) v.findViewById(R.id.textViewBacon);
        final TextView textViewLongChicken = (TextView) v.findViewById(R.id.textView);
        final TextView textViewBigKing = (TextView) v.findViewById(R.id.textViewBigKing);





        Button botonAñadir = (Button) v.findViewById(R.id.buttonAñadirFinal);

        
        botonAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1 ; i++) {
                    precioTotalFinal =0;
                    int numeroDeProductos = 0;

                    if (radioButtonWopper.isChecked()){
                        precioTotalFinal = precioTotalFinal +precioWopper;
                        numeroDeProductos = numeroDeProductos+1;
                        totalProductosPedidos = " Hamburguesa Wopper ";
                    }
                    if (radioButtonBigKing.isChecked()){
                        precioTotalFinal =precioTotalFinal+ precioBigKing;
                        numeroDeProductos = numeroDeProductos+1;
                        totalProductosPedidos = totalProductosPedidos + " \n Hamburguesa Big King ";
                    }
                    if (radioButtonLongChicken.isChecked()){
                        precioTotalFinal =precioTotalFinal+ precioLongChicken;
                        numeroDeProductos = numeroDeProductos+1;
                        totalProductosPedidos = totalProductosPedidos + " \n Hamburguesa Long Chicken ";
                    }
                    if (radioButtonBacon.isChecked()){
                        precioTotalFinal = precioTotalFinal+ precioBacon;
                        numeroDeProductos = numeroDeProductos+1;
                        totalProductosPedidos = totalProductosPedidos + " \n Hamburguesa Bacon ";
                    }



                    setPrecioTotalFinal(precioTotalFinal);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductos + "Productos  : " + precioTotalFinal, Toast.LENGTH_SHORT).show();

                    switch(numeroDeProductos) {
                        case 1:
                            tiempoDeEspera = "30 MINUTOS";
                            setTiempoDeEspera(tiempoDeEspera);
                            conjuntoPedido = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEspera = "45 MINUTOS";
                            setTiempoDeEspera(tiempoDeEspera);
                            conjuntoPedido = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEspera = "50 MINUTOS";
                            setTiempoDeEspera(tiempoDeEspera);
                            conjuntoPedido = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEspera = "1 HORA Y 10 MINUTOS";
                            conjuntoPedido = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEspera(tiempoDeEspera);
                            break;
                        default:
                            tiempoDeEspera = "0";
                            setTiempoDeEspera(tiempoDeEspera);
                    }




                    radioButtonBacon.setChecked(false);
                    radioButtonBigKing.setChecked(false);
                    radioButtonLongChicken.setChecked(false);
                    radioButtonWopper.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinal()));
                    bundle.putString("key2",getTiempoDeEspera());
                    bundle.putString("key3",getTotalProductosPedidos());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :"+getPrecioTotalFinal());
            }
        });
        
        return v;
    }


    public String getTotalProductosPedidos() {
        return totalProductosPedidos;

    }

    public void setTotalProductosPedidos(String totalProductosPedidos) {
        this.totalProductosPedidos = totalProductosPedidos;
    }

    public double  getPrecioTotalFinal() {

        return precioTotalFinal;

    }

    public  void setPrecioTotalFinal(  double precioTotalFinal) {
        this.precioTotalFinal = precioTotalFinal;
        System.out.println(precioTotalFinal);
    }


    public String getTiempoDeEspera() {
        return tiempoDeEspera;
    }

    public void setTiempoDeEspera(String tiempoDeEspera) {
        this.tiempoDeEspera = tiempoDeEspera;
    }




}
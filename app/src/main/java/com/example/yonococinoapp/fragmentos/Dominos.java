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
 * Use the {@link Dominos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dominos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    final double precioInicialDominos = 0;

    double precioTotalFinalDominos = 0;
    double precioProductoDominos1 = 19.90 ;
    double precioProductoDominos2 = 4.5 ;
    double precioProductoDominos3 = 12.95 ;
    double precioProductoDominos4 = 15.95 ;
    String tiempoDeEsperaDominos;
    String conjuntoPedidoDominos;
    String totalProductosPedidosDominos ="";

    public Dominos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dominos.
     */
    // TODO: Rename and change types and number of parameters
    public static Dominos newInstance(String param1, String param2) {
        Dominos fragment = new Dominos();
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
        final View v =  inflater.inflate(R.layout.fragment_dominos, container, false);

        final RadioButton radioDominos1 = (RadioButton) v.findViewById(R.id.radioButtonDominos1) ;
        final RadioButton radioDominos2 = (RadioButton) v.findViewById(R.id.radioButtonDominos2) ;
        final RadioButton radioDominos3 = (RadioButton) v.findViewById(R.id.radioButtonDominos3) ;
        final RadioButton radioDominos4 = (RadioButton) v.findViewById(R.id.radioButtonDominos4) ;

        final TextView tvDominosP1 = (TextView) v.findViewById(R.id.textViewDominosProducto1);
        final TextView tvDominosP2 = (TextView) v.findViewById(R.id.textViewDominosProducto2);
        final TextView tvDominosP3 = (TextView) v.findViewById(R.id.textViewDominosProducto3);
        final TextView tvDominosP4 = (TextView) v.findViewById(R.id.textViewDominosProducto4);


        Button botonAñadirDominos = (Button) v.findViewById(R.id.buttonAñadirFinalDominos);


        botonAñadirDominos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1 ; i++) {
                    precioTotalFinalDominos =0;
                    int numeroDeProductosDominos = 0;

                    if (radioDominos1.isChecked()){
                        precioTotalFinalDominos = precioTotalFinalDominos +precioProductoDominos1;
                        numeroDeProductosDominos = numeroDeProductosDominos+1;
                        totalProductosPedidosDominos = " Patatas Chedar Bacon ";
                    }
                    if (radioDominos2.isChecked()){
                        precioTotalFinalDominos = precioTotalFinalDominos + precioProductoDominos2;
                        numeroDeProductosDominos = numeroDeProductosDominos+1;
                        totalProductosPedidosDominos = totalProductosPedidosDominos + " \n Palomitas de Queso ";
                    }
                    if (radioDominos3.isChecked()){
                        precioTotalFinalDominos = precioTotalFinalDominos + precioProductoDominos3;
                        numeroDeProductosDominos = numeroDeProductosDominos+1;
                        totalProductosPedidosDominos = totalProductosPedidosDominos + " \n Montadito Kebbab ";
                    }
                    if (radioDominos4.isChecked()){
                        precioTotalFinalDominos = precioTotalFinalDominos + precioProductoDominos4;
                        numeroDeProductosDominos = numeroDeProductosDominos+1;
                        totalProductosPedidosDominos = totalProductosPedidosDominos + " \n Nachos  ";
                    }



                    setPrecioTotalFinalDominos(precioTotalFinalDominos);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductosDominos + "Productos  : " + precioTotalFinalDominos, Toast.LENGTH_SHORT).show();

                    switch(numeroDeProductosDominos) {
                        case 1:
                            tiempoDeEsperaDominos = "30 MINUTOS";
                            setTiempoDeEsperaDominos(tiempoDeEsperaDominos);
                            conjuntoPedidoDominos = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEsperaDominos = "45 MINUTOS";
                            setTiempoDeEsperaDominos(tiempoDeEsperaDominos);
                            conjuntoPedidoDominos = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEsperaDominos = "50 MINUTOS";
                            setTiempoDeEsperaDominos(tiempoDeEsperaDominos);
                            conjuntoPedidoDominos = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEsperaDominos = "1 HORA Y 10 MINUTOS";
                            conjuntoPedidoDominos = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEsperaDominos(tiempoDeEsperaDominos);
                            break;
                        default:
                            tiempoDeEsperaDominos = "0";
                            setTiempoDeEsperaDominos(tiempoDeEsperaDominos);
                    }

                    radioDominos1.setChecked(false);
                    radioDominos2.setChecked(false);
                    radioDominos3.setChecked(false);
                    radioDominos4.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinalDominos()));
                    bundle.putString("key2", getTiempoDeEsperaDominos());
                    bundle.putString("key3", getTotalProductosPedidosDominos());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :"+ getPrecioTotalFinalDominos());
            }
        });



        return v;
    }

    public String getTotalProductosPedidosDominos() {
        return totalProductosPedidosDominos;

    }

    public void setTotalProductosPedidosDominos(String totalProductosPedidosDominos) {
        this.totalProductosPedidosDominos = totalProductosPedidosDominos;
    }

    public double getPrecioTotalFinalDominos() {

        return precioTotalFinalDominos;

    }

    public  void setPrecioTotalFinalDominos(double precioTotalFinalDominos) {
        this.precioTotalFinalDominos = precioTotalFinalDominos;
        System.out.println(precioTotalFinalDominos);
    }


    public String getTiempoDeEsperaDominos() {
        return tiempoDeEsperaDominos;
    }

    public void setTiempoDeEsperaDominos(String tiempoDeEsperaDominos) {
        this.tiempoDeEsperaDominos = tiempoDeEsperaDominos;
    }
}
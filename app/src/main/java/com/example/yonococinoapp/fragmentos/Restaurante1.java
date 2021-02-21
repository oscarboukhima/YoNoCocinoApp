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
 * Use the {@link Restaurante1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Restaurante1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Restaurante1() {
        // Required empty public constructor
    }

    double precioTotalFinalRes1 = 0;
    double precioProductoRes1 = 21.50;
    double precioProductoRes2 = 14.50;
    double precioProductoRes3 = 12.00;
    double precioProductoRes4 = 9.50;
    String tiempoDeEsperaRes1;
    String conjuntoPedidoRes1;
    String totalProductosPedidosRes1 = "";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Restaurante1.
     */
    // TODO: Rename and change types and number of parameters
    public static Restaurante1 newInstance(String param1, String param2) {
        Restaurante1 fragment = new Restaurante1();
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
        final View v = inflater.inflate(R.layout.fragment_restaurante1, container, false);

        final RadioButton radioRes11 = (RadioButton) v.findViewById(R.id.radioButtonRestaurante11);
        final RadioButton radioRes12 = (RadioButton) v.findViewById(R.id.radioButtonRestaurante12);
        final RadioButton radioRes13 = (RadioButton) v.findViewById(R.id.radioButtonRestaurante13);
        final RadioButton radioRes14 = (RadioButton) v.findViewById(R.id.radioButtonRestaurante14);

        final TextView tvRes1Producto1 = (TextView) v.findViewById(R.id.tvRestaurante1Producto1);
        final TextView tvRes1Producto2 = (TextView) v.findViewById(R.id.tvRestaurante1Producto2);
        final TextView tvRes1Producto3 = (TextView) v.findViewById(R.id.tvRestaurante1Producto3);
        final TextView tvRes1Producto4 = (TextView) v.findViewById(R.id.tvRestaurante1Producto4);


        Button botonAñadirRes1 = (Button) v.findViewById(R.id.buttonAñadirFinalRes1);


        botonAñadirRes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1; i++) {
                    precioTotalFinalRes1 = 0;
                    int numeroDeProductosRes1 = 0;

                    if (radioRes11.isChecked()) {
                        precioTotalFinalRes1 = precioTotalFinalRes1 + precioProductoRes1;
                        numeroDeProductosRes1 = numeroDeProductosRes1 + 1;
                        totalProductosPedidosRes1 = " Entrecot de carne de tercena de la Sierra de Guadarrama ";
                    }
                    if (radioRes12.isChecked()) {
                        precioTotalFinalRes1 = precioTotalFinalRes1 + precioProductoRes2;
                        numeroDeProductosRes1 = numeroDeProductosRes1 + 1;
                        totalProductosPedidosRes1 = totalProductosPedidosRes1 + " \n Costillar a la brasa con salsa BBQ ";
                    }
                    if (radioRes13.isChecked()) {
                        precioTotalFinalRes1 = precioTotalFinalRes1 + precioProductoRes3;
                        numeroDeProductosRes1 = numeroDeProductosRes1 + 1;
                        totalProductosPedidosRes1 = totalProductosPedidosRes1 + " \n Pollito picantón a la brasa";
                    }
                    if (radioRes14.isChecked()) {
                        precioTotalFinalRes1 = precioTotalFinalRes1 + precioProductoRes4;
                        numeroDeProductosRes1 = numeroDeProductosRes1 + 1;
                        totalProductosPedidosRes1 = totalProductosPedidosRes1 + " \n Brocheta de ternera ";
                    }


                    setPrecioTotalFinalRes1(precioTotalFinalRes1);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductosRes1 + "Productos  : " + precioTotalFinalRes1, Toast.LENGTH_SHORT).show();

                    switch (numeroDeProductosRes1) {
                        case 1:
                            tiempoDeEsperaRes1 = "30 MINUTOS";
                            setTiempoDeEsperaRes1(tiempoDeEsperaRes1);
                            conjuntoPedidoRes1 = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEsperaRes1 = "45 MINUTOS";
                            setTiempoDeEsperaRes1(tiempoDeEsperaRes1);
                            conjuntoPedidoRes1 = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEsperaRes1 = "50 MINUTOS";
                            setTiempoDeEsperaRes1(tiempoDeEsperaRes1);
                            conjuntoPedidoRes1 = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEsperaRes1 = "1 HORA Y 10 MINUTOS";
                            conjuntoPedidoRes1 = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEsperaRes1(tiempoDeEsperaRes1);
                            break;
                        default:
                            tiempoDeEsperaRes1 = "0";
                            setTiempoDeEsperaRes1(tiempoDeEsperaRes1);
                    }

                    radioRes11.setChecked(false);
                    radioRes12.setChecked(false);
                    radioRes13.setChecked(false);
                    radioRes14.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinalRes1()));
                    bundle.putString("key2", getTiempoDeEsperaRes1());
                    bundle.putString("key3", getTotalProductosPedidosRes1());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :" + getPrecioTotalFinalRes1());
            }
        });


        return v;
    }
    public String getTotalProductosPedidosRes1() {
        return totalProductosPedidosRes1;

    }

    public void setTotalProductosPedidosRes1(String totalProductosPedidosRes1) {
        this.totalProductosPedidosRes1 = totalProductosPedidosRes1;
    }

    public double getPrecioTotalFinalRes1() {

        return precioTotalFinalRes1;

    }

    public void setPrecioTotalFinalRes1(double precioTotalFinalRes1) {
        this.precioTotalFinalRes1 = precioTotalFinalRes1;
        System.out.println(precioTotalFinalRes1);
    }


    public String getTiempoDeEsperaRes1() {
        return tiempoDeEsperaRes1;
    }

    public void setTiempoDeEsperaRes1(String tiempoDeEsperaRes1) {
        this.tiempoDeEsperaRes1 = tiempoDeEsperaRes1;
    }
}
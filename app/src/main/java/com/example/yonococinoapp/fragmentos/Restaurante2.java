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
 * Use the {@link Restaurante2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Restaurante2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Restaurante2() {
        // Required empty public constructor
    }

    double precioTotalFinalRes2 = 0;
    double precioProductoRes21 = 10.90;
    double precioProductoRes22 = 12.95;
    double precioProductoRes23 = 11.90;
    double precioProductoRes24 = 14.95;
    String tiempoDeEsperaRes2;
    String conjuntoPedidoRes2;
    String totalProductosPedidosRes2 = "";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Restaurante2.
     */
    // TODO: Rename and change types and number of parameters
    public static Restaurante2 newInstance(String param1, String param2) {
        Restaurante2 fragment = new Restaurante2();
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
        final View v = inflater.inflate(R.layout.fragment_restaurante2, container, false);

        final RadioButton radioRes21 = (RadioButton) v.findViewById(R.id.radioButtonRestaurante21);
        final RadioButton radioRes22 = (RadioButton) v.findViewById(R.id.radioButtonRestaurante22);
        final RadioButton radioRes23 = (RadioButton) v.findViewById(R.id.radioButtonRestaurante23);
        final RadioButton radioRes24 = (RadioButton) v.findViewById(R.id.radioButtonRestaurante24);

        final TextView tvRes2Producto1 = (TextView) v.findViewById(R.id.tvRestaurante2Producto1);
        final TextView tvRes2Producto2 = (TextView) v.findViewById(R.id.tvRestaurante2Producto2);
        final TextView tvRes2Producto3 = (TextView) v.findViewById(R.id.tvRestaurante2Producto3);
        final TextView tvRes2Producto4 = (TextView) v.findViewById(R.id.tvRestaurante2Producto4);


        Button botonAñadirRes2 = (Button) v.findViewById(R.id.buttonAñadirFinalRes2);


        botonAñadirRes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1; i++) {
                    precioTotalFinalRes2 = 0;
                    int numeroDeProductosRes2 = 0;

                    if (radioRes21.isChecked()) {
                        precioTotalFinalRes2 = precioTotalFinalRes2 + precioProductoRes21;
                        numeroDeProductosRes2 = numeroDeProductosRes2 + 1;
                        totalProductosPedidosRes2 = " Fetuccini alla Putanesca ";
                    }
                    if (radioRes22.isChecked()) {
                        precioTotalFinalRes2 = precioTotalFinalRes2 + precioProductoRes22;
                        numeroDeProductosRes2 = numeroDeProductosRes2 + 1;
                        totalProductosPedidosRes2 = totalProductosPedidosRes2 + " \n Lasagna Bolognesa ";
                    }
                    if (radioRes23.isChecked()) {
                        precioTotalFinalRes2 = precioTotalFinalRes2 + precioProductoRes23;
                        numeroDeProductosRes2 = numeroDeProductosRes2 + 1;
                        totalProductosPedidosRes2 = totalProductosPedidosRes2 + " \n Macarrones Mari e Monti";
                    }
                    if (radioRes24.isChecked()) {
                        precioTotalFinalRes2 = precioTotalFinalRes2 + precioProductoRes24;
                        numeroDeProductosRes2 = numeroDeProductosRes2 + 1;
                        totalProductosPedidosRes2 = totalProductosPedidosRes2 + " \n Penne rigate all'arrabiata ";
                    }


                    setPrecioTotalFinalRes2(precioTotalFinalRes2);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductosRes2 + "Productos  : " + precioTotalFinalRes2, Toast.LENGTH_SHORT).show();

                    switch (numeroDeProductosRes2) {
                        case 1:
                            tiempoDeEsperaRes2 = "30 MINUTOS";
                            setTiempoDeEsperaRes2(tiempoDeEsperaRes2);
                            conjuntoPedidoRes2 = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEsperaRes2 = "45 MINUTOS";
                            setTiempoDeEsperaRes2(tiempoDeEsperaRes2);
                            conjuntoPedidoRes2 = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEsperaRes2 = "50 MINUTOS";
                            setTiempoDeEsperaRes2(tiempoDeEsperaRes2);
                            conjuntoPedidoRes2 = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEsperaRes2 = "1 HORA Y 10 MINUTOS";
                            conjuntoPedidoRes2 = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEsperaRes2(tiempoDeEsperaRes2);
                            break;
                        default:
                            tiempoDeEsperaRes2 = "0";
                            setTiempoDeEsperaRes2(tiempoDeEsperaRes2);
                    }

                    radioRes21.setChecked(false);
                    radioRes22.setChecked(false);
                    radioRes23.setChecked(false);
                    radioRes24.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinalRes2()));
                    bundle.putString("key2", getTiempoDeEsperaRes2());
                    bundle.putString("key3", getTotalProductosPedidosRes2());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :" + getPrecioTotalFinalRes2());
            }
        });


        return v;
    }

    public String getTotalProductosPedidosRes2() {
        return totalProductosPedidosRes2;

    }

    public void setTotalProductosPedidosRes2(String totalProductosPedidosRes2) {
        this.totalProductosPedidosRes2 = totalProductosPedidosRes2;
    }

    public double getPrecioTotalFinalRes2() {

        return precioTotalFinalRes2;

    }

    public void setPrecioTotalFinalRes2(double precioTotalFinalRes2) {
        this.precioTotalFinalRes2 = precioTotalFinalRes2;
        System.out.println(precioTotalFinalRes2);
    }


    public String getTiempoDeEsperaRes2() {
        return tiempoDeEsperaRes2;
    }

    public void setTiempoDeEsperaRes2(String tiempoDeEsperaRes2) {
        this.tiempoDeEsperaRes2 = tiempoDeEsperaRes2;
    }
}
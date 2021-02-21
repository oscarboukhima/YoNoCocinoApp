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
 * Use the {@link Vips#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Vips extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Vips() {
        // Required empty public constructor
    }

    double precioTotalFinalVips = 0;
    double precioProductoVips1 = 17.95;
    double precioProductoVips2 = 12.95;
    double precioProductoVips3 = 6.50;
    double precioProductoVips4 = 9.50;
    String tiempoDeEsperaVips;
    String conjuntoPedidoVips;
    String totalProductosPedidosVips = "";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Vips.
     */
    // TODO: Rename and change types and number of parameters
    public static Vips newInstance(String param1, String param2) {
        Vips fragment = new Vips();
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
        final View v = inflater.inflate(R.layout.fragment_vips, container, false);

        final RadioButton radioVips1 = (RadioButton) v.findViewById(R.id.radioButtonVips1);
        final RadioButton radioVips2 = (RadioButton) v.findViewById(R.id.radioButtonVips2);
        final RadioButton radioVips3 = (RadioButton) v.findViewById(R.id.radioButtonVips3);
        final RadioButton radioVips4 = (RadioButton) v.findViewById(R.id.radioButtonVips4);

        final TextView tvVipsProducto1 = (TextView) v.findViewById(R.id.tvRestaurante2Producto1);
        final TextView tvVipsProducto2 = (TextView) v.findViewById(R.id.tvRestaurante2Producto2);
        final TextView tvVipsProducto3 = (TextView) v.findViewById(R.id.tvRestaurante2Producto3);
        final TextView tvVipsProducto4 = (TextView) v.findViewById(R.id.tvRestaurante2Producto4);


        Button botonAñadirVips = (Button) v.findViewById(R.id.buttonAñadirFinalVips);


        botonAñadirVips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1; i++) {
                    precioTotalFinalVips = 0;
                    int numeroDeProductosVips = 0;

                    if (radioVips1.isChecked()) {
                        precioTotalFinalVips = precioTotalFinalVips + precioProductoVips1;
                        numeroDeProductosVips = numeroDeProductosVips + 1;
                        totalProductosPedidosVips = " Costillas BBQ Vips ";
                    }
                    if (radioVips2.isChecked()) {
                        precioTotalFinalVips = precioTotalFinalVips + precioProductoVips2;
                        numeroDeProductosVips = numeroDeProductosVips + 1;
                        totalProductosPedidosVips = totalProductosPedidosVips + " \n Pechuga Villaroy ";
                    }
                    if (radioVips3.isChecked()) {
                        precioTotalFinalVips = precioTotalFinalVips + precioProductoVips3;
                        numeroDeProductosVips = numeroDeProductosVips + 1;
                        totalProductosPedidosVips = totalProductosPedidosVips + " \n Tortitas Bombón";
                    }
                    if (radioVips4.isChecked()) {
                        precioTotalFinalVips = precioTotalFinalVips + precioProductoVips4;
                        numeroDeProductosVips = numeroDeProductosVips + 1;
                        totalProductosPedidosVips = totalProductosPedidosVips + " \n Nachos Tex-Mex ";
                    }


                    setPrecioTotalFinalVips(precioTotalFinalVips);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductosVips + "Productos  : " + precioTotalFinalVips, Toast.LENGTH_SHORT).show();

                    switch (numeroDeProductosVips) {
                        case 1:
                            tiempoDeEsperaVips = "30 MINUTOS";
                            setTiempoDeEsperaVips(tiempoDeEsperaVips);
                            conjuntoPedidoVips = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEsperaVips = "45 MINUTOS";
                            setTiempoDeEsperaVips(tiempoDeEsperaVips);
                            conjuntoPedidoVips = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEsperaVips = "50 MINUTOS";
                            setTiempoDeEsperaVips(tiempoDeEsperaVips);
                            conjuntoPedidoVips = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEsperaVips = "1 HORA Y 10 MINUTOS";
                            conjuntoPedidoVips = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEsperaVips(tiempoDeEsperaVips);
                            break;
                        default:
                            tiempoDeEsperaVips = "0";
                            setTiempoDeEsperaVips(tiempoDeEsperaVips);
                    }

                    radioVips1.setChecked(false);
                    radioVips2.setChecked(false);
                    radioVips3.setChecked(false);
                    radioVips4.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinalVips()));
                    bundle.putString("key2", getTiempoDeEsperaVips());
                    bundle.putString("key3", getTotalProductosPedidosVips());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :" + getPrecioTotalFinalVips());
            }
        });


        return v;
    }

    public String getTotalProductosPedidosVips() {
        return totalProductosPedidosVips;

    }

    public void setTotalProductosPedidosVips(String totalProductosPedidosVips) {
        this.totalProductosPedidosVips = totalProductosPedidosVips;
    }

    public double getPrecioTotalFinalVips() {

        return precioTotalFinalVips;

    }

    public void setPrecioTotalFinalVips(double precioTotalFinalVips) {
        this.precioTotalFinalVips = precioTotalFinalVips;
        System.out.println(precioTotalFinalVips);
    }


    public String getTiempoDeEsperaVips() {
        return tiempoDeEsperaVips;
    }

    public void setTiempoDeEsperaVips(String tiempoDeEsperaVips) {
        this.tiempoDeEsperaVips = tiempoDeEsperaVips;
    }
}
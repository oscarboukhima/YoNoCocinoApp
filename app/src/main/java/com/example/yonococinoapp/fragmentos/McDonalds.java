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
 * Use the {@link McDonalds#newInstance} factory method to
 * create an instance of this fragment.
 */
public class McDonalds extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public McDonalds() {
        // Required empty public constructor
    }

    double precioTotalFinalMcDnlds = 0;
    double precioProductoMcDnlds1 = 7.60;
    double precioProductoMcDnlds2 = 5.50;
    double precioProductoMcDnlds3 = 5.60;
    double precioProductoMcDnlds4 = 7.20;
    String tiempoDeEsperaMcDnlds;
    String conjuntoPedidoMcDnlds;
    String totalProductosPedidosMcDnlds = "";


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment McDonalds.
     */
    // TODO: Rename and change types and number of parameters
    public static McDonalds newInstance(String param1, String param2) {
        McDonalds fragment = new McDonalds();
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
        final View v = inflater.inflate(R.layout.fragment_mc_donalds, container, false);

        final RadioButton radioMcdnlds1 = (RadioButton) v.findViewById(R.id.radioButtonMcDonalds1);
        final RadioButton radioMcdnlds2 = (RadioButton) v.findViewById(R.id.radioButtonMcDonalds2);
        final RadioButton radioMcdnlds3 = (RadioButton) v.findViewById(R.id.radioButtonMcDonalds3);
        final RadioButton radioMcdnlds4 = (RadioButton) v.findViewById(R.id.radioButtonMcDonalds4);

        final TextView tvMcdnldsProducto1 = (TextView) v.findViewById(R.id.tvMcDonaldsProducto1);
        final TextView tvMcdnldsProducto2 = (TextView) v.findViewById(R.id.tvMcDonaldsProducto2);
        final TextView tvMcdnldsProducto3 = (TextView) v.findViewById(R.id.tvMcDonaldsProducto3);
        final TextView tvMcdnldsProducto4 = (TextView) v.findViewById(R.id.tvMcDonaldsProducto4);


        Button botonAñadirMcdnlds = (Button) v.findViewById(R.id.buttonAñadirFinalMcdnlds);


        botonAñadirMcdnlds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1; i++) {
                    precioTotalFinalMcDnlds = 0;
                    int numeroDeProductosCienMon = 0;

                    if (radioMcdnlds1.isChecked()) {
                        precioTotalFinalMcDnlds = precioTotalFinalMcDnlds + precioProductoMcDnlds1;
                        numeroDeProductosCienMon = numeroDeProductosCienMon + 1;
                        totalProductosPedidosMcDnlds = " Signature Queso de Cabra ";
                    }
                    if (radioMcdnlds2.isChecked()) {
                        precioTotalFinalMcDnlds = precioTotalFinalMcDnlds + precioProductoMcDnlds2;
                        numeroDeProductosCienMon = numeroDeProductosCienMon + 1;
                        totalProductosPedidosMcDnlds = totalProductosPedidosMcDnlds + " \n CBO ";
                    }
                    if (radioMcdnlds3.isChecked()) {
                        precioTotalFinalMcDnlds = precioTotalFinalMcDnlds + precioProductoMcDnlds3;
                        numeroDeProductosCienMon = numeroDeProductosCienMon + 1;
                        totalProductosPedidosMcDnlds = totalProductosPedidosMcDnlds + " \n Mc Wrap Chicken Bacon";
                    }
                    if (radioMcdnlds4.isChecked()) {
                        precioTotalFinalMcDnlds = precioTotalFinalMcDnlds + precioProductoMcDnlds4;
                        numeroDeProductosCienMon = numeroDeProductosCienMon + 1;
                        totalProductosPedidosMcDnlds = totalProductosPedidosMcDnlds + " \n Grand McExtreme Double Bacon ";
                    }


                    setPrecioTotalFinalMcDnlds(precioTotalFinalMcDnlds);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductosCienMon + "Productos  : " + precioTotalFinalMcDnlds, Toast.LENGTH_SHORT).show();

                    switch (numeroDeProductosCienMon) {
                        case 1:
                            tiempoDeEsperaMcDnlds = "30 MINUTOS";
                            setTiempoDeEsperaMcDnlds(tiempoDeEsperaMcDnlds);
                            conjuntoPedidoMcDnlds = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEsperaMcDnlds = "45 MINUTOS";
                            setTiempoDeEsperaMcDnlds(tiempoDeEsperaMcDnlds);
                            conjuntoPedidoMcDnlds = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEsperaMcDnlds = "50 MINUTOS";
                            setTiempoDeEsperaMcDnlds(tiempoDeEsperaMcDnlds);
                            conjuntoPedidoMcDnlds = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEsperaMcDnlds = "1 HORA Y 10 MINUTOS";
                            conjuntoPedidoMcDnlds = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEsperaMcDnlds(tiempoDeEsperaMcDnlds);
                            break;
                        default:
                            tiempoDeEsperaMcDnlds = "0";
                            setTiempoDeEsperaMcDnlds(tiempoDeEsperaMcDnlds);
                    }

                    radioMcdnlds1.setChecked(false);
                    radioMcdnlds2.setChecked(false);
                    radioMcdnlds3.setChecked(false);
                    radioMcdnlds4.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinalMcDnlds()));
                    bundle.putString("key2", getTiempoDeEsperaMcDnlds());
                    bundle.putString("key3", getTotalProductosPedidosMcDnlds());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :" + getPrecioTotalFinalMcDnlds());
            }
        });


        return v;
    }

    public String getTotalProductosPedidosMcDnlds() {
        return totalProductosPedidosMcDnlds;

    }

    public void setTotalProductosPedidosMcDnlds(String totalProductosPedidosMcDnlds) {
        this.totalProductosPedidosMcDnlds = totalProductosPedidosMcDnlds;
    }

    public double getPrecioTotalFinalMcDnlds() {

        return precioTotalFinalMcDnlds;

    }

    public void setPrecioTotalFinalMcDnlds(double precioTotalFinalMcDnlds) {
        this.precioTotalFinalMcDnlds = precioTotalFinalMcDnlds;
        System.out.println(precioTotalFinalMcDnlds);
    }


    public String getTiempoDeEsperaMcDnlds() {
        return tiempoDeEsperaMcDnlds;
    }

    public void setTiempoDeEsperaMcDnlds(String tiempoDeEsperaMcDnlds) {
        this.tiempoDeEsperaMcDnlds = tiempoDeEsperaMcDnlds;
    }
}
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
 * Use the {@link CienMon#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CienMon extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CienMon() {
        // Required empty public constructor
    }

    double precioTotalFinalCienMon = 0;
    double precioProductoCienmon1 = 2.0 ;
    double precioProductoCienmon2 = 2.0 ;
    double precioProductoCienmon3 = 1.5 ;
    double precioProductoCienmon4 = 2.0 ;
    String tiempoDeEsperaCienMon;
    String conjuntoPedidoCienMOn;
    String totalProductosPedidosCienMon ="";

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CienMon.
     */
    // TODO: Rename and change types and number of parameters
    public static CienMon newInstance(String param1, String param2) {
        CienMon fragment = new CienMon();
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

        final RadioButton radioCienMon1 = (RadioButton) v.findViewById(R.id.radioButtonCienMon1) ;
        final RadioButton radioCienMon2 = (RadioButton) v.findViewById(R.id.radioButtonCienMon2) ;
        final RadioButton radioCienMon3 = (RadioButton) v.findViewById(R.id.radioButtonCienMon3) ;
        final RadioButton radioCienMon4 = (RadioButton) v.findViewById(R.id.radioButtonCienMon4) ;

        final TextView tvCienMooonProducto1 = (TextView) v.findViewById(R.id.tvCienMonProducto1);
        final TextView tvCienMooonProducto2 = (TextView) v.findViewById(R.id.tvCienMonProducto2);
        final TextView tvCienMooonProducto3 = (TextView) v.findViewById(R.id.tvCienMonProducto3);
        final TextView tvCienMooonProducto4 = (TextView) v.findViewById(R.id.tvCienMonProducto4);


        Button botonAñadirCienMon = (Button) v.findViewById(R.id.buttonAñadirFinalCienMon);


        botonAñadirCienMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1 ; i++) {
                    precioTotalFinalCienMon =0;
                    int numeroDeProductosCienMon = 0;

                    if (radioCienMon1.isChecked()){
                        precioTotalFinalCienMon = precioTotalFinalCienMon +precioProductoCienmon1;
                        numeroDeProductosCienMon = numeroDeProductosCienMon+1;
                        totalProductosPedidosCienMon = " Patatas Chedar Bacon ";
                    }
                    if (radioCienMon2.isChecked()){
                        precioTotalFinalCienMon = precioTotalFinalCienMon + precioProductoCienmon2;
                        numeroDeProductosCienMon = numeroDeProductosCienMon+1;
                        totalProductosPedidosCienMon = totalProductosPedidosCienMon + " \n Palomitas de Queso ";
                    }
                    if (radioCienMon3.isChecked()){
                        precioTotalFinalCienMon = precioTotalFinalCienMon + precioProductoCienmon3;
                        numeroDeProductosCienMon = numeroDeProductosCienMon+1;
                        totalProductosPedidosCienMon = totalProductosPedidosCienMon + " \n Montadito Kebbab ";
                    }
                    if (radioCienMon4.isChecked()){
                        precioTotalFinalCienMon = precioTotalFinalCienMon + precioProductoCienmon4;
                        numeroDeProductosCienMon = numeroDeProductosCienMon+1;
                        totalProductosPedidosCienMon = totalProductosPedidosCienMon + " \n Nachos  ";
                    }



                    setPrecioTotalFinalCienMon(precioTotalFinalCienMon);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductosCienMon + "Productos  : " + precioTotalFinalCienMon, Toast.LENGTH_SHORT).show();

                    switch(numeroDeProductosCienMon) {
                        case 1:
                            tiempoDeEsperaCienMon = "30 MINUTOS";
                            setTiempoDeEsperaCienMon(tiempoDeEsperaCienMon);
                            conjuntoPedidoCienMOn = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEsperaCienMon = "45 MINUTOS";
                            setTiempoDeEsperaCienMon(tiempoDeEsperaCienMon);
                            conjuntoPedidoCienMOn = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEsperaCienMon = "50 MINUTOS";
                            setTiempoDeEsperaCienMon(tiempoDeEsperaCienMon);
                            conjuntoPedidoCienMOn = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEsperaCienMon = "1 HORA Y 10 MINUTOS";
                            conjuntoPedidoCienMOn = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEsperaCienMon(tiempoDeEsperaCienMon);
                            break;
                        default:
                            tiempoDeEsperaCienMon = "0";
                            setTiempoDeEsperaCienMon(tiempoDeEsperaCienMon);
                    }

                    radioCienMon1.setChecked(false);
                    radioCienMon2.setChecked(false);
                    radioCienMon3.setChecked(false);
                    radioCienMon4.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinalCienMon()));
                    bundle.putString("key2", getTiempoDeEsperaCienMon());
                    bundle.putString("key3", getTotalProductosPedidosCienMon());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :"+ getPrecioTotalFinalCienMon());
            }
        });



        return v;
    }

    public String getTotalProductosPedidosCienMon() {
        return totalProductosPedidosCienMon;

    }

    public void setTotalProductosPedidosCienMon(String totalProductosPedidosCienMon) {
        this.totalProductosPedidosCienMon = totalProductosPedidosCienMon;
    }

    public double getPrecioTotalFinalCienMon() {

        return precioTotalFinalCienMon;

    }

    public  void setPrecioTotalFinalCienMon(double precioTotalFinalCienMon) {
        this.precioTotalFinalCienMon = precioTotalFinalCienMon;
        System.out.println(precioTotalFinalCienMon);
    }


    public String getTiempoDeEsperaCienMon() {
        return tiempoDeEsperaCienMon;
    }

    public void setTiempoDeEsperaCienMon(String tiempoDeEsperaCienMon) {
        this.tiempoDeEsperaCienMon = tiempoDeEsperaCienMon;
    }
}
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
 * Use the {@link Foster#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Foster extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    final double precioInicialCienMon = 0;

    double precioTotalFinalFoster = 0;
    double precioProductoFoster1 = 10.35 ;
    double precioProductoFoster2 = 15.15 ;
    double precioProductoFoster3 = 10.95 ;
    double precioProductoFoster4 = 15.95 ;
    String tiempoDeEsperFoster;
    String conjuntoPedidoFoster;
    String totalProductosPedidosFoster ="";

    public Foster() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Foster.
     */
    // TODO: Rename and change types and number of parameters
    public static Foster newInstance(String param1, String param2) {
        Foster fragment = new Foster();
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
        final View v =  inflater.inflate(R.layout.fragment_foster, container, false);

        final RadioButton radioFoster1 = (RadioButton) v.findViewById(R.id.radioButtonFoster1) ;
        final RadioButton radioFoster2 = (RadioButton) v.findViewById(R.id.radioButtonFoster2) ;
        final RadioButton radioFoster3 = (RadioButton) v.findViewById(R.id.radioButtonFoster3) ;
        final RadioButton radioFoster4 = (RadioButton) v.findViewById(R.id.radioButtonFoster4) ;

        final TextView tvFosterProducto1 = (TextView) v.findViewById(R.id.textViewFosterProducto1);
        final TextView tvFosterProducto2 = (TextView) v.findViewById(R.id.textViewFosterProducto2);
        final TextView tvFosterProducto3 = (TextView) v.findViewById(R.id.textViewFosterProducto3);
        final TextView tvFosterProducto4 = (TextView) v.findViewById(R.id.textViewFosterProducto4);


        Button botonAñadirCienMon = (Button) v.findViewById(R.id.buttonAñadirFinalCienMon);


        botonAñadirCienMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1 ; i++) {
                    precioTotalFinalFoster =0;
                    int numeroDeProductosCienMon = 0;

                    if (radioFoster1.isChecked()){
                        precioTotalFinalFoster = precioTotalFinalFoster + precioProductoFoster1;
                        numeroDeProductosCienMon = numeroDeProductosCienMon+1;
                        totalProductosPedidosFoster = " Patatas Chedar Bacon ";
                    }
                    if (radioFoster2.isChecked()){
                        precioTotalFinalFoster = precioTotalFinalFoster + precioProductoFoster2;
                        numeroDeProductosCienMon = numeroDeProductosCienMon+1;
                        totalProductosPedidosFoster = totalProductosPedidosFoster + " \n Palomitas de Queso ";
                    }
                    if (radioFoster3.isChecked()){
                        precioTotalFinalFoster = precioTotalFinalFoster + precioProductoFoster3;
                        numeroDeProductosCienMon = numeroDeProductosCienMon+1;
                        totalProductosPedidosFoster = totalProductosPedidosFoster + " \n Montadito Kebbab ";
                    }
                    if (radioFoster4.isChecked()){
                        precioTotalFinalFoster = precioTotalFinalFoster + precioProductoFoster4;
                        numeroDeProductosCienMon = numeroDeProductosCienMon+1;
                        totalProductosPedidosFoster = totalProductosPedidosFoster + " \n Nachos  ";
                    }



                    setPrecioTotalFinalFoster(precioTotalFinalFoster);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductosCienMon + "Productos  : " + precioTotalFinalFoster, Toast.LENGTH_SHORT).show();

                    switch(numeroDeProductosCienMon) {
                        case 1:
                            tiempoDeEsperFoster = "30 MINUTOS";
                            setTiempoDeEsperFoster(tiempoDeEsperFoster);
                            conjuntoPedidoFoster = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEsperFoster = "45 MINUTOS";
                            setTiempoDeEsperFoster(tiempoDeEsperFoster);
                            conjuntoPedidoFoster = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEsperFoster = "50 MINUTOS";
                            setTiempoDeEsperFoster(tiempoDeEsperFoster);
                            conjuntoPedidoFoster = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEsperFoster = "1 HORA Y 10 MINUTOS";
                            conjuntoPedidoFoster = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEsperFoster(tiempoDeEsperFoster);
                            break;
                        default:
                            tiempoDeEsperFoster = "0";
                            setTiempoDeEsperFoster(tiempoDeEsperFoster);
                    }

                    radioFoster1.setChecked(false);
                    radioFoster2.setChecked(false);
                    radioFoster3.setChecked(false);
                    radioFoster4.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinalFoster()));
                    bundle.putString("key2", getTiempoDeEsperFoster());
                    bundle.putString("key3", getTotalProductosPedidosFoster());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :"+ getPrecioTotalFinalFoster());
            }
        });



        return v;
    }

    public String getTotalProductosPedidosFoster() {
        return totalProductosPedidosFoster;

    }

    public void setTotalProductosPedidosFoster(String totalProductosPedidosFoster) {
        this.totalProductosPedidosFoster = totalProductosPedidosFoster;
    }

    public double getPrecioTotalFinalFoster() {

        return precioTotalFinalFoster;

    }

    public  void setPrecioTotalFinalFoster(double precioTotalFinalFoster) {
        this.precioTotalFinalFoster = precioTotalFinalFoster;
        System.out.println(precioTotalFinalFoster);
    }


    public String getTiempoDeEsperFoster() {
        return tiempoDeEsperFoster;
    }

    public void setTiempoDeEsperFoster(String tiempoDeEsperFoster) {
        this.tiempoDeEsperFoster = tiempoDeEsperFoster;
    }
}
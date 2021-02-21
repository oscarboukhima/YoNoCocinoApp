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
 * Use the {@link KFC#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KFC extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    final double precioInicialKFC = 0;

    double precioTotalFinalKFC = 0;
    double precioProductoKFC1 = 4.6 ;
    double precioProductoKFC2 = 5.99 ;
    double precioProductoKFC3 = 9.99;
    double precioProductoKFC4 = 2.89 ;
    String tiempoDeEsperaKFC;
    String conjuntoPedidoKFC;
    String totalProductosPedidosKFC ="";

    public KFC() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KFC.
     */
    // TODO: Rename and change types and number of parameters
    public static KFC newInstance(String param1, String param2) {
        KFC fragment = new KFC();
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
        final View v =  inflater.inflate(R.layout.fragment_k_f_c, container, false);

        final RadioButton radioKFC1 = (RadioButton) v.findViewById(R.id.radioButtonKFC1) ;
        final RadioButton radioKFC2 = (RadioButton) v.findViewById(R.id.radioButtonKFC2) ;
        final RadioButton radioKFC3 = (RadioButton) v.findViewById(R.id.radioButtonKFC3) ;
        final RadioButton radioKFC4 = (RadioButton) v.findViewById(R.id.radioButtonKFC4) ;

        final TextView tvKFCProducto1 = (TextView) v.findViewById(R.id.tvKFCProducto1);
        final TextView tvKFCProducto2 = (TextView) v.findViewById(R.id.tvKFCProducto2);
        final TextView tvKFCProducto3 = (TextView) v.findViewById(R.id.tvKFCProducto3);
        final TextView tvKFCProducto4 = (TextView) v.findViewById(R.id.tvKFCProducto4);


        Button botonAñadirKFC = (Button) v.findViewById(R.id.buttonAñadirFinalKFC);


        botonAñadirKFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 1 ; i++) {
                    precioTotalFinalKFC =0;
                    int numeroDeProductosKFC = 0;

                    if (radioKFC1.isChecked()){
                        precioTotalFinalKFC = precioTotalFinalKFC + precioProductoKFC1;
                        numeroDeProductosKFC = numeroDeProductosKFC+1;
                        totalProductosPedidosKFC = " TwisterWrap ";
                    }
                    if (radioKFC2.isChecked()){
                        precioTotalFinalKFC = precioTotalFinalKFC + precioProductoKFC2;
                        numeroDeProductosKFC = numeroDeProductosKFC+1;
                        totalProductosPedidosKFC = totalProductosPedidosKFC + " \n La infame ";
                    }
                    if (radioKFC3.isChecked()){
                        precioTotalFinalKFC = precioTotalFinalKFC + precioProductoKFC3;
                        numeroDeProductosKFC = numeroDeProductosKFC+1;
                        totalProductosPedidosKFC = totalProductosPedidosKFC + " \n Chick ANd Share ";
                    }
                    if (radioKFC4.isChecked()){
                        precioTotalFinalKFC = precioTotalFinalKFC + precioProductoKFC4;
                        numeroDeProductosKFC = numeroDeProductosKFC+1;
                        totalProductosPedidosKFC = totalProductosPedidosKFC + " \n Fries Chedar";
                    }



                    setPrecioTotalFinalKFC(precioTotalFinalKFC);
                    Toast.makeText(getActivity(), "Se han añadido " + numeroDeProductosKFC + "Productos  : " + precioTotalFinalKFC, Toast.LENGTH_SHORT).show();

                    switch(numeroDeProductosKFC) {
                        case 1:
                            tiempoDeEsperaKFC = "30 MINUTOS";
                            setTiempoDeEsperaKFC(tiempoDeEsperaKFC);
                            conjuntoPedidoKFC = "TOTAL PRODUCTOS : 1";
                            break;
                        case 2:
                            tiempoDeEsperaKFC = "45 MINUTOS";
                            setTiempoDeEsperaKFC(tiempoDeEsperaKFC);
                            conjuntoPedidoKFC = "TOTAL PRODUCTOS : 2";
                            break;
                        case 3:
                            tiempoDeEsperaKFC = "50 MINUTOS";
                            setTiempoDeEsperaKFC(tiempoDeEsperaKFC);
                            conjuntoPedidoKFC = "TOTAL PRODUCTOS : 3";
                            break;
                        case 4:
                            tiempoDeEsperaKFC = "1 HORA Y 10 MINUTOS";
                            conjuntoPedidoKFC = "TOTAL PRODUCTOS : 4";
                            setTiempoDeEsperaKFC(tiempoDeEsperaKFC);
                            break;
                        default:
                            tiempoDeEsperaKFC = "0";
                            setTiempoDeEsperaKFC(tiempoDeEsperaKFC);
                    }

                    radioKFC1.setChecked(false);
                    radioKFC2.setChecked(false);
                    radioKFC3.setChecked(false);
                    radioKFC4.setChecked(false);

                    Bundle bundle = new Bundle();

                    bundle.putString("key", Double.toString(getPrecioTotalFinalKFC()));
                    bundle.putString("key2", getTiempoDeEsperaKFC());
                    bundle.putString("key3", getTotalProductosPedidosKFC());

                    Fragment fragment = new carritoFragment();
                    fragment.setArguments(bundle);


                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, fragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
                System.out.println(" geter :"+ getPrecioTotalFinalKFC());
            }
        });



        return v;
    }



    public String getTotalProductosPedidosKFC() {
        return totalProductosPedidosKFC;

    }

    public void setTotalProductosPedidosKFC(String totalProductosPedidosKFC) {
        this.totalProductosPedidosKFC = totalProductosPedidosKFC;
    }

    public double getPrecioTotalFinalKFC() {

        return precioTotalFinalKFC;

    }

    public  void setPrecioTotalFinalKFC(double precioTotalFinalKFC) {
        this.precioTotalFinalKFC = precioTotalFinalKFC;
        System.out.println(precioTotalFinalKFC);
    }


    public String getTiempoDeEsperaKFC() {
        return tiempoDeEsperaKFC;
    }

    public void setTiempoDeEsperaKFC(String tiempoDeEsperaKFC) {
        this.tiempoDeEsperaKFC = tiempoDeEsperaKFC;
    }
}
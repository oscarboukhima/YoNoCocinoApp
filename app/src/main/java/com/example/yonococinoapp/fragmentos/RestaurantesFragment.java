package com.example.yonococinoapp.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.yonococinoapp.R;
import com.example.yonococinoapp.SingIn;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RestaurantesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RestaurantesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RestaurantesFragment newInstance(String param1, String param2) {
        RestaurantesFragment fragment = new RestaurantesFragment();
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
        View v =  inflater.inflate(R.layout.fragment_restaurantes, container, false);

        ImageView BurguerKingLogo = (ImageView) v.findViewById(R.id.ivBurger);
        ImageView CienMonLogo = (ImageView) v.findViewById(R.id.iv100mon);
        ImageView DominosLogo = (ImageView) v.findViewById(R.id.ivDominos);
        ImageView FosterLogo = (ImageView) v.findViewById(R.id.ivFoster);
        ImageView GoikoLogo = (ImageView) v.findViewById(R.id.ivGoiko);
        ImageView McDldsLogo = (ImageView) v.findViewById(R.id.ivMcdonalds);
        ImageView KFCLogo = (ImageView) v.findViewById(R.id.ivKFC);
        ImageView VipsLogo = (ImageView) v.findViewById(R.id.ivVips);
        ImageView Res1Logo = (ImageView) v.findViewById(R.id.ivRestaurante1);
        ImageView Res2Logo = (ImageView) v.findViewById(R.id.ivRestaurante2);

        BurguerKingLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BurguerKing BurguerKingFragment = new BurguerKing();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, BurguerKingFragment, "findThisFragment").addToBackStack(null).commit();
            }
        });


        CienMonLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CienMon cienMonFrag = new CienMon();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, cienMonFrag, "findThisFragment").addToBackStack(null).commit();
            }
        });

        DominosLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dominos DominosFragment = new Dominos();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, DominosFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        FosterLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Foster FosterFragment = new Foster();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, FosterFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        GoikoLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Goiko GoikoFragment = new Goiko();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, GoikoFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        KFCLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KFC kfcFragment = new KFC();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, kfcFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        McDldsLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                McDonalds mcDonaldsFragment = new McDonalds();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, mcDonaldsFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        Res1Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Restaurante2 restaurante2Fragment = new Restaurante2();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, restaurante2Fragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        Res2Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Restaurante1 restaurante1Fragment = new Restaurante1();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, restaurante1Fragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });
        VipsLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vips VipsFragment = new Vips();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, VipsFragment, "findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });





        return v;
    }


}
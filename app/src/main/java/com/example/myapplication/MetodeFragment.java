package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MetodeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MetodeFragment extends Fragment {
    private Button btnNext1;
    private EditText etJmlTahun,etCapital,etNonCapital,etHarga,etOpex,etPajak;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MetodeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MetodeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MetodeFragment newInstance(String param1, String param2) {
        MetodeFragment fragment = new MetodeFragment();
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
        View view = inflater.inflate(R.layout.fragment_metode, container, false);
        return view;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){

        btnNext1 = view.findViewById(R.id.btn_next1);
        etJmlTahun = view.findViewById(R.id.et_jml_tahun);
        etCapital = view.findViewById(R.id.et_capital);
        etNonCapital = view.findViewById(R.id.et_noncapital);
        etHarga = view.findViewById(R.id.et_harga);
        etOpex = view.findViewById(R.id.et_opex);
        etPajak = view.findViewById(R.id.et_pajak);

        final Spinner List = view.findViewById(R.id.listItemMetode);

        //get data input


        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strJmlTahun = etJmlTahun.getText().toString();
                int jumlahTahun = Integer.parseInt(strJmlTahun);
                int capital = Integer.parseInt(etCapital.getText().toString());
                int nonCapital = Integer.parseInt(etNonCapital.getText().toString());
                int harga = Integer.parseInt(etHarga.getText().toString());
                int opex = Integer.parseInt(etOpex.getText().toString());
                int pajak = Integer.parseInt(etPajak.getText().toString());
                String metode = List.getSelectedItem().toString();

                Intent intent = new Intent(getActivity(),Tahun.class);
                intent.putExtra("jumlahTahun",jumlahTahun);
                intent.putExtra("capital",capital);
                intent.putExtra("nonCapital", nonCapital);
                intent.putExtra("harga",harga);
                intent.putExtra("opex",opex);
                intent.putExtra("pajak", pajak);
                intent.putExtra("metode", metode);
                startActivity(intent);
            }
        });
    }
}
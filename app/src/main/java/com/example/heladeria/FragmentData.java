package com.example.heladeria;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FragmentData extends Fragment {
    public FragmentData () {
        super(R.layout.fragment_data);
    }

    TextView dVainillia, dFresa, dChoco, dTipo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_data,container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String dataVainilla = requireArguments().getString("dataVainilla");
        String dataFresa = requireArguments().getString("dataFresa");
        String dataChocolate = requireArguments().getString("dataChocolate");
        String spinnerData = requireArguments().getString("spinnerData");
        String spinnerColor = requireArguments().getString("spinnerColor");

        dVainillia = view.findViewById(R.id.result_vainilla);
        dVainillia.setText(dataVainilla);
        dVainillia.setTextColor(Color.parseColor("#FFFF00"));

        dFresa = view.findViewById(R.id.result_fresa);
        dFresa.setText(dataFresa);
        dFresa.setTextColor(Color.parseColor("#A64D79"));

        dChoco = view.findViewById(R.id.result_chocolate);
        dChoco.setText(dataChocolate);
        dChoco.setTextColor(Color.parseColor("#876A0F"));

        dTipo = view.findViewById(R.id.result_tipo);
        dTipo.setText(spinnerData);
        dTipo.setTextColor(Color.parseColor(spinnerColor));
    }
}

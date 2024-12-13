package com.example.heladeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    private Button generar;
    private EditText e1,e2,e3;
    private Spinner sp;
    private String vainillas, fresas, chocos, spinnerData, spinnerColor;
    private Bundle datosHelado = new Bundle();
    private int numHelados = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.recipientes, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerData = (i == 2)? "U" : "V"; //Solo la tarrina lleva U, las demás tienen V
                spinnerColor = (i == 0)? "#CD9F0e" : (i == 1) ? "#544105" : "#000000";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        e1 = findViewById(R.id.v_number);
        e2 = findViewById(R.id.f_number);
        e3 = findViewById(R.id.c_number);
        generar = findViewById(R.id.generar);
        generar.setOnClickListener(view -> {
            vainillas = "";
            fresas = "";
            chocos = "";
            int num_vainilla = Integer.parseInt(e1.getText().toString());
            int num_fresa = Integer.parseInt(e2.getText().toString());
            int num_choco = Integer.parseInt(e3.getText().toString());
            int maxNum = (num_vainilla>num_fresa)?
                    Math.max(num_vainilla, num_choco) : Math.max(num_fresa, num_choco);
            for (int i = 0; i < maxNum; i++) {
                if (i < num_vainilla) {
                    vainillas += "O";
                }
                if (i < num_fresa) {
                    fresas += "O";
                }
                if (i < num_choco) {
                    chocos += "O";
                }
            }
            /*
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra("dataVainilla", vainillas);
            intent.putExtra("dataFresa",fresas);
            intent.putExtra("dataChocolate",chocos);
            intent.putExtra("spinnerData",spinnerData);
            intent.putExtra("spinnerColor",spinnerColor);
            startActivity(intent);
            */

            datosHelado.putString("dataVainilla", vainillas);
            datosHelado.putString("dataFresa",fresas);
            datosHelado.putString("dataChocolate",chocos);
            datosHelado.putString("spinnerData",spinnerData);
            datosHelado.putString("spinnerColor",spinnerColor);


            FragmentManager fm = getSupportFragmentManager();
            //FragmentData fragmento = new FragmentData();
            //fragmento.setArguments(datosHelado);
            fm.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.data_transfer, FragmentData.class, datosHelado, "Helado_"+numHelados)
                    // .add(R.id.data_transfer, fragmento, "Helado_"+numHelados
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();


        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}
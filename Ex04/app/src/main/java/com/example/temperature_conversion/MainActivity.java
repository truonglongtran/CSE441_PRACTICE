package com.example.temperature_conversion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtf, edtc;;
    Button btnFC, btnCF, btnclear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtf = findViewById(R.id.edtf);
        edtc = findViewById(R.id.edtc);
        btnFC = findViewById(R.id.btnFC);
        btnCF = findViewById(R.id.btnCF);
        btnclear = findViewById(R.id.btnclear);
        btnFC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DecimalFormat dcf = new DecimalFormat("#.##");
                int f = Integer.parseInt(edtf.getText().toString());
                double c = (f-32)*1.8;
                edtc.setText(dcf.format(c)+"");
           }
        });
        btnCF.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.##");
                int c = Integer.parseInt(edtc.getText().toString());
                double f = (c * 1.8) + 32;
                edtf.setText(dcf.format(f)+"");
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtf.setText("");
                edtc.setText("");
            }
        });
    }
}
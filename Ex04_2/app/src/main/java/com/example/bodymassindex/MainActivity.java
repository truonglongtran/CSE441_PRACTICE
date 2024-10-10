package com.example.bodymassindex;

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
    EditText edtName, edtHeight, edtWeight, edtBMI, edtRecom;
    Button btn;
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
        edtName = findViewById(R.id.edtName);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        edtBMI = findViewById(R.id.edtBMI);
        edtRecom = findViewById(R.id.edtRecom);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double H = Double.parseDouble(edtHeight.getText().toString());
                double W = Double.parseDouble(edtWeight.getText().toString());

                double BMI  = W/(H*H);
                String chuandoan = "";
                if(BMI < 14){
                    chuandoan = "Bạn gầy";
                }else if(BMI<=24.9)
                {
                    chuandoan ="Bạn bình thường";
                }
                else if(BMI<=29.9)
                {
                    chuandoan ="Bạn béo phì độ 1";
                }
                else if(BMI<=34.9)
                {
                    chuandoan = "Bạn béo phì độ 2";
                }
                else
                {
                    chuandoan = "Bạn béo phì độ 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.##");
                edtBMI.setText(dcf.format(BMI)+"");
                edtRecom.setText(chuandoan);
            }
        });
    }
}
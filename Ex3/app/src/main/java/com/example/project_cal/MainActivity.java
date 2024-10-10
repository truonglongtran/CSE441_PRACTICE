package com.example.project_cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtkq;
    Button btntong, btnhieu, btntich, btnthuong;
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

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtkq = findViewById(R.id.edtkq);

        btnhieu = findViewById(R.id.btnhieu);
        btntich = findViewById(R.id.btntich);
        btnthuong = findViewById(R.id.btnthuong);
        btntong = findViewById(R.id.btntong);

        btntong.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a+b;
                edtkq.setText(String.valueOf(c));
            }
        });
        btnhieu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a-b;
                edtkq.setText(String.valueOf(c));
            }
        });
        btntich.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a*b;
                edtkq.setText(String.valueOf(c));
            }
        });
        btnthuong.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a/b;
                edtkq.setText(String.valueOf(c));
            }
        });

    }
}
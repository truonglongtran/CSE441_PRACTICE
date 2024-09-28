package com.example.prac02;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv_result;
    private EditText edt_id, edt_name, edt_birth, edt_salary;
    private Button btn_add ;

    private final  EmployeeViewModel employeeViewModel = new EmployeeViewModel();
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
        tv_result = findViewById(R.id.tv_result);
        edt_id = findViewById(R.id.edt_id);
        edt_name = findViewById(R.id.edt_name);
        edt_birth = findViewById(R.id.edt_birth);
        edt_salary = findViewById(R.id.edt_salary);
        btn_add = findViewById(R.id.btn_add);

        employeeViewModel.getEmployees().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(List<Employee> employees) {
               if (employees == null || employees.isEmpty()) {
                    tv_result.setText("No Result!");
               }else {
                    StringBuilder result = new StringBuilder();
                    for (Employee employee : employees) {
                        result.append(employee.toString()).append("\n");
                    }
                    tv_result.setText(result.toString());
               }
            }
        });
        btn_add.setOnClickListener(v -> {
            String id = edt_id.getText().toString();
            String name = edt_name.getText().toString();
            String birthDate = edt_birth.getText().toString();
            long salary = Long.parseLong(edt_salary.getText().toString());

           Employee employee = new Employee(id, name, birthDate, salary);
           employeeViewModel.addEmployee(employee);
            edt_id.setText("");
            edt_name.setText("");
            edt_birth.setText("");
            edt_salary.setText("");

        });
    }


}
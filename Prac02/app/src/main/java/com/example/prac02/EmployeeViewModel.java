package com.example.prac02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class EmployeeViewModel extends ViewModel {

    private final MutableLiveData<List<Employee>> employees = new MutableLiveData<>(new ArrayList<>());

    // Hàm thêm nhân viên vào danh sách
    public void addEmployee(Employee employee) {
        List<Employee> currentEmployees = employees.getValue();
        if (currentEmployees != null) {
            currentEmployees.add(employee);
            employees.setValue(currentEmployees);
        }
    }

    // Hàm trả về danh sách nhân viên dưới dạng LiveData
    public LiveData<List<Employee>> getEmployees() {
        return employees;
    }
}

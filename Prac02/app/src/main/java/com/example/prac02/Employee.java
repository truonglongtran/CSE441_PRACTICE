package com.example.prac02;

public class Employee {
    private String id;
    private String name;
    private String birthDate;
    private long salary;

    public Employee(String id, String name, String birthDate, long salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return   id + " - " + name + " - " + birthDate + " - " + salary;
    }
}

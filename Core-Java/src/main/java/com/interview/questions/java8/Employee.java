//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.java8;

class Employee {

    private String name;
    private double salary;
    private String gender;
    private String department;

    public Employee(String name, double salary, String gender, String department) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getGender() {
        return gender;
    }
}

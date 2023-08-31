//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Stream {

    public static void main(String[] args) {
        getEmployeeListWhosSameDept();
        getDepartmentWithItHighestEmployeeSal();
        getFemaleEmployeeAvgSalary();
    }

    private static void getFemaleEmployeeAvgSalary() {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 51000, "female", "HR"),
            new Employee("Bob", 60000, "male", "IT"),
            new Employee("Carol", 55000, "female", "IT"),
            new Employee("David", 62000, "male", "HR"),
            new Employee("Eve", 52000, "female", "Finance")
        );

        double averageFemaleSalary = employees.stream().filter(e -> e.getGender().equals("female")).mapToDouble(Employee::getSalary).average().orElse(0);
        double averageMaleSalary = employees.stream().filter(e -> e.getGender().equals("male")).mapToDouble(Employee::getSalary).average().orElse(0);
        System.out.println("averageFemaleSalary = " + averageFemaleSalary);
        System.out.println("averageMaleSalary = " + averageMaleSalary);

    }

    private static void getEmployeeListWhosSameDept() {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 1, "female", "HR"),
            new Employee("Bob", 2, "male", "IT"),
            new Employee("Carol", 3, "female", "IT"),
            new Employee("David", 4, "male", "HR"),
            new Employee("Eve", 5, "female", "Finance"),
            new Employee("Frank", 6, "male", "IT")
        );

        Map<String, List<Employee>> employeesByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        // Filter and print employees with the same department
        employeesByDepartment.values().stream()
            //            .filter(employeeList -> employeeList.size() > 1)
            .forEach(employeeList -> {
                System.out.println("Employees in department " + employeeList.get(0).getDepartment() + ":");
                employeeList.forEach(employee -> System.out.println(" - " + employee.getName()));
            });
    }

    private static void getDepartmentWithItHighestEmployeeSal() {
        Department department1 = new Department("HR");
        department1.addEmployee(new Employee("Alice", 50000, "female", "HR"));
        department1.addEmployee(new Employee("Bob", 60000, "male", "IT"));

        Department department2 = new Department("Engineering");
        department2.addEmployee(new Employee("Charlie", 70000, "male", "IT"));
        department2.addEmployee(new Employee("David", 80000, "male", "HR"));

        List<Department> departmentList = Arrays.asList(department1, department2);

        Map<String, Employee> map = departmentList.stream().collect(Collectors.toMap(
            Department::getName,
            Java8Stream::getHighestSalaryEmployee
        ));

        map.forEach((dept, emp) -> System.out.println("Department : " + dept + " Employee: " + emp.getName()));

        departmentList.stream().collect(
                Collectors.toMap(
                    Department::getName,
                    Java8Stream::getHighestSalaryEmployee
                )).
            forEach(
                (dept, emp) -> System.out.println("Department : " + dept + " Employee: " + emp.getName())
            );

    }

    public static Employee getHighestSalaryEmployee(Department department) {

        return department.getEmployees().stream()
            .max(Comparator.comparingDouble(Employee::getSalary))
            .orElse(null);
    }
}


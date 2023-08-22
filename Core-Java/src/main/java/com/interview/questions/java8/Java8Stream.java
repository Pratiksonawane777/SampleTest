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
    }
    private static void getEmployeeListWhosSameDept() {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 1, "HR"),
            new Employee("Bob", 2, "IT"),
            new Employee("Carol", 3, "IT"),
            new Employee("David", 4, "HR"),
            new Employee("Eve", 5, "Finance"),
            new Employee("Frank", 6, "IT")
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
        department1.addEmployee(new Employee("Alice", 50000,"HR"));
        department1.addEmployee(new Employee("Bob", 60000,"IT"));

        Department department2 = new Department("Engineering");
        department2.addEmployee(new Employee("Charlie", 70000,"IT"));
        department2.addEmployee(new Employee("David", 80000,"HR"));

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


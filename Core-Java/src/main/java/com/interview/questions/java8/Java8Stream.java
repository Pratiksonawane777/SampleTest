//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Stream {

    public static void main(String[] args) {
        getEmployeeListWhosSameDept();
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
}


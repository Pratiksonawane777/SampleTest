//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Feature {

    public static void main(String[] args) {
        nonRepeatedFirstChar();
        getIntAppearsTimeCount();
        getDepartmentWithItHighestEmployeeSal();
    }

    private static void getDepartmentWithItHighestEmployeeSal() {
        Department department1 = new Department("HR");
        department1.addEmployee(new Employee("Alice", 50000));
        department1.addEmployee(new Employee("Bob", 60000));

        Department department2 = new Department("Engineering");
        department2.addEmployee(new Employee("Charlie", 70000));
        department2.addEmployee(new Employee("David", 80000));

        List<Department> departmentList = Arrays.asList(department1, department2);
        Map<String, Employee> map = departmentList.stream().collect(Collectors.toMap(
            Department::getName,
            Java8Feature::getHighestSalaryEmployee
        ));

        map.forEach((dept, emp) -> System.out.println("Department : " + dept + " Employee: " + emp.getName()));

    }

    private static Employee getHighestSalaryEmployee(Department department) {
        return department.getEmployees().stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
    }

    private static void getIntAppearsTimeCount() {
        //get Integer and it's appears count
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3, 6, 4);
        Map<Integer, Long> map = numbers.stream().
            collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        map.forEach((in, lo) ->
            System.out.println("Integer: " + in + " Count: " + lo)
        );

        Integer integer = numbers.stream().
            filter(n -> map.get(n) == 1).
            findFirst().orElse(null);

        System.out.println("First integer whose count 1: " + integer);

        List<Integer> list = numbers.stream().filter(n -> map.get(n) == 1).collect(Collectors.toList());
        System.out.println("Integer whose count 1: " + list.toString());
    }

    private static void nonRepeatedFirstChar() {
        //        find out the first non-repeated character in it using Stream functions
        String str = "java is a programming language";

        Map<Character, Long> characterLongMap = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        List<Character> characterList = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        Character character = characterList.stream().filter(c -> characterLongMap.get(c) == 1L).findFirst().orElse(null);
        System.out.println("Non Repeated Char is: " + character);
    }

}

class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class Department {

    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }
}


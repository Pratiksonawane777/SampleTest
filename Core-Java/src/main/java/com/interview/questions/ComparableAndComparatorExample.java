package com.interview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparatorExample {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("a", "itanagar", 22));
        persons.add(new Person("d", "delhi", 25));
        persons.add(new Person("c", "patana", 23));

        //sort using name use comparable natural ordering
        Collections.sort(persons);
        printSortedList(persons);

        //sort using city use comparator natural ordering
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getCity().compareTo(o2.getCity());
            }
        });
        // Print the sorted list
        printSortedList(persons);

        Collections.sort(persons, new AgeComparator());
        // Print the sorted list
        printSortedList(persons);

        //sort using age use lambda
        persons.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        // Print the sorted list
        printSortedList(persons);
    }

    private static void printSortedList(List<Person> persons) {
        // Print the sorted list
        for (Person person : persons) {
            System.out.println("Name: " + person.getName() + ", City: " + person.getCity() + ", Age: " + person.getAge());
        }
    }

}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

class Person implements Comparable<Person> {

    private String name;
    private String city;
    private int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    // Getter methods for name, city, and age

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }
}


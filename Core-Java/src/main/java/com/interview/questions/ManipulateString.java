package com.interview.questions;

public class ManipulateString {

    public static void main(String[] args) {
        String str="ABC";

        Customer customer= new Customer();
        customer.setName(str);

        System.out.println(str);

        manupulateString(str,customer);

        System.out.println(customer.getName());
    }

    private static Customer manupulateString(String str, Customer customer) {
        str.toLowerCase();
        Customer customerNew= new Customer();
        customerNew = customer;
        customerNew.setName("XYZ");

        System.out.println(str);

        return customerNew;
    }

}

class Customer{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name="PQR";
}

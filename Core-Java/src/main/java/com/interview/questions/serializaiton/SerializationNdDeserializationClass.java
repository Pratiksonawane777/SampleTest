package com.interview.questions.serializaiton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee extends superEmployee {

    public String firstName;
    private static final long serialVersionUID = 5462223600l;
}

class superEmployee implements Serializable {

    public String lastName;
    static String companyName;
    transient String address;
    static transient String companyCEO;
}

public class SerializationNdDeserializationClass {

    public static void main(String[] args) {
        serialzation();
        deserialzation();
    }

    private static void deserialzation() {
        Employee emp = null;
        try {
            FileInputStream fileIn = new FileInputStream("./employee.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            emp = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserializing Employee...");
        System.out.println("First Name of Employee: " + emp.firstName);
        System.out.println("Last Name of Employee: " + emp.lastName);
        System.out.println("Company Name: " + emp.companyName);
        System.out.println("Company CEO: " + emp.companyCEO);
        System.out.println("Company Address: " + emp.address);
    }

    private static void serialzation() {
        Employee emp = new Employee();
        emp.firstName = "Vivekanand";
        emp.lastName = "Gautam";
        emp.companyName = "JBT";
        //Below part needs to be removed in case address field is made final
        emp.address = "MUM";
        emp.companyCEO = "ME CEO";

        try {
            FileOutputStream fileOut = new FileOutputStream("./employee.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in ./employee.txt file");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

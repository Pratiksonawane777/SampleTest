//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com;

// Target Interface
interface Target {
    void request();
}

// Adaptee (Incompatible Class)
class Adaptee {
    public void specificRequest() {
        System.out.println("Specific request from Adaptee.");
    }
}

// Adapter Class
class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// Client Code
public class AddapterDesignPattern {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);

        target.request(); // Calls the specificRequest method of Adaptee through the Adapter
    }
}

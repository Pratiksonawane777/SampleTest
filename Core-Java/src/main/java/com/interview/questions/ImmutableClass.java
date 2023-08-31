package com.interview.questions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ImmutableClass {

    private final int id;
    private final String name;

    private final HashMap<String, String> testMap;

    public ImmutableClass(int id, String name, Map<String, String> testMap) {
        System.out.println("Performing Deep Copy for Object initialization");

        // "this" keyword refers to the current object
        this.id = id;
        this.name = name;

        HashMap<String, String> tempMap = new HashMap<>();
        String key;
        Iterator<String> it = testMap.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            tempMap.put(key, testMap.get(key));
        }
        this.testMap = tempMap;
    }

    //    public ImmutableClass(int id, String name, HashMap<String, String> testMap) {
    //        System.out.println("Performing shallow Copy for Object initialization");
    //
    //        // "this" keyword refers to the current object
    //        this.id = id;
    //        this.name = name;
    //        this.testMap = testMap;
    //    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTestMap() {
        return testMap;
    }

    // Test the immutable class

    public static void main(String[] args) {
        HashMap<String, String> h1 = new HashMap<String, String>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i = 10;

        ImmutableClass iC = new ImmutableClass(i, s, h1);

        // print the ce values
        System.out.println("ce id: " + iC.getId());
        System.out.println("ce name: " + iC.getName());
        System.out.println("ce testMap: " + iC.getTestMap());
        // change the local variable values
        i = 20;
        s = "modified";
        h1.put("3", "third");
        // print the values again
        System.out.println("ce id after local variable change: " + iC.getId());
        System.out.println("ce name after local variable change: " + iC.getName());
        System.out.println("ce testMap after local variable change: " + iC.getTestMap());

        HashMap<String, String> hmTest = iC.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from getter methods: " + iC.getTestMap());

    }

}

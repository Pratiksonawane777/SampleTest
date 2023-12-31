//  *******************************************
//  * Copyright (c) CRIF - All Right Reserved *
//  *******************************************

package com.interview.questions.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Feature {

    public static void main(String[] args) {
        getNonRepeatedFirstChar();
        firstNonRepeatingLetterWithCaseInSensitive();
        getIntAppearsTimeCount();
        getCountOfRepeatedChar();
        getIntValueRepeatedWithSameCount();

    }

    private static void getIntValueRepeatedWithSameCount() {
        //        int[] A = { 5, 5, 5, 5, 5 };
        //        int[] A = { 2, 5, 5, 5, 2 };
        int[] A = { 2, 3, 3, 3, 2 };
        Map<Integer, Integer> integerMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
            integerMap.put(A[i], integerMap.getOrDefault(A[i], 0) + 1);
        }
        int resultKey = 0;
        int resultValue = 0;

        //One Way
        for (Entry<Integer, Integer> entry : integerMap.entrySet()) {
            if (entry.getValue().equals(entry.getKey()) && entry.getKey() > resultKey) {
                resultKey = entry.getKey();
                resultValue = entry.getKey();
            }
        }
        System.out.println("Result : key " + resultKey + "  & Value :" + resultValue);

        resultKey = 0;
        resultValue = 0;

        //Second Way
        Map<Integer, Long> mapOfCount = list.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        for (Entry<Integer, Long> entry : mapOfCount.entrySet()) {
            if (entry.getValue().equals((long) entry.getKey()) && entry.getKey() > resultKey) {
                resultKey = entry.getKey();
                resultValue = entry.getKey();
            }
        }

        System.out.println("Result : key " + resultKey + "  & Value :" + resultValue);

    }

    private static void getCountOfRepeatedChar() {
        String str = "apple";
        Map<Character, Long> map = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        map.forEach((key, value) ->
            System.out.println("Key :" + key + " Value :" + value)
        );

        Map<Character, Integer> charOccurrencesMap = new HashMap<>();
        for (Character character : str.toCharArray()) {
            //            if(charOccurrencesMap.containsKey(character)){
            //                int count=charOccurrencesMap.get(character)+1;
            //                charOccurrencesMap.put(character,count);
            //            }else{
            //                charOccurrencesMap.put(character,1);
            //            }
            charOccurrencesMap.put(character, charOccurrencesMap.getOrDefault(character, 0) + 1);
        }
        charOccurrencesMap.forEach((key, value) ->
            System.out.println("Key :" + key + " Value :" + value)
        );
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

        //    get Integer and it's appears count
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3, 6, 4);
        Map<Integer, Long> map1 = numbers1.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        map1.forEach((i, l) -> System.out.println("Integer: " + i + "-> Count: " + l));

        Map<Integer, Long> map2 = map.entrySet().stream().filter(integerLongEntry -> integerLongEntry.getValue() == 1).collect(Collectors.toMap(Entry::getKey, Entry::getValue));
        map2.forEach((i, l) -> System.out.println("Integer: " + i + "-> Count: " + l));
    }

    private static void getNonRepeatedFirstChar() {
        //        find out the first non-repeated character in it using Stream functions
        String str = "java is a programming language";

        Map<Character, Long> characterLongMap = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        List<Character> characterList = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        Character character = characterList.stream().filter(c -> characterLongMap.get(c) == 1L).findFirst().orElse(null);
        System.out.println("Non Repeated Char is: " + character);

    }

    public static void firstNonRepeatingLetterWithCaseInSensitive() {
        String str = "Stress";
        Map<Character, Long> map = str.chars().
            mapToObj(c -> (char) c).
            collect(Collectors.groupingBy(Character::toLowerCase, Collectors.counting()));

        Optional<Character> list = str.chars().
            mapToObj(c -> (char) c).
            filter(c -> map.get(Character.toLowerCase(c)) == 1L).
            findFirst();
        System.out.println("Non Repeated Char is: " + list.map(Object::toString).orElse(""));
    }

}




package com.interview.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetListUpToIndexJava8 {
    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<>();
        originalList.add(11);
        originalList.add(12);
        originalList.add(12);
        originalList.add(14);
        originalList.add(15);
        originalList.add(16);
        originalList.add(17);
        originalList.add(18);
        originalList.add(19);
        originalList.add(20);

        int indexToGet = 5;

        List<Integer> resultList = getElementsUpToIndex(originalList, indexToGet);

        System.out.println("Original List: " + originalList);
        System.out.println("Result List up to index " + indexToGet + ": " + resultList);
    }

    public static List<Integer> getElementsUpToIndex(List<Integer> originalList, int index) {
        return IntStream.range(0, Math.min(index + 1, originalList.size()))
                .mapToObj(originalList::get)
                .collect(Collectors.toList());
    }
}

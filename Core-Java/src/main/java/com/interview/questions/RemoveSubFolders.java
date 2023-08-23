package com.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveSubFolders {

    public static void main(String[] args) {
        List<String> inputPaths = Arrays.asList("/a", "/a/b", "/c/d", "/c/d/e", "/c/f", "/a/e/f");
        List<String> outputPaths = removeSubFolders(inputPaths);
        System.out.println(outputPaths);
    }

    private static List<String> removeSubFolders(List<String> inputPaths) {
        Set<String> topLevelPaths = new HashSet<>();

        for (String path : inputPaths) {
            String[] folders = path.split("/");
            StringBuilder currentPath = new StringBuilder();

            // Skip the first empty element after splitting by "/"
            for (int i = 1; i < folders.length; i++) {
                currentPath.append("/").append(folders[i]);
                // Check if the currentPath exists in the topLevelPaths (subfolder found)
                if (topLevelPaths.contains(currentPath.toString())) {
                    break;
                }
            }
            // If subFolder not found, add the path to topLevelPaths
            if (!topLevelPaths.contains(currentPath.toString())) {
                topLevelPaths.add(path);
            }
        }
        return new ArrayList<>(topLevelPaths);
    }
}

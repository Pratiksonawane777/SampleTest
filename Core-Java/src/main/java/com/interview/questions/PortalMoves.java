package com.interview.questions;

import java.util.Arrays;
import java.util.Scanner;

public class PortalMoves {

    public static void main(String[] args) {
        //        Java - Portals
        //        Objective
        //        Your avatar is in a strange world with two inter-dimensional, bidirectional portals.
        //            Write a program that returns the coordinates of your avatar given a series of moves and the location of the portals.

        Scanner scanner = new Scanner(System.in);
        // Read the width and height of the world
        System.out.print("width :");
        int width = scanner.nextInt();
        System.out.print("height :");
        int height = scanner.nextInt();

        // Read the initial position of the avatar
        int[] position = new int[2];
        System.out.print("position X :");
        position[0] = scanner.nextInt(); // x-coordinate
        System.out.print("position Y :");
        position[1] = scanner.nextInt(); // y-coordinate

        // Read the location of portal A
        int[] portalA = new int[2];
        System.out.print("portalA X :");
        portalA[0] = scanner.nextInt(); // x-coordinate of portal A
        System.out.print("portalA Y :");
        portalA[1] = scanner.nextInt(); // y-coordinate of portal A

        // Read the location of portal B
        int[] portalB = new int[2];
        System.out.print("portalB X :");
        portalB[0] = scanner.nextInt(); // x-coordinate of portal B
        System.out.print("portalB Y :");
        portalB[1] = scanner.nextInt(); // y-coordinate of portal B

        // Read the series of moves as a string
        System.out.print("moves :");
        String moves = scanner.next();

        // Call the computeFinalPosition method to get the final position of the avatar
        int[] finalPosition = computeFinalPosition(width, height, position, portalA, portalB, moves);

        // Print the final position of the avatar
        System.out.println("Last Position is (" + finalPosition[0] + "," + finalPosition[1] + ")");

        //        int[] finalPosition1 = computeFinalPosition(5, 4, new int[] { 0, 0 }, new int[] { 1, 1 }, new int[] { 2, 3 }, "DRR");
        //        System.out.println(finalPosition1[0] + " " + finalPosition1[1]);//3,3
        //
        //        int[] finalPosition2 = computeFinalPosition(5, 4, new int[] { 0, 0 }, new int[] { 1, 1 }, new int[] { 2, 3 }, "DRRUUL");
        //        System.out.println(finalPosition2[0] + " " + finalPosition2[1]);//2,1
        //
        //        int[] finalPosition3 = computeFinalPosition(5, 4, new int[] { 0, 0 }, new int[] { 1, 1 }, new int[] { 2, 3 }, "DRRUULL");
        //        System.out.println(finalPosition3[0] + " " + finalPosition3[1]);//2,3

    }

    public static int[] computeFinalPosition(int width, int height, int[] position, int[] portalA, int[] portalB, String moves) {
        int x = position[0];
        int y = position[1];

        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'R':
                    x = (x + 1) % width;
                    break;
                case 'L':
                    x = (x - 1) % width;
                    break;
                case 'D':
                    y = (y + 1) % height;
                    break;
                case 'U':
                    y = (y - 1) % height;
                    break;
                default:
                    break;
            }

            if (Arrays.equals(new int[] { x, y }, portalA)) {
                x = portalB[0];
                y = portalB[1];
            } else if (Arrays.equals(new int[] { x, y }, portalB)) {
                x = portalA[0];
                y = portalA[1];
            }
        }
        return new int[] { x, y };
    }
}

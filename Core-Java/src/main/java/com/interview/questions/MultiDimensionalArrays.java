package com.interview.questions;

import java.util.HashMap;
import java.util.Map;

public class MultiDimensionalArrays {

    public static void main(String[] args) {
        int[][] input = {
            { 1, 5, 2, 5 },
            { 3, 7, 4, 9 },
            { 5, 5, 6, 5 },
            { 1, 5, 3, 6 },
            { 2, 7, 4, 9 }
        };

        Map<Integer, Integer> playerWins = new HashMap<>();

        for (int[] match : input) {
            int player1 = match[0];
            int player2 = match[2];

            int score1 = match[1];
            int score2 = match[3];

            int winner = (score1 == score2) ? 0 : (score1 > score2) ? player1 : player2;
            playerWins.put(winner, playerWins.getOrDefault(winner, 0) + 1);
        }

        //        for (int i = 0; i < input.length; i++) {
        //            int player1 = input[i][0];
        //            int player2 = input[i][2];
        //
        //            int score1 = input[i][1];
        //            int score2 = input[i][3];
        //
        //            int winner = (score1 == score2) ? 0 : (score1 > score2) ? player1 : player2;
        //            playerWins.put(winner, playerWins.getOrDefault(winner, 0) + 1);
        //        }

        int maxWins = -1;
        int winningPlayer = -1;

        for (Map.Entry<Integer, Integer> entry : playerWins.entrySet()) {
            if (entry.getValue() > maxWins && entry.getKey() != 0) {
                maxWins = entry.getValue();
                winningPlayer = entry.getKey();
            }
        }

        if (winningPlayer != -1) {
            System.out.println("Player " + winningPlayer + " is the most frequent winner with " + maxWins + " wins.");
        } else {
            System.out.println("No consistent winner.");
        }

    }
}

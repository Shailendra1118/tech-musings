package com.sports.rafael.geeks;

public class Tournament {

    /**
     * Given a positive integer N representing the count of players playing the game.
     * The game is played between two teams such that each team consists of at least one player
     * but the total count of players in the game must be N.
     * The game lasts in exactly 30 minutes.
     * the task is to check if all players will play the game against each other
     * or not If the game can be played up to T hours,
     * and it is allowed to play the game more than 1 times.
     *
     */
    public static void main(String[] args) {
        int players = 4;
        double matchTimeInHours = 0.5;
        boolean res = checkAllPlayerAgainst(players, matchTimeInHours);
        System.out.println("Res: "+res);
    }

    private static boolean checkAllPlayerAgainst(int players, double matchTimeInHours) {

        //observations
        // 1. In each match, if one of the two team has only ONE player,
        // then total match are required would be N-1 times ===> Maximum matches possible

        // 2. In each match, if one of the team have N/2 player and other team has (N+1)/2 players
        // then match are required to be played = (N+1)/2 time ===> Minimum matches

        int playersInTeamA = players/2;
        int playersInTeamB = players - playersInTeamA;
        double totalTimeInMinutes = matchTimeInHours * 60;

        int matchCountRequired;
        if(playersInTeamA == 1 || playersInTeamB == 1) {
            matchCountRequired = players - 1;
        }else {
            matchCountRequired = (players + 1)/2;
        }
        int matchCount = 0;
        while(totalTimeInMinutes > 0) {
            matchCount++;
            totalTimeInMinutes -= 30;

            if(matchCount == matchCountRequired)
                return true;
        }

        return false;
    }
}

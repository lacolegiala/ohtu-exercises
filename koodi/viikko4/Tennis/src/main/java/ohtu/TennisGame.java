package ohtu;

public class TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;
    private static int GAME = 4;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            player1Score += 1;
        else if (playerName == player2Name) {
            player2Score += 1;
        }
    }

    public String getScore() {
        String score = "";

        if (player1Score == player2Score) {
            return scoreResult(player2Score, player1Score);
        }

        int minScore = Math.min(player1Score, player2Score);
        int maxScore = Math.max(player1Score, player2Score);
        if (maxScore >= GAME) {
            String leadingPlayer = player1Score < player2Score ? player2Name : player1Name;
            switch(maxScore - minScore) {
                case 1:
                    score = "Advantage " + leadingPlayer;
                    break;
                default:
                    score = "Win for " + leadingPlayer;
            }
        }
        else {
            return scoreResult(player2Score, player1Score);
        }
        return score;
    }

    public static String resultName(int score) {
        switch(score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }

    public static String scoreResult(int scoreSecondPlayer, int scoreFirstPlayer) {
        String result = resultName(scoreFirstPlayer);
        if (scoreSecondPlayer == scoreFirstPlayer && scoreSecondPlayer < GAME) {
            return result + "-All";
        }
        else if (scoreSecondPlayer < GAME) {
            return result + "-" + resultName(scoreSecondPlayer);
        }
        else {
            return result;
        }
    }

}
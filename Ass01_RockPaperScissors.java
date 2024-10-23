import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            String playerAChoice = getValidMove(scanner, "Player A");
            String playerBChoice = getValidMove(scanner, "Player B");

            displayResults(playerAChoice, playerBChoice);

            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getValidMove(Scanner scanner, String player) {
        String move;
        do {
            System.out.print(player + ", enter your move (R, P, S): ");
            move = scanner.nextLine().toUpperCase();
        } while (!move.equals("R") && !move.equals("P") && !move.equals("S"));
        return move;
    }

    private static void displayResults(String playerA, String playerB) {
        if (playerA.equals(playerB)) {
            System.out.println(playerA + " vs " + playerB + " it's a Tie!");
        } else if (playerA.equals("R") && playerB.equals("S") || playerA.equals("P") && playerB.equals("R") || playerA.equals("S") && playerB.equals("P")) {
            System.out.println(getResultString(playerA, playerB) + " Player A wins!");
        } else {
            System.out.println(getResultString(playerB, playerA) + " Player B wins!");
        }
    }

    private static String getResultString(String move1, String move2) {
        if (move1.equals("R")) {
            return "Rock breaks Scissors";
        } else if (move1.equals("P")) {
            return "Paper covers Rock";
        } else {
            return "Scissors cuts Paper";
        }
    }
}

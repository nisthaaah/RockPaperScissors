import java.util.Random;
import java.util.Scanner;

public class rps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Creating sc object outside the loop ensures that you don't recreate a new Scanner object in every
                                            //iteration of the loop.Recreating it inside the loop might lead to potential issues like resource leakage
                                           //or unexpected behavior because each new Scanner instantiation might consume additional resources.

        while (true) {
            String[] rps = { "Rock", "Paper", "Scissor" };
            String computerMove = rps[new Random().nextInt(rps.length)];

            String playerMove;

            while (true) {
                System.out.println("Please enter your move (Rock, Paper, Scissor)");
                playerMove = sc.nextLine();

                if (playerMove.equals("Paper") || playerMove.equals("Scissor") || playerMove.equals("Rock")) {
                    break;
                }
                System.out.println(playerMove + " is not a valid move!!");
            }

            System.out.println("Computer played: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("IT'S A TIE!!");
            } else if (playerMove.equals("Rock")) {
                if (computerMove.equals("Paper")) {
                    System.out.println("YOU LOSE!!");
                } else if (computerMove.equals("Scissor")) {
                    System.out.println("YOU WIN!!");
                }
            } else if (playerMove.equals("Paper")) {
                if (computerMove.equals("Scissor")) {
                    System.out.println("YOU LOSE!!");
                } else if (computerMove.equals("Rock")) {
                    System.out.println("YOU WIN!!");
                }
            } else if (playerMove.equals("Scissor")) {
                if (computerMove.equals("Rock")) {
                    System.out.println("YOU LOSE!!");
                } else if (computerMove.equals("Paper")) {
                    System.out.println("YOU WIN!!");
                }
            }
            System.out.println("\nPLAY AGAIN? (Y/N)");
            String playAgain = sc.nextLine();

            if (!playAgain.equals("Y")) {
                break;
            }
        }
        sc.close();
    }
}
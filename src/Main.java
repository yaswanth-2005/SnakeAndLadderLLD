import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Snake[] snakes = {
                new Snake(17, 7),
                new Snake(54, 34),
                new Snake(62, 19),
                new Snake(98, 79)
        };
        Ladder[] ladders = {
                new Ladder(3, 22),
                new Ladder(5, 8),
                new Ladder(20, 29),
                new Ladder(40, 59),
                new Ladder(70, 90)
        };

        Board board = new Board(100, snakes, ladders);
        Dice dice = new Dice();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players: ");
        int noOfPlayers = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[noOfPlayers];
        for(int i = 0; i < noOfPlayers; i++) {
            System.out.println("Enter Player " + (i + 1) + "'s name: ");
            players[i] = new Player(sc.nextLine());
        }

        boolean gameWon = false;

        System.out.println("Game Started!!!");
        while(!gameWon) {
            for(Player player : players) {
                System.out.println(player.getName() + "'s turn. Press Enter to roll the dice.");
                sc.nextLine();

                int roll = dice.roll();
                System.out.println(player.getName()+" rolled a dice to " + roll);
                player.move(roll);

                if(player.getPosition() > board.getSize()) {
                    player.setPosition(player.getPosition());
                }

                int newPosition = board.checkSnakesAndLadders(player.getPosition());
                player.setPosition(newPosition);
                System.out.println(player.getName() + " is now at position " + player.getPosition() + "\n");

                if(board.isWinningPosition(player.getPosition())) {
                    System.out.println(player.getName() + " won!");
                    gameWon = true;
                    break;
                }
            }
        }
    }
}

package week06assignment;

public class Week06wargame {

    public static void main(String[] args) {

        // 1. Create a deck and shuffle it
        Deck deck = new Deck();
        deck.shuffle();

        // 2. Create two players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // 3. Deal 26 cards to each player
        for (int i = 0; i < 26; i++) {
            player1.draw(deck);
            player2.draw(deck);
        }

        // Optional: show starting hands
        player1.describeHand();
        player2.describeHand();

        // 4. Play 26 rounds
        for (int i = 0; i < 26; i++) {
            Card card1 = player1.flip();
            Card card2 = player2.flip();

            System.out.print(player1.getName() + " plays ");
            card1.describe();

            System.out.print(player2.getName() + " plays ");
            card2.describe();

            if (card1.getValue() > card2.getValue()) {
                player1.incrementScore();
                System.out.println(player1.getName() + " wins the round!");
            } else if (card2.getValue() > card1.getValue()) {
                player2.incrementScore();
                System.out.println(player2.getName() + " wins the round!");
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("---------------------");
        }

        // 5. Print final scores
        System.out.println("Final Scores:");
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());

        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins the game!");
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println(player2.getName() + " wins the game!");
        } else {
            System.out.println("The game is a draw!");
        }
    }
}

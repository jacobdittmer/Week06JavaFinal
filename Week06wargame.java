package week06assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        // Show starting hands
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


// CARD CLASS

class Card {

    private int value;
    private String name;
    private String suit;

    public Card(int value, String name, String suit) {
        this.value = value;
        this.name = name;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public void describe() {
        System.out.println(name + " of " + suit + " (Value: " + value + ")");
    }
}


// DECK CLASS

class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck() {
        String[] names = {
            "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"
        };

        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };

        for (int i = 0; i < names.length; i++) {
            for (String suit : suits) {
                cards.add(new Card(i + 2, names[i], suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card draw() {
        return cards.remove(0);
    }
}


// PLAYER CLASS 

class Player {

    private String name;
    private List<Card> hand = new ArrayList<>();
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public void draw(Deck deck) {
        hand.add(deck.draw());
    }

    public Card flip() {
        return hand.remove(0);
    }

    public void incrementScore() {
        score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void describeHand() {
        System.out.println(name + "'s hand contains:");
        for (Card card : hand) {
            card.describe();
        }
        System.out.println("Score: " + score);
    }
}

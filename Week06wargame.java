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

        // 3. Deal 26 cards to each player using draw
        for (int i = 0; i < 26; i++) {
            player1.draw(deck);
            player2.draw(deck);
        }

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

    int value;
    String name;

    // Constructor
    public Card(int value, String name) {
        this.value = value;
        this.name = name;
    }

    // Getters and setters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Describe method
    public void describe() {
        System.out.println(name + " (Value: " + value + ")");
    }
}

// DECK CLASS
class Deck {

    List<Card> cards = new ArrayList<>();

    // Constructor: create 52 cards
    public Deck() {
        String[] names = {
            "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"
        };

        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < 4; j++) { // 4 suits
                cards.add(new Card(i + 2, names[i]));
            }
        }
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draw the top card
    public Card draw() {
        return cards.remove(0);
    }
}

// PLAYER CLASS
class Player {

    String name;
    List<Card> hand = new ArrayList<>();
    int score = 0;

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    // Draw a card from a deck
    public void draw(Deck deck) {
        hand.add(deck.draw());
    }

    // Flip the top card
    public Card flip() {
        return hand.remove(0);
    }

    // Increment score
    public void incrementScore() {
        score++;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Describe player and their hand
    public void describe() {
        System.out.println(name + "'s hand contains:");
        for (Card card : hand) {
            card.describe();
        }
        System.out.println("Score: " + score);
    }
   
}

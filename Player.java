package week06assignment;

import java.util.ArrayList;
import java.util.List;

public class Player {

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
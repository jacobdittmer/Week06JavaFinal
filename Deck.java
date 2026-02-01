package week06assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

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
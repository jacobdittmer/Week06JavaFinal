package week06assignment;

public class Card {

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
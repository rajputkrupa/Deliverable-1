/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package higherlowergame;

/**
 *
 * @author krupa
 */
public class Card {
    private String suit;
    private int value;

    public static final String[] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};

    public Card(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        String val;
        if (value == 11) val = "Jack";
        else if (value == 12) val = "Queen";
        else if (value == 13) val = "King";
        else if (value == 14) val = "Ace";
        else val = String.valueOf(value);
        return val + " of " + suit;
    }
}
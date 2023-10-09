/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package higherlowergame;

/**
 *
 * @author aarzoo,krupa,chirag
 Date: 09/10/23
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HigherLowerGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Card> deck = createDeck();
        Collections.shuffle(deck);

        int score = 0;

        while (true) {
            Card current = deck.get(0);
            System.out.println("Current: " + current);

            System.out.print("Predict 'H' for higher, 'L' for lower, or 'S' for same: ");
            String guess = in.nextLine().trim().toLowerCase();

            if (!guess.equals("h") && !guess.equals("l") && !guess.equals("s")) {
                System.out.println("Invalid input. Please choose 'H' for higher, 'L' for lower, or 'S' for same.");
                continue;
            }

            Card next = deck.get(1);
            System.out.println("Next: " + next);

            if ((guess.equals("h") && next.getValue() > current.getValue()) ||
                (guess.equals("l") && next.getValue() < current.getValue()) ||
                (guess.equals("s") && next.getValue() == current.getValue())) {
                System.out.println("You are Correct! Congratulations!");

                // Check if the selected card is the same as the one drawn
                if (next.getValue() == current.getValue() && next.getSuit().equals(current.getSuit())) {
                    System.out.println("Bingo! This is a lucky card!");
                }

                score++;
            } else {
                System.out.println("You're wrong! The game is over. Your score is: " + score);
                break;
            }

            deck.remove(0);
            deck.remove(0);

            if (deck.size() < 2) {
                deck = createDeck();
                Collections.shuffle(deck);
            }
        }

        in.close();
    }

    private static List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        for (String s : Card.SUITS) {
            for (int v = 2; v <= 14; v++) {
                deck.add(new Card(s, v));
            }
        }
        return deck;
    }
}

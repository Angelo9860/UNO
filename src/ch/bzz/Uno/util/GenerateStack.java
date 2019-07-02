package ch.bzz.Uno.util;


import ch.bzz.Uno.model.Card;

import java.awt.*;
import java.util.ArrayList;

public class GenerateStack {

    private ArrayList<Card> stack = new ArrayList<>();

    public  ArrayList<Card> generateStack() {

        generateCards();
        generateActionCards();
        return stack;
    }

    private void generateCards() {
        for (int i = 0; i < 10; i++) {
            Card card = new Card(String.valueOf(i), false, Color.blue, 0);
            stack.add(card);
        }
        for (int i = 1; i < 10; i++) {
            Card card = new Card(String.valueOf(i), false, Color.blue, 0);
            stack.add(card);
        }
        for (int i = 0; i < 10; i++) {
            Card card = new Card(String.valueOf(i), false, Color.yellow, 0);
            stack.add(card);
        }
        for (int i = 1; i < 10; i++) {
            Card card = new Card(String.valueOf(i), false, Color.yellow, 0);
            stack.add(card);
        }
        for (int i = 0; i < 10; i++) {
            Card card = new Card(String.valueOf(i), false, Color.red, 0);
            stack.add(card);
        }
        for (int i = 1; i < 10; i++) {
            Card card = new Card(String.valueOf(i), false, Color.red, 0);
            stack.add(card);
        }
        for (int i = 0; i < 10; i++) {
            Card card = new Card(String.valueOf(i), false, Color.green, 0);
            stack.add(card);
        }
        for (int i = 0; i < 10; i++) {
            Card card = new Card(String.valueOf(i), false, Color.green, 0);
            stack.add(card);
        }

    }

    private void generateActionCards() {
        stack.add(new Card("+2", true, Color.green, 1));
        stack.add(new Card("+2", true, Color.green, 1));
        stack.add(new Card("+2", true, Color.blue, 1));
        stack.add(new Card("+2", true, Color.blue, 1));
        stack.add(new Card("+2", true, Color.red, 1));
        stack.add(new Card("+2", true, Color.red, 1));
        stack.add(new Card("+2", true, Color.yellow, 1));
        stack.add(new Card("+2", true, Color.yellow, 1));

        stack.add(new Card("Reverse", true, Color.green, 2));
        stack.add(new Card("Reverse", true, Color.green, 2));
        stack.add(new Card("Reverse", true, Color.blue, 2));
        stack.add(new Card("Reverse", true, Color.blue, 2));
        stack.add(new Card("Reverse", true, Color.red, 2));
        stack.add(new Card("Reverse", true, Color.red, 2));
        stack.add(new Card("Reverse", true, Color.yellow, 2));
        stack.add(new Card("Reverse", true, Color.yellow, 2));

        stack.add(new Card("Skip", true, Color.green, 3));
        stack.add(new Card("Skip", true, Color.green, 3));
        stack.add(new Card("Skip", true, Color.blue, 3));
        stack.add(new Card("Skip", true, Color.blue, 3));
        stack.add(new Card("Skip", true, Color.red, 3));
        stack.add(new Card("Skip", true, Color.red, 3));
        stack.add(new Card("Skip", true, Color.yellow, 3));
        stack.add(new Card("Skip", true, Color.yellow, 3));

        stack.add(new Card("+4", true, Color.black, 4));
        stack.add(new Card("+4", true, Color.black, 4));
        stack.add(new Card("+4", true, Color.black, 4));
        stack.add(new Card("+4", true, Color.black, 4));
        stack.add(new Card("wish", true, Color.black, 5));
        stack.add(new Card("wish", true, Color.black, 5));
        stack.add(new Card("wish", true, Color.black, 5));
        stack.add(new Card("wish", true, Color.black, 5));


    }

}

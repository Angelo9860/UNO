package ch.bzz.Uno.util;


import ch.bzz.Uno.model.Card;

import java.awt.*;
import java.util.ArrayList;

public class GenerateStack {

    private ArrayList<Card> stack;

    public  ArrayList<Card> generateStack() {
        System.out.println(stack.size());

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
        stack.add(new Card("+2", false, Color.green, 1));
        stack.add(new Card("+2", false, Color.green, 1));
        stack.add(new Card("+2", false, Color.blue, 1));
        stack.add(new Card("+2", false, Color.blue, 1));
        stack.add(new Card("+2", false, Color.red, 1));
        stack.add(new Card("+2", false, Color.red, 1));
        stack.add(new Card("+2", false, Color.yellow, 1));
        stack.add(new Card("+2", false, Color.yellow, 1));

        stack.add(new Card("Reverse", false, Color.green, 2));
        stack.add(new Card("Reverse", false, Color.green, 2));
        stack.add(new Card("Reverse", false, Color.blue, 2));
        stack.add(new Card("Reverse", false, Color.blue, 2));
        stack.add(new Card("Reverse", false, Color.red, 2));
        stack.add(new Card("Reverse", false, Color.red, 2));
        stack.add(new Card("Reverse", false, Color.yellow, 2));
        stack.add(new Card("Reverse", false, Color.yellow, 2));

        stack.add(new Card("Skip", false, Color.green, 3));
        stack.add(new Card("Skip", false, Color.green, 3));
        stack.add(new Card("Skip", false, Color.blue, 3));
        stack.add(new Card("Skip", false, Color.blue, 3));
        stack.add(new Card("Skip", false, Color.red, 3));
        stack.add(new Card("Skip", false, Color.red, 3));
        stack.add(new Card("Skip", false, Color.yellow, 3));
        stack.add(new Card("Skip", false, Color.yellow, 3));

        stack.add(new Card("+4", false, Color.black, 4));
        stack.add(new Card("+4", false, Color.black, 4));
        stack.add(new Card("+4", false, Color.black, 4));
        stack.add(new Card("+4", false, Color.black, 4));
        stack.add(new Card("wish", false, Color.black, 5));
        stack.add(new Card("wish", false, Color.black, 5));
        stack.add(new Card("wish", false, Color.black, 5));
        stack.add(new Card("wish", false, Color.black, 5));


    }

}

package ch.bzz.Uno.test;

import ch.bzz.Uno.Validator.Validator;
import ch.bzz.Uno.controller.Controller;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Field;
import ch.bzz.Uno.model.Player;
import ch.bzz.Uno.util.GenerateStack;
import ch.bzz.Uno.util.ShuffleDeck;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControllerTest {
    Field field = new Field();
    Controller underTest = new Controller(field);
    GenerateStack stack = new GenerateStack();
    Card cardForTest1 = new Card("8", false, Color.blue, 0);
    Card cardForTest2 = new Card("8", false, Color.red, 0);
    Card cardForTest3 = new Card("5", false, Color.red, 0);
    Card cardForTest4 = new Card("9", false, Color.yellow, 0);
    Card  defaultCard = new Card("7", false, Color.red, 0);
    Card onStackCard = new Card("5", false, Color.blue, 0);
    Card actionCard = new Card("+2", true, Color.red, 1);
    Card skipCard = new Card("Skip", true, Color.red, 3);
    Player angelo = new Player("Angelo");
    Player nina =new Player("Nina");
    Validator validator = new Validator();

    @Test
    public void zahlenKarteAufgrundFarbeSpielbar() {
        field.setPlayer(angelo);
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(0).setHand(cardForTest1);
        field.getPlayers().get(0).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(onStackCard);
        assertEquals(true, underTest.layDownCardHasBeenPressed(cardForTest1, Color.pink));
        boolean isNotInHand = true;
        for (int i = 0; i < field.getPlayers().get(0).getHand().size(); i++) {
            if (field.getPlayers().get(0).getHand().get(i).equals(cardForTest1)) {
                isNotInHand = false;
            }
        }
        assertEquals(true, isNotInHand);
    }


    @Test
    public void zahlenKarteAufgrundFarbeNichtSpielbar() {
        field.setPlayer(angelo);
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(0).setHand(cardForTest2);
        field.getPlayers().get(0).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(onStackCard);
        assertEquals(false, underTest.layDownCardHasBeenPressed(cardForTest2, Color.pink));
        boolean isNotInHand = false;
        for (int i = 0; i < field.getPlayers().get(0).getHand().size(); i++) {
            if (field.getPlayers().get(0).getHand().get(i).equals(cardForTest1)) {
                isNotInHand = true;
            }
        }
        assertEquals(false, isNotInHand);
    }

    @Test
    public void karteLegenMitGleicherZahl(){
        field.setPlayer(angelo);
        field.setPlayer(nina);
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(0).setHand(cardForTest3);
        field.getPlayers().get(0).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(onStackCard);
        assertEquals(true, underTest.layDownCardHasBeenPressed(cardForTest3, Color.pink));
        underTest.nextHasBeenPressed();
        boolean isNotSamePlayer = true;
        for(int i = 0; i < field.getPlayers().size();i++){
            if(field.getCurrentlyPlaying().equals(angelo)){
                isNotSamePlayer = false;
            }
        }
        assertEquals(true, isNotSamePlayer);
    }

    @Test
    public void karteLegenMitFalscherZahl(){
        field.setPlayer(angelo);
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(0).setHand(cardForTest4);
        field.getPlayers().get(0).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(onStackCard);
        assertEquals(false, underTest.layDownCardHasBeenPressed(cardForTest4, Color.pink));
    }

    @Test
    public void legenEinerKartedesTestSpielers(){
        field.setPlayer(angelo);
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(0).setHand(cardForTest1);
        field.getPlayers().get(0).setHand(cardForTest2);
        field.getPlayers().get(0).setHand(cardForTest3);
        field.getPlayers().get(0).setHand(cardForTest4);
        field.getPlayers().get(0).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(onStackCard);
        int sizeBeforLayDown = field.getPlayers().get(0).getHand().size();
        assertEquals(true, underTest.layDownCardHasBeenPressed(cardForTest1, Color.pink));
        int sizeAfterLayDown = field.getPlayers().get(0).getHand().size();
        assertEquals(4, sizeAfterLayDown);
    }


    @Test
    public void eineKateVomStapelNehmen(){
        field.setPlayer(angelo);
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(0).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(onStackCard);
        assertEquals(Card.class, underTest.drawCardHasBeenPressed(angelo).getClass() );



    }
    /*Kann nicht wirklich getestet werden*/
   /* @Test
    public void keineKartenMehr(){
        field.setPlayer(angelo);
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(0).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(onStackCard);

    }*/

   //Methode wird nicht die Karte zurück geben sondern false, die Karte wird aber immer noch auf der Hand des
    //spielers sein.

    @Test
    public void spielerLegtUnspielbareKarte(){
        field.setPlayer(angelo);
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(0).setHand(cardForTest1);
        field.getPlayers().get(0).setHand(cardForTest2);
        field.getPlayers().get(0).setHand(cardForTest3);
        field.getPlayers().get(0).setHand(cardForTest4);
        field.getPlayers().get(0).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(onStackCard);
        assertEquals(false, underTest.layDownCardHasBeenPressed(defaultCard, Color.pink));
    }

    @Test
    public void gewinntRunde(){
        field.setPlayer(angelo);
        field.setPlayer(nina);
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(1).setHand(cardForTest1);
        field.getPlayers().get(1).setHand(cardForTest2);
        field.getPlayers().get(1).setHand(cardForTest3);
        field.getPlayers().get(1).setHand(cardForTest4);
        field.getPlayers().get(1).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(onStackCard);
        underTest.calculatePoints();
        assertEquals(30, angelo.getPoints());
    }
    @Test
    public void istAktionKarte(){
        field.setOnFieldStack(defaultCard);
        assertEquals(true, validator.checkCard(actionCard, defaultCard));

    }

    @Test
    public void überprüfungWelcheActionKarte(){

        field.setPlayer(angelo);
        field.setPlayer(nina);
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.getPlayers().get(1).setHand(cardForTest1);
        field.getPlayers().get(1).setHand(cardForTest2);
        field.getPlayers().get(1).setHand(cardForTest3);
        field.getPlayers().get(1).setHand(cardForTest4);
        field.getPlayers().get(1).setHand(defaultCard);
        field.setFirstCard();
        field.setOnFieldStack(defaultCard);
        underTest.layDownCardHasBeenPressed(skipCard, Color.pink);
        assertEquals(true, underTest.isSkip());
    }

    /* 13 14 konnten nicht gemacht werden.*/


}

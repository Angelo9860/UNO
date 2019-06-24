package ch.bzz.Uno.controller;

import ch.bzz.Uno.Validator.Validator;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Field;
import ch.bzz.Uno.model.Player;
import ch.bzz.Uno.util.GenerateStack;
import ch.bzz.Uno.util.PointsTable;


public class Controller {
    private Field field;
    public Validator validator;

    public Controller() {
        validator = new Validator();
    }

    public void drawCard() {
        Player player = field.getCurrentlyPlaying();
        player.setHand(field.drawCard());
    }

    public void layDownACard(Card card) {
        validator.checkCard(card, field.getCurrentCard());
    }

    public void hasPressedUno() {
        validator.checkUno(field.getCurrentlyPlaying());
    }

    public void hasPressedNext() {

        if (field.getCurrentlyPlaying().getHand().size() == 1) {
            if (validator.getUnoStatus()) {
                field.setCurrentlyPlaying(field.getPlayers().get(field.getCurrentlyPlaying().getId() + 1));
            } else {
                //TODO: Check how many cards should be drawn
                field.drawCard();
                field.drawCard();
                field.drawCard();
                field.drawCard();
            }
        }
    }

    public void playerHasWonARound() {
        /*security measure*/
        if (field.getCurrentlyPlaying().getHand().size() == 0) {
            //TODO: define what has to be done when Player wins a Round
            field.setPlayers(PointsTable.calculatePoints(field.getPlayers(), field.getCurrentlyPlaying()));
        }
    }

    //Todo: define what happens when player wins the game
    public void playerHasWonTheGame() {
        if (field.getCurrentlyPlaying().getPoints() >= 500) {

        }
    }

    public void addPlayerHasBeenPressed(String name){
        Player player = new Player(name);
        field.setPlayer(player);
    }

    public void startGameHasBeenPressed(){
        field.setStack(GenerateStack.generateStack());
        field.handOutCards();
        field.setFirstCard();
    }

    public void setField(Field field) {
        this.field = field;
    }
}

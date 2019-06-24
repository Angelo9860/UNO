package ch.bzz.Uno.controller;

import ch.bzz.Uno.Validator.Validator;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Field;
import ch.bzz.Uno.model.Player;


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
    public void setField(Field field){
        this.field = field;
    }

    public void layDownACard(Card card) {
        validator.checkCard(card, field.getCurrentCard());
    }

    public void hasPressedUno(){
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
}

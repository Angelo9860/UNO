package ch.bzz.Uno.controller;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.Validator.Validator;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Field;
import ch.bzz.Uno.model.Player;
import ch.bzz.Uno.util.GenerateStack;
import ch.bzz.Uno.util.PointsTable;


public class Controller implements ControllerInterface {
    private Field field;
    private Validator validator;
    private GenerateStack stack = new GenerateStack();

    public Controller(Field field) {
        this.field = field;
        validator = new Validator();
    }

    public void drawCard() {
        Player player = field.getCurrentlyPlaying();
        player.setHand(field.drawCard());
    }

    public void layDownACard(Card card) {
        setField(validator.checkCard(card, field.getCurrentCard(), field));
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
        }else{
            field.setCurrentlyPlaying(field.getPlayers().get(field.getCurrentlyPlaying().getId() + 1));
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
    @Override
    public void addPlayerHasBeenPressed(String name){

        Player player = new Player(name);
        System.out.println(player.getUserName());
        field.setPlayer(player);
        System.out.println("In the list" +field.getPlayers().get(0).getUserName());
    }

    public void startGameHasBeenPressed(){
        field.setStack(stack.generateStack());
        field.handOutCards();
        field.setFirstCard();
    }

    public void setField(Field field) {
        this.field = field;
    }
}

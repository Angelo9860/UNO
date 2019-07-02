package ch.bzz.Uno.controller;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.Validator.Validator;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Field;
import ch.bzz.Uno.model.Player;
import ch.bzz.Uno.util.GenerateStack;
import ch.bzz.Uno.util.PointsTable;
import ch.bzz.Uno.util.ShuffleDeck;

import java.util.ArrayList;


public class Controller implements ControllerInterface {
    private Field field;
    private Validator validator;
    private GenerateStack stack = new GenerateStack();
    private ShuffleDeck shuffler = new ShuffleDeck();

    public Controller(Field field) {
        this.field = field;
        validator = new Validator();
    }
    //TODO: define what has to be done when Player wins a Round
    public void playerHasWonARound() {
        /*security measure*/
        if (field.getCurrentlyPlaying().getHand().size() == 0) {
            field.setPlayers(PointsTable.calculatePoints(field.getPlayers(), field.getCurrentlyPlaying()));
        }
    }

    //Todo: define what happens when player wins the game
    public void playerHasWonTheGame() {
        if (field.getCurrentlyPlaying().getPoints() >= 500) {

        }
    }

    @Override
    public void addPlayerHasBeenPressed(String name) {

        Player player = new Player(name);
        field.setPlayer(player);
    }

    @Override
    public void startGameHasBeenPressed() {
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setDrawStack(stack.generateStack());
        ArrayList<Card> stacker = field.getDrawStack();
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.handOutCards();
        field.setFirstCard();
    }

    @Override
    public Card drawCardHasBeenPressed(Player p) {
    return field.getPlayers().get(p.getId()).setHand(field.drawCard());
    }

    //TODO:REVALIDATE FUNCTIONALITY
    @Override
    public boolean layDownCardHasBeenPressed(Card card) {
        if (validator.checkCard(card, field.getCurrentCard())) {
            removeSetCardFromPlayerHand(card);
            field.setOnFieldStack(card);
           return true;
        } else {
            return false;
        }
    }

    @Override
    public void unoHasBeenPressed() {
        validator.checkUno(field.getCurrentlyPlaying());
    }

    @Override
    public void nextHasBeenPressed() {
        if (field.getCurrentlyPlaying().getHand().size() == 1) {
            if (validator.getUnoStatus()) {
                if (field.getCurrentlyPlaying().getId() == field.getPlayers().size()-1) {
                    field.setCurrentlyPlaying(field.getPlayers().get(0));
                }else{
                    field.setCurrentlyPlaying(field.getPlayers().get(field.getCurrentlyPlaying().getId() + 1));
                    if(validator.getDrawCard() != 0){
                        for (int i = 0; i != validator.getDrawCard(); i++) {
                            field.getCurrentlyPlaying().setHand(field.drawCard());
                        }
                    }
                }
            } else {
                field.getPlayers().get(getCurrentlyPlaying().getId()).setHand(field.drawCard());
                field.getPlayers().get(getCurrentlyPlaying().getId()).setHand(field.drawCard());
            }
        } else {

            if(field.getCurrentlyPlaying().getId() == field.getPlayers().size()-1){
                field.setCurrentlyPlaying(field.getPlayers().get(0));

                if (validator.getDrawCard() != 0) {
                    for (int i = 0; i != validator.getDrawCard(); i++) {
                        field.getCurrentlyPlaying().setHand(field.drawCard());
                    }
                }
            }else {
                field.setCurrentlyPlaying(field.getPlayers().get(field.getCurrentlyPlaying().getId() + 1));
                if (validator.getDrawCard() != 0) {
                    for (int i = 0; i != validator.getDrawCard(); i++) {
                        field.getCurrentlyPlaying().setHand(field.drawCard());
                    }
                }
            }

        }
        validator.reset();
    }

    public Card cardOnField() {
        return field.getCurrentCard();
    }

    private void removeSetCardFromPlayerHand(Card card) {
        field.getPlayers().get(field.getCurrentlyPlaying().getId()).removeCard(card);
    }

    public Player getCurrentlyPlaying() {
        return field.getCurrentlyPlaying();
    }
}

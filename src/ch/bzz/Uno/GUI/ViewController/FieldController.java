package ch.bzz.Uno.GUI.ViewController;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

import java.awt.*;


public class FieldController implements ControllerInterface {
    @Override
    public void addPlayerHasBeenPressed(String name) {

    }

    @Override
    public Color getWishColor(){
        return controller.getWishColor();
    }

    @Override
    public void startGameHasBeenPressed() {

    }

    public void calculatePoints(){
        controller.calculatePoints();
    }

    @Override
    public Card drawCardHasBeenPressed(Player p) {
    return controller.drawCardHasBeenPressed(p);
    }

    @Override
    public boolean layDownCardHasBeenPressed(Card card, Color wishColorString) {
        return controller.layDownCardHasBeenPressed(card, wishColorString);
    }
    @Override
    public Card cardOnField(){
        return controller.cardOnField();
    }

    @Override
    public void resetWishColor() {
        controller.resetWishColor();
    }

    @Override
    public void unoHasBeenPressed() {
controller.unoHasBeenPressed();
    }

    @Override
    public void nextHasBeenPressed() {
controller.nextHasBeenPressed();
    }

    public Player getPlayer() {
        return controller.getCurrentlyPlaying();
    }


}

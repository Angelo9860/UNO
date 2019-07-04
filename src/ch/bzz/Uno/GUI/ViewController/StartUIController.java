package ch.bzz.Uno.GUI.ViewController;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

import java.awt.*;

public class StartUIController implements ControllerInterface {


    @Override
    public Color getWishColor() {
        return null;
    }

    @Override
    public void addPlayerHasBeenPressed(String name) {
        controller.addPlayerHasBeenPressed(name);
    }

    @Override
    public void startGameHasBeenPressed() {
        controller.startGameHasBeenPressed();
    }

    @Override
    public Card drawCardHasBeenPressed(Player p) {
        return null;
    }

    @Override
    public boolean layDownCardHasBeenPressed(Card card, Color wishColorString) {
        return controller.layDownCardHasBeenPressed(card, wishColorString);
    }

    @Override
    public void unoHasBeenPressed() {
        controller.unoHasBeenPressed();
    }

    public void nextHasBeenPressed(){
        controller.nextHasBeenPressed();
    }

    @Override
    public Card cardOnField() {
        return null;
    }

    @Override
    public void resetWishColor() {

    }
}

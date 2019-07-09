package ch.bzz.Uno.GUI.ViewController;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.controller.Controller;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

import java.awt.*;
import java.util.ArrayList;

public class PointsUIController implements ControllerInterface {

    @Override
    public Color getWishColor() {
        return null;
    }

    @Override
    public void addPlayerHasBeenPressed(String name) {

    }

    @Override
    public void startGameHasBeenPressed() {

    }

    @Override
    public Card drawCardHasBeenPressed(Player p) {
        return null;
    }

    @Override
    public boolean layDownCardHasBeenPressed(Card card, Color wishColorString) {
        return false;
    }

    @Override
    public void unoHasBeenPressed() {

    }

    @Override
    public void nextHasBeenPressed() {

    }

    @Override
    public Card cardOnField() {
        return null;
    }

    @Override
    public void resetWishColor() {

    }

    public ArrayList<Player> getPlayers(){
        return controller.getPlayers();
    }
    public Player getPlayer() {
        return controller.getCurrentlyPlaying();
    }

}

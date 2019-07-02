package ch.bzz.Uno.GUI.ViewController;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

public class FieldController implements ControllerInterface {
    @Override
    public void addPlayerHasBeenPressed(String name) {

    }

    @Override
    public void startGameHasBeenPressed() {

    }

    @Override
    public Card drawCardHasBeenPressed(Player p) {
    return controller.drawCardHasBeenPressed(p);
    }

    @Override
    public boolean layDownCardHasBeenPressed(Card card) {
        return controller.layDownCardHasBeenPressed(card);
    }
    @Override
    public Card cardOnField(){

        return controller.cardOnField();
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

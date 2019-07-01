package ch.bzz.Uno.GUI.viewController;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

public class SpielbrettController implements ControllerInterface {
    @Override
    public void addPlayerHasBeenPressed(String name) {

    }

    @Override
    public void startGameHasBeenPressed() {

    }

    @Override
    public void drawCardHasBeenPressed() {

    }

    @Override
    public void layDownCardHasBeenPressed(Card card) {

    }

    @Override
    public void unoHasBeenPressed() {

    }

    @Override
    public void nextHasBeenPressed() {

    }

    public Player getPlayer(){
        return controller.getCurrentlyPlaying();
    }
}

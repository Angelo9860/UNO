package ch.bzz.Uno.GUI.ViewController;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

public class StartUIController implements ControllerInterface {


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
    public boolean layDownCardHasBeenPressed(Card card) {
        return controller.layDownCardHasBeenPressed(card);
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
}

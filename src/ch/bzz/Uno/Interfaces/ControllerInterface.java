package ch.bzz.Uno.Interfaces;

import ch.bzz.Uno.controller.Controller;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Field;
import ch.bzz.Uno.model.Player;
import ch.bzz.Uno.util.GenerateStack;

public interface ControllerInterface {
    Field field = new Field();
    Controller controller = new Controller(field);
    void addPlayerHasBeenPressed(String name);
    void startGameHasBeenPressed();
    Card drawCardHasBeenPressed(Player p);
    boolean layDownCardHasBeenPressed(Card card);
    void unoHasBeenPressed();
    void nextHasBeenPressed();
    Card cardOnField();
}

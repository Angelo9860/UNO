package ch.bzz.Uno.GUI.ViewController;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.model.Card;

public class StartUIController implements ControllerInterface {


    @Override
    public void addPlayerHasBeenPressed(String name) {
        System.out.println("Hello World Controller View");
        controller.addPlayerHasBeenPressed(name);
    }

    @Override
    public void startGameHasBeenPressed() {
        controller.startGameHasBeenPressed();
    }


    @Override
    public void drawCardHasBeenPressed() {
        controller.drawCardHasBeenPressed();
    }


    @Override
    public void layDownCardHasBeenPressed(Card card) {
        controller.layDownCardHasBeenPressed(card);
    }

    @Override
    public void unoHasBeenPressed() {
        controller.unoHasBeenPressed();
    }

    public void nextHasBeenPressed(){
        controller.nextHasBeenPressed();
    }
}

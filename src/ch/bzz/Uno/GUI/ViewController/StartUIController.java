package ch.bzz.Uno.GUI.ViewController;

import ch.bzz.Uno.Interfaces.ControllerInterface;
public class StartUIController implements ControllerInterface {


    @Override
    public void addPlayerHasBeenPressed(String name) {
        System.out.println("Hello World Controller View");
        controller.addPlayerHasBeenPressed(name);
    }
}

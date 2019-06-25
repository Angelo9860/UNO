package ch.bzz.Uno.Interfaces;

import ch.bzz.Uno.controller.Controller;
import ch.bzz.Uno.model.Field;
import ch.bzz.Uno.util.GenerateStack;

public interface ControllerInterface {
    Field field = new Field();
    Controller controller = new Controller(field);

     void addPlayerHasBeenPressed(String name);
}

package ch.bzz.Uno.controller;

import ch.bzz.Uno.Interfaces.ControllerInterface;
import ch.bzz.Uno.Validator.Validator;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Field;
import ch.bzz.Uno.model.Player;
import ch.bzz.Uno.util.GenerateStack;
import ch.bzz.Uno.util.PointsTable;
import ch.bzz.Uno.util.ShuffleDeck;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author : Angelo Lachnit
 * @version : 1.0
 */

public class Controller implements ControllerInterface {
    private Field field;
    private Validator validator;
    private PointsTable points = new PointsTable();
    private GenerateStack stack = new GenerateStack();
    private ShuffleDeck shuffler = new ShuffleDeck();
    private Color wished = Color.pink;
    private boolean wish = false;
    private boolean reverse = false;
    private boolean skip = false;
    private int toSkip = 0;
    private static Color defaultColor = new Color(238, 238, 238);


    public Controller(Field field) {
        this.field = field;
        validator = new Validator();
    }

    //Todo: define what happens when player wins the game
    public void playerHasWonTheGame() {
        if (field.getCurrentlyPlaying().getPoints() >= 500) {

        }
    }

    @Override
    /**
     * @param name name of the Player
     */
    public void addPlayerHasBeenPressed(String name) {

        Player player = new Player(name);
        field.setPlayer(player);
    }

    @Override
    public void startGameHasBeenPressed() {
        field.setDrawStack(ShuffleDeck.shuffleDeck(stack.generateStack()));
        field.setDrawStack(stack.generateStack());
        ArrayList<Card> stacker = field.getDrawStack();
        field.setCurrentlyPlaying(field.getPlayers().get(0));
        field.handOutCards();
        field.setFirstCard();
    }

    @Override
    /**
     * @param p Is the player whoms turn it is
     * @return Returns a card which has been drawn
     */
    public Card drawCardHasBeenPressed(Player p) {
        setSkip(false);
        return field.getPlayers().get(p.getId()).setHand(field.drawCard());
    }

    //TODO:REVALIDATE FUNCTIONALITY
    @Override
    /**
     * @param card The card which the player wants to lay down
     * @param wishColor Default is pink. If a player wishes a color it will be the color that has been wished
     * @return is a boolean if the card was valid. Valid: true. Invalid: false
     */

    public boolean layDownCardHasBeenPressed(Card card, Color wishColor) {
        if (isWish()) {
            if (validator.checkCard(card, field.getCurrentCard(), wished)) {
                removeSetCardFromPlayerHand(card);
                field.setOnFieldStack(card);
                wished = Color.pink;
                setWish(false);
                return true;
            } else {
                return false;
            }
        } /*else if (isReverse()) {
            setReverse(validator.isReverse());
            return true;

        } */else {
            wished = wishColor;
            if (validator.checkCard(card, field.getCurrentCard())) {
                removeSetCardFromPlayerHand(card);
                field.setOnFieldStack(card);
                setWish(validator.isWish());
                System.out.println("Validator: " + validator.isWish());
                System.out.println("Controller: " + isWish());
                if (validator.isSkip()) {
                    setSkip(true);
                    setToSkip(1);
                } else {
                    setSkip(false);
                    setToSkip(0);
                }
                System.out.println("Skip: " + getToSkip());
                setReverse(validator.isReverse());
                System.out.println("Reverse Controller: " + isReverse());
                System.out.println("Reverse Validator: " + validator.isReverse());
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void resetWishColor() {
        wished = Color.pink;
    }

    @Override
    public void unoHasBeenPressed() {
        validator.checkUno(field.getCurrentlyPlaying());
    }

    @Override
    public void nextHasBeenPressed() {
        if (field.getCurrentlyPlaying().getHand().size() == 1) {
            if (!validator.getUnoStatus()) {
                field.getPlayers().get(getCurrentlyPlaying().getId()).setHand(field.drawCard());
                field.getPlayers().get(getCurrentlyPlaying().getId()).setHand(field.drawCard());
            }
        }
        setNextPlayer();
        if (isSkip()) {
            setNextPlayer();
        }

        if (validator.getDrawCard() != 0) {
            for (int i = 0; i != validator.getDrawCard(); i++) {
                field.getCurrentlyPlaying().setHand(field.drawCard());
            }
        }
        validator.reset();
        setToSkip(0);
    }

    @Override
    /**
     * @return returns the wished color
     */
    public Color getWishColor() {
        return wished;
    }

    /**
     * @return
     */
    public Card cardOnField() {
        return field.getCurrentCard();
    }

    private void setNextPlayer() {
        if(isReverse()){
            if(field.getCurrentlyPlaying().getId() == 0){
                field.setCurrentlyPlaying(field.getPlayers().get(field.getPlayers().size()-1));
            }else{
                field.setCurrentlyPlaying(field.getPlayers().get(field.getCurrentlyPlaying().getId() - 1));
            }
        }else{
            if (field.getCurrentlyPlaying().getId() == field.getPlayers().size() - 1) {
                field.setCurrentlyPlaying(field.getPlayers().get(0));
            } else {
                field.setCurrentlyPlaying(field.getPlayers().get(field.getCurrentlyPlaying().getId() + 1));
            }
        }

    }

    private void removeSetCardFromPlayerHand(Card card) {
        field.getPlayers().get(field.getCurrentlyPlaying().getId()).removeCard(card);
    }

    public ArrayList<Player> getPlayers(){
        return field.getPlayers();
    }

    public void calculatePoints(){
        field.setPlayers(points.calculatePoints(field.getPlayers(), getCurrentlyPlaying()));

        resetAllFlags();
    }

    public void resetAllFlags(){
        validator.reset();
        setSkip(false);
        setWish(false);
        setReverse(false);
        setToSkip(0);
        resetWishColor();
    }


    public Player getCurrentlyPlaying() {
        return field.getCurrentlyPlaying();
    }

    public boolean isWish() {
        return wish;
    }

    public void setWish(boolean wish) {
        this.wish = wish;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public int getToSkip() {
        return toSkip;
    }

    public void setToSkip(int i) {
        toSkip = i;
    }
}

package ch.bzz.Uno.Validator;

import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

import java.awt.*;


/**
 * @author : Angelo Lachnit
 * @version : 1.0
 * @description: Validates the card which he wants to laydown
 */

public class Validator {

    private boolean unoStatus = false;
    private int drawCard = 0;
    private boolean reverse;
    private boolean skip;
    private boolean wish;

    /**
     *
     * @param toLayDownCard the card which the player wants to laydown
     * @param onStackCard the card on the top of the stack
     * @return returns a boolean value if the action was valid or not
     */

    public boolean checkCard(Card toLayDownCard, Card onStackCard) {
        if (toLayDownCard.isActionCard()) {
            return checkAction(toLayDownCard, onStackCard);
        } else if (regularCheck(toLayDownCard, onStackCard)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param toLayDownCard the card which the player wants to laydown
     * @param onStackCard the card on the top of the stack
     * @param wished the color that has been wished
     * @return returns a boolean value if the action was valid or not
     *
     */
    public boolean checkCard(Card toLayDownCard, Card onStackCard, Color wished) {
            return checkAfterActionCard(toLayDownCard, onStackCard, wished);
    }

    /**
     *
     * @param toLayDownCard the card which the player wants to laydown
     * @param onStackCard the card on the top of the stack
     * @param wished the color that has been wished
     * @return returns a boolean value if the action was valid or not
     */
    private boolean checkAfterActionCard(Card toLayDownCard, Card onStackCard, Color wished) {
        if(toLayDownCard.getColor() == wished){
            setWish(false);
            if(toLayDownCard.isActionCard()){
                checkAction(toLayDownCard, onStackCard);
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     *
     * @param player checks if this player has a uno
     */
    public void checkUno(Player player) {
        unoStatus = player.getHand().size() == 1;
    }

    /**
     *
     * @param toLayDownCard the card which the player wants to laydown
     * @param onStackCard the card on the top of the stack
     * @return returns a boolean value if the action was valid or not
     */
    public boolean checkAction(Card toLayDownCard, Card onStackCard) {
        int action = toLayDownCard.getAction();
        if (action == 1 && (onStackCard.getColor().equals(toLayDownCard.getColor()) || onStackCard.getValue().equals(toLayDownCard.getValue()) || onStackCard.getColor().equals(Color.black))) {
            //+2
            setDrawCard(2);
            return true;
        }

        if (action == 2 && (onStackCard.getColor().equals(toLayDownCard.getColor()) || onStackCard.getValue().equals(toLayDownCard.getValue()) || onStackCard.getColor().equals(Color.black))) {
            //Reverse
            if(isReverse()){
                setReverse(false);
            }else{
                setReverse(true);
            }
            return true;
        }
        if (action == 3 && (onStackCard.getColor().equals(toLayDownCard.getColor()) || onStackCard.getValue().equals(toLayDownCard.getValue()) || onStackCard.getColor().equals(Color.black))) {
            //skip
            setSkip(true);
            return true;
        }
        if (action == 4) {
            //+4
            System.out.println("is 4");
            setDrawCard(4);
            setWish(true);
            return true;
        }
        if (action == 5) {
            System.out.println("is 5");
            setWish(true);
            return true;
        }
        return false;
    }

    /**
     *
     * @param toLayDownCard the card which the player wants to laydown
     * @param onStackCard the card on the top of the stack
     * @return returns a boolean value if the action was valid or not
     */
    private boolean regularCheck(Card toLayDownCard, Card onStackCard) {

        if (toLayDownCard.getColor() == onStackCard.getColor() || toLayDownCard.getValue().equals(onStackCard.getValue())) {
            return true;
        }
        return false;
    }

    /**
     * description resets all the flags
     */
    public void reset() {
        setWish(false);
        setDrawCard(0);
        setSkip(false);
        setUnoStatus(false);

    }

    public boolean getUnoStatus() {
        return unoStatus;
    }

    public void setUnoStatus(boolean b) {
        unoStatus = b;
    }

    public void setDrawCard(int i) {
        drawCard = i;
    }

    public int getDrawCard() {
        return drawCard;
    }

    public void setReverse(boolean b) {
        reverse = b;
    }

    public boolean isReverse() {
        return reverse;
    }

    public void setSkip(boolean b) {
        skip = b;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setWish(boolean b) {
        wish = b;
    }

    public boolean isWish() {
        return wish;
    }
}

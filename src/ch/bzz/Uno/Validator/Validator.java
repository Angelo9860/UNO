package ch.bzz.Uno.Validator;

import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

public class Validator {

    private boolean unoStatus = false;
    private int drawCard = 0;
    private boolean reverse = false;
    private boolean skip = false;
    private boolean wish = false;

    public boolean checkCard(Card toLayDownCard, Card onStackCard) {
        if (toLayDownCard.isActionCard()) {
            return checkAction(toLayDownCard, onStackCard);
        } else if (regularCheck(toLayDownCard, onStackCard)) {
            return true;
        } else {
            return false;
        }
    }

    public void checkUno(Player player) {
        unoStatus = player.getHand().size() == 1;
    }

    public boolean checkAction(Card toLayDownCard, Card onStackCard) {
        int action = toLayDownCard.getAction();
        if (action == 1 && (onStackCard.getColor().equals(toLayDownCard.getColor()) || onStackCard.getValue().equals(toLayDownCard.getValue()))) {
            //+2
            setDrawCard(2);
            return true;
        }

        if (action == 2 && (onStackCard.getColor().equals(toLayDownCard.getColor()) || onStackCard.getValue().equals(toLayDownCard.getValue()))) {
            //Reverse
            setReverse(true);
            return true;
        }
        if (action == 3 && (onStackCard.getColor().equals(toLayDownCard.getColor()) || onStackCard.getValue().equals(toLayDownCard.getValue()))) {
            //skip
            setSkip(true);
            return true;
        }
        if (action == 4) {
            //+4
            setDrawCard(4);
            setWish(true);
            return true;
            //TODO: Find a way to set and get the color
            //field.setWishColor(color);
        }
        if (action == 5) {
            //wish
            //TODO: Find a way to set and get the color
            setWish(true);
            return true;
            //field.setWishColor(color);
        }
        return false;
    }

    private boolean regularCheck(Card toLayDownCard, Card onStackCard) {

        if (toLayDownCard.getColor() == onStackCard.getColor() || toLayDownCard.getValue().equals(onStackCard.getValue())) {
            return true;
        }
        return false;
    }

    public void reset() {
        setWish(false);
        setDrawCard(0);
        setReverse(false);
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

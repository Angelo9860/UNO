package ch.bzz.Uno.Validator;

import ch.bzz.Uno.model.ActionCard;
import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

import javax.swing.*;

public class Validator {

    private boolean unoStatus;

    public boolean checkCard(Card toLayDownCard, Card onStackCard) {
            cardIsValid(toLayDownCard, onStackCard);
        return false;
    }

    public void checkUno(Player player){
        unoStatus = player.getHand().size() == 1;
    }


    public boolean checkAction(Card toLayDownCard) {
        int action = toLayDownCard.getAction();
        if (action == 1) {
            //+2
            return true;
        }

        if (action == 2) {
            //+2
            return true;
        }
        if (action == 3) {
            //+2
            return true;
        }
        if (action == 4) {
            //+2
            return true;
        }
        if (action == 5) {
            //+2
            return true;
        }
        else if(!(toLayDownCard.getAction() == 1 && toLayDownCard.getAction() == 2 && toLayDownCard.getAction() == 3 && toLayDownCard.getAction() == 4 && toLayDownCard.getAction() == 5)){
            return false;
        }
        return false;
    }

    public boolean cardIsValid(Card toLayDownCard, Card onStackCard) {
        if(toLayDownCard.getColor() == onStackCard.getColor() || toLayDownCard.getValue().equals(onStackCard.getValue())){
            return true;
        }else{
            checkAction(toLayDownCard);

        }
        return false;
    }

    public boolean getUnoStatus() {
        return unoStatus;
    }
}

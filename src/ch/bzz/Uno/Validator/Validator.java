package ch.bzz.Uno.Validator;

import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Field;
import ch.bzz.Uno.model.Player;

public class Validator {

    private boolean unoStatus;

    public Field checkCard(Card toLayDownCard, Card onStackCard, Field field) {
        return cardIsValid(toLayDownCard, onStackCard, field);
    }

    public void checkUno(Player player){
        unoStatus = player.getHand().size() == 1;
    }


    public Field checkAction(Card toLayDownCard, Field field) {
        Field newField = field;
        int action = toLayDownCard.getAction();
        if (action == 1) {
            newField.setDrawCards(2);
        }

        if (action == 2) {
            //+2
            newField.setReverse(true);
        }
        if (action == 3) {
            //+2
            newField.setSkip(true);
        }
        if (action == 4) {
            //+2
            newField.setDrawCards(4);
            newField.setHasWish(true);
            //TODO: Find a way to set and get the color
            //field.setWishColor(color);
        }
        if (action == 5) {
            //+2
            //TODO: Find a way to set and get the color
            newField.setHasWish(true);
            //field.setWishColor(color);
        }
        else if(!(toLayDownCard.getAction() == 1 && toLayDownCard.getAction() == 2 && toLayDownCard.getAction() == 3 && toLayDownCard.getAction() == 4 && toLayDownCard.getAction() == 5)){
            return null;
        }
        return newField;
    }

    public Field cardIsValid(Card toLayDownCard, Card onStackCard, Field field) {
        if(toLayDownCard.getColor() == onStackCard.getColor() || toLayDownCard.getValue().equals(onStackCard.getValue())){
            return field;
        }else{
            return checkAction(toLayDownCard, field);
        }
    }

    public boolean getUnoStatus() {
        return unoStatus;
    }
}

package ch.bzz.Uno.util;
import ch.bzz.Uno.model.Card;
import java.util.ArrayList;
import java.util.Collections;
public class ShuffleDeck {


    /**
     *
     * @param cardsToShuffle cards to shuffle
     * @return returns a shuffled stack
     */
    public static ArrayList<Card> shuffleDeck(ArrayList<Card> cardsToShuffle){
        ArrayList<Card> shuffeled = cardsToShuffle;
        Collections.shuffle(cardsToShuffle);

        return shuffeled;
    }
}

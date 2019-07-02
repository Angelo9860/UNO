package ch.bzz.Uno.util;
import ch.bzz.Uno.model.Card;
import java.util.ArrayList;
import java.util.Collections;
public class ShuffleDeck {



    public static ArrayList<Card> shuffleDeck(ArrayList<Card> cardsToShuffle){
        ArrayList<Card> shuffeled = cardsToShuffle;
        Collections.shuffle(cardsToShuffle);
        return shuffeled;
    }
}

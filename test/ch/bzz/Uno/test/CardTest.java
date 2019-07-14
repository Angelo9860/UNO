package ch.bzz.Uno.test;

import ch.bzz.Uno.model.Card;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CardTest {

    @Test
    public void getValueThatWillPass(){
        Card underTest = new Card("8", false, Color.blue, 0);
        assertEquals("8", underTest.getValue());
    }


    @Test
    public void getValueThatWillNotPass(){
        Card underTest = new Card("8", false, Color.blue, 0);
        assertNotEquals("9", underTest.getValue());
    }

    @Test
    public void getIsActionCardThatWillPass(){
        Card underTest = new Card("8", false, Color.blue, 0);
        assertEquals(false, underTest.isActionCard());
    }

    @Test
    public void getIsActionCardThatWillNotPass(){
        Card underTest = new Card("8", false, Color.blue, 0);
        assertNotEquals(true, underTest.isActionCard());
    }


    @Test
    public void getColorThatWillPass(){
        Card underTest = new Card("8", false, Color.blue, 0);
        assertEquals(Color.blue, underTest.getColor());
    }

    @Test
    public void getColorThatWillNotPass(){
        Card underTest = new Card("8", false, Color.blue, 0);
        assertNotEquals(Color.black, underTest.getColor());
    }

    @Test
    public void getActionThatWillPass(){
        Card underTest = new Card("8", false, Color.blue, 0);
        assertEquals(0, underTest.getAction());
    }

    @Test
    public void getActionThatWillNotPass(){
        Card underTest = new Card("8", false, Color.blue, 0);
        assertNotEquals(1, underTest.getAction());
    }



}
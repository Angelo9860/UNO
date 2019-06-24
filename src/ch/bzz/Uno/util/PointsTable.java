package ch.bzz.Uno.util;

import ch.bzz.Uno.model.Card;
import ch.bzz.Uno.model.Player;

import java.util.ArrayList;

public class PointsTable {

    public PointsTable(){

    }
    public static ArrayList<Player> calculatePoints(ArrayList<Player> players, Player wonRound){
        for(int i = 0; i < players.size(); i++){
            if(wonRound.getId() != players.get(i).getId()){
                ArrayList<Card> handOfPlayerThatLost = players.get(i).getHand();
                for(int x = 0; x < handOfPlayerThatLost.size(); x++){
                    String value = handOfPlayerThatLost.get(x).getValue();
                    if(value.equals("+2") || value.equals("Reverse") || value.equals("Skip")){
                        wonRound.setPoints(20);
                    }else if(value.equals("+4") || value.equals("wish")){
                        wonRound.setPoints(50);
                    }else{
                        wonRound.setPoints(Integer.parseInt(value));
                    }

                }
            }

        }
        players.set(wonRound.getId(), wonRound);
        return players;
    }


}

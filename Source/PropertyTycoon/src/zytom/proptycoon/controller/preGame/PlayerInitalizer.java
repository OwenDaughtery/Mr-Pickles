package zytom.proptycoon.controller.preGame;

import zytom.proptycoon.model.Player;

import java.util.ArrayList;


public class PlayerInitalizer {

    private ArrayList<Player> players;
    private ArrayList<Player.TokenType> takenTokens;
    private int numOfPlayers;
    

    public PlayerInitalizer(){
        players = new ArrayList<>();
        numOfPlayers = 0;
    }

    public void createPlayer(String name, Player.TokenType tokenType){
        if(numOfPlayers < 6 && !takenTokens.contains(tokenType)) {
            Player player = new Player(name,tokenType);
            this.players.add(player);
            numOfPlayers++;
            takenTokens.add(tokenType);
        }
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }
}

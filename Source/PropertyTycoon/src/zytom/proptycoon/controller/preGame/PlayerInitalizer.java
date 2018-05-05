package zytom.proptycoon.controller.preGame;

import zytom.proptycoon.model.Player;

import java.util.ArrayList;

public class PlayerInitalizer {

    private ArrayList<Player> players;

    public PlayerInitalizer(){
        players = new ArrayList<>();
    }

    public void createPlayer(String name, Player.TokenType tokenType){
        Player player = new Player(name,tokenType);
        this.players.add(player);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }
}

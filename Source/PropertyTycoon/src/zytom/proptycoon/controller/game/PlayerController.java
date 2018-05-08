package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Player;

public class PlayerController {

    private Player player;
    public PlayerController(Player player){
        this.player = player;
    }

    public int getPlayerPossition(){
        return player.getPosition();
    }
}

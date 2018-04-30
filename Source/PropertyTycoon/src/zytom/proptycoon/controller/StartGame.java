package zytom.proptycoon.controller;


import zytom.proptycoon.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetOwner;

import java.util.ArrayList;

public class StartGame {

    private Game game;
    private int playerTurn;

    public StartGame(ArrayList<Player> players, Player startingPlayer) throws Game.PlayerNumberException {
        this.game = new Game(players, startingPlayer);
        this.playerTurn = players.indexOf(startingPlayer);

    }

    public void turn() throws AssetOwner.AssetNotFoundException {
        Player currentPlayer = Game.getCurrentPlayer();
        int doubles = 0;
        if (currentPlayer.getPosition() == 40) {
            if (currentPlayer.getTurnsInJail() > 1) {
                currentPlayer.moveTo(10, false);
            } else{
                currentPlayer.setTurnsInJail(currentPlayer.getTurnsInJail()+1);
            }
        } else {
            //Add while loop for doubles and shit.
                // ActionListener Button 'roll' rolls the dice
                roll.addActionListener((ActionEvent e) -> {
                    boolean isDouble = rollDice();

                });
                //Other methods in turn.

        }

        // ActionListener Button 'endTurn'
        endTurn.addActionListener((ActionEvent e) -> {
            playerTurn = playerTurn++ % 6;
            Game.setCurrentPlayer(Game.getPlayers().get(playerTurn));
        });
    }

    public boolean rollDice() {
        boolean doubles = false;
        Player currentPlayer = Game.getCurrentPlayer();
        Game.getDice().roll();
        int dice1 = Game.getDice().getFirstValue();
        int dice2 = Game.getDice().getSecondValue();
        if (dice1 == dice2) {
            doubles = true;
        }
        int moveAmount = dice1 + dice2;
        currentPlayer.move(moveAmount);
        return doubles;
    }

}

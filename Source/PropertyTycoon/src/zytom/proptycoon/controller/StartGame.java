package zytom.proptycoon.controller;


import zytom.proptycoon.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.cell.Cell;
import javax.swing.Timer;

import java.util.ArrayList;

public class StartGame {

    private Game game;
    private int playerTurn;
    private int doubles = 0;
    private Timer t = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent a) {
            time++;
        }
    });

    int time = 0;

    public StartGame(ArrayList<Player> players, Player startingPlayer) throws Game.PlayerNumberException, AssetOwner.AssetNotFoundException, FileNotFoundException {
        this.game = new Game(players, startingPlayer);
        this.playerTurn = players.indexOf(startingPlayer);

        t.start();
        this.turn();

    }

    public int getTime(){
        return time;
    }

    public void turn() throws AssetOwner.AssetNotFoundException {
        Player currentPlayer = game.getCurrentPlayer();
        if (currentPlayer.getPosition() == 40) {
            if (currentPlayer.getTurnsInJail() > 1) {
                currentPlayer.moveTo(10, false,game.getBank());
                //end Turn Button
            } else{
                currentPlayer.setTurnsInJail(currentPlayer.getTurnsInJail()+1);
                //end Turn Button
            }
        } else {
            //Roll Dice Button
        }
    }

    public void landOnCell() throws Board.CellNotFoundException {
        Player currentPlayer = game.getCurrentPlayer();
        int cellNumber = currentPlayer.getPosition();
        Cell currentCell = game.getBoard().getCell(cellNumber);
        //Do cell action and button and shit
    }



    public void retireAction( button){
        button.addActionListener((ActionEvent e) -> {
            Player currentPlayer = game.getCurrentPlayer();
            playerTurn = playerTurn++ % game.getPlayers().size();
            game.setCurrentPlayer(game.getPlayers().get(playerTurn));
            game.getPlayers().remove(currentPlayer);
            turn();
        });
    }


    public void rollDiceAction(button) {
        button.addActionListener((ActionEvent e) -> {
            Player currentPlayer = game.getCurrentPlayer();
            game.getDice().roll();
            int dice1 = game.getDice().getFirstValue();
            int dice2 = game.getDice().getSecondValue();
            int moveAmount = dice1 + dice2;
            if(dice1==dice2){
                doubles++;
            }
            if(doubles==2){
                currentPlayer.moveTo(40,false,game.getBank());
            }else {
                currentPlayer.move(moveAmount, game.getBank());
            }
            //landOnCell();

            ////endTurnButton
        });
    }


    public void endTurnAction(button) {
        button.addActionListener((ActionEvent e) -> {
            if(game.getDice().getFirstValue()!=game.getDice().getSecondValue()|| game.getCurrentPlayer().getPosition()!=40) {
                playerTurn = playerTurn++ % game.getPlayers().size();
                doubles = 0;
            }
            game.setCurrentPlayer(game.getPlayers().get(playerTurn));
            turn();
        });
    }
}

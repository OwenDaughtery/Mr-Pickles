//package zytom.proptycoon.controller;
//
//
//import zytom.proptycoon.model.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import zytom.proptycoon.model.Game;
//import zytom.proptycoon.model.Player;
//import zytom.proptycoon.model.assets.AssetOwner;
//import zytom.proptycoon.model.cell.Cell;
//import javax.swing.Timer;
//
//import java.util.ArrayList;
//
//public class StartGame {
//
//    private Game game;
//    private int playerTurn;
//    private int doubles = 0;
//    private Timer t = new Timer(1000, new ActionListener() {
//
//        @Override
//        public void actionPerformed(ActionEvent a) {
//            time++;
//        }
//    });
//
//    int time = 0;
//
//    public StartGame(ArrayList<Player> players, Player startingPlayer) throws Game.PlayerNumberException, AssetOwner.AssetNotFoundException, FileNotFoundException {
//        this.game = new Game(players, startingPlayer);
//        this.playerTurn = players.indexOf(startingPlayer);
//
//        t.start();
//        this.turn();
//
//    }
//
//    public int getTime(){
//        return time;
//    }
//
//    public void turn() throws AssetOwner.AssetNotFoundException {
//        Player currentPlayer = game.getCurrentPlayer();
//        if (currentPlayer.getPosition() == 40) {
//            if (currentPlayer.getTurnsInJail() > 1) {
//                currentPlayer.moveTo(10, false,game.getBank());
//                //end Turn Button
//            } else{
//                currentPlayer.setTurnsInJail(currentPlayer.getTurnsInJail()+1);
//                //end Turn Button
//            }
//        } else {
//            //Roll Dice Button
//        }
//    }
//
//    public void landOnCell() throws Board.CellNotFoundException {
//        Player currentPlayer = game.getCurrentPlayer();
//        int cellNumber = currentPlayer.getPosition();
//        Cell currentCell = game.getBoard().getCell(cellNumber);
//        //Do cell action and button and shit
//    }
//
//
//
//    public void retireAction( button){
//        button.addActionListener((ActionEvent e) -> {
//            Player currentPlayer = game.getCurrentPlayer();
//            playerTurn = playerTurn++ % game.getPlayers().size();
//            game.setCurrentPlayer(game.getPlayers().get(playerTurn));
//            game.getPlayers().remove(currentPlayer);
//            turn();
//        });
//    }
//
//
//    public void rollDiceAction(button) {
//        button.addActionListener((ActionEvent e) -> {
//            Player currentPlayer = game.getCurrentPlayer();
//            game.getDice().roll();
//            int dice1 = game.getDice().getFirstValue();
//            int dice2 = game.getDice().getSecondValue();
//            int moveAmount = dice1 + dice2;
//            if(dice1==dice2){
//                doubles++;
//            }
//            if(doubles==2){
//                currentPlayer.moveTo(40,false,game.getBank());
//            }else {
//                currentPlayer.move(moveAmount, game.getBank());
//            }
//            //landOnCell();
//
//            ////endTurnButton
//        });
//    }
//
//
//    public void endTurnAction(button) {
//        button.addActionListener((ActionEvent e) -> {
//            if(game.getDice().getFirstValue()!=game.getDice().getSecondValue()|| game.getCurrentPlayer().getPosition()!=40) {
//                playerTurn = playerTurn++ % game.getPlayers().size();
//                doubles = 0;
//            }
//            game.setCurrentPlayer(game.getPlayers().get(playerTurn));
//            turn();
//        });
//    }
//}


import zytom.proptycoon.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import zytom.proptycoon.model.Game;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.PropertyCard;
import zytom.proptycoon.model.cell.*;
import javax.swing.Timer;
import javax.swing.JButton;

/**
 * @Author Ayman
 *
 * Controller for full length game of Monopoly
 *
 */
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

    /**
     * Makes the model for the game, starts the timer and starts the first turn.
     * @param players
     * @param startingPlayer
     * @throws Game.PlayerNumberException
     * @throws AssetOwner.AssetNotFoundException
     * @throws FileNotFoundException
     */
    public StartGame(ArrayList<Player> players, Player startingPlayer) throws Game.PlayerNumberException, AssetOwner.AssetNotFoundException, FileNotFoundException, Board.CellNotFoundException {
        this.game = new Game(players, startingPlayer);
        this.playerTurn = players.indexOf(startingPlayer);

        t.start();
        this.startTurn();

    }

    /**
     * @return time
     */
    public int getTime(){
        return time;
    }

    /**
     * starts the turn and Calls for the creation of the initial buttons based on if player is in jail or not.
     * @throws AssetOwner.AssetNotFoundException
     */
    public void startTurn() throws AssetOwner.AssetNotFoundException {
        Player currentPlayer = game.getCurrentPlayer();
        //Handels turn if current player is in jail
        if (currentPlayer.getPosition() == 40) {
            if (currentPlayer.getTurnsInJail() > 1) {
                currentPlayer.moveTo(10, false,game.getBank());
                //TODO create a endTurn and add the action i made to it.
            } else{
                currentPlayer.setTurnsInJail(currentPlayer.getTurnsInJail()+1);

                //TODO create a endTurn and add the action i made to it.
            }
            //handels turn otherwise
        } else {
            //TODO create a rollDiceButton and add the action i made to it.
        }
    }

    /**
     * Calles the relevent methods based on which cell the current player is on
     * @throws Board.CellNotFoundException
     * @throws CellNotFoundException
     */
    public void landOnCell() throws Board.CellNotFoundException, CellNotFoundException {
        Player currentPlayer = game.getCurrentPlayer();
        int cellNumber = currentPlayer.getPosition();
        Cell currentCell = game.getBoard().getCell(cellNumber);
        //Property Cell Decision
        if(currentCell instanceof PropertyCell){
            PropertyCellLanded((PropertyCell)currentCell);
        }
        // Go cell Desision
        else if(currentCell instanceof GoCell) {
            //Do Nothing
        }
        // Just Visiting Cell Decision
        else if(currentCell instanceof PassingJailCell){
            //Do Nothing
        }
        //Free Parking Cell Decision
        else if(currentCell instanceof FreeParkingCell){
            FreeParking freeParking = game.getFreeParking();
            try {
                Transaction transaction = new Transaction(
                        freeParking,
                        currentPlayer,
                        new AssetCollection(game.getFreeParking().getAssetCollection().getMoney()),
                        new AssetCollection(0)
                );
                transaction.settleTransaction();
            } catch (AssetOwner.AssetNotFoundException ex) {

            }
        }
        //Go to jail Cell
        else if(currentCell instanceof GoToJailCell){
            currentPlayer.moveTo(40,false,game.getBank());
        }
        //Opportunity Knocks Cell
        else if(currentCell instanceof OpportunityKnocksCell){
            //do shhit
        }
        //Pot luck
        else if(currentCell instanceof PotLuckCell){
            //do shit
        }
        //Income Tax
        else if (currentCell instanceof  IncomeTaxCell){
            FreeParking freeParking = game.getFreeParking();
            try {
                Transaction transaction = new Transaction(
                        currentPlayer,
                        freeParking,
                        new AssetCollection(200),
                        new AssetCollection(0)
                );
                transaction.settleTransaction();
            } catch (AssetOwner.AssetNotFoundException ex) {

            }
        }
        //SuperTax
        else if (currentCell instanceof SuperTaxCell){
            FreeParking freeParking = game.getFreeParking();
            try {
                Transaction transaction = new Transaction(
                        currentPlayer,
                        freeParking,
                        new AssetCollection(100),
                        new AssetCollection(0)
                );
                transaction.settleTransaction();
            } catch (AssetOwner.AssetNotFoundException ex) {

            }
        }
        else{
            throw new CellNotFoundException();
        }
    }

    /**
     * Does relevent steps which happends when you land on a property
     * @param currentCell
     */
    public void PropertyCellLanded(PropertyCell currentCell){
        PropertyCard card = currentCell.getAssociatedCard();
        //TODO do actions based on card
    }

    /**
     * Adds a event to button which runs the player retirement sequence.
     */
    public void retireAction(JButton button){
        button.addActionListener((ActionEvent e) -> {
            Player currentPlayer = game.getCurrentPlayer();
            playerTurn = playerTurn++ % game.getPlayers().size();
            game.setCurrentPlayer(game.getPlayers().get(playerTurn));
            game.getPlayers().remove(currentPlayer);
            try {
                startTurn();
            } catch (AssetOwner.AssetNotFoundException e1) {
                e1.printStackTrace();
            }
        });
    }


    /**
     * adds a event to the button which starts the sequence of event that happen after a player rolls the dice when pressed
     * @Param button
     */
    public void rollDiceAction(JButton button) {
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
            try {
                landOnCell();
            } catch (Board.CellNotFoundException e1) {
                e1.printStackTrace();
            } catch (CellNotFoundException e1) {
                e1.printStackTrace();
            }


            //TODO create a endTurn and add the action i made to it.
        });
    }


    /**
     * adds a event to a button which does the end turn seqence when pressed.
     * @param button
     */
    public void endTurnAction(JButton button) {
        button.addActionListener((ActionEvent e) -> {
            if(game.getDice().getFirstValue()!=game.getDice().getSecondValue()|| game.getCurrentPlayer().getPosition()!=40) {
                playerTurn = playerTurn++ % game.getPlayers().size();
                doubles = 0;
            }
            game.setCurrentPlayer(game.getPlayers().get(playerTurn));
            try {
                startTurn();
            } catch (AssetOwner.AssetNotFoundException e1) {
                e1.printStackTrace();
            }
        });
    }



    public static class CellNotFoundException extends Exception {
        public CellNotFoundException(
        ) {
            super (
                    "Cell not Found"
            );
        }
        /**
         * Gets the message
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }
}

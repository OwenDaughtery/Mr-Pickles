package zytom.proptycoon.controller;

//import zytom.proptycoon.model.Bank;
//import zytom.proptycoon.model.Board;
//import zytom.proptycoon.model.Dice;
//import zytom.proptycoon.model.Player;
//
//public class DiceController {
//    private Dice dice;
//    public DiceController(Dice dice){
//        this.dice = dice;
//
//    }
//
//
//    /**
//     * method calls model to roll dice in game
//     */
//    public void roll(PlayerController playerController, Board board, Bank bank){
//        Player player = playerController.getPlayer();
//        dice.roll();
//        player.move(dice.getFirstValue()+dice.getSecondValue(), bank);
//        try {
//            playerController.hasLanded(board.getCell(player.getPosition()));
//        } catch (Board.CellNotFoundException e) {
//            //This will probably never happen.
//            e.printStackTrace();
//        }
//    }
//
//}

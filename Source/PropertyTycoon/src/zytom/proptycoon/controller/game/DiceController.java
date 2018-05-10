package zytom.proptycoon.controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import zytom.proptycoon.model.Dice;
import zytom.proptycoon.model.Player;
import zytom.proptycoon.view.board.LeftDie;
import zytom.proptycoon.view.board.RightDie;
import zytom.proptycoon.view.board.RollDiceButton;

public class DiceController implements ActionListener {

    private final Dice dice;
    private final GameController gameController;

    private RollDiceButton diceButtonView;
    private LeftDie leftDieView;
    private RightDie rightDieView;
    
    public DiceController(
            Dice dice,
            GameController gameController
    ) {
        this.dice = dice;
        this.gameController = gameController;
    }
    
    public void setDiceButtonView(RollDiceButton view) {
        this.diceButtonView = view;
        this.diceButtonView.addActionListener(this);
        gameController.readyToRoll();
    }
    
    public void setLeftDieView(LeftDie view) {
        this.leftDieView = view;
    }
    
    public void setRightDieView(RightDie view) {
        this.rightDieView = view;
    }
    
    public void timeToRoll() {
        this.diceButtonView.timeToRoll();
    }
    
    private void dontRoll() {
        this.diceButtonView.dontRoll();
    }
    
    private void updateDiceViews() {
        this.leftDieView.setValue(
                this.dice.getFirstValue()-1
        );
        this.rightDieView.setValue(
                this.dice.getSecondValue()-1
        );
    }

    /**
     * Rolls the dice and moves the player. If they roll a double, increment doublesRolled
     *
     * @return True if double was rolled.
     */
    public boolean roll() {
        dice.roll();
        updateDiceViews();
        //Prevent rolling again until necessary to do so.
        this.dontRoll();
        int dice1 = dice.getFirstValue();
        int dice2 = dice.getSecondValue();
        return (dice1 == dice2);
    }

    /**
     *
     * @return dice
     */
    public Dice getDice() {
        return this.dice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameController.diceRolled(
                this.roll()
        );
    }
}

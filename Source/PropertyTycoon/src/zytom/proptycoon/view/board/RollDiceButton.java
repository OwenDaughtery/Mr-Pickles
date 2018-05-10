/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import javax.swing.JButton;
import zytom.proptycoon.controller.game.DiceController;

/**
 *
 * @author utopia
 */
public class RollDiceButton extends JButton {
    public RollDiceButton() {
        super();
        this.setText("Roll Dice");
        this.setBounds(300, 450, 120, 50);
        this.setEnabled(false);
    }
    
    public void timeToRoll() {
        this.setEnabled(true);
    }
    
    public void dontRoll() {
        this.setEnabled(false);
    }
}

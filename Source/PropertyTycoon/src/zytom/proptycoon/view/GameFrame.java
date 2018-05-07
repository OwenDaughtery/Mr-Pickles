/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import zytom.proptycoon.controller.game.BoardController;
import zytom.proptycoon.controller.game.GameController;
import zytom.proptycoon.view.board.BoardCanvas;

/**
 *
 * @author utopia
 */
public class GameFrame extends JFrame {
    BoardCanvas boardCanvas;
    
    public GameFrame(GameController gameController) {
        this.setSize(720, 720);
        //this.setMininumSize(new Dimension(720, 720));
        this.setLayout(new BorderLayout());
        
        BoardController boardController = gameController.getBoardController();
        
        boardCanvas = new BoardCanvas(
                boardController.getStreetNames(),
                boardController.getStationNames(),
                boardController.getUtilityNames(),
                boardController.getStreetPrices(),
                boardController.getStationPrices(),
                boardController.getUtilityPrices()
        );
        add(boardCanvas);
        boardCanvas.setVisible(true);
        pack();

    }
}

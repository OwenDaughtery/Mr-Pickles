/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import zytom.proptycoon.view.board.BoardCanvas;

/**
 *
 * @author utopia
 */
public class GameFrame extends JFrame {
    BoardCanvas boardCanvas;
    
    public GameFrame(GameController gameController) {
        this.setLayout(new BorderLayout());
        
        BoardController boardController = gameController.getBoardController();
        
        boardCanvas = new BoardCanvas(
                boardController.getStreetNames(),
                boardController.getStationNames(),
                boardController.getUtilityNames(),
                boardController.getStationPrices(),
                boardController.getStreetPrices(),
                boardController.getUtilityPrices()
        );
        add(boardCanvas);
    }
}

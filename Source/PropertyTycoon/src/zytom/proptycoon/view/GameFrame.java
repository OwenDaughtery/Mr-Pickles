/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
        this.getContentPane()
                .setPreferredSize(
                        new Dimension(720, 720)
                );
        this.setLayout(new BorderLayout());
        this.pack();
        setResizable(false);
        
        BoardController boardController = gameController.getBoardController();
        
        boardCanvas = new BoardCanvas(
                boardController.getStreetNames(),
                boardController.getStationNames(),
                boardController.getUtilityNames(),
                boardController.getStreetPrices(),
                boardController.getStationPrices(),
                boardController.getUtilityPrices(),
                boardController.getIncomeTaxPrice(),
                boardController.getSuperTaxPrice()
        );
        add(boardCanvas);
        boardCanvas.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}

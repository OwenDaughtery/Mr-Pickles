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
 * @author Tom
 */
public class GameFrame extends JFrame {
    BoardCanvas boardCanvas;
    public GameFrame(GameController gameController) {
        this.getContentPane()
                .setPreferredSize(
                        new Dimension(720, 720)
                );
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(720, 720));
        this.setResizable(false);
        this.pack();
        setResizable(false);
        BoardController boardController = gameController.getBoardController();
        boardCanvas = new BoardCanvas(this, boardController);
               
        add(boardCanvas);
        boardCanvas.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}

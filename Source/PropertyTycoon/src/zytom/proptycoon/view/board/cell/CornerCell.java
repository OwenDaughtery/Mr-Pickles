/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author Tom
 */
public abstract class CornerCell extends Cell {
    /** which corner the cell is located at */
    public enum Corner { TOPLEFT, TOPRIGHT, BOTTOMRIGHT, BOTTOMLEFT };
    
    /**
     * Get the width & height this cell should be based on the board it is in.
     * @param boardSize How wide & high the board is.
     * @param boardProportion The proportion of the board's width/height one side of this cell takes up.
     * @return the width & height this cell should be based on the board it is in.
     */
    public static Dimension calcDimension(
            Dimension boardSize,
            float boardProportion
    ) {
        return new Dimension(
                    Math.round((float)boardSize.width * boardProportion),
                    Math.round((float)boardSize.height * boardProportion)
                );
    }
    
    /**
     * Get the absolute position of the the cell based on the board.
     * @param boardSize How wide & high the board is.
     * @param boardProportion The proportion of the board's width/height one side of this cell takes up.
     * @param corner Which corner the cell is in
     * @return the absolute position of the the cell based on the board.
     */
    public static Point calcPosition(
            Dimension boardSize,
            float boardProportion,
            Corner corner
    ) {
        Dimension cellSize = calcDimension(
                boardSize, 
                boardProportion
        );
        switch (corner) {
            case TOPLEFT:
                return new Point(0, 0);
            case TOPRIGHT:
                return new Point(
                        boardSize.width - cellSize.width,
                        0
                );
            case BOTTOMRIGHT:
                return new Point(
                        boardSize.width - cellSize.width,
                        boardSize.height - cellSize.height
                );
            case BOTTOMLEFT:
                return new Point(
                        0,
                        boardSize.height - cellSize.height
                );
        }
        return new Point(0, 0);
    }
    
    /**
     * 
     * @param boardSize
     * @param boardProportion
     * @param corner 
     */
    public CornerCell(
            Dimension boardSize, 
            float boardProportion, 
            Corner corner) {
        super(
                calcDimension(boardSize, boardProportion),
                calcPosition(boardSize, boardProportion, corner),
                Orientation.UP
        );
    }
}

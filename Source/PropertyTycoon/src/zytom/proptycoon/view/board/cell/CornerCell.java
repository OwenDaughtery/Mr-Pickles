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
    public enum Corner { TOPLEFT, TOPRIGHT, BOTTOMRIGHT, BOTTOMLEFT };
    
    private static Dimension calcDimension(
            Dimension boardSize,
            float boardProportion
    ) {
        return new Dimension(
                    Math.round((float)boardSize.width * boardProportion),
                    Math.round((float)boardSize.height * boardProportion)
                );
    }
    
    private static Point calcPosition(
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
    
    public CornerCell(
            Dimension boardSize, 
            float boardProportion, 
            Corner corner) {
        super(
                calcDimension(boardSize, boardProportion),
                calcPosition(boardSize, boardProportion, corner)
        );
    }
}

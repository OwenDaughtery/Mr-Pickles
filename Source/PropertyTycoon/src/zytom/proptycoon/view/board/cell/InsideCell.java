/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Tom
 */
public abstract class InsideCell extends Cell {
    public enum Side { BOTTOM, LEFT, TOP, RIGHT};
    
    private Side side;
    private int rowIndex; //0-9
    
    public static Dimension calcDimension(
            Dimension boardSize,
            float boardProportion
    ) {
        return new Dimension(
                    Math.round((float)boardSize.width * boardProportion / 1.5f),
                    Math.round((float)boardSize.height * boardProportion)
                );
    }
    
    public static Point calcPosition(
            Dimension boardSize,
            float boardProportion,
            Side side,
            int rowIndex
    ) {
        Dimension dimension = calcDimension(boardSize, boardProportion);
        Dimension cornerDimension = CornerCell.calcDimension(boardSize, boardProportion);
        //Start of row position.
        Point position = new Point();
        switch (side) {
            case BOTTOM:
                position.x = boardSize.width - cornerDimension.width - dimension.width;
                position.y = boardSize.height - cornerDimension.height;
                break;
            case LEFT:
                position.x = dimension.height;
                position.y = boardSize.height - cornerDimension.height - dimension.width;
                break;
            case TOP:
                position.x = cornerDimension.width + dimension.width;
                position.y = cornerDimension.height;
                break;
            case RIGHT:
                position.x = boardSize.width - cornerDimension.width;
                position.y = cornerDimension.height + dimension.width;
                break;
        }
        //Increment position based on index in row.
        switch (side) {
            case BOTTOM:
                position.x -= rowIndex * dimension.width;
                break;
            case LEFT:
                position.y -= rowIndex * dimension.width;
                break;
            case TOP:
                position.x += rowIndex * dimension.width;
                break;
            case RIGHT:
                position.y += rowIndex * dimension.width;
                break;
        }
        return position;
    }
    
    public static Orientation getOrientation(Side side) {
        switch (side) {
            case BOTTOM:
                return Orientation.UP;
            case LEFT:
                return Orientation.LEFT;
            case TOP:
                return Orientation.DOWN;
            case RIGHT:
                return Orientation.RIGHT;
        }
        return Orientation.UP;
    }
    
    public InsideCell(
            Dimension boardSize, 
            float boardProportion, 
            Side side,
            int rowIndex
    ){
        super (
                calcDimension(boardSize, boardProportion),
                calcPosition(boardSize, boardProportion, side, rowIndex),
                getOrientation(side)
        );
    }
}

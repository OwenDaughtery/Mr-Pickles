/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author Tom
 */
public class LeftDie extends Die {
    public LeftDie(Dimension boardSize) {
        super(
                boardSize,
                new Point(250, 500)
        );
    }
}

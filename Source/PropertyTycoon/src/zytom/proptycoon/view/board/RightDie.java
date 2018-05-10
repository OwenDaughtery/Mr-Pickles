/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author zenos
 */
public class RightDie extends Die {
    public RightDie(Dimension boardSize) {
        super(
                boardSize,
                new Point(380, 500)
        );
    }
}


/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;


import java.util.Random;

/**
 * @author Tom Chesters,Max Pattman
 */
public class Dice {
    private int firstValue;
    private int secondValue;
    private static final int HIGH = 6;
    private static final int LOW = 1;

    public Dice() {
        //assert that values are between 1-6
        this.firstValue = 0;
        this.secondValue = 0;
    }

    public int getFirstValue() {
        return this.firstValue;
    }

    public int getSecondValue() {
        return this.secondValue;
    }

    public void roll() {
        Random r = new Random();
        this.firstValue = r.nextInt(HIGH - LOW) + LOW;
        this.secondValue = r.nextInt(HIGH - LOW) + LOW;
    }
}

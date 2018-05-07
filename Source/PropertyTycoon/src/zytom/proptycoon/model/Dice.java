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
        this.firstValue = 0;
        this.secondValue = 0;
    }

    /**
     * @return The value of the first die
     */
    public int getFirstValue() {
        return this.firstValue;
    }
    
    /**
     * @return The value of the second die
     */
    public int getSecondValue() {
        return this.secondValue;
    }

    /**
     * Method rolls the dice and updates firstValue and secondValue
     */
    public void roll() {
        Random r = new Random();
        this.firstValue = r.nextInt(HIGH - LOW) + LOW;
        this.secondValue = r.nextInt(HIGH - LOW) + LOW;
    }

    /**
     * @return True if firstValue is the same as secondValue, false otherwise
     */
    public boolean wasDoubleRolled(){
        return this.getFirstValue() == this.getSecondValue();
    }

}

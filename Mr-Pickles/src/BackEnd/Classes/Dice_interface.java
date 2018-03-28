package BackEnd.Classes;

/**
 * @author max
 */
public interface Dice_interface {

    /**
     * getter method.
     * @return the value of the first die
     */
    public int getFirstValue();

    /**
     * getter method .
     * @return the value of the second die
     */
    public int getSecondValue();

    /**
     * method rolls die and generates two random values
     */
    public void roll();
}

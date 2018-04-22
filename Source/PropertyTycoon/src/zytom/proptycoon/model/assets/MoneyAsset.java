/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;

/**
 *
 * @author Tom Chesters
 */
public class MoneyAsset extends Asset {
    
    private int value;
    
    /**
     * Constructor will assign the value of the money asset.
     * 
     * @author Zenos Pavlakou
     */
    public MoneyAsset(int value) {
        this.value = value;
    }
    
     /**
     * @author Zenos Pavlakou
     * 
     * @return the value of the money asset
     */
    public int getMoney() {
        return this.value;
    }
}

/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;

/**
 *
 * @author Tom Chesters
 */
public class MoneyAsset extends Asset {
    
    private int assetValue;
    
    /**
     * Constructor will assign the value of the money asset.
     * 
     * @author Zenos Pavlakou
     */
    public MoneyAsset(int assetValue) {
        this.assetValue = assetValue;
    }
    
     /**
     * @author Zenos Pavlakou
     * 
     * @return the value of the money asset
     */
    public int getValue() {
        return this.assetValue;
    }
}

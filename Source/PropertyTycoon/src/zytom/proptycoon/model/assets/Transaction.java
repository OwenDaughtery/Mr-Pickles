/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;
import zytom.proptycoon.model.Player;
/**
 *
 * @author Tom Chesters
 */
public class Transaction {
    
    private AssetOwner primaryOwner;
    private AssetOwner secondaryOwner;
    private Asset giving;
    private Asset receiving;
    
    
    /**
     * @author Zenos Pavlakou
     * 
     * @param primary The primary asset owner
     * @param secondary The secondary asset owner
     * @param giving The asset which the primary owner will be trading with the secondary asset owner
     * @param receiving The asset which the secondary owner will be trading with the primary asset owner
     */
    public Transaction(AssetOwner primary, AssetOwner secondary, Asset giving, Asset receiving) {
        this.primaryOwner = primary;
        this.secondaryOwner = secondary;
        this.giving = giving;
        this.receiving = receiving;
    }
    
    /**
     * @author Zenos Pavlakou
     * 
     * @return True if transaction is successful, false otherwise
     */
    public boolean settleTransaction() {
        this.primaryOwner.takeAsset(giving);
        this.secondaryOwner.takeAsset(receiving);
        this.primaryOwner.giveAsset(receiving);
        this.secondaryOwner.giveAsset(giving);
        return true;
    }
    
}

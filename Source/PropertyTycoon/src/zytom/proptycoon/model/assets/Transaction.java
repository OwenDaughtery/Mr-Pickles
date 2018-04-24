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
     * @author Tom Chesters
     * @throws AssetNotFoundException if one of the AssetOwners does not have the asset being requested from them.
     */
    public void settleTransaction() throws AssetNotFoundException { 
        //First, assert that primary asset owner
        //owns what it is giving.
        //If so take 
        Asset takenFromPrimary;
        try {
            takenFromPrimary = primary.takeAsset(giving);
        } catch(AssetNotFoundException ex) {
            throw ex;
        }
        Asset takenFromSecondary;
        try {
            takenFromSecondary = secondary.takeAsset(receiving);
        } catch(AssetNotFoundException ex) {
            throw ex;
        }
    }
    
}

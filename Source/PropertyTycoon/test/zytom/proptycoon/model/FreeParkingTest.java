package zytom.proptycoon.model;

import org.junit.Test;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;

import static org.junit.Assert.*;

/**
 * ALL TESTS PASSING
 */
public class FreeParkingTest {

    @Test
    public void getAssetCollection() throws AssetOwner.AssetNotFoundException, AssetOwner.CannotAcceptAssetException {
        AssetCollection assetCollection = new AssetCollection(100);
        FreeParking freeParking = new FreeParking();
        freeParking.giveAssetCollection(assetCollection);
        assertTrue(freeParking.getAssetCollection().getMoney()==100);
    }

    @Test
    public void takeAssetCollection() throws AssetOwner.AssetNotFoundException, AssetOwner.CannotAcceptAssetException{
        AssetCollection assetCollection = new AssetCollection(100);
        FreeParking freeParking = new FreeParking();
        freeParking.giveAssetCollection(assetCollection);
        assertTrue(freeParking.getAssetCollection().getMoney()==100);
        freeParking.takeAssetCollection(assetCollection);
        assertTrue(freeParking.getAssetCollection().getMoney()==0);
    }

    @Test
    public void giveAssetCollection() throws AssetOwner.CannotAcceptAssetException
    {
        AssetCollection assetCollection = new AssetCollection(100);
        FreeParking freeParking = new FreeParking();

        freeParking.giveAssetCollection(assetCollection);
        assertTrue(freeParking.getAssetCollection().getMoney() == 100);

    }
}
/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.assets;
import java.util.ArrayList;

/**
 *
 * @author Tom Chesters
 */
public class CardsAsset extends Asset {
    
    private final ArrayList<CardAsset> cardAssets;
    
    public CardsAsset(ArrayList<CardAsset> cardAsset){
        this.cardAssets = cardAsset;
    }

    public ArrayList<CardAsset> getCardAssets() {
        return cardAssets;
    }
}

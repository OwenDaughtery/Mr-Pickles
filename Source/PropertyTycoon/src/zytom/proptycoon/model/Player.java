/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;

import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.*;
import zytom.proptycoon.model.cell.GoCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;

import java.util.ArrayList;

/**
 * @author Tom Chesters
 */
public class Player implements AssetOwner {
    public static final int INITIAL_BALANCE = 1500;

    private int turnsInJail = 0;
    private final String name;
    private int position;
    private final AssetCollection assetCollection;

    /**
     * 
     * @param name
     */
    public Player(String name){
        this.name = name;
        this.position = 0;
        this.assetCollection = new AssetCollection(INITIAL_BALANCE);
    }

    /**
     * @author Zenos Pavlakou
     * @return The name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @author Zenos Pavlakou
     * @return The position of the player
     */
    public int getPosition() {
        return this.position;
    }

    /**
     *
     * @author Zenos + Ayman
     * @param numberOfSpaces
     * @param bank
     */
    public void move(int numberOfSpaces, Bank bank) {
        int currentPosition = this.position;
        this.position = (this.position + numberOfSpaces) % 40;
        if (numberOfSpaces > 0 && position < currentPosition)
            hasPassedGo(bank);
    }
    
    /**
     *
     * @author Ayman
     * @param position
     * @param movingForewards
     * @throws zytom.proptycoon.model.assets.AssetOwner.AssetNotFoundException
     */
    public void moveTo(int position, boolean movingForewards, Bank bank){
        int currentPosition = this.position;
        this.position = position;
        if (movingForewards == true && position < currentPosition)
            hasPassedGo(bank);
    }
    
    /**
     * 
     * @param bank 
     */
    private void hasPassedGo(Bank bank) {
        try {
            Transaction transaction = new Transaction(
                    bank,
                    this,
                    new AssetCollection(GoCell.PASS_GO_MONEY),
                    new AssetCollection(0)
            );
            transaction.settleTransaction();
        } catch (AssetNotFoundException ex) {
            //There will be no exception.
            //So do nothing.
            ;
        }
    }
    
    /**
     * @return All the assets that this asset owner is in possesion of.
     */
    @Override
    public AssetCollection getAssetCollection() {
        return this.assetCollection;
    }
    
    /**
     * @author ayman
     *
     * @return turnsInJail
     */
    public int getTurnsInJail() {
        return turnsInJail;
    }

    /**
     * @author ayman
     * @param turnsInJail
     */
    public void setTurnsInJail(int turnsInJail) {
        this.turnsInJail = turnsInJail;
    }

    /**
     * Remove the contents of the specified money asset from this asset owner
     * and return them within the asset instance.
     *
     * @param requested The asset collection to look for in this asset owner.
     * @return An asset instance containing the requested contents.
     * @throws AssetNotFoundException If requested asset contents cannot be
     * found in this asset owner.
     */
    @Override
    public AssetCollection takeAssetCollection(AssetCollection requested) throws AssetNotFoundException {
        //Remove requested potluck cards. (Throw exception if not found).
        if (this.assetCollection.getPotLuckCards().containsAll(requested.getPotLuckCards())) {
            this.assetCollection.getPotLuckCards().removeAll(requested.getPotLuckCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested opportunityknocks cards. (Throw exception if not found).
        if (this.assetCollection.getOpportunityKnocksCards().containsAll(requested.getOpportunityKnocksCards())) {
            this.assetCollection.getOpportunityKnocksCards().removeAll(requested.getOpportunityKnocksCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested street property cards. (Throw exception if not found).
        if (this.assetCollection.getStreetPropertyCards().containsAll(requested.getStreetPropertyCards())) {
            this.assetCollection.getStreetPropertyCards().removeAll(requested.getStreetPropertyCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested station property cards. (Throw exception if not found).
        if (this.assetCollection.getStationPropertyCards().containsAll(requested.getStationPropertyCards())) {
            this.assetCollection.getStationPropertyCards().removeAll(requested.getStationPropertyCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested utility property cards. (Throw exception if not found).
        if (this.assetCollection.getUtilityPropertyCards().containsAll(requested.getUtilityPropertyCards())) {
            this.assetCollection.getUtilityPropertyCards().removeAll(requested.getUtilityPropertyCards());
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Remove requested money. (Throw exception if not found).
        if (this.assetCollection.getMoney() >= requested.getMoney()) {
            this.assetCollection.setMoney(
                    this.assetCollection.getMoney() - requested.getMoney()
            );
        } else {
            throw new AssetOwner.AssetNotFoundException(this, requested);
        }

        //Return the requested AssetCollection.
        return requested;
    }

    /**
     * Append the contents of the specified asset collection to the asset
     * owner's asset collection.
     *
     * @param giving
     */
    @Override
    public void giveAssetCollection(AssetCollection giving) {
        this.assetCollection.getPotLuckCards().addAll(
                giving.getPotLuckCards()
        );
        this.assetCollection.getOpportunityKnocksCards().addAll(
                giving.getOpportunityKnocksCards()
        );
        this.assetCollection.getStreetPropertyCards().addAll(
                giving.getStreetPropertyCards()
        );
        this.assetCollection.getStationPropertyCards().addAll(
                giving.getStationPropertyCards()
        );
        this.assetCollection.getUtilityPropertyCards().addAll(
                giving.getUtilityPropertyCards()
        );
        this.assetCollection.setMoney(
                this.assetCollection.getMoney() + giving.getMoney()
        );
    }

    @Override
    public String toString() {
        String info = "Player Name : " + this.name + "\n" +
                "PLayer Position : " + this.position + "\n" +
                "Players Current Assets : \n" +
                "Cash : " + this.getAssetCollection().getMoney() + "\n";


        return info;

    }
}
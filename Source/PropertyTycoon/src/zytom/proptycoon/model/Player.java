/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model;

import zytom.proptycoon.Common.TokenType;
import zytom.proptycoon.model.assets.AssetOwner;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.Transaction;
import zytom.proptycoon.model.card.Card;
import zytom.proptycoon.model.card.OpportunityKnocksCard;
import zytom.proptycoon.model.card.PotLuckCard;
import zytom.proptycoon.model.card.StationPropertyCard;
import zytom.proptycoon.model.card.StreetPropertyCard;
import zytom.proptycoon.model.card.UtilityPropertyCard;
import zytom.proptycoon.model.cell.GoCell;


/**
 * @author Tom Chesters
 */
public class Player implements AssetOwner {
    public static final int INITIAL_BALANCE = 1500;
    private boolean hasPassedGo;
    private int doublesRolled = 0;
    private int turnsInJail = 0;
    private final String name;
    private int position;
    private final AssetCollection assetCollection;
    private final TokenType tokenType;

    /**
     * 
     * @param name
     * @param tokenType
     */
    public Player(String name, TokenType tokenType){
        this.name = name;
        this.position = 0;
        this.assetCollection = new AssetCollection(INITIAL_BALANCE);
        this.hasPassedGo = false;
        this.tokenType = tokenType;
    }
    
    /**
     * @author Tom
     * @return The type of token this player is represented by.
     */
    public TokenType getTokenType() {
        return this.tokenType;
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
     * @param bank
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
            playerPassedGo();
        } catch (AssetNotFoundException ex) {
            //There will be no exception.
            //So do nothing.
           
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
     * @return The amount of times the player rolled a double
     */
    public int getDoublesRolled() {
        return doublesRolled;
    }
    

    /*
    /**
     * Invoked everytime a player rolls a double
     * @param doublesRolled The number of times the player rolled a double 
     */
    /*
    public void setDoublesRolled(int doublesRolled) {
        this.doublesRolled = doublesRolled;
    }
    */
    
    public void incrementDoublesRolled() {
        this.doublesRolled ++;
    }
    
    public void clearDoublesRolled() {
        this.doublesRolled = 0;
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


    /**
     * Checks if the player has a certain card
     * @param asset The card being queried
     * @return True if the player has the card, false otherwise
     */
    @Override
    public boolean checkHasAsset(Card asset) {
        if(this.getAssetCollection().getStreetPropertyCards().contains((StreetPropertyCard)asset)){

        }else if (this.getAssetCollection().getUtilityPropertyCards().contains((UtilityPropertyCard)asset)){
            return true;
        }else if (this.getAssetCollection().getStationPropertyCards().contains((StationPropertyCard)asset)){
            return true;
        }else if (this.getAssetCollection().getOpportunityKnocksCards().contains((OpportunityKnocksCard)asset)){
            return true;
        }else if (this.getAssetCollection().getPotLuckCards().contains((PotLuckCard)asset)){
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the player has enough money
     * @param money The amount of money 
     * @return  True if the player has enough money, false otherwise. 
     */
    @Override
    public boolean checkHasAsset(int money){
        return this.getAssetCollection().getMoney() > money;
    }

    /**
     * @return True if player has passed the Go cell, false otherwise
     */
    public boolean hasPlayerPassedGo(){
        return this.hasPassedGo;
    }
    
    /**
     * hasPassedGo set to true once the player goes round the board once
     */
    public void playerPassedGo(){
        this.hasPassedGo = true;
    }
    
    public void sendToJail() {
        //So long as 'movingForewards' is false.
        //No need to pass a bank.
        this.moveTo(Board.JAIL_INDEX, false, null);
    }

    @Override
    public String toString() {
        String info = "Player Name : " + this.name + "\n" +
                "PLayer Position : " + this.position + "\n" +
                "Players Current Assets : " + this.getAssetCollection().toString() + "\n";

        return info;

    }
}
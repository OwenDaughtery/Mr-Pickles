package zytom.proptycoon.model;

import org.junit.Test;
import zytom.proptycoon.model.card.*;
import zytom.proptycoon.model.cell.StreetPropertyCell;
import zytom.proptycoon.model.deckCreator.DeckCreator;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Before;
import zytom.proptycoon.model.assets.AssetCollection;
import zytom.proptycoon.model.assets.AssetOwner;

public class BankTest {
    
    private DeckCreator dc;
    private Board board;
    private Bank bank;
    
    @Before
    public void init() throws FileNotFoundException, CardAction.InvalidActionException, Board.CellNotFoundException {
        this.dc = new DeckCreator();
        this.board = new Board(dc.getPropertyData());
        this.bank = new Bank(dc.createPotLuckDeck(), 
                             dc.createOpportunityKnocksDeck(),
                             dc.createStreetPropertyCardDeck(board),
                             dc.createStationPropertyCardDeck(board),
                             dc.createUtilityPropertyCardDeck(board));
    }

    @Test
    public void getAssetCollection() throws FileNotFoundException {

        ArrayList<PotLuckCard> a = new ArrayList<>();
        ArrayList<OpportunityKnocksCard> b = new ArrayList<>() ;
        ArrayList<StreetPropertyCard> c = new ArrayList<>();

        //street property card set up
        StreetPropertyCell streetPropertyCell = new StreetPropertyCell("Awesome Street");
        int[] qt = new int[4];
        qt[0] = 5;
        qt[1] = 6;
        qt[2]= 7;
        qt[3] =8;


        StreetPropertyCard streetPropertyCard = new StreetPropertyCard(streetPropertyCell,"Awesome Street",400,qt,40);
        streetPropertyCell.setAssociatedCard(streetPropertyCard);
        c.add(0,streetPropertyCard);
        ArrayList<StationPropertyCard> d = new ArrayList<>() ;
        ArrayList<UtilityPropertyCard>e = new ArrayList<>();
        Bank bank = new Bank(a,b,c,d,e);

        System.out.print(bank.toString());
    }

    @Test
    public void getAssetCollectionWithDeckCreator() throws FileNotFoundException, Board.CellNotFoundException, Game.PlayerNumberException, CardAction.InvalidActionException {
        ArrayList<Player> players = new ArrayList<>();
        Player player1 = new Player("zenos", Player.TokenType.SMARTPHONE);
        Player player2 = new Player("Tom", Player.TokenType.BOOT);
        Player player3 = new Player("Max", Player.TokenType.GOBLET);
        Player player4 = new Player("Ayman", Player.TokenType.CAT);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        Game game = new Game(players,players.get(0));
        System.out.print(game.getBank().toString());
    }

    @Test
    public void takeAssetCollection() throws AssetOwner.AssetNotFoundException {
        PotLuckCard card = bank.getAssetCollection().getPotLuckCards().get(0);
        AssetCollection asset = new AssetCollection(card);
        bank.takeAssetCollection(asset);
        assertFalse(bank.getAssetCollection().getPotLuckCards().contains(asset));
    }

    @Test
    public void giveAssetCollection() throws AssetOwner.AssetNotFoundException {
        PotLuckCard card = bank.getAssetCollection().getPotLuckCards().get(0);
        AssetCollection asset = new AssetCollection(card);
        bank.takeAssetCollection(asset);
        assertFalse(bank.getAssetCollection().getPotLuckCards().contains(asset));
        bank.giveAssetCollection(asset);
        assertTrue(bank.getAssetCollection().getPotLuckCards().contains(card));
    }
}
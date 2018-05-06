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
import zytom.proptycoon.model.card.StreetPropertyCard.Colour;

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


        StreetPropertyCard streetPropertyCard = new StreetPropertyCard(streetPropertyCell,"Awesome Street",400,qt,40, Colour.GREEN);
        streetPropertyCell.setAssociatedCard(streetPropertyCard);
        c.add(0,streetPropertyCard);
        ArrayList<StationPropertyCard> d = new ArrayList<>() ;
        ArrayList<UtilityPropertyCard>e = new ArrayList<>();
        Bank bank = new Bank(a,b,c,d,e);

        //System.out.print(bank.toString());
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
        //System.out.print(game.getBank().toString());
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
    
    @Test
    public void checkBrownPropertyGroup() {
        ArrayList<StreetPropertyCard> brownProperties = bank.getGroupOfStreetProperties(Colour.BROWN);
        assertTrue(brownProperties.size() == 2);
        assertTrue("CRAPPER STREET".equals(brownProperties.get(0).getTitle()));
        assertTrue("GANGSTERS PARADISE".equals(brownProperties.get(1).getTitle()));
    }
    
    @Test
    public void checkBluePropertyGroup() {
        ArrayList<StreetPropertyCard> blueProperties = bank.getGroupOfStreetProperties(Colour.BLUE);
        assertTrue(blueProperties.size() == 3);
        assertTrue("WEEPING ANGEL".equals(blueProperties.get(0).getTitle()));
        assertTrue("POTTS AVENUE".equals(blueProperties.get(1).getTitle()));
        assertTrue("NARDOLE DRIVE".equals(blueProperties.get(2).getTitle()));
    }
    
    @Test
    public void checkGreenProperties() {
        ArrayList<StreetPropertyCard> greenProperties = bank.getGroupOfStreetProperties(Colour.GREEN);
        assertTrue(greenProperties.size() == 3);
        assertTrue("SIRAT MEWS".equals(greenProperties.get(0).getTitle()));
        assertTrue("GHENGIS CRESCENT".equals(greenProperties.get(1).getTitle()));
        assertTrue("IBIS CLOSE".equals(greenProperties.get(2).getTitle()));
    }
    
    @Test
    public void checkOrangeProperties() {
        ArrayList<StreetPropertyCard> orangeProperties = bank.getGroupOfStreetProperties(Colour.ORANGE);
        assertTrue(orangeProperties.size() == 3);
        assertTrue("COOPER DRIVE".equals(orangeProperties.get(0).getTitle()));
        assertTrue("WOLOWITZ STREET".equals(orangeProperties.get(1).getTitle()));
        assertTrue("PENNY LANE".equals(orangeProperties.get(2).getTitle()));
    }
    
    @Test
    public void checkPurpleProperties() {
        ArrayList<StreetPropertyCard> purpleProperties = bank.getGroupOfStreetProperties(Colour.PURPLE);
        assertTrue(purpleProperties.size() == 3);
        assertTrue("SKYWALKER DRIVE".equals(purpleProperties.get(0).getTitle()));
        assertTrue("WOOKIE HOLE".equals(purpleProperties.get(1).getTitle()));
        assertTrue("REY LANE".equals(purpleProperties.get(2).getTitle()));
    }
    
    @Test
    public void checkRedProperties() {
        ArrayList<StreetPropertyCard> redProperties = bank.getGroupOfStreetProperties(Colour.RED);
        assertTrue(redProperties.size() == 3);
        assertTrue("YUE FEI SQUARE".equals(redProperties.get(0).getTitle()));
        assertTrue("MULAN ROUGE".equals(redProperties.get(1).getTitle()));
        assertTrue("HAN XIN GARDEN".equals(redProperties.get(2).getTitle()));
    }
    
    @Test
    public void checkYellowProperties() {
        ArrayList<StreetPropertyCard> yellowProperties = bank.getGroupOfStreetProperties(Colour.YELLOW);
        assertTrue(yellowProperties.size() == 3);
        assertTrue("KIRK CLOSE".equals(yellowProperties.get(0).getTitle()));
        assertTrue("PICARD AVENUE".equals(yellowProperties.get(1).getTitle()));
        assertTrue("CRUSHER CREEK".equals(yellowProperties.get(2).getTitle()));  
    }
    
    // DEEPBLUE DOES NOT WORK!

}
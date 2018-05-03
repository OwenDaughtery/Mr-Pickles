package zytom.proptycoon.model;

import org.junit.Test;
import zytom.proptycoon.model.card.*;
import zytom.proptycoon.model.cell.StreetPropertyCell;
import zytom.proptycoon.model.deckCreator.DeckCreator;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class BankTest {

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

        StreetPropertyCard streetPropertyCard = null;

         streetPropertyCard = new StreetPropertyCard(streetPropertyCell,"Awesome Street",400,qt,40);
        streetPropertyCell.setAssociatedCard(streetPropertyCard);
        c.add(0,streetPropertyCard);
        ArrayList<StationPropertyCard> d = new ArrayList<>() ;
        ArrayList<UtilityPropertyCard>e = new ArrayList<>();
        Bank bank = new Bank(a,b,c,d,e);

        System.out.print(bank.toString());



    }

    @Test
    public void takeAssetCollection() {
    }

    @Test
    public void giveAssetCollection() {
    }
}
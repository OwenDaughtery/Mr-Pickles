package zytom.proptycoon.model;

import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import zytom.proptycoon.model.cell.FreeParkingCell;
import zytom.proptycoon.model.cell.GoCell;
import zytom.proptycoon.model.cell.GoToJailCell;
import zytom.proptycoon.model.cell.IncomeTaxCell;
import zytom.proptycoon.model.cell.JailCell;
import zytom.proptycoon.model.cell.OpportunityKnocksCell;
import zytom.proptycoon.model.cell.PassingJailCell;
import zytom.proptycoon.model.cell.PotLuckCell;
import zytom.proptycoon.model.cell.StationPropertyCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;
import zytom.proptycoon.model.cell.SuperTaxCell;
import zytom.proptycoon.model.cell.UtilityPropertyCell;
import zytom.proptycoon.model.deckCreator.DeckCreator;

public class BoardTest {


    @Test
    public void getLastCell() throws FileNotFoundException, Board.CellNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        Board board = new Board(deckCreator.getPropertyData());
        Assert.assertEquals("TURING HEIGHTS", board.getCell(39).getTitle());
    }

    
    @Test
    public void getGoCell() throws FileNotFoundException, Board.CellNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        Board board = new Board(deckCreator.getPropertyData());
        Assert.assertEquals("GO", board.getCell(0).getTitle());
    }
    
    
    @Test
    public void checkAllCells() throws FileNotFoundException, Board.CellNotFoundException {
        DeckCreator deckCreator = new DeckCreator();
        Board board = new Board(deckCreator.getPropertyData());
        
        assertTrue("GO".equals(board.getCell(0).getTitle()));                   //0
        assertTrue(board.getCell(0) instanceof GoCell);
        
        assertTrue("CRAPPER STREET".equals(board.getCell(1).getTitle()));       //1
        assertTrue(board.getCell(1) instanceof StreetPropertyCell);
        
        assertTrue("POT LUCK".equals(board.getCell(2).getTitle()));             //2
        assertTrue(board.getCell(2) instanceof PotLuckCell);
        
        assertTrue("GANGSTERS PARADISE".equals(board.getCell(3).getTitle()));   //3
        assertTrue(board.getCell(3) instanceof StreetPropertyCell);
        
        assertTrue("INCOME TAX".equals(board.getCell(4).getTitle()));           //4
        assertTrue(board.getCell(4) instanceof IncomeTaxCell);
        
        assertTrue("BRIGHTON STATION".equals(board.getCell(5).getTitle()));     //5
        assertTrue(board.getCell(5) instanceof StationPropertyCell);
        
        assertTrue("WEEPING ANGEL".equals(board.getCell(6).getTitle()));        //6
        assertTrue(board.getCell(6) instanceof StreetPropertyCell);
        
        assertTrue("OPPORTUNITY KNOCKS".equals(board.getCell(7).getTitle()));   //7
        assertTrue(board.getCell(7) instanceof OpportunityKnocksCell);
        
        assertTrue("POTTS AVENUE".equals(board.getCell(8).getTitle()));         //8
        assertTrue(board.getCell(8) instanceof StreetPropertyCell);
        
        assertTrue("NARDOLE DRIVE".equals(board.getCell(9).getTitle()));        //9
        assertTrue(board.getCell(9) instanceof StreetPropertyCell);
        
        assertTrue("JUST VISITING JAIL".equals(board.getCell(10).getTitle()));  //10
        assertTrue(board.getCell(10) instanceof PassingJailCell);
        
        assertTrue("SKYWALKER DRIVE".equals(board.getCell(11).getTitle()));     //11
        assertTrue(board.getCell(11) instanceof StreetPropertyCell);
        
        assertTrue("TESLA POWER CO".equals(board.getCell(12).getTitle()));      //12
        assertTrue(board.getCell(12) instanceof UtilityPropertyCell);
        
        assertTrue("WOOKIE HOLE".equals(board.getCell(13).getTitle()));         //13
        assertTrue(board.getCell(13) instanceof StreetPropertyCell);
        
        assertTrue("REY LANE".equals(board.getCell(14).getTitle()));            //14
        assertTrue(board.getCell(14) instanceof StreetPropertyCell);
        
        assertTrue("HOVE STATION".equals(board.getCell(15).getTitle()));        //15
        assertTrue(board.getCell(15) instanceof StationPropertyCell);
        
        assertTrue("COOPER DRIVE".equals(board.getCell(16).getTitle()));        //16
        assertTrue(board.getCell(16) instanceof StreetPropertyCell);
        
        assertTrue("POT LUCK".equals(board.getCell(17).getTitle()));            //17
        assertTrue(board.getCell(17) instanceof PotLuckCell);
        
        assertTrue("WOLOWITZ STREET".equals(board.getCell(18).getTitle()));     //18
        assertTrue(board.getCell(18) instanceof StreetPropertyCell);
        
        assertTrue("PENNY LANE".equals(board.getCell(19).getTitle()));          //19
        assertTrue(board.getCell(19) instanceof StreetPropertyCell);
        
        assertTrue("FREE PARKING".equals(board.getCell(20).getTitle()));        //20
        assertTrue(board.getCell(20) instanceof FreeParkingCell);
        
        assertTrue("YUE FEI SQUARE".equals(board.getCell(21).getTitle()));      //21
        assertTrue(board.getCell(21) instanceof StreetPropertyCell);
        
        assertTrue("OPPORTUNITY KNOCKS".equals(board.getCell(22).getTitle()));  //22
        assertTrue(board.getCell(22) instanceof OpportunityKnocksCell);
        
        assertTrue("MULAN ROUGE".equals(board.getCell(23).getTitle()));         //23
        assertTrue(board.getCell(23) instanceof StreetPropertyCell);
        
        assertTrue("HAN XIN GARDEN".equals(board.getCell(24).getTitle()));      //24
        assertTrue(board.getCell(24) instanceof StreetPropertyCell);
        
        assertTrue("FALMER STATION".equals(board.getCell(25).getTitle()));      //25
        assertTrue(board.getCell(25) instanceof StationPropertyCell);
        
        assertTrue("KIRK CLOSE".equals(board.getCell(26).getTitle()));          //26
        assertTrue(board.getCell(26) instanceof StreetPropertyCell);
        
        assertTrue("PICARD AVENUE".equals(board.getCell(27).getTitle()));       //27
        assertTrue(board.getCell(27) instanceof StreetPropertyCell);
        
        assertTrue("EDISON WATER".equals(board.getCell(28).getTitle()));        //28
        assertTrue(board.getCell(28) instanceof UtilityPropertyCell);
        
        assertTrue("CRUSHER CREEK".equals(board.getCell(29).getTitle()));       //29
        assertTrue(board.getCell(29) instanceof StreetPropertyCell);
        
        assertTrue("GO TO JAIL".equals(board.getCell(30).getTitle()));          //30
        assertTrue(board.getCell(30) instanceof GoToJailCell);
        
        assertTrue("SIRAT MEWS".equals(board.getCell(31).getTitle()));          //31
        assertTrue(board.getCell(31) instanceof StreetPropertyCell);
        
        assertTrue("GHENGIS CRESCENT".equals(board.getCell(32).getTitle()));    //32
        assertTrue(board.getCell(32) instanceof StreetPropertyCell);
        
        assertTrue("POT LUCK".equals(board.getCell(33).getTitle()));            //33
        assertTrue(board.getCell(33) instanceof PotLuckCell);
        
        assertTrue("IBIS CLOSE".equals(board.getCell(34).getTitle()));          //34
        assertTrue(board.getCell(34) instanceof StreetPropertyCell);
        
        assertTrue("LEWES STATION".equals(board.getCell(35).getTitle()));       //35
        assertTrue(board.getCell(35) instanceof StationPropertyCell);
        
        assertTrue("OPPORTUNITY KNOCKS".equals(board.getCell(36).getTitle()));  //36
        assertTrue(board.getCell(36) instanceof OpportunityKnocksCell);
        
        assertTrue("HAWKING WAY".equals(board.getCell(37).getTitle()));         //37
        assertTrue(board.getCell(37) instanceof StreetPropertyCell);
        
        assertTrue("SUPER TAX".equals(board.getCell(38).getTitle()));           //38
        assertTrue(board.getCell(38) instanceof SuperTaxCell);
        
        assertTrue("TURING HEIGHTS".equals(board.getCell(39).getTitle()));      //39
        assertTrue(board.getCell(39) instanceof StreetPropertyCell);
        
        assertTrue("JAIL CELL".equals(board.getCell(40).getTitle()));           //40
        assertTrue(board.getCell(40) instanceof JailCell);
    }
    
}
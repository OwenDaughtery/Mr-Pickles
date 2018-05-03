package zytom.proptycoon.model;

import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
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
        Assert.assertEquals("Go", board.getCell(0).getTitle());
    }
    
//    @Test
//    public void checkAllCells() throws FileNotFoundException, Board.CellNotFoundException {
//        DeckCreator deckCreator = new DeckCreator();
//        Board board = new Board(deckCreator.getPropertyData());
//        Assert.assertEquals("Go", board.getCell(0).getTitle()); //0
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle()); //1
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle()); //2
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle()); //3
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle()); //4
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle()); //5
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle()); //6
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle()); //
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle());
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle());
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle());
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle());
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle());
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle());
//        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle()); 
//    }
    
}
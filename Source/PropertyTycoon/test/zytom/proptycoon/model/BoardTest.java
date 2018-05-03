package zytom.proptycoon.model;

import java.io.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import zytom.proptycoon.model.cell.GoCell;
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
        Assert.assertEquals("GO", board.getCell(0).getTitle()); //0
        Assert.assertEquals("CRAPPER STREET", board.getCell(1).getTitle()); //1
        Assert.assertEquals("POT LUCK", board.getCell(2).getTitle()); //2
        Assert.assertEquals("GANGSTERS PARADISE", board.getCell(3).getTitle()); //3
        Assert.assertEquals("INCOME TAX", board.getCell(4).getTitle()); //4
        Assert.assertEquals("BRIGHTON STATION", board.getCell(5).getTitle()); //5
        Assert.assertEquals("WEEPING ANGEL", board.getCell(6).getTitle()); //6
        Assert.assertEquals("OPPORTUNITY KNOCKS", board.getCell(7).getTitle()); //7
        Assert.assertEquals("POTTS AVENUE", board.getCell(8).getTitle()); //8
        Assert.assertEquals("NARDOLE DRIVE", board.getCell(9).getTitle()); //9
        Assert.assertEquals("JUST VISITING JAIL", board.getCell(10).getTitle()); //10
        Assert.assertEquals("SKYWALKER DRIVE", board.getCell(11).getTitle()); //11
        Assert.assertEquals("TESLA POWER CO", board.getCell(12).getTitle()); //12
        Assert.assertEquals("WOOKIE HOLE", board.getCell(13).getTitle()); //13
        Assert.assertEquals("REY LANE", board.getCell(14).getTitle());  //14
        Assert.assertEquals("HOVE STATION", board.getCell(15).getTitle());  //15
        Assert.assertEquals("COOPER DRIVE", board.getCell(16).getTitle());  //16
        Assert.assertEquals("POT LUCK", board.getCell(17).getTitle());  //17
        Assert.assertEquals("WOLOWITZ STREET", board.getCell(18).getTitle());  //18
        Assert.assertEquals("PENNY LANE", board.getCell(19).getTitle());  //19
        Assert.assertEquals("FREE PARKING", board.getCell(20).getTitle());  //20
        Assert.assertEquals("YUE FEI SQUARE", board.getCell(21).getTitle());  //21
        Assert.assertEquals("OPPORTUNITY KNOCKS", board.getCell(22).getTitle());  //22
        Assert.assertEquals("MULAN ROUGE", board.getCell(23).getTitle());  //23
        Assert.assertEquals("HAN XIN GARDEN", board.getCell(24).getTitle());  //24
        Assert.assertEquals("FALMER STATION", board.getCell(25).getTitle());  //25
        Assert.assertEquals("KIRK CLOSE", board.getCell(26).getTitle());  //26
        Assert.assertEquals("PICARD AVENUE", board.getCell(27).getTitle());  //27
        Assert.assertEquals("EDISON WATER", board.getCell(28).getTitle());  //28
        Assert.assertEquals("CRUSHER CREEK", board.getCell(29).getTitle());  //29
        Assert.assertEquals("GO TO JAIL", board.getCell(30).getTitle());  //30
        Assert.assertEquals("SIRAT MEWS", board.getCell(31).getTitle());  //31
        Assert.assertEquals("GHENGIS CRESCENT", board.getCell(32).getTitle());  //32
        Assert.assertEquals("POT LUCK", board.getCell(33).getTitle());  //33
        Assert.assertEquals("IBIS CLOSE", board.getCell(34).getTitle());  //34
        Assert.assertEquals("LEWES STATION", board.getCell(35).getTitle());  //35
        Assert.assertEquals("OPPORTUNITY KNOCKS", board.getCell(36).getTitle());  //36
        Assert.assertEquals("HAWKING WAY", board.getCell(37).getTitle());  //37
        Assert.assertEquals("SUPER TAX", board.getCell(38).getTitle());  //38
        Assert.assertEquals("TURING HEIGHTS", board.getCell(39).getTitle());  //39
        Assert.assertEquals("JAIL CELL", board.getCell(40).getTitle());  //40
    }
    
}
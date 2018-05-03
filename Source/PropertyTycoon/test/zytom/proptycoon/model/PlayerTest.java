package zytom.proptycoon.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {


    @Before



    @Test
    public void getName() {
        Player player = new Player("zenos");
       String result = player.getName();
        assertTrue(result == "zenos");
    }

    @Test
    public void getPosition() {
        Player player = new Player("zenos");
        player.toString();


    }

    @Test
    public void move() {
    }

    @Test
    public void moveTo() {
    }

    @Test
    public void getAssetCollection() {
    }

    @Test
    public void getTurnsInJail() {
    }

    @Test
    public void setTurnsInJail() {
    }

    @Test
    public void takeAssetCollection() {
    }

    @Test
    public void giveAssetCollection() {
    }
}
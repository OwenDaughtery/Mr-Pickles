/**
 * @author Max Pattman
 * @version 0.1
 */
package Unit_Tests;

import BackEnd.Classes.Player;
import BackEnd.Classes.PropertyCard;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testParametersInstatiation(){

        Player player = new Player(1,"Fred",
                500,false,0);
        assert (player instanceof Player);
    }

    @Test
    public void getPlayerNumber() {
        Player player = new Player(1,"Fred",500,false,0);

        assert(player.getPlayerNumber() == 1);

    }

    @Test
    public void getPlayerCashBalance() {
        Player player = new Player(1,"Fred",500,false,0);
        assertTrue(player.getPlayerCashBalance() == 500);
    }

    @Test
    public void setCash() {

        Player player = new Player(1,"Fred",500,false,0);
        assertTrue(player.getPlayerCashBalance() == 500);
        player.setCash(510);
        assertTrue(player.getPlayerCashBalance() == 510);

    }

    @Test
    public void putInJail() {
        Player player = new Player(1,"Fred",500,false,0);
        player.putInJail();
        assert(player.getisInJail());
    }

    @Test
    public void getisInJail() {
        Player player = new Player(1,"Fred",500,false,0);

    }

    @Test
    public void getCurrentSpace() {
        Player player = new Player(1,"Fred",500,false,0);
    }

    @Test
    public void setCurrentCell() {
        Player player = new Player(1,"Fred",500,false,0);
    }

    @Test
    public void addToPropertyPortfolio(){

    }

    @Test
    public void getOwnedProperties() {
        Player player = new Player(1,"Fred",500,false,0);
    }


}
package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.StationPropertyCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;
import zytom.proptycoon.model.cell.UtilityPropertyCell;

import java.util.ArrayList;

/**
 * @author Ayman Tom
 * Gets all fields needed by the view such as the street names and camera controller.
 */
public class BoardController {
    
    private final Board board;
    private final CameraController camera;
    
    public BoardController(Board board) {
        this.board = board;
        this.camera = new CameraController();
    }
    
    public Board getBoard() {
        return board;
    }
    
    public CameraController getCameraController() {
        return camera;
    }

    /**
     *
     * @return street names
     */
    public ArrayList<String>getStreetNames(){
        ArrayList<String>streetNames = new ArrayList<>();
        for (Cell c:board.getCells()
                ) {
            if(c instanceof StreetPropertyCell){
                streetNames.add(c.getTitle());
            }
        }
        return streetNames;
    }

    /**
     *
     * @return station names
     */
    public ArrayList<String>getStationNames(){
        ArrayList<String>stationNames = new ArrayList<>();
        for (Cell c:board.getCells()
                ) {
            if(c instanceof StationPropertyCell){
                stationNames.add(c.getTitle());
            }
        }
        return stationNames;
    }

    /**
     *
     * @return Utility Names
     */
    public ArrayList<String> getUtilityNames(){
        ArrayList<String>utilityNames = new ArrayList<>();
        for (Cell c:board.getCells()
                ) {
            if(c instanceof UtilityPropertyCell){
                utilityNames.add(c.getTitle());
            }
        }
        return utilityNames;
    }

    /**
     *
     * @return street Prices
     */
    public ArrayList<String>getStreetPrices(){
        ArrayList<String>streetPrices = new ArrayList<>();
        for (Cell c:board.getCells()
                ) {
            if(c instanceof StreetPropertyCell){
                streetPrices.add(String.valueOf(((StreetPropertyCell) c).getAssociatedCard().getPrice()));
            }
        }
        return streetPrices;
    }
    public ArrayList<String>getStationPrices(){
        ArrayList<String>stationPrices = new ArrayList<>();
        for (Cell c:board.getCells()
                ) {
            if(c instanceof StationPropertyCell){
                stationPrices.add(String.valueOf(((StationPropertyCell) c).getAssociatedCard().getPrice()));
            }
        }
        return stationPrices;
    }

    /**
     *
     * @return utility Prices
     */
    public ArrayList<String>getUtilityPrices(){
        ArrayList<String>utilityPrices = new ArrayList<>();
        for (Cell c:board.getCells()
                ) {
            if(c instanceof UtilityPropertyCell){
                utilityPrices.add(String.valueOf(((UtilityPropertyCell) c).getAssociatedCard().getPrice()));
            }
        }
        return utilityPrices;
    }

    /**
     *
     * @return income tax price
     */
    public String getIncomeTaxPrice() {
        //TODO, MAKE READ FROM CSV.
        return "100";
    }

    /**
     *
     * @return super tax price
     */
    public String getSuperTaxPrice() {
        //TODO, MAKE READ FROM CSV.
        return "200";
    }
}

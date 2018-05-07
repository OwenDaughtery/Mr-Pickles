package zytom.proptycoon.controller.game;

import zytom.proptycoon.model.Board;
import zytom.proptycoon.model.cell.Cell;
import zytom.proptycoon.model.cell.StationPropertyCell;
import zytom.proptycoon.model.cell.StreetPropertyCell;
import zytom.proptycoon.model.cell.UtilityPropertyCell;

import java.util.ArrayList;

public class BoardController {
    
    private final Board board;
    private final CameraController camera;
    
    public BoardController(Board board) {
        this.board = board;
        this.camera = new CameraController();
    }
    
    public CameraController getCameraController() {
        return camera;
    }

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

    public ArrayList<String>getStreetPrices(){
        ArrayList<String>streetNames = new ArrayList<>();
        for (Cell c:board.getCells()
                ) {
            if(c instanceof StreetPropertyCell){
                streetNames.add(String.valueOf(((StreetPropertyCell) c).getAssociatedCard().getPrice()));
            }
        }
        return streetNames;
    }
    public ArrayList<String>getStationPrices(){
        ArrayList<String>stationNames = new ArrayList<>();
        for (Cell c:board.getCells()
                ) {
            if(c instanceof StationPropertyCell){
                stationNames.add(String.valueOf(((StationPropertyCell) c).getAssociatedCard().getPrice()));
            }
        }
        return stationNames;
    }
    public ArrayList<String>getUtilityPrices(){
        ArrayList<String>utilityNames = new ArrayList<>();
        for (Cell c:board.getCells()
                ) {
            if(c instanceof UtilityPropertyCell){
                utilityNames.add(String.valueOf(((UtilityPropertyCell) c).getAssociatedCard().getPrice()));
            }
        }
        return utilityNames;
    }
    
    public String getIncomeTaxPrice() {
        //TODO, MAKE READ FROM CSV.
        return "100";
    }
    public String getSuperTaxPrice() {
        //TODO, MAKE READ FROM CSV.
        return "200";
    }
}

package zytom.proptycoon.model;


import java.io.FileNotFoundException;
import zytom.proptycoon.model.cell.Cell;

import java.util.ArrayList;
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

public final class Board {
    ArrayList<Cell> cells = new ArrayList<>();

    public Board(ArrayList<String[]> propertyData) throws FileNotFoundException {
        this.cells = initCells(propertyData);
    }

    /**
     * @author Zenos Pavlakou
     * @param cellTitles
     * @return
     */
    public ArrayList<Cell> initCells(ArrayList<String[]> cellTitles) {
        ArrayList<Cell> boardCells = new ArrayList<>();
        boardCells.add(new GoCell()); //index 0 
        boardCells.add(new StreetPropertyCell(cellTitles.get(1)[2])); //index 1
        boardCells.add(new PotLuckCell()); //index 2
        boardCells.add(new StreetPropertyCell(cellTitles.get(3)[2])); //index 3
        boardCells.add(new IncomeTaxCell()); //index 4
        boardCells.add(new StationPropertyCell(cellTitles.get(5)[2])); //index 5
        boardCells.add(new StreetPropertyCell(cellTitles.get(6)[2])); //index 6
        boardCells.add(new OpportunityKnocksCell()); //index 7
        boardCells.add(new StreetPropertyCell(cellTitles.get(8)[2])); //index 8
        boardCells.add(new StreetPropertyCell(cellTitles.get(9)[2])); //index 9
        boardCells.add(new PassingJailCell()); //index 10
        boardCells.add(new StreetPropertyCell(cellTitles.get(11)[2])); //index 11
        boardCells.add(new UtilityPropertyCell(cellTitles.get(12)[2])); //index 12
        boardCells.add(new StreetPropertyCell(cellTitles.get(13)[2])); //index 13
        boardCells.add(new StreetPropertyCell(cellTitles.get(14)[2])); //index 14
        boardCells.add(new StationPropertyCell(cellTitles.get(15)[2])); //index 15
        boardCells.add(new StreetPropertyCell(cellTitles.get(16)[2])); //index 16
        boardCells.add(new PotLuckCell()); //index 17
        boardCells.add(new StreetPropertyCell(cellTitles.get(18)[2])); //index 18
        boardCells.add(new StreetPropertyCell(cellTitles.get(19)[2])); //index 19
        boardCells.add(new FreeParkingCell()); //index 20
        boardCells.add(new StreetPropertyCell(cellTitles.get(21)[2])); //index 21
        boardCells.add(new OpportunityKnocksCell()); //index 22
        boardCells.add(new StreetPropertyCell(cellTitles.get(23)[2])); //index 23
        boardCells.add(new StreetPropertyCell(cellTitles.get(24)[2])); //index 24
        boardCells.add(new StationPropertyCell(cellTitles.get(25)[2])); //index 25
        boardCells.add(new StreetPropertyCell(cellTitles.get(26)[2])); //index 26
        boardCells.add(new StreetPropertyCell(cellTitles.get(27)[2])); //index 27
        boardCells.add(new UtilityPropertyCell(cellTitles.get(28)[2])); //index 28
        boardCells.add(new StreetPropertyCell(cellTitles.get(29)[2])); //index 29
        boardCells.add(new GoToJailCell()); //index 30
        boardCells.add(new StreetPropertyCell(cellTitles.get(31)[2])); //index 31
        boardCells.add(new StreetPropertyCell(cellTitles.get(32)[2])); //index 32
        boardCells.add(new PotLuckCell()); //index 33
        boardCells.add(new StreetPropertyCell(cellTitles.get(34)[2])); //index 34
        boardCells.add(new StationPropertyCell(cellTitles.get(35)[2])); //index 35
        boardCells.add(new OpportunityKnocksCell()); //36
        boardCells.add(new StreetPropertyCell(cellTitles.get(37)[2])); //index 37
        boardCells.add(new SuperTaxCell()); //index 38
        boardCells.add(new StreetPropertyCell(cellTitles.get(39)[2])); //index 39
        boardCells.add(new JailCell()); //index 40 where player will be when in jail
        
        return boardCells;
    }

    public Cell getCell(int index) throws CellNotFoundException {
        try {
            return this.cells.get(index);
        }
        catch (Exception e) {
            throw new CellNotFoundException(index);
        }
    }

    /**
     * @return The first cell in the ArrayList of cells.
     * @author Zenos Pavlakou
     */
    public Cell getGoCell() {
        //not completely sure this is correct.
        return this.cells.get(0);
    }

   

    public static class CellNotFoundException extends Exception {
        /**
         * Generate the exception message.
         *
         */
        public CellNotFoundException(int index) {
            super(
                    "Requested cell could not be found at Board Index " +
                            ": \n" + index
            );
        }


    }
}

package zytom.proptycoon.model;


import zytom.proptycoon.model.cell.Cell;

import java.util.ArrayList;

public final class Board {
    ArrayList<Cell> cells = new ArrayList<>();

    public Board() {
        this.cells = initCells();
    }

    /**
     * @return
     */
    public ArrayList<Cell> initCells() {
        ArrayList<Cell> cells = new ArrayList<>();

        return cells;
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

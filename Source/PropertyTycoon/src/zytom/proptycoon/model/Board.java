package zytom.proptycoon.model;


import zytom.proptycoon.model.cell.Cell;

import java.util.ArrayList;

public final class Board {
    ArrayList<Cell> cells = new ArrayList<>();

    public Board(){

        this.cells = initCells();
    }

    /**
     *
     * @return
     */
    public ArrayList<Cell> initCells() {
        ArrayList<Cell> cells = new ArrayList<>();

        return cells;
    }

    /**
     * @author Zenos Pavlakou
     * @return The first cell in the ArrayList of cells. 
     */
    public Cell getGoCell(){
        //not completely sure this is correct.
        return this.cells.get(0);
    }

}

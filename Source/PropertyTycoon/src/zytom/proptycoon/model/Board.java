package zytom.proptycoon.model;


import zytom.proptycoon.model.cell.Cell;

import java.util.ArrayList;

public class Board {
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

    public Cell getGoCell(){



    }

}

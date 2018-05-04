/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.model.cell;

/**
 *
 * @author Tom Chesters
 */
public abstract class Cell {
    
    private final String title;
    
    /**
     * @author Zenos Pavlakou
     * 
     * @param title The title of the cell being created
     */
    public Cell(String title) {
        this.title = title;
    }
    
    /**
     * @author Zenos Pavlakou
     * 
     * @return The title of the cell
     */
    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString(){
        String info = "Cell title : " + getTitle() + "\n";
        return info;
    }


}

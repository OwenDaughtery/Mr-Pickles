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
    private final int index;
    
    /**
     * @author Zenos Pavlakou
     * 
     * @param title The title of the cell being created
     */
    public Cell(String title, int index) {
        this.title = title;
        this.index = index;
    }
    
    /**
     * @author Zenos Pavlakou
     * 
     * @return The title of the cell
     */
    public String getTitle() {
        return this.title;
    }
    
    public int getIndex() {
        return this.index;
    }

    @Override
    public String toString(){
        String info  = "Cell Title : "+ getTitle() +"\n"+
                        "Cell Index :" + getIndex()+ "\n";
        return info;
    }
}

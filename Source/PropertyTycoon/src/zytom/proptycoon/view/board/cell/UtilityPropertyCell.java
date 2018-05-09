/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.board.cell;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tom
 */
public class UtilityPropertyCell extends InsideCell {
    
    private final String title;
    private final String price;
    private final ArrayList<String> lines;
    private static final int CHAR_LIMIT = 8;

    private BufferedImage tesla;
    private BufferedImage drop;
    private InsideCell.Side side;

    public UtilityPropertyCell(
            Dimension boardSize, 
            float boardProportion,
            InsideCell.Side side,
            int rowIndex,
            String title,
            String price) {
        super(boardSize, boardProportion, side, rowIndex);
        this.title = title;
        this.price = price;
        
        lines = new ArrayList<>();
        String remainder = this.title;
        while (remainder.length() > CHAR_LIMIT) {
            lines.add(remainder.substring(0, CHAR_LIMIT));
            remainder = remainder.substring(CHAR_LIMIT);
        }
        lines.add(remainder);
        this.side = side;
        try {
            this.tesla = ImageIO.read(new File("./resources/images/cells/tesla.png"));
            this.drop = ImageIO.read(new File("./resources/images/cells/drop.png"));
        } catch (IOException ex) {
            Logger.getLogger(StationPropertyCell.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void renderContents(Graphics2D g2) {
        g2.setFont(new Font("Monaco", Font.PLAIN, 8));
        
        float yPos = dimension.height * 0.175f;
        for (int i=0; i<lines.size(); i++) {
            g2.drawString(lines.get(i), 8, yPos);
            yPos += 10.0f;
        }
        
        g2.drawString("Price: " + price, 4, dimension.height * 0.85f);
        switch (side) {
            case LEFT:
                renderTesla(g2);
                break;
            case TOP:
                renderDrop(g2);
                break;
        }
    }


    public void renderTesla(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.38, 0.38);
        g2.drawImage(tesla, 38, 80, null);
        g2.setTransform(at);
    }

    public void renderDrop(Graphics2D g2) {
        AffineTransform at = g2.getTransform();
        g2.scale(0.45, 0.45);
        g2.drawImage(drop, 22, 55, null);
        g2.setTransform(at);
    }
}

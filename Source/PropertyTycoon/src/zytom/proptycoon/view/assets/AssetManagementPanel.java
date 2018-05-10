/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.assets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author zenos
 */
public final class AssetManagementPanel extends javax.swing.JPanel {
    
    public AssetManagementPanel() {

    }
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.getContentPane().setPreferredSize(new Dimension(720, 720));

        
        JPanel container = new JPanel();
        container.setSize(new Dimension(720, 720));
        
        JPanel l = new JPanel();
        l.setMinimumSize(new Dimension(200, 200));
        l.setBackground(Color.BLACK);
        
        JPanel r = new JPanel();
        r.setMinimumSize(new Dimension(200, 200));
        r.setBackground(Color.BLUE);
        
        container.add(l);
        container.add(r);
        
        container.setPreferredSize(new Dimension(720, 720));
        frame.add(container, BorderLayout.CENTER);
        
        frame.setMinimumSize(new Dimension(720, 720));
       // frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }



    
}

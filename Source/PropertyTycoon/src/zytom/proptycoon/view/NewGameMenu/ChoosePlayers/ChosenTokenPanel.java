/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.NewGameMenu.ChoosePlayers;

/**
 *
 * @author utopia
 */
public class ChosenTokenPanel extends javax.swing.JPanel {

    /**
     * Creates new form ChosenPlayerPanel
     */
    public ChosenTokenPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aiLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        aiLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        aiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aiLabel.setText("AI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aiLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aiLabel;
    // End of variables declaration//GEN-END:variables
}

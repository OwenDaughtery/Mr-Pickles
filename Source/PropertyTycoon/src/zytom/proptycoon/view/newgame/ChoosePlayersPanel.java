/*
 * PropertyTycoon Application by Zytom
 */
package zytom.proptycoon.view.newgame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel;
import zytom.proptycoon.view.newgame.chooseplayers.TokenLabel;
import zytom.proptycoon.view.newgame.chooseplayers.TokenLabel.TokenType;
import zytom.proptycoon.view.newgame.chooseplayers.TokenPanel;

/**
 *
 * @author utopia
 */
public class ChoosePlayersPanel extends javax.swing.JPanel {
    
    //View Models.
    private class TokenLabelModel {
        private final TokenType type;
        public TokenLabelModel(TokenType type) {
            this.type = type;
        }
        public TokenType getType() {
            return type;
        }
    }
    private abstract class AbstractTokenPanelModel {
        private TokenLabelModel childToken;
        public AbstractTokenPanelModel() {
            this.childToken = null;
        }
        public TokenLabelModel removeToken() {
            TokenType tokenType = this.childToken.type;
            this.childToken = null;
            return new TokenLabelModel(tokenType);
        }
        public final void giveToken(TokenLabelModel childToken) {
            this.childToken = childToken;
        }
        public final boolean containsToken(TokenLabelModel childToken) {
            return (this.childToken == childToken);
        }
        public final boolean hasAToken() {
            return (this.childToken != null);
        }
    }
    private class ChosenPanelModel extends AbstractTokenPanelModel { }
    private class TokenPanelModel extends AbstractTokenPanelModel { }    

    //Views
    //References to token panels in array form.
    private final TokenPanel[] tokenPanels;
    //References to chosen panels in array form.
    private final ChosenTokenPanel[] chosenPanels;
    //Token labels that move around.
    private final TokenLabel[] tokenLabels;
    
    
    //ViewModels
    private final TokenPanelModel[] tokenPanelModels;
    private final ChosenPanelModel[] chosenPanelModels;
    private final TokenLabelModel[] tokenLabelModels;
    
    /**
     * Creates new form ChoosePlayersPanel
     */
    public ChoosePlayersPanel() {
        initComponents();
        
        chosenPanels = new ChosenTokenPanel[6];
        tokenPanels = new TokenPanel[6];
        tokenLabels = new TokenLabel[6];
        
        tokenPanels[0] = tokenPanel1;
        tokenPanels[1] = tokenPanel2;
        tokenPanels[2] = tokenPanel3;
        tokenPanels[3] = tokenPanel4;
        tokenPanels[4] = tokenPanel5;
        tokenPanels[5] = tokenPanel6;
        
        chosenPanels[0] = chosenTokenPanel1;
        chosenPanels[1] = chosenTokenPanel2;
        chosenPanels[2] = chosenTokenPanel3;
        chosenPanels[3] = chosenTokenPanel4;
        chosenPanels[4] = chosenTokenPanel5;
        chosenPanels[5] = chosenTokenPanel6;
        
        chosenPanelModels = new ChosenPanelModel[6];
        tokenPanelModels = new TokenPanelModel[6];
        tokenLabelModels = new TokenLabelModel[6];
        initViewModels();
        
        initTokenLabels();
        placeTokenLabels();
    }
    
    
    private void initTokenLabels(){
        try {
            tokenLabels[0] = new TokenLabel(TokenLabel.TokenType.BOOT);
            tokenLabels[1] = new TokenLabel(TokenLabel.TokenType.SMARTPHONE);
            tokenLabels[2] = new TokenLabel(TokenLabel.TokenType.GOBLET);
            tokenLabels[3] = new TokenLabel(TokenLabel.TokenType.HATSTAND);
            tokenLabels[4] = new TokenLabel(TokenLabel.TokenType.CAT);
            tokenLabels[5] = new TokenLabel(TokenLabel.TokenType.SPOON);
        } catch (IOException ex) {
            //One of the token image files could not be found.
            //Show error dialog.
            JOptionPane.showMessageDialog(
                    (JFrame) SwingUtilities.getWindowAncestor(this),
                    "TokenLabel image file could not be found.",
                    "File Not Found",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    private void initViewModels() {
        for (int i=0; i<6; i++) {
            chosenPanelModels[i] = new ChosenPanelModel();
            tokenPanelModels[i] = new TokenPanelModel();
        }
        tokenLabelModels[0] = new TokenLabelModel(TokenLabel.TokenType.BOOT);
        tokenLabelModels[1] = new TokenLabelModel(TokenLabel.TokenType.SMARTPHONE);
        tokenLabelModels[2] = new TokenLabelModel(TokenLabel.TokenType.GOBLET);
        tokenLabelModels[3] = new TokenLabelModel(TokenLabel.TokenType.HATSTAND);
        tokenLabelModels[4] = new TokenLabelModel(TokenLabel.TokenType.CAT);
        tokenLabelModels[5] = new TokenLabelModel(TokenLabel.TokenType.SPOON);
    }
    
    private int getChosenPanelIndex(ChosenPanelModel chosenPanelModel) {
        for (int i=0; i<6; i++) {
            if (chosenPanelModels[i] == chosenPanelModel)
                return i;
        }
        return -1;
    }
    
    private int getTokenPanelIndex(TokenPanelModel tokenPanelModel) {
        for (int i=0; i<6; i++) {
            if (tokenPanelModels[i] == tokenPanelModel)
                return i;
        }
        return -1;
    }
    
    private int getChosenPanelIndex(ChosenTokenPanel chosenPanel) {
        for (int i=0; i<6; i++) {
            if (chosenPanels[i] == chosenPanel)
                return i;
        }
        return -1;
    }
    
    private int getTokenPanelIndex(TokenPanel tokenPanel) {
        for (int i=0; i<6; i++) {
            if (tokenPanels[i] == tokenPanel)
                return i;
        }
        return -1;
    }
    
    
    private int getTokenLabelIndex(TokenLabelModel tokenLabelModel) {
        for (int i=0; i<6; i++) {
            if (tokenLabelModels[i].getType() == tokenLabelModel.getType())
                return i;
        }
        return -1;
    }
    
    private void placeTokenLabels() {
        //Loop through token panels.
        for (int i = 0; i < 6; i++) {
            //Add the corresponding token label.
            tokenPanels[i].add(tokenLabels[i]);
            //Do same with view model.
            tokenPanelModels[i].giveToken(tokenLabelModels[i]);
        }
    }
    
    private void chooseToken(TokenPanel tokenPanel) {
        //Find the index of the token panel.
        int panelIndex = getTokenPanelIndex(tokenPanel);
        
        TokenPanelModel tokenPanelModel = tokenPanelModels[panelIndex];
        
        //Exit if panel doesn't contain a token.
        if (!tokenPanelModel.hasAToken())
            return;
        
        //Otherwise...
        
        //Get the token on the token panel.
        //Assume that first child component is a token label.
        TokenLabel tokenLabel = (TokenLabel) tokenPanel.getComponent(0);
        
        //Remove the token label on the token panel.
        tokenPanel.remove(tokenLabel);
        //Do same for view-model.
        TokenLabelModel tokenLabelModel = tokenPanelModel.removeToken();
        
        //Find the next free chosen token panel.
        int smallestIndex = 6;
        for (int i=0; i<6; i++) {
            if (!chosenPanelModels[i].hasAToken() && i < smallestIndex) {
                smallestIndex = i;
            }
        }
        
        //Get the chosen panel view and view-model at that index.
        ChosenTokenPanel chosenPanel = chosenPanels[smallestIndex];
        ChosenPanelModel chosenPanelModel = chosenPanelModels[smallestIndex];
        
        //Give them the corresponding view & view-model for the token label.
        chosenPanel.add(tokenLabel);
        chosenPanelModel.giveToken(tokenLabelModel);
        
        //Retitle AI label to P#
        JLabel aiLabel = (JLabel) chosenPanel.getComponent(0);
        aiLabel.setText("P" + (smallestIndex + 1));
        
        //Enable the chosen panel (in case it was disabled.)
        chosenPanel.setEnabled(true);
    }
    
    private void unchooseToken(ChosenTokenPanel chosenPanel) {
        //Get the index of the chosen token panel.
        int index = getChosenPanelIndex(chosenPanel);
        ChosenPanelModel chosenPanelModel = chosenPanelModels[index];
        
        //Check if it has something chosen.
        //Exit if not.
        if (!chosenPanelModel.hasAToken())
            return;
        
        //Otherwise...
        //Remove the token view and view-model from the chosen panel.
        TokenLabel tokenLabel = (TokenLabel) chosenPanel.getComponent(1);
        chosenPanel.remove(tokenLabel);
        TokenLabelModel tokenLabelModel = chosenPanelModel.removeToken();
        
        //And give it to it's original token panel.
        int tokenPanelIndex = this.getTokenLabelIndex(tokenLabelModel);
        TokenPanel tokenPanel = (TokenPanel) tokenPanels[tokenPanelIndex];
        TokenPanelModel tokenPanelModel = tokenPanelModels[tokenPanelIndex];
        tokenPanel.add(tokenLabel);
        tokenPanelModel.giveToken(tokenLabelModel);
        
        
        //Retitle P# label to AI
        JLabel aiLabel = (JLabel) chosenPanel.getComponent(0);
        aiLabel.setText("AI");
    }
    
    private void highlight(JPanel panel) {
        //Find the panel.
        panel.setBorder(BorderFactory.createRaisedBevelBorder());
    }
    
    private void highlight(TokenPanel panel) {
        int index = getTokenPanelIndex(panel);
        TokenPanelModel tokenPanelModel = tokenPanelModels[index];
        if (tokenPanelModel.hasAToken())
            highlight( (JPanel) panel );
    }
    
    private void highlight(ChosenTokenPanel panel) {
        int index = getChosenPanelIndex(panel);
        ChosenPanelModel chosenPanelModel = chosenPanelModels[index];
        if (chosenPanelModel.hasAToken())
            highlight( (JPanel) panel );
    }
    
    private void unhighlight(JPanel panel) {
        panel.setBorder(BorderFactory.createEtchedBorder());
    }
    
    /**
     * Enable view functionality for clicking a chosen token panel.
     * @param panel The chosen token panel panel that's been clicked.
     */
    public void clickPanel(ChosenTokenPanel panel) {
        int index = getChosenPanelIndex(panel);
        ChosenPanelModel chosenPanelModel = chosenPanelModels[index];
        
        //Check if it has a token.
        if (chosenPanelModel.hasAToken()) {
            //If so, unchoose the token.
            this.unchooseToken(panel);
        }
        else {
            //Otherwise, toggle it's enabled/disabled state.
            if (panel.isEnabled()) {
                panel.setEnabled(false);
            } else {
                panel.setEnabled(true);
            }
        }
    }
    
    /**
     * Enable view functionality for clicking a token panel.
     * @param panel The token panel that's been clicked.
     */
    public void clickPanel(TokenPanel panel) {
        int index = getTokenPanelIndex(panel);
        TokenPanelModel tokenPanelModel = tokenPanelModels[index];
        
        //Check if it has a token.
        if (tokenPanelModel.hasAToken()) {
            //If so, choose it.
            this.chooseToken(panel);
        }
    }
    
    /**
     * Enable view functionality for hovering the mouse over a token panel.
     * @param panel The token panel that's been hovered over.
     */
    public void mouseEnter(TokenPanel panel) {
        this.highlight(panel);
    }
    
    /**
     * Enable view functionality for hovering the mouse over a chosen token panel.
     * @param panel The chosen panel that's been hovered over.
     */
    public void mouseEnter(ChosenTokenPanel panel) {
        this.highlight(panel);
    }
    
    /**
     * Enable view functionality for hovering the mouse away from any panel.
     * @param panel The panel that's been hovered away from.
     */
    public void mouseLeave(JPanel panel) {
        this.unhighlight(panel);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChoosePlayersLabel = new javax.swing.JLabel();
        chosenTokenPanel1 = new zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel();
        chosenTokenPanel2 = new zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel();
        chosenTokenPanel3 = new zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel();
        chosenTokenPanel4 = new zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel();
        chosenTokenPanel5 = new zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel();
        chosenTokenPanel6 = new zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel();
        tokenPanel1 = new zytom.proptycoon.view.newgame.chooseplayers.TokenPanel();
        tokenPanel2 = new zytom.proptycoon.view.newgame.chooseplayers.TokenPanel();
        tokenPanel3 = new zytom.proptycoon.view.newgame.chooseplayers.TokenPanel();
        tokenPanel4 = new zytom.proptycoon.view.newgame.chooseplayers.TokenPanel();
        tokenPanel5 = new zytom.proptycoon.view.newgame.chooseplayers.TokenPanel();
        tokenPanel6 = new zytom.proptycoon.view.newgame.chooseplayers.TokenPanel();
        nextButton = new javax.swing.JButton();

        ChoosePlayersLabel.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        ChoosePlayersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChoosePlayersLabel.setText("Choose Players...");

        nextButton.setText("Next");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tokenPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTokenPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(ChoosePlayersLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tokenPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tokenPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tokenPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tokenPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tokenPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(chosenTokenPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(chosenTokenPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(chosenTokenPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(chosenTokenPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(chosenTokenPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(ChoosePlayersLabel)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chosenTokenPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTokenPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTokenPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTokenPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTokenPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenTokenPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tokenPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tokenPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tokenPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tokenPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tokenPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tokenPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChoosePlayersLabel;
    private zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel chosenTokenPanel1;
    private zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel chosenTokenPanel2;
    private zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel chosenTokenPanel3;
    private zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel chosenTokenPanel4;
    private zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel chosenTokenPanel5;
    private zytom.proptycoon.view.newgame.chooseplayers.ChosenTokenPanel chosenTokenPanel6;
    private javax.swing.JButton nextButton;
    private zytom.proptycoon.view.newgame.chooseplayers.TokenPanel tokenPanel1;
    private zytom.proptycoon.view.newgame.chooseplayers.TokenPanel tokenPanel2;
    private zytom.proptycoon.view.newgame.chooseplayers.TokenPanel tokenPanel3;
    private zytom.proptycoon.view.newgame.chooseplayers.TokenPanel tokenPanel4;
    private zytom.proptycoon.view.newgame.chooseplayers.TokenPanel tokenPanel5;
    private zytom.proptycoon.view.newgame.chooseplayers.TokenPanel tokenPanel6;
    // End of variables declaration//GEN-END:variables
}

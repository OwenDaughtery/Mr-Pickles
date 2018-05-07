//package zytom.proptycoon.view.dice;
//
//
//import zytom.proptycoon.view.board.cell.Cell;
//import zytom.proptycoon.view.board.cell.CornerCell;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.geom.AffineTransform;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class DiceCell extends Cell {
//
//
//    private BufferedImage one;
//    private BufferedImage two;
//    private BufferedImage three;
//    private BufferedImage four;
//    private BufferedImage five;
//    private BufferedImage six;
//    private static final double scale = 0.40;
//    private static final int drawIm = 20;
//
//    private int state;
//
//    public DiceCell() {
//        try {
//            this.one= ImageIO.read(new File("./resources/images/dice/1.png"));
//            this.two = ImageIO.read(new File("./resources/images/dice/2.png"));
//            this.three = ImageIO.read(new File("./resources/images/dice/3.png"));
//            this.four = ImageIO.read(new File("./resources/images/dice/4.png"));
//            this.five = ImageIO.read(new File("./resources/images/dice/5.png"));
//            this.six = ImageIO.read(new File("./resources/images/dice/6.png"));
//        } catch (IOException ex) {
//            Logger.getLogger("Dice Images Not Found").log(Level.SEVERE, null, ex);
//        }
//        state = 6;
//    }
//
//    public void setState(int state) {
//        this.state = state;
//    }
//
//    public void renderOne(Graphics2D g2) {
//        AffineTransform at = g2.getTransform();
//        g2.scale(scale, scale);
//        g2.drawImage(one, drawIm, drawIm, null);
//        g2.setTransform(at);
//    }
//    public void renderTwo(Graphics2D g2) {
//        AffineTransform at = g2.getTransform();
//        g2.scale(scale, scale);
//        g2.drawImage(two, drawIm, drawIm, null);
//        g2.setTransform(at);
//    }
//    public void renderThree(Graphics2D g2) {
//        AffineTransform at = g2.getTransform();
//        g2.scale(scale, scale);
//        g2.drawImage(three, drawIm, drawIm, null);
//        g2.setTransform(at);
//    }
//    public void renderFour(Graphics2D g2) {
//        AffineTransform at = g2.getTransform();
//        g2.scale(scale, scale);
//        g2.drawImage(four, drawIm, drawIm, null);
//        g2.setTransform(at);
//    }
//    public void renderFive(Graphics2D g2) {
//        AffineTransform at = g2.getTransform();
//        g2.scale(scale, scale);
//        g2.drawImage(five, drawIm, drawIm, null);
//        g2.setTransform(at);
//    }
//    public void renderSix(Graphics2D g2) {
//        AffineTransform at = g2.getTransform();
//        g2.scale(scale, scale);
//        g2.drawImage(six, drawIm, drawIm, null);
//        g2.setTransform(at);
//    }
//    public void renderError(Graphics2D g2) {
//        AffineTransform at = g2.getTransform();
//        g2.scale(scale, scale);
//        g2.drawString("No Number", drawIm, drawIm);
//        g2.setTransform(at);
//    }
//
//    @Override
//    public void renderContents(Graphics2D g2) {
//        switch (state){
//            case(1):
//                renderOne(g2);
//                break;
//            case(2):
//                renderTwo(g2);
//                break;
//            case(3):
//                renderThree(g2);
//                break;
//            case(4):
//                renderFour(g2);
//                break;
//            case(5):
//                renderFive(g2);
//                break;
//            case(6):
//                renderSix(g2);
//                break;
//            default:
//                renderError(g2);
//        }
//    }
//}

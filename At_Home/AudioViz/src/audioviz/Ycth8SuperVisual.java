/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioviz;

import static java.lang.Integer.min;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineJoin;

/**
 *
 * @author WIN
 */
public class Ycth8SuperVisual implements Visualizer{
    
    private final String visualizerName = "Ycth8 Super Visual";
    
    private String visualizerOriginalStyle = "";
    
    private Line[] lines1;
    private Line[] lines2;
    
    private int numberOfBands;
    private AnchorPane visualizerPane;
    private double visualizerPaneHeight;
    private double visualizerPaneWidth;
    
    private double bandWidth;
    private final double deltaWidth = 5;
    private double shift;
    
    private double displayAreaHeight;
    private double displayAreaWidth;
    private double displayAreaWidthCenter;
    
    private final double hue = 330.0;
    
    @Override
    public void start(Integer numBands, AnchorPane vizPane) {
        end();
        
        lines1 = new Line[numBands];
        lines2 = new Line[numBands];
        
        visualizerOriginalStyle = vizPane.getStyle();
        
        this.numberOfBands = numBands;
        this.visualizerPane = vizPane;
        this.visualizerPaneHeight = vizPane.getWidth();
        this.visualizerPaneWidth = vizPane.getWidth();
        
        Rectangle rectangle = new Rectangle(visualizerPaneWidth, visualizerPaneHeight);
        rectangle.setLayoutX(0);
        rectangle.setLayoutY(0);
        vizPane.setClip(rectangle);
        
        displayAreaHeight = visualizerPaneHeight-120;
        displayAreaWidth = visualizerPaneWidth;
        displayAreaWidthCenter = displayAreaWidth/2;
        
        bandWidth = displayAreaHeight/numberOfBands;
        shift = bandWidth/2;
        
        for (int i = 0; i < numBands; i++) {
            Line line1 = new Line();
            line1.setStartX(displayAreaWidthCenter+shift); 
            line1.setStartY(bandWidth*i + shift);         
            line1.setEndX(displayAreaWidthCenter+shift); 
            line1.setEndY(bandWidth*i + shift);
            line1.setSmooth(true);
            line1.setStrokeWidth(bandWidth/2);
            line1.setStroke(Color.hsb(hue, 1.0, 1.0, 1.0));
            vizPane.getChildren().add(line1);
            lines1[i] = line1;
            
            Line line2 = new Line();
            line2.setStartX(displayAreaWidthCenter-shift); 
            line2.setStartY(bandWidth*i + shift);         
            line2.setEndX(displayAreaWidthCenter-shift); 
            line2.setEndY(bandWidth*i + shift);
            line2.setSmooth(true);
            line2.setStrokeWidth(bandWidth/2);
            line2.setStroke(Color.hsb(hue, 1.0, 1.0, 1.0));
            vizPane.getChildren().add(line2);
            lines2[i] = line2;
        }

    }

    @Override
    public void end() {
        if (lines1 != null) {
            for (Line line1 : lines1) {
                visualizerPane.getChildren().remove(line1);
            }
            for (Line line2 : lines2) {
                visualizerPane.getChildren().remove(line2);
            }
            lines1 = null;
            visualizerPane.setClip(null);
            visualizerPane.setStyle(visualizerOriginalStyle);
        } 
    }

    @Override
    public String getName() {
        return visualizerName;
    }

    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
        if (lines1 == null) {
            return;
        }
        else{

            for (int i = 0; i < numberOfBands; i++) {
                lines1[i].setStartX(displayAreaWidthCenter + shift - 1.5*(60-Math.abs(magnitudes[i]))); 
                lines1[i].setEndX(displayAreaWidthCenter + shift + 1.5*(60-Math.abs(magnitudes[i]))); 
                lines1[i].setTranslateX(1.5*(60-Math.abs(magnitudes[i])));
                
                lines2[i].setStartX(displayAreaWidthCenter - shift - 3*(60-Math.abs(magnitudes[i]))); 
                lines2[i].setEndX(displayAreaWidthCenter - shift - 3*(60-Math.abs(magnitudes[i]))); 
            }
            
        }
    }
    
}

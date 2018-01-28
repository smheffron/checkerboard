/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Shelby Heffron
 * pp: smhgzd
 */
public class CheckerboardModel 
{
    private Color lightColor = Color.RED;
    
    private Color darkColor = Color.BLACK;
    
    private int numRows = 8;
    
    private int numCols = 8;
    
    private double boardWidth;
    
    private double boardHeight;
    
    private AnchorPane anchorPane;
    
    private double rectangleWidth;
    
    private double rectangleHeight;
    
    
    
    public CheckerboardModel(int numRows, int numCols, double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }
   
    public CheckerboardModel(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build(){
        anchorPane = new AnchorPane();
        
        rectangleWidth = Math.ceil(boardWidth / numCols);
        rectangleHeight = Math.ceil(boardHeight / numRows);
        
        for(int i = 0; i<numCols; i++){
            for(int j = 0; j<numRows; j++) {
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight);

                if((j%2)==(i%2)){
                    rect.setFill(lightColor);
                }
                else{
                    rect.setFill(darkColor);
                }

                rect.setX(rectangleWidth*j);
                rect.setY(rectangleHeight*i);
                anchorPane.getChildren().add(rect);
                
            }
        }
        
        return anchorPane;
    }
    
    public AnchorPane getAnchorPane(){
        return anchorPane;
    }
    
    public int getNumRows(){
        return numRows;
    }
    
    public int getNumCols(){
        return numCols;
    }
    
    public double getWidth(){
        return boardWidth;
    }
    
    public double getHeight(){
        return boardHeight;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
    
    public double getRectangleWidth(){
        return rectangleWidth;
    }
    
    public double getRectangleHeight(){
        return rectangleHeight;
    }
      
}

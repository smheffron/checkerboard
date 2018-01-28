/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *  @author Shelby Heffron
 *  pp: smhgzd
 */
public class CheckerboardFXMLController implements Initializable, Startable{

    @FXML
    private Pane boardArea;
    
    private Stage stage;

    private CheckerboardModel checkerboard;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;

        checkerboard = new CheckerboardModel(8,8, boardArea.getWidth(), boardArea.getHeight());
        addToBoardArea();

        ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            update(checkerboard.getNumRows(),checkerboard.getNumCols());
        };

        this.stage.widthProperty().addListener(lambdaChangeListener);
        this.stage.heightProperty().addListener(lambdaChangeListener);
    }
    
    private void update(int numRow, int numCol){

        clearBoardArea();
        checkerboard = new CheckerboardModel(numRow, numCol, boardArea.getWidth(), boardArea.getHeight(), checkerboard.getLightColor(),checkerboard.getDarkColor());
        addToBoardArea();
        
    }

    @FXML
    private void handle16(ActionEvent event) {
        update(16,16);
    }

    @FXML
    private void handle10(ActionEvent event) {
        update(10,10);
    }

    @FXML
    private void handle8(ActionEvent event) {
        update(8,8);
    }

    @FXML
    private void handle3(ActionEvent event) {
        update(3,3);
    }

    @FXML
    private void handleDefault(ActionEvent event) {
        clearBoardArea();
        checkerboard = new CheckerboardModel(checkerboard.getNumRows(),checkerboard.getNumCols(),boardArea.getWidth(), boardArea.getHeight());
        addToBoardArea();
    }

    @FXML
    private void handleBlue(ActionEvent event) {
        clearBoardArea();
        checkerboard = new CheckerboardModel(checkerboard.getNumRows(),checkerboard.getNumCols(),boardArea.getWidth(), boardArea.getHeight(), Color.SKYBLUE, Color.DARKBLUE);
       addToBoardArea();
    }
    
    private void clearBoardArea(){
        boardArea.getChildren().clear();
    }
    
    private void addToBoardArea(){
         boardArea.getChildren().add(checkerboard.build());
    }
     
}

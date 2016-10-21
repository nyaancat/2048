package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class WinController {
    private Field field;

    @FXML
    private Button btnRestart;
    @FXML
    Parent root;

    public void setField(Field newField){
        field = newField;
    }

    public Field getField(){
        return field;
    }

    public void btnRestartClick(ActionEvent actionEvent) {
        field = new Field();
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }


}

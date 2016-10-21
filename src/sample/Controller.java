package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.*;

public class Controller {
    @FXML
    private Label lbl_0_0;
    @FXML
    private Label lbl_0_1;
    @FXML
    private Label lbl_0_2;
    @FXML
    private Label lbl_1_0;
    @FXML
    private Label lbl_1_1;
    @FXML
    private Label lbl_1_2;
    @FXML
    private Label lbl_2_0;
    @FXML
    private Label lbl_2_1;
    @FXML
    private Label lbl_2_2;
    @FXML
    private Label lbl_0_3;
    @FXML
    private Label lbl_1_3;
    @FXML
    private Label lbl_2_3;
    @FXML
    private Label lbl_3_3;
    @FXML
    private Label lbl_3_0;
    @FXML
    private Label lbl_3_1;
    @FXML
    private Label lbl_3_2;

    private int mSize = 4;

    private Field field = new Field();

    private Label[][] lblArr = new Label [mSize][mSize];

    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private WinController winController;
    private Stage winStage;

    public boolean gameOver = true;

 public void initialize() {
      lblArr[0][0] = lbl_0_0;
      lblArr[0][1] = lbl_0_1;
      lblArr[0][2] = lbl_0_2;
      lblArr[1][0] = lbl_1_0;
      lblArr[1][1] = lbl_1_1;
      lblArr[1][2] = lbl_1_2;
      lblArr[2][0] = lbl_2_0;
      lblArr[2][1] = lbl_2_1;
      lblArr[2][2] = lbl_2_2;
      lblArr[0][3] = lbl_0_3;
      lblArr[1][3] = lbl_1_3;
      lblArr[2][3] = lbl_2_3;
      lblArr[3][3] = lbl_3_3;
      lblArr[3][0] = lbl_3_0;
      lblArr[3][1] = lbl_3_1;
      lblArr[3][2] = lbl_3_2;

     try {

         fxmlLoader.setLocation(getClass().getResource("sampleWin.fxml"));
         fxmlEdit = fxmlLoader.load();
         winController = fxmlLoader.getController();

     } catch (IOException e) {
         e.printStackTrace();
     }

     //две заполненные стартовые ячейи
     field.newNumber();
     field.newNumber();

     setField();
  }

    private void setField () {
        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++) {
                if (field.fieldArr[i][j] != 0)
                    lblArr[i][j].setText(Integer.toString(field.fieldArr[i][j]));
                else //очищение несоответствующих действительности надписей
                    if (Integer.toString(field.fieldArr[i][j]) != lblArr[i][j].getText())
                        lblArr[i][j].setText(" ");
            }
    }

    //создает новое окно - конец игры. проверяет, изменилось ли поле (была ли нажата кнопка рестарт)
    //и соответственно обновляет его в родительском окне
    private void newWindow(ActionEvent actionEvent) {
        winController.setField(field);
        if (winStage == null) {
            winStage = new Stage();
            winStage.setTitle("Game Over");
            winStage.setResizable(false);
            winStage.setScene(new Scene(fxmlEdit));
            winStage.initModality(Modality.WINDOW_MODAL);
            winStage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());
        }
        winStage.showAndWait();
        if (winController.getField() != field){
            field = winController.getField();
            field.newNumber();
            field.newNumber();
            setField();
        }
    }

    public void btnDownClick(ActionEvent actionEvent) {
        if (field.down())
            field.newNumber();
        setField();

        if (field.gameOver)
            newWindow(actionEvent);
    }

    public void btnUpClick(ActionEvent actionEvent) {
       if (field.up())
           field.newNumber();
        setField();

        if (field.gameOver)
            newWindow(actionEvent);
    }

    public void btnRightClick(ActionEvent actionEvent) {
        if (field.right())
            field.newNumber();
        setField();

        if (field.gameOver)
            newWindow(actionEvent);
    }

    public void btnLeftClick(ActionEvent actionEvent) {
        if (field.left())
            field.newNumber();
        setField();

        if (field.gameOver)
            newWindow(actionEvent);
    }
}

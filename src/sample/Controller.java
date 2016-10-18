package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

      for (int i = 0; i < mSize; i++)
          for (int j = 0; j < mSize; j++)
              lblArr[i][j].setText(Integer.toString(field.fieldArr[i][j]));

  }

    public void setField (int fieldArr[][]) {
        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++)
                lblArr[i][j].setText(Integer.toString(fieldArr[i][j]));
    }

    public void btnDownClick(ActionEvent actionEvent) {
        int [][] arr = field.down();
        setField(arr);
    }

    public void btnUpClick(ActionEvent actionEvent) {
        int [][] arr = field.up();
        setField(arr);
    }

    public void btnRightClick(ActionEvent actionEvent) {
        int [][] arr = field.right();
        setField(arr);
    }

    public void btnLeftClick(ActionEvent actionEvent) {
        int [][] arr = field.left();
        setField(arr);
    }
}

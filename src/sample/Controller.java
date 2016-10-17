package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    private Label[][] lbl_mas = new Label [3][3];
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


    private Field field = new Field();

 public void initialize()
  {
      lbl_mas[0][0] = lbl_0_0;
      lbl_mas[0][1] = lbl_0_1;
      lbl_mas[0][2] = lbl_0_2;
      lbl_mas[1][0] = lbl_1_0;
      lbl_mas[1][1] = lbl_1_1;
      lbl_mas[1][2] = lbl_1_2;
      lbl_mas[2][0] = lbl_2_0;
      lbl_mas[2][1] = lbl_2_1;
      lbl_mas[2][2] = lbl_2_2;

      for (int i = 0; i < 3; i++)
          for (int j = 0; j < 3; j++)
              lbl_mas[i][j].setText(Integer.toString(field.field_mas[i][j]));

  }

    public void set_field (int field_mas[][])
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                lbl_mas[i][j].setText(Integer.toString(field_mas[i][j]));
    }

    public void btnDown_click(ActionEvent actionEvent)
    {
        int [][] ff = field.down();
        set_field(ff);
    }

    public void btnUp_click(ActionEvent actionEvent)
    {
        int [][] ff = field.up();
        set_field(ff);
    }

    public void btnRight_click(ActionEvent actionEvent)
    {
        int [][] ff = field.right();
        set_field(ff);
    }

    public void btnLeft_click(ActionEvent actionEvent)
    {
        int [][] ff = field.left();
        set_field(ff);
    }
}

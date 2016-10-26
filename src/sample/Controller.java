package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

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


    @FXML
    private Pane pane_0_0;
    @FXML
    private Pane pane_0_1;
    @FXML
    private Pane pane_0_2;
    @FXML
    private Pane pane_1_0;
    @FXML
    private Pane pane_1_1;
    @FXML
    private Pane pane_1_2;
    @FXML
    private Pane pane_2_0;
    @FXML
    private Pane pane_2_1;
    @FXML
    private Pane pane_2_2;
    @FXML
    private Pane pane_0_3;
    @FXML
    private Pane pane_1_3;
    @FXML
    private Pane pane_2_3;
    @FXML
    private Pane pane_3_3;
    @FXML
    private Pane pane_3_0;
    @FXML
    private Pane pane_3_1;
    @FXML
    private Pane pane_3_2;

    @FXML
    private Button btnLeft;

    private int mSize = 4;//размер поля
    private Field field = new Field();//поле
    private Label[][] lblArr = new Label [mSize][mSize];//массив надписей
    private Pane[][] paneArr = new Pane [mSize][mSize];//массив полей для покраски
    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private WinController winController;//контроллер окна - наследника
    private Stage winStage; //stage окна-наледника
    private boolean gotWin = false; //была ли уже победа?


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

     paneArr[0][0] = pane_0_0;
     paneArr[0][1] = pane_0_1;
     paneArr[0][2] = pane_0_2;
     paneArr[1][0] = pane_1_0;
     paneArr[1][1] = pane_1_1;
     paneArr[1][2] = pane_1_2;
     paneArr[2][0] = pane_2_0;
     paneArr[2][1] = pane_2_1;
     paneArr[2][2] = pane_2_2;
     paneArr[0][3] = pane_0_3;
     paneArr[1][3] = pane_1_3;
     paneArr[2][3] = pane_2_3;
     paneArr[3][3] = pane_3_3;
     paneArr[3][0] = pane_3_0;
     paneArr[3][1] = pane_3_1;
     paneArr[3][2] = pane_3_2;

     //сразу в инициализации один раз грузим окно-наследника
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

               // paneArr[0][1].setStyle("");

                switch(field.fieldArr[i][j]){
                    case 2:
                        paneArr[i][j].setStyle("-fx-background-color: #FFFFCC;");
                        break;
                    case 4:
                        paneArr[i][j].setStyle("-fx-background-color: #FFFF99;");
                        break;
                    case 8:
                        paneArr[i][j].setStyle("-fx-background-color: #FFE5CC;");
                        break;
                    case 16:
                        paneArr[i][j].setStyle("-fx-background-color: #FFCC99;");
                        break;
                    case 32:
                        paneArr[i][j].setStyle("-fx-background-color: #FFCCCC;");
                        break;
                    case 64:
                        paneArr[i][j].setStyle("-fx-background-color: #FF9999;");
                        break;
                    case 128:
                        paneArr[i][j].setStyle("-fx-background-color: #FF6666;");
                        break;
                    case 256:
                        paneArr[i][j].setStyle("-fx-background-color: #FFB266;");
                        break;
                    case 512:
                        paneArr[i][j].setStyle("-fx-background-color: #FFFFCC;");
                        break;
                    case 1024:
                        paneArr[i][j].setStyle("-fx-background-color: #FF9933;");
                        break;
                    case 2048:
                        paneArr[i][j].setStyle("-fx-background-color: #FF3333;");
                        break;
                    case 0:
                        paneArr[i][j].setStyle("-fx-background-color: #CDCDCD;");
                        break;
                    default:
                        paneArr[i][j].setStyle("-fx-background-color: #FF007F;");
                        break;

                }
            }
    }

    //создает новое окно - конец игры. проверяет, изменилось ли поле (была ли нажата кнопка рестарт)
    //и соответственно обновляет его в родительском окне
    private void newWindow() {
        winController.setField(field);
        //устанавливает надпись и кнопку, в зависимости от того, произошел ли выигрыш или проигрыш
        winController.initialize();
        if (winStage == null) {
            winStage = new Stage();
            winStage.setTitle("2048");
            winStage.setResizable(false);
            winStage.setScene(new Scene(fxmlEdit));
            winStage.initModality(Modality.WINDOW_MODAL);
            winStage.initOwner(btnLeft.getScene().getWindow());
        }
        winStage.showAndWait();
        //если нужно, переустанавливаем поле
        if (winController.getField() != field){
            field = winController.getField();
            field.newNumber();
            field.newNumber();
            setField();
        }
    }

    //действия для каждой из кнопок
    //везде проверки на конец игры и на победу
    public void btnDownClick() {
        if (field.down())
            field.newNumber();
        setField();

        if (field.gameOver)
            newWindow();
        else
            if (field.win && !gotWin){
                gotWin = true;
                winController.setWin(true);
                newWindow();
            }
    }

    public void btnUpClick() {
       if (field.up())
           field.newNumber();
        setField();

        if (field.gameOver)
            newWindow();
        else
            if (field.win && !gotWin){
                gotWin = true;
                winController.setWin(true);
                newWindow();
            }
    }

    public void btnRightClick() {
        if (field.right())
            field.newNumber();
        setField();

        if (field.gameOver)
            newWindow();
        else
            if (field.win && !gotWin){
                gotWin = true;
                winController.setWin(true);
                newWindow();
            }
    }

    public void btnLeftClick() {
        if (field.left())
            field.newNumber();
        setField();

        if (field.gameOver)
            newWindow();
        else
            if (field.win && !gotWin){
                gotWin = true;
                winController.setWin(true);
                newWindow();
            }
    }

    //обработка клавиш-стрелок
    public void keyPressed(KeyEvent e) {
        if (e.getCode().equals(KeyCode.LEFT)) btnLeftClick();
        if (e.getCode().equals(KeyCode.RIGHT)) btnRightClick();
        if (e.getCode().equals(KeyCode.UP)) btnUpClick();
        if (e.getCode().equals(KeyCode.DOWN)) btnDownClick();
    }
}

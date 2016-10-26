package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WinController {

    private Field field;
    private boolean win;

    @FXML
    private Label lblWin;
    @FXML
    private Button btnWin;
    @FXML
    private Label lblScore;

    public void initialize() {
        if (!win) {
            lblWin.setText("Game Over");
            btnWin.setText("Restart");
            setWin(false);
        }
        else {
            lblWin.setText("Congratulations!");
            btnWin.setText("Ok");
            setWin(true);
        }
    }

    private void setScore () {
        lblScore.setText("Score: " + field.score);
    }

    public void setField(Field newField)
    {
        field = newField;
        setScore();
    }

    public void setWin(boolean f){ win = f; }

    public Field getField(){
        return field;
    }

    public void btnClick(ActionEvent actionEvent) {
        if (!win) {
            field = new Field();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.hide();
        }
        else{
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.hide();
        }
    }
}

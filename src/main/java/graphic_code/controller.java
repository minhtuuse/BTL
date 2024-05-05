package graphic_code;

import javafx.fxml.FXML;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class controller {
        @FXML
        private AnchorPane content;
        public Label conteLabel;
        public void translate(ActionEvent event)throws IOException {
            Parent rootParent = FXMLLoader.load(getClass().getResource("Translate.fxml"));
            content.getChildren().setAll(rootParent);
            conteLabel.setText("TRANSLATE");
        }
        public void MarkWordView(ActionEvent event)throws IOException {
            Parent rootParent = FXMLLoader.load(getClass().getResource("MarkWord.fxml"));
            content.getChildren().setAll(rootParent);
            conteLabel.setText("MARKED WORDS");
        }
        public void Change_Add_Delete(ActionEvent event) throws IOException{
            Parent rootParent = FXMLLoader.load(getClass().getResource("Chang_Add_Delete.fxml"));
            content.getChildren().setAll(rootParent);
            conteLabel.setText("EDIT DICTIONARY");
        }
    public void game1_controller(ActionEvent event) throws IOException{
        Parent rootParent = FXMLLoader.load(getClass().getResource("game1.fxml"));
        content.getChildren().setAll(rootParent);
        conteLabel.setText("GAME");
    }
    public void game2_controller(ActionEvent event) throws IOException{
        Parent rootParent = FXMLLoader.load(getClass().getResource("game2.fxml"));
        content.getChildren().setAll(rootParent);
        conteLabel.setText("GAME");
    }
}



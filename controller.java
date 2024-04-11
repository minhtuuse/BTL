//MAI PHAN ANH TUNG
package graphic_code;
import javafx.fxml.FXML;
import graphic_code.MarkWord;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class controller {
	@FXML
	private AnchorPane content;
	public void translate(ActionEvent event)throws IOException {
		Parent rootParent = FXMLLoader.load(getClass().getResource("Translate.fxml"));
		content.getChildren().setAll(rootParent);
	}
	public void MarkWordView(ActionEvent event)throws IOException {
 		Parent rootParent = FXMLLoader.load(getClass().getResource("MarkWord.fxml"));
 		content.getChildren().setAll(rootParent);
 	}
	public void Change_Add_Delete(ActionEvent event) throws IOException{
		Parent rootParent = FXMLLoader.load(getClass().getResource("Chang_Add_Delete.fxml"));
		content.getChildren().setAll(rootParent);
	}
}

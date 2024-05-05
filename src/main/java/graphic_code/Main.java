package graphic_code;

import javafx.application.Application;
import javafx.scene.image.*;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import graphic_code.MarkWord;
import graphic_code.Search_word;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/graphic_code/Start_scene.fxml"));
			Scene scene=new Scene(root);
			stage.setTitle("BaiTapLon");
			stage.setScene(scene);
			stage.setResizable(true);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		Search_word search_word=new Search_word();
		search_word.initialize();
		launch(args);

	}
}

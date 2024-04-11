//Pham Minhtu
package graphic_code;

import java.io.IOException;
import java.util.TreeSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditDic extends Search_word {
	private boolean add_;
	private boolean change_;
	private boolean addmeaning_;
	private boolean remove_;
	@FXML
	Button addWord;
	@FXML
	Button changeWord;
	@FXML
	Button addmeaning;
	@FXML
	Button deleteButton;
	@FXML
	private	TextField word;
	@FXML
	private	TextField meaning;
	@FXML
	private Label notification;
	@FXML
	private Label lb1;
	@FXML
	private Label lb2;
	@FXML
	private Button confirm;
	private TreeSet<String> wordSet;
	public void init() {
		add_=false;
		change_=false;
		addmeaning_=false;
		remove_=false;
		addWord.setStyle(null);
		changeWord.setStyle(null);
		addmeaning.setStyle(null);
		deleteButton.setStyle(null);
	}
	
	public EditDic() {
		this.words=getMap();
		confirm=null;
	}
	 private boolean isConfirmEnabled() {
	       return confirm != null && !confirm.isDisabled();
	    }
	public void add(ActionEvent event) {
		init();
		addWord.setStyle("-fx-background-color: #4CAF50");
		add_=true;
		lb1.setVisible(true);
		lb2.setVisible(true);
		lb2.setText("NHẬP NGHĨA");
		word.setVisible(true);
		meaning.setVisible(true);
		notification.setText(null);
    }

    public void changeMeaning(ActionEvent event) {
    	init();
    	changeWord.setStyle("-fx-background-color: #4CAF50");
    	change_=true;
    	lb1.setVisible(true);
		lb2.setVisible(true);
		lb2.setText("NHẬP NGHĨA");
		word.setVisible(true);
		meaning.setVisible(true);
    	notification.setText(null);
    }

    public void addMeaning(ActionEvent event) {
    	init();
    	addmeaning_=true;
    	addmeaning.setStyle("-fx-background-color: #4CAF50");
    	lb1.setVisible(true);
		lb2.setVisible(true);
		lb2.setText("NHẬP NGHĨA");
		word.setVisible(true);
		meaning.setVisible(true);
        notification.setText(null);
    }

    public void deleteMeaning(ActionEvent event) {
    	init();
    	remove_=true;
    	deleteButton.setStyle("-fx-background-color: #4CAF50");
    	meaning.setVisible(false);
    	notification.setText(null);
    	lb2.setText(null);
    }
    public void action(ActionEvent event) throws IOException {
    	if(add_==true) {
			String Eng=word.getText().toLowerCase();
			String Vie=meaning.getText().toLowerCase();
			if (words.containsKey(Eng)) {
	            notification.setText("word already exists");
	        } else {
	            words.put(Eng, Vie);
	            wordSet.add(Eng);
	            notification.setText("word has been added successfully");
	        	Save saveaction=new Save(words, wordSet); 
	            saveaction.save();
	        }
    	}
    	else if(change_==true) {
    		String Eng=word.getText().toLowerCase();
			String Vie=meaning.getText().toLowerCase();
	    	if (!words.containsKey(Eng)) {
	            notification.setText("word dont exist");
	        } else {
	            words.put(Eng, Vie);
	            notification.setText("word has been changed successfully");
	        	Save saveaction=new Save(words, wordSet); 
	            saveaction.save();
	        }
    	}
    	else if (addmeaning_==true) {
    		String Eng=word.getText().toLowerCase();
    		String Vie=meaning.getText().toLowerCase();
	    	if (!words.containsKey(Eng)) {
	            notification.setText("word dont exist");
	        } else {
	            StringBuilder sb = new StringBuilder(words.get(Eng));
	            sb.append("\n");
	            sb.append(Vie);
	            words.put(Eng, sb.toString());
	            notification.setText("The word has added meaning");
	        	Save saveaction=new Save(words, wordSet); 
	            saveaction.save();
	        }
		}
    	else if (remove_==true) {
    		String Eng=word.getText().toLowerCase();
	    	if(!words.containsKey(Eng)){
	    		notification.setText("word dont exist");
	        } else {
	            words.remove(Eng);
	            notification.setText("word have been removed");
	        	Save saveaction=new Save(words, wordSet); 
	            saveaction.save();
	        }
		}
    	else {
			notification.setText("PLEASE CHOOSE ACTION");
		}
    }
}
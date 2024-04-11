//MAI PHAN ANH TUNG
package graphic_code;
import javafx.collections.FXCollections;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import basic.Dictionary;
import basic.DictionaryCommandline;
import basic.DictionaryManagement;
import basic.Word;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class translate implements Initializable  {
	@FXML
	protected TextField myTextField;
	@FXML
	protected TextArea myTextArea;
	@FXML
	private Button dich;
	@FXML
	ListView<String> mylistview;
	String selectedword;
	ArrayList<String> history=new ArrayList<String>();
	DictionaryManagement dictionaryManagement=new DictionaryManagement();
	Search_word search_word=new Search_word();
	public void dictionaryExportToFile(ArrayList<String> arrayList,String path) throws IOException
	{	
		File file=new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedWriter bufferedWriter=null;
		BufferedReader  bufferedReader=new BufferedReader(fileReader);
		String input;
		while((input=bufferedReader.readLine())!=null) {
			Boolean checkBoolean=false;
			for(String aString:arrayList) {
				if(aString.equals(input)) {
					checkBoolean=true;
					break;
				}
			}
			if(!checkBoolean)
				arrayList.add(input);
		}
		try {
			FileWriter fileWriter=new FileWriter(file);
			bufferedWriter= new BufferedWriter(fileWriter);
			for(String aString : arrayList)
			{
				bufferedWriter.write(aString);
				bufferedWriter.newLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(bufferedWriter!=null)
				{
					bufferedWriter.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public ArrayList<String> readfromfile(String path) {
		ArrayList<String>arrayList=new ArrayList<String>();
		try {
			File file = new File(path);
	        FileReader fileReader = new FileReader(file);
	        BufferedReader bufferedReader = new BufferedReader(fileReader);
	        String readString;
	        while((readString=bufferedReader.readLine())!=null) {
	        	arrayList.add(readString);
	        }
	        bufferedReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return arrayList;
	}
	//translate the word and add it to history list
 	public void input(ActionEvent event) throws IOException {
		String inputString=myTextField.getText();
		myTextArea.setText(search_word.searchForWord(inputString.toLowerCase()));
		history.clear();
		history.add(inputString);
		dictionaryExportToFile(history,"C:\\Users\\Admin\\eclipse-workspace\\Dictionary_graphics\\src\\History");
		mylistview.getItems().setAll(history);
		history.clear();
	}
 	public void MarkWord(ActionEvent event) throws IOException {
 		ArrayList<String> aList =new ArrayList<String>();
 		String inputString=myTextField.getText();
 		aList.add(inputString);
 		dictionaryExportToFile(aList,"C:\\Users\\Admin\\eclipse-workspace\\Dictionary_graphics\\src\\markedwords");
 	}
 	@Override
 	public void initialize(URL arg0, ResourceBundle arg1) {
 	    //display the history in the first time running
 		if (mylistview != null) {
 	        history.clear();
 	        history = readfromfile("C:\\Users\\Admin\\eclipse-workspace\\Dictionary_graphics\\src\\History");
 	        mylistview.getItems().setAll(history);
 	    }
 	        // Add listener to mylistview selection model
 	        mylistview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
 	            if (newValue != null) {
 	                // When a new item is selected, update myTextArea
 	                myTextArea.setText(search_word.searchForWord(newValue));
 	            }
 	        });
 	    }
 }

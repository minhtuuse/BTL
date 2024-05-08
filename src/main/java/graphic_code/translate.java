package graphic_code;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class translate implements Initializable {
    @FXML
    protected TextField myTextField;
    @FXML
    protected TextArea myTextArea;
    @FXML
    private Button dich;
    @FXML
    protected ListView<String> mylistview;
    @FXML
    protected VBox MyVBOX = new VBox();
    @FXML
    protected ListView<String> GoiY;
    public CheckBox MyCheckbox;
    public CheckBox X_to_Y;
    String selectedword;
    protected ArrayList<String> history = new ArrayList<String>();
    Search_word search_word = new Search_word();
    EditDic e=new EditDic();
    SOUND audioAPI=new SOUND();
    API googleAPI=new API();
    WordStartWith wordStartWith = new WordStartWith(new LinkedList<String>(search_word.getMap().keySet()), e.getSet());
    private WordSuggestion wordSuggestion = new WordSuggestion(new LinkedList<String>(search_word.getMap().keySet()), e.getSet());
    private boolean offline=true;
    private boolean Eng=true;

    public void dictionaryExportToFile(ArrayList<String> arrayList, String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            Boolean checkBoolean = false;
            for (String aString : arrayList) {
                if (aString.equals(input)) {
                    checkBoolean = true;
                    break;
                }
            }
            if (!checkBoolean)
                arrayList.add(input);
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String aString : arrayList) {
                bufferedWriter.write(aString);
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }

    public ArrayList<String> readfromfile(String path) {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readString;
            while ((readString = bufferedReader.readLine()) != null) {
                arrayList.add(readString);
            }
            bufferedReader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return arrayList;
    }
    public void setHistory(String inputString) throws IOException {
        history.clear();
        history.add(inputString);
        dictionaryExportToFile(history, "src/main/java/History");
        mylistview.getItems().setAll(history);
        history.clear();
    }
    //translate the word and add it to history list
    public void input(ActionEvent event) throws IOException {
        String inputString = myTextField.getText();
        if(offline) {
            myTextArea.setText(search_word.searchForWord(inputString));
        }else {
            if(Eng) {
                myTextArea.setText(googleAPI.translate(inputString, "en", "vi"));
            }else {
                myTextArea.setText(googleAPI.translate(inputString, "vi", "en"));
            }
        }
        setHistory(inputString);
    }

    public void MarkWord(ActionEvent event) throws IOException {
        ArrayList<String> aList = new ArrayList<String>();
        String inputString = myTextField.getText();
        aList.add(inputString);
        dictionaryExportToFile(aList, "src/main/java/markedwords");
    }

    public void handleWordSuggestions(KeyEvent event) {
            String a = event.getText();
            TreeSet<String> s = e.getSet();
            wordSuggestion.provideSuggestions(myTextField, GoiY, a);
    }
    public void playsound(ActionEvent event){
        String a=myTextField.getText();
        if(Eng) {
            audioAPI.AudioPlay(a, "en-US");
        }else {
            audioAPI.AudioPlay(a, "vi");
        }
    }
    public void checking(ActionEvent event){
        if (MyCheckbox.isSelected()){
            MyCheckbox.setText("ONLINE");
            offline=false;
            X_to_Y.setVisible(true);
        }else {
            MyCheckbox.setText("OFFLINE");
            offline=true;
            X_to_Y.setVisible(false);
        }
    }
    public void language(ActionEvent event){
        if (X_to_Y.isSelected()){
            X_to_Y.setText("VI ==> EN ");
            Eng=false;
        }else {
            X_to_Y.setText("EN ==> VI");
            Eng=true;
        }
        updateGoiYVisibility();
    }
    private void updateGoiYVisibility() {
        if(Eng){
            GoiY.setVisible(true);
        }else {
            GoiY.setVisible(false);
        }
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Initialize WordSuggestion object
        //display the history in the first time running
        if (mylistview != null) {
            history.clear();
            history = readfromfile("src/main/java/History");
            mylistview.getItems().setAll(history);
        }
        // Add listener to mylistview selection model
        mylistview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                // When a new item is selected, update myTextArea
                myTextField.setText(newValue);
                if(offline) {
                    myTextArea.setText(search_word.searchForWord(newValue));
                }else{
                    try {
                        myTextArea.setText(googleAPI.translate(newValue, "en", "vi"));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        GoiY.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    setHistory(newValue);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                // When a new item is selected, update myTextArea
                myTextField.setText(newValue);
                myTextArea.setText(search_word.searchForWord(newValue));
            }
        });
    }
}

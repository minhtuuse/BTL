package graphic_code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class MarkWord extends translate {
    @FXML
    protected ListView<String> myListView;
    @FXML
    protected Button unmark;
    ArrayList<String> arrayList = new ArrayList<String>();

    /**
     * Override to write only the array list to file
     */
    @Override
    public void dictionaryExportToFile(ArrayList<String> arrayList, String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedWriter bufferedWriter = null;
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

    /**
     * Unmark word and then export the list that had been changed to file
     *
     * @param event
     * @throws IOException
     */
    public void UnMarkWord(ActionEvent event) throws IOException {
        String selectedword = myListView.getSelectionModel().getSelectedItem();
        if (selectedword != null) {
            arrayList.remove(selectedword);
            myListView.getItems().setAll(arrayList);
            dictionaryExportToFile(arrayList, "src/main/java/markedwords"); // Assuming this method saves the updated list to file
        }
    }

    /**
     * Read from file and then return an array list
     *
     * @return
     */
    public ArrayList<String> readfromfile() {
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            File file = new File("src/main/java/markedwords");
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        arrayList.clear();
        arrayList = readfromfile();
        myListView.getItems().setAll(readfromfile());
    }
}

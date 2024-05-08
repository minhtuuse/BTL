package graphic_code;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class WordSuggestion {
    private LinkedList<String> dictionary;
    private TreeSet<String> additionalWords;

    public WordSuggestion(LinkedList<String> dictionary, TreeSet<String> additionalWords) {
        this.dictionary = dictionary;
        this.additionalWords = additionalWords;
    }

    public void provideSuggestions(TextField inputField, ListView<String> suggestionList, String keyString) {
        String input = inputField.getText();
        input += keyString;
        List<String> suggestions = new ArrayList<>();
        WordStartWith wordStartWith = new WordStartWith(dictionary, additionalWords);
        suggestions.addAll(wordStartWith.startsWith(input));
        ObservableList<String> observableSuggestions = FXCollections.observableArrayList(suggestions);
        suggestionList.setItems(observableSuggestions);
    }

}

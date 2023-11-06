package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    private Label redLines;
    @FXML
    private TextArea inputText;

    @FXML
    private Label outputText;
    @FXML
    private ComboBox<String> letterBox;

    //private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "ű", "í", "ö", "ü", "ó", "é", "á", "ú", "ő", ",", ".", "-", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "<", ">", "#", "&", "@", "{", "}", "[", "]", "?", ":", "_", ";"};

    private List<String> letters = new ArrayList<>();

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(char i = 'A'; i < 'Z'; i++){
            letters.add(String.valueOf(i).toLowerCase());
        }
        for(int i = 0; i < 10; i++){
            letters.add(String.valueOf(i));
        }
        String[] additionalLetters = {"ű", "í", "ö", "ü", "ó", "é", "á", "ú", "ő", ",", ".", "-","<", ">", "#", "&", "@", "{", "}", "[", "]", "?", ":", "_", ";"};
        for(int i = 0; i < additionalLetters.length; i++){
            letters.add(additionalLetters[i]);
        }


        letterBox.getItems().addAll(letters);

    }

    public void onFilterButtonClick()
    {
        String text = inputText.getText();
        StringBuilder highlight = new StringBuilder();
        if(text.length() > 20 || letterBox.getSelectionModel().getSelectedItem() == null)
        {
            outputText.setText("Invalid inputs");
            inputText.clear();
            letterBox.valueProperty().set(null);
        }
        else {
            String s = letterBox.getSelectionModel().getSelectedItem();
            text.toLowerCase();
            int x = 0;


            for(int i = 0; i < text.length(); i++)
            {
                if (String.valueOf(text.charAt(i)).equals(s)){
                    x++;
                }
            }
            for(int i = 0; i < text.length(); i++)
            {
                if (String.valueOf(text.charAt(i)).equals(s)){
                    highlight.append(s);
                }
                else{
                    highlight.append("-");
                }
            }


            String highlightString = String.valueOf(highlight);
            String output = String.valueOf(x);
            outputText.setText(s + ": " + output + "\n" + text);
            redLines.setText(highlightString);
            inputText.clear();
        }

    }
}
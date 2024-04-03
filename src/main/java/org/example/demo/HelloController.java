package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Label name;
    @FXML
    private Button EN;
    @FXML
    private Button FA;
    @FXML
    private Button JP;
    private ResourceBundle bundle;
    private Locale locale;
    private int counter = 0;

    public void languageBundle(String language, String country) {
        locale = new Locale(language, country);
        bundle = ResourceBundle.getBundle("messages", locale);

//        String greeting = bundle.getString("greeting");
//        LocalDateTime localTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        String formattedTime = localTime.format(formatter);
//
//        String fullGreeting = String.format(greeting, formattedTime);
//        welcomeText.setText(fullGreeting);

        name.setText(bundle.getString("name"));
        name.setFont(new Font("Arial", 20));
        EN.setText(bundle.getString("firstButton"));
        EN.setFont(new Font("Arial", 12));
        FA.setText(bundle.getString("secondButton"));
        FA.setFont(new Font("Arial", 12));
        JP.setText(bundle.getString("thirdButton"));
        JP.setFont(new Font("Arial", 12));

    }

    public void changeLanguage(ActionEvent actionEvent) {
        counter = (counter % 3) + 1;

        switch (counter) {
            case 1:
                languageBundle("en", "US");
                break;
            case 2:
                languageBundle("fa", "IR");
                break;
            case 3:
                languageBundle("jp", "JP");
                break;
        }
    }

}
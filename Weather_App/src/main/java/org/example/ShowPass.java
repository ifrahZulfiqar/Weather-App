package org.example;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ShowPass implements EventHandler {
    public ShowPass(PasswordField pass, CheckBox check,GridPane layout) {
        this.pass = pass;
        this.check = check;
        this.layout = layout;

    }

    PasswordField pass = new PasswordField();
    TextField password = new TextField();
    CheckBox check;
    GridPane layout;

    @Override
    public void handle(Event event) {
        if(check.isSelected())
        {
            password.setText(pass.getText());
            layout.getChildren().remove(pass);
            password.setStyle("-fx-border-radius: 15px; -fx-background-radius: 10px; -fx-background-color: #FEFEFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 15");
            layout.add(password , 1 ,1);
        } if(!check.isSelected())
        {
            pass.setText(password.getText());

            layout.getChildren().remove(password);
            layout.add(pass , 1 ,1);
        }
    }
}

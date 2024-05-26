package org.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class SignUpPage {
    public SignUpPage(Stage stage, Scene login_scene){
        Label label = new Label("Create your Account");
        label.setFont(new Font("Calibri" , 25));
        Text text1 = new Text("UserName: ");
        TextField textField1 = new TextField();
        textField1.setStyle("-fx-border-radius: 15px; -fx-background-radius: 10px; -fx-background-color: #FEFEFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Text text2 = new Text("Password");
        PasswordField passwordField1 = new PasswordField();
        passwordField1.setStyle("-fx-border-radius: 15px; -fx-background-radius: 10px; -fx-background-color: #FEFEFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Text text3 = new Text("Confirm Password");
        PasswordField passwordField2 = new PasswordField();
        passwordField2.setStyle("-fx-border-radius: 15px; -fx-background-radius: 10px; -fx-background-color: #FEFEFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Text text4 = new Text("Email");
        TextField textField2 = new TextField();
        textField2.setStyle("-fx-border-radius: 15px; -fx-background-radius: 10px; -fx-background-color: #FEFEFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Text text5 = new Text("Mobile No.");
        TextField textField3 = new TextField();
        textField3.setStyle("-fx-border-radius: 15px; -fx-background-radius: 10px; -fx-background-color: #FEFEFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");

        Button button1 = new Button("Sign Up");
        button1.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #B4DCFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(passwordField1.getText().equals(passwordField2.getText())) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Register Your Account?");
                    alert.show();
                    try {
                        Login.writer(textField1.getText(), passwordField1.getText());
                        Login.reader();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    stage.setScene(login_scene);
                }
                else{
                    Alert alert2 = new Alert(Alert.AlertType.WARNING);
                    alert2.setContentText("Check your password!");
                    alert2.show();
                }
            }
        });

        Button previous_button = new Button("Previous");
        previous_button.setStyle("-fx-border-radius: 10px; -fx-background-radius: 15px; -fx-background-color: #5F6164; -fx-text-fill: #FEFEFE; -fx-margin: 5px; -fx-font-size: 12");
        previous_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(login_scene);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.addRow(1, new Text());
        gridPane.addRow(2, new Text());
        gridPane.add(text1, 0, 3);
        gridPane.add(textField1, 2, 3);
        gridPane.add(text2, 0, 4);
        gridPane.add(passwordField1, 2, 4);
        gridPane.add(text3,0,5);
        gridPane.add(passwordField2,2,5);
        gridPane.add(text4,0,6);
        gridPane.add(textField2,2,6);
        gridPane.add(text5,0,7);
        gridPane.add(textField3,2,7);
        gridPane.addRow(8, new Text());
        gridPane.add(button1, 3, 9);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        gridPane.setStyle("-fx-font-size: 15");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(label);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(30,20,0,20));

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(previous_button);
        borderPane.setBackground(Background.fill(Color.rgb(212, 228, 232)));



        Scene SignUp_scene = new Scene(borderPane, 800, 500);
        stage.setScene(SignUp_scene);
        stage.show();
    }
}

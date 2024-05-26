package org.example;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class City {
    public static String city_name;

    public City(Stage stage, Scene login_scene) throws FileNotFoundException {
        BackgroundImage bg1 = new BackgroundImage(new Image(new FileInputStream("background.png"), 800, 500,false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        TextField textField = new TextField();
        textField.setPromptText("Enter City Name");
        textField.setStyle("-fx-border-radius: 15px; -fx-background-radius: 10px; -fx-background-color: #FEFEFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 15");
        Button search = new Button("Search");
        search.setStyle("-fx-border-radius: 10px; -fx-background-radius: 15px; -fx-background-color: #B4DCFE; -fx-text-fill: #000001; -fx-margin: 5px; -fx-font-size: 12");
        Button login_button = new Button("Login Page");
        login_button.setStyle("-fx-border-radius: 10px; -fx-background-radius: 15px; -fx-background-color: #5F6164; -fx-text-fill: #FEFEFE; -fx-margin: 5px; -fx-font-size: 12");
        Text text = new Text("Enter City Name");
        text.setFont(new Font("Calibri", 20));
        Text top_text = new Text("Weather App");
        top_text.setFont(new Font("Calibri", 30));
        HBox hBox = new HBox(top_text);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(30,20,0,20));

        GridPane gridPane = new GridPane();
        gridPane.addColumn(0, new Text());
        gridPane.addColumn(1, new Text());
        gridPane.add(text, 2, 1);
        gridPane.add(textField, 2,2);
        gridPane.addRow(3, new Text());
        gridPane.add(search, 3,4);
        gridPane.setHgap(10);
        gridPane.setVgap(15);
        gridPane.setAlignment(Pos.CENTER);


        login_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                textField.setText(" ");
                stage.setScene(login_scene);
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(login_button);
        StackPane stackPane = new StackPane();
        stackPane.setBackground(new Background(bg1));
        stackPane.getChildren().add(borderPane);
        Scene city_scene = new Scene(stackPane, 800,500);

        search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    new WeatherPage(stage, city_scene);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                city_name = textField.getText();
                textField.setText(" ");
                Main.function(city_name);

            }
        });

        stage.setScene(city_scene);
        stage.show();
    }
}

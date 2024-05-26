package org.example;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
public class WeatherPage {
    public WeatherPage(Stage stage, Scene login_scene) throws FileNotFoundException {

        Text temp = new Text("Temperature:");
        Text temp_text = new Text();
        Text precipitation = new Text("Precipitation:");
        Text pr_text = new Text("     ");
        Text minimum_temperature = new Text("Day");
        Text min_text = new Text("     ");
        Text wind = new Text("Wind");
        Text wind_text = new Text("     ");
        Text humidity = new Text("Humidity");
        Text humidity_text = new Text("     ");
        Text description = new Text("Description");
        Text desc_text = new Text();

        Image image = new Image("https://ssl.gstatic.com/onebox/weather/64/partly_cloudy.png");
        ImageView imageView = new ImageView(image);

        HBox inner_hbox = new HBox();
        inner_hbox.setMinHeight(30);
        inner_hbox.setMinWidth(30);
        inner_hbox.setMaxSize(100,100);
        inner_hbox.getChildren().add(imageView);

        Button btn = new Button("Previous");
        btn.setStyle("-fx-border-radius: 10px; -fx-background-radius: 15px; -fx-background-color: #5F6164; -fx-text-fill: #FEFEFE; -fx-margin: 5px; -fx-font-size: 12");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(login_scene);
            }
        });

        Button monday = new Button("Monday");
        monday.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #B4DCFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Button tuesday = new Button("Tuesday");
        tuesday.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #B4DCFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Button wednesday = new Button("Wednesday");
        wednesday.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #B4DCFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Button thursday = new Button("Thursday");
        thursday.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #B4DCFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Button friday = new Button("Friday");
        friday.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #B4DCFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Button saturday = new Button("Saturday");
        saturday.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #B4DCFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");
        Button sunday = new Button("Sunday");
        sunday.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #B4DCFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 12");

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                temp_text.setText(Main.hashMap.get("temp") + "°C");
                pr_text.setText(Main.hashMap.get("precipitation"));
                min_text.setText(Main.hashMap.get("dayAndTime"));
                wind_text.setText(Main.hashMap.get("wind"));
                humidity_text.setText(Main.hashMap.get("humidity"));
                desc_text.setText(Main.hashMap.get("description"));
//                imageView.setImage(new Image(Main.hashMap.get("icon")));
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(monday, tuesday, wednesday, thursday, friday, saturday, sunday);
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);


        temp.setFont(new Font("Calibri" ,30));
        temp_text.setFont(new Font(30));

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(20);
        gp.setHgap(20);
        gp.setStyle("-fx-font-size: 17");
        gp.add(inner_hbox, 4,1,3,3);
        gp.addColumn(0, new Text());
        gp.add(temp, 0,0,2,1);
        gp.add(temp_text,3,0,2,1);
        gp.addRow(1, new Text());
        gp.addRow(2,new Text());
        gp.add(description,0,3);
        gp.add(desc_text,1,3);
        gp.add(precipitation,0,4);
        gp.add(pr_text,1,4);
        gp.add(minimum_temperature,0,5);
        gp.add(min_text,1,5);
        gp.add(wind,0,6);
        gp.add(wind_text,1,6);
        gp.add(humidity,0,7);
        gp.add(humidity_text,1,7);

        BorderPane bp = new BorderPane();
        bp.setCenter(gp);
        bp.setTop(btn);
        bp.setBottom(hBox);
        bp.setBackground(Background.fill(Color.rgb(212, 228, 232)));
        Scene weatherscene = new Scene(bp , 800 ,500);


        monday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main2.function(City.city_name, "monday");
                new FutureForecast(stage, weatherscene);
            }
        });


        tuesday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main2.function(City.city_name, "tuesday");
                new FutureForecast(stage, weatherscene);
            }
        });


        wednesday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main2.function(City.city_name, "wednesday");
                new FutureForecast(stage, weatherscene);
            }
        });


        thursday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main2.function(City.city_name, "thursday");
                new FutureForecast(stage, weatherscene);
            }
        });


        friday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main2.function(City.city_name, "friday");
                new FutureForecast(stage, weatherscene);
            }
        });


        saturday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main2.function(City.city_name, "saturday");
                new FutureForecast(stage, weatherscene);
            }
        });


        sunday.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main2.function(City.city_name, "sunday");
                new FutureForecast(stage, weatherscene);
            }
        });

        stage.setScene(weatherscene);
    }
}

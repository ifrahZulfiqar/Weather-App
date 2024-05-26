package org.example;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FutureForecast {
    public FutureForecast(Stage stage, Scene weather_page_scene){

        Text temp = new Text("Temperature:");
        Text temp_text = new Text();
        Text precipitation = new Text("Precipitation:");
        Text pr_text = new Text("     ");
        Text minimum_temperature = new Text("Day:");
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

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                temp_text.setText(Main2.hashMap.get("temp") + "°C");
                pr_text.setText(Main2.hashMap.get("precipitation"));
                min_text.setText(Main2.hashMap.get("dayAndTime"));
                wind_text.setText(Main2.hashMap.get("wind"));
                humidity_text.setText(Main2.hashMap.get("humidity"));
                desc_text.setText(Main2.hashMap.get("description"));
                imageView.setImage(new Image(Main2.hashMap.get("icon")));
            }
        });

        Button btn = new Button("Previous");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(weather_page_scene);
            }
        });

        temp.setFont(new Font("Times New Roman" ,30));
        temp_text.setFont(new Font(30));

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(20);
        gp.setHgap(20);
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
        bp.setBottom(btn);
        bp.setBackground(Background.fill(Color.rgb(212, 228, 232)));

        Scene scene = new Scene(bp, 800, 500);
        stage.setScene(scene);

    }
}

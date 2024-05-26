package org.example;

import javafx.animation.FillTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Transition  {

    public static StackPane transit(Stage stage) {
        Circle circle = new Circle();
        circle.setRadius(20);
        circle.setCenterX(-20);
        circle.setCenterY(100);
        circle.setFill(Color.BLUE);

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(15000));
        translateTransition.setNode(circle);
        translateTransition.setByX(820);
        translateTransition.setCycleCount(Timeline.INDEFINITE);
        translateTransition.setAutoReverse(true);
        translateTransition.play();

        FillTransition fillTransition = new FillTransition();
        fillTransition.setDuration(Duration.millis(15000));
        fillTransition.setShape(circle);
        fillTransition.setAutoReverse(true);
        fillTransition.setCycleCount(Timeline.INDEFINITE);
        fillTransition.setFromValue(Color.rgb(255, 107, 44));
        fillTransition.setToValue(Color.rgb(237, 237, 237));
        fillTransition.play();

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(800);
        rectangle.setHeight(500);
        rectangle.setFill(Color.rgb(104, 183, 255));

        FillTransition fillTransition2 = new FillTransition();
        fillTransition2.setDuration(Duration.millis(15000));
        fillTransition2.setShape(rectangle);
        fillTransition2.setAutoReverse(true);
        fillTransition2.setCycleCount(Timeline.INDEFINITE);
        fillTransition2.setFromValue(Color.rgb(104, 183, 255));
        fillTransition2.setToValue(Color.rgb(2, 76, 144));
        fillTransition2.play();

        //Creating a Group object
        HBox hbox = new HBox(circle);
        StackPane root = new StackPane(rectangle, hbox);
        hbox.setMinWidth(600);
        hbox.setPadding(new Insets(20));

        return root;

        //Creating a scene object
//         scene = new Scene(root, 800, 500);

//        stage.setScene(scene);

    }
}

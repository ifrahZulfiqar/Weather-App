package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Login extends Application {

    public static ArrayList<HashMap <String , String> > data = new ArrayList<>();
    public static HashMap<String, String> dummy = new HashMap<>();
    static File file = new File("data.txt");
    public static void reader() throws Exception {
        Scanner reader = new Scanner(file);
        while(reader.hasNext()) {
            String readData = reader.nextLine();
            dummy.put("name", readData.toString().split("_")[0]);
            dummy.put("pass", readData.toString().split("_")[1]);

            data.add(dummy);
            dummy = new HashMap<String, String>();
        }
        reader.close();

    }

    public static void writer(String username, String password) throws IOException {
        FileWriter fw = new FileWriter("data.txt", true);
        fw.write("\n");
        fw.write(username + "_" + password);
        fw.close();
    }

    @Override
    public void start(Stage stage) throws Exception {
        CheckBox show = new CheckBox();
        stage.setTitle("Weather App");
        Label label = new Label("LOGIN PAGE");
        label.setFont(new Font("Calibri" , 30));
        HBox hb = new HBox(label);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(50,30,10,30));
        BorderPane border = new BorderPane();
        border.setTop(hb);



        Text username = new Text("Username");
        Text password = new Text("Password");
        TextField user = new TextField();
        user.setStyle("-fx-border-radius: 15px; -fx-background-radius: 10px; -fx-background-color: #FEFEFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 15");
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-border-radius: 15px; -fx-background-radius: 10px; -fx-background-color: #FEFEFE; -fx-text-fill: #000001; -fx-margin: 10px; -fx-font-size: 15");
        Button signin = new Button("SIGN IN");
        signin.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #5F6164; -fx-text-fill: #FEFEFE; -fx-margin: 10px; -fx-font-size: 12");
        Button signup = new Button("SIGN UP");
        signup.setStyle("-fx-border-radius: 30px; -fx-background-radius: 15px; -fx-background-color: #5F6164; -fx-text-fill: #FEFEFE; -fx-margin: 10px; -fx-font-size: 12");
        signup.setCursor(Cursor.HAND);
        signin.setCursor(Cursor.HAND);
        String userstr = "Enter Username";
        String pswrd = "Enter Password";
        user.setPromptText(userstr);
        passwordField.setPromptText(pswrd);

        HBox hb2 = new HBox();
        hb2.getChildren().addAll(signin , signup);
        hb2.setSpacing(5);

        GridPane layout = new GridPane();
        layout.add(username , 0 , 0);
        layout.add(user , 1 , 0);
        layout.add(password , 0 ,1);
        layout.add(passwordField , 1 ,1);
        layout.add(show,2,1);
        layout.add(hb2 , 1 ,2);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(20);
        layout.setHgap(20);
        show.setText("Show Password");
        layout.setPadding(new Insets(10));
        border.setCenter(layout);


        StackPane stackPane = Transition.transit(stage);
        stackPane.getChildren().add(border);
        Scene scene = new Scene(stackPane,800,500);


        signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!(user.getText().equals("") && passwordField.getText().equals(""))) {
                    for (HashMap<String, String> i:data) {
                        if (i.get("name").equals(user.getText()) && i.get("pass").equals(passwordField.getText())) {
                            user.setText("");
                            passwordField.setText("");

                            stage.setTitle("Weather App");
                            try {
                                new City(stage, scene);
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            return;
                        } else {
                            stage.setTitle("Invalid password or username");
                        }
                    }
                }else{
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setContentText("Plz enter Username and Password if you already have an account.\nOtherwise create an account by signing up");
                    a.show();
                }
            }
        });

        signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new SignUpPage(stage, scene);
            }
        });
        show.setOnAction(new ShowPass(passwordField,show,layout));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        reader();
        launch(args);
    }
}

package com.example.goal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Stage stage_var;
    public static Scene login;
    public static Scene signup;
    public static Scene goal;
    public static Scene milestone;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("getStarted.fxml"));
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("signup.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("goal.fxml"));
        FXMLLoader fxmlLoader4 = new FXMLLoader(HelloApplication.class.getResource("milestone.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Scene scene1 = new Scene(fxmlLoader1.load());
        Scene scene2 = new Scene(fxmlLoader2.load());
        Scene scene3 = new Scene(fxmlLoader3.load());
        Scene scene4 = new Scene(fxmlLoader4.load());

        stage_var = stage;
        login = scene1;
        signup = scene2;
        goal = scene3;
        milestone = scene4;

        stage.setTitle("GoalTrackingController");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
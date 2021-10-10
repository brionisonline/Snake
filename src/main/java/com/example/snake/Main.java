package com.example.snake;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import static com.example.snake.Controls.controlFilter;
import static com.example.snake.Controls.move;
public class Main extends Application {

    public static List<Snake> snake = new ArrayList<>();
    public static boolean isGameOver;
    public static Frame frame = new Frame();
    public static GraphicsContext graphicsContext;
    public static Pane root;
    public static Scene scene;
    public static int width = 1000;
    public static int height = 750;
    public static Canvas playCanvas = new Canvas(width, height);


    @Override
    public void start(Stage primaryStage) {
        Score.importScore();
        graphicsContext = playCanvas.getGraphicsContext2D();
        root = new Pane();

        scene = new Scene(root, width, height);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake");
        primaryStage.show();
        frame.start();
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> Controls.controlFilter(key));
        GameStop.gameStop();
    }

    public static void main(String[] args) {
        launch();
    }
}
package com.example.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame extends Application {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 750;
    public static final Canvas PLAY_CANVAS = new Canvas(WIDTH, HEIGHT);

    public static Frame frame;
    public static List<Snake> snake;
    public static boolean isGameOver;
    public static GraphicsContext graphicsContext;
    public static Pane root;
    public static Controller controller;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Score.importScore();
        Audio.playGameAudio();
        frame = new Frame();
        snake = new ArrayList<>();
        root = new Pane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        isGameOver = false;
        graphicsContext = PLAY_CANVAS.getGraphicsContext2D();
        
        controller = new Controller();
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> controller.controlFilter(key));

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake");
        primaryStage.show();
        frame.start();

        new Game().title();
    }

}
package com.example.snake;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Game {
    private GraphicsContext titleContext;
    private Canvas title;

    public void restart() {
        // Reset parameters
        Frame.speed = 125;
        Score.score = 0;
        SnakeGame.isGameOver = false;
        Controller.direction = Direction.down;

        SnakeGame.root.getChildren().add(SnakeGame.PLAY_CANVAS);
        SnakeGame.root.getChildren().remove(title);

        generateSnake();

        SnakeGame.frame.start();
    }

    private void generateSnake() {
        // Generate snake
        for (int x = 0; x < 3; x++) {
            SnakeGame.snake.add(new Snake(20, 15));
        }
    }

    public void title() {
        title = new Canvas(SnakeGame.WIDTH, SnakeGame.HEIGHT);
        SnakeGame.isGameOver = true;
        titleContext = title.getGraphicsContext2D();
        Score.exportScore();

        SnakeGame.root.getChildren().remove(SnakeGame.PLAY_CANVAS);
        SnakeGame.root.getChildren().add(title);

        drawTitleBackground();
        Frame.basicUI(titleContext);
        drawPressSpaceText();
        drawMoveText();

        SnakeGame.snake.removeAll(SnakeGame.snake);
        SnakeGame.frame.stop();
    }

    private void drawTitleBackground() {
        titleContext.setFill(Color.web("#E4FCD4"));
        titleContext.fillRect(0, 0, SnakeGame.WIDTH, SnakeGame.HEIGHT);

        titleContext.setFill(Color.web("#254F43"));
        titleContext.fillRect(0, 0, SnakeGame.WIDTH, 75);
    }

    private void drawPressSpaceText() {
        titleContext.setFill(Color.web("#254F43"));
        titleContext.setFont(new Font("", 130));
        titleContext.fillText("PRESS SPACE", 105, 350);

        titleContext.setFill(Color.web("#254F43"));
        titleContext.setFont(new Font("", 137));
        titleContext.fillText("TO START", 200, 485);
    }

    private void drawMoveText() {
        titleContext.setFill(Color.web("#254F43"));
        titleContext.setFont(new Font("", 50));
        titleContext.fillText("W,A,S,D TO MOVE", 310, 735);
    }
}

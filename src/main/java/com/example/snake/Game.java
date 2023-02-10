package com.example.snake;

public class Game {


    public void restart() {
        // Reset parameters
        Frame.speed = 125;
        Score.score = 0;
        SnakeGame.isGameOver = false;
        Controller.direction = Direction.down;

        SnakeGame.root.getChildren().add(SnakeGame.PLAY_CANVAS);
        SnakeGame.root.getChildren().remove(UIElements.title);

        Snake.generateSnake();

        SnakeGame.frame.start();
    }

  
}

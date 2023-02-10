package com.example.snake;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class Frame extends AnimationTimer {

    // speed of the frame refresh
    static int speed;
    // initializing variable which tells the time since the last update
    long lastUpdate = 0;

    public void frameUpdate(GraphicsContext graphicsContext) {

        if (!Audio.gameAudio.isPlaying()) {
            Audio.playGameAudio();
        }
        if (SnakeGame.isGameOver) {
            new UIElements().title();
            return;
        }

        // makes snakePortions follow movements of head
        for (int snakePortion = SnakeGame.snake.size() - 1; snakePortion >= 1; snakePortion--) {
            SnakeGame.snake.get(snakePortion).xPosition = SnakeGame.snake.get(snakePortion - 1).xPosition;
            SnakeGame.snake.get(snakePortion).yPosition = SnakeGame.snake.get(snakePortion - 1).yPosition;
        }
        Controller.move();
        Food.eat();

        for (int x = 1; x < SnakeGame.snake.size(); x++) {
            if (SnakeGame.snake.get(0).xPosition == SnakeGame.snake.get(x).xPosition
                    && SnakeGame.snake.get(0).yPosition == SnakeGame.snake.get(x).yPosition) {
                SnakeGame.isGameOver = true;
            }
        }
        if (Score.score > Score.highScore) {
            Score.highScore = Score.score;
        }

        UIElements.background(graphicsContext);
        UIElements.scoreboard(graphicsContext);
        Snake.drawChunks(graphicsContext);
        Food.drawChunks(graphicsContext);
    }

    @Override
    public void handle(long now) {
        long downTime = now - lastUpdate;
        if (downTime >= speed * 10e5) {
            frameUpdate(SnakeGame.graphicsContext);
            lastUpdate = now;
        }

    }

}

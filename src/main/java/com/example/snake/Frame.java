package com.example.snake;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
public class Frame extends AnimationTimer {
   
    //speed of the frame refresh
    static int speed;
    //initializing variable which tells the time since the last update
    long lastUpdate = 0;
    public void frameUpdate(GraphicsContext graphicsContext) {


        if (!Audio.gameAudio.isPlaying()) {
            Audio.playGameAudio();
        }
        if (SnakeGame.isGameOver) {
            new Game().title();
            return;
        }

        //makes snakePortions follow movements of head
        for (int snakePortion = SnakeGame.snake.size() - 1; snakePortion >= 1; snakePortion--) {
            SnakeGame.snake.get(snakePortion).xPosition = SnakeGame.snake.get(snakePortion - 1).xPosition;
            SnakeGame.snake.get(snakePortion).yPosition = SnakeGame.snake.get(snakePortion - 1).yPosition;
        }

        Controller.move();
        Food.eat();

        for (int x = 1; x < SnakeGame.snake.size(); x++) {
            if (SnakeGame.snake.get(0).xPosition == SnakeGame.snake.get(x).xPosition && SnakeGame.snake.get(0).yPosition == SnakeGame.snake.get(x).yPosition) {
                SnakeGame.isGameOver = true;
            }
        }
        if (Score.score > Score.highScore) {
            Score.highScore = Score.score;
        }

        //colors of the UI
        graphicsContext.setFill(Color.web("#E4FCD4"));
        graphicsContext.fillRect(0, 0, SnakeGame.WIDTH, SnakeGame.HEIGHT);

        graphicsContext.setFill(Color.web("#254F43"));
        graphicsContext.fillRect(0, 0, SnakeGame.WIDTH, 75);

        SnakeGame.snake.forEach(chunk -> {
            graphicsContext.setFill(Color.web("#254F43"));
            graphicsContext.fillRect(chunk.xPosition * 25, chunk.yPosition * 25, 24, 24);
        });

        basicUI(graphicsContext);

        graphicsContext.setFill(Color.web("#8CC474"));
        graphicsContext.fillOval(Food.xPosition * 25, Food.yPosition * 25, 24, 24);


    }

    static void basicUI(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.web("#8CC474"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText(String.valueOf(Score.highScore), 10, 30);

        graphicsContext.setFill(Color.web("#8CC474"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText("High Score", 430, 30);

        graphicsContext.setFill(Color.web("#E4FCD4"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText(String.valueOf(Score.score), 10, 60);

        graphicsContext.setFill(Color.web("#E4FCD4"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText("Current Score", 411, 60);
    }
    @Override
    public void handle(long now) {
        //sets downtime to the current time minus the time of the last update
        long downTime = now - lastUpdate;
        //if downtime is greater than or equal to speed * 1,000,000, update the
        //frame and set the time of the last update to now.
        if (downTime >= speed * 10e5) {
            frameUpdate(SnakeGame.graphicsContext);
            lastUpdate = now;
        }

    }

}

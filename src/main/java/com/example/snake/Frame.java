package com.example.snake;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import static com.example.snake.Audio.gameAudio;
import static com.example.snake.Audio.gameAudioPlay;
import static com.example.snake.Controls.move;
import static com.example.snake.Food.*;
import static com.example.snake.Main.*;
import static com.example.snake.Score.highScore;
import static com.example.snake.Score.score;
public class Frame extends AnimationTimer {

    //speed of the frame refresh
    static int speed;
    //initializing variable which tells the time since the last update
    long lastUpdate = 0;
    public static void frameUpdate(GraphicsContext graphicsContext) {
        if (!gameAudio.isPlaying()) {
            gameAudioPlay();

        }

        if (isGameOver) {
            GameStop.gameStop();
            return;
        }

        //makes snakePortions follow movements of head
        for (int snakePortion = Main.snake.size() - 1; snakePortion >= 1; snakePortion--) {
            snake.get(snakePortion).xPosition = snake.get(snakePortion - 1).xPosition;
            snake.get(snakePortion).yPosition = snake.get(snakePortion - 1).yPosition;
        }

        move();
        Controls.directionSet = false;
        eat();

        for (int x = 1; x < snake.size(); x++) {
            if (snake.get(0).xPosition == snake.get(x).xPosition && snake.get(0).yPosition == snake.get(x).yPosition) {
                isGameOver = true;
            }
        }
        if (score > highScore) {
            highScore = score;
        }

        //colors of the UI
        graphicsContext.setFill(Color.web("#E4FCD4"));
        graphicsContext.fillRect(0, 0, width, height);

        graphicsContext.setFill(Color.web("#254F43"));
        graphicsContext.fillRect(0, 0, width, 75);

        snake.forEach(chunk -> {
            graphicsContext.setFill(Color.web("#254F43"));
            graphicsContext.fillRect(chunk.xPosition * 25, chunk.yPosition * 25, 24, 24);
        });

        basicUI(graphicsContext);

        graphicsContext.setFill(Color.web("#8CC474"));
        graphicsContext.fillOval(xPosition * 25, yPosition * 25, 24, 24);


    }

    static void basicUI(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.web("#8CC474"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText(String.valueOf(highScore), 10, 30);

        graphicsContext.setFill(Color.web("#8CC474"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText("High Score", 430, 30);

        graphicsContext.setFill(Color.web("#E4FCD4"));
        graphicsContext.setFont(new Font("", 30));
        graphicsContext.fillText(String.valueOf(score), 10, 60);

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
            frameUpdate(Main.graphicsContext);
            lastUpdate = now;
        }

    }

}

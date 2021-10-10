package com.example.snake;

import static com.example.snake.Main.*;
import static com.example.snake.Score.score;
import static com.example.snake.Controls.*;
public class GameStart {
    public static void gameStart() {
        //reset params
        Frame.speed = 125;
        score = 0;
        isGameOver = false;
        direction = Direction.down;

        root.getChildren().add(playCanvas);
        root.getChildren().remove(GameStop.gameOver);

        //generate snake
        for (int x = 0; x < 3; x++) {
            snake.add(new Snake(20, 15));
        }
        frame.start();

    }
}

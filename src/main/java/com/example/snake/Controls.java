package com.example.snake;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import static com.example.snake.GameStart.gameStart;
import static com.example.snake.Main.*;

enum Direction {
    left, right, up, down
}

public class Controls {
    public static Direction direction = Direction.down;
    public static Boolean directionSet = false;

    public static void controlFilter(KeyEvent key){
        if ((key.getCode() == KeyCode.W || key.getCode() == KeyCode.UP) && direction != Direction.down && !directionSet) {
            direction = Direction.up;
            directionSet = true;
        }
        if ((key.getCode() == KeyCode.A || key.getCode() == KeyCode.LEFT) && direction != Direction.right && !directionSet) {
            direction = Direction.left;
            directionSet = true;
        }
        if ((key.getCode() == KeyCode.S || key.getCode() == KeyCode.DOWN) && direction != Direction.up && !directionSet) {
            direction = Direction.down;
            directionSet = true;
        }
        if ((key.getCode() == KeyCode.D || key.getCode() == KeyCode.RIGHT) && direction != Direction.left && !directionSet) {
            direction = Direction.right;
            directionSet = true;
        }
        if (isGameOver) {
            if (key.getCode() == KeyCode.SPACE) {
                gameStart();
            }
        }
    }

    public static void move() {

        switch (direction) {
            case up:
                snake.get(0).yPosition--;
                if (snake.get(0).yPosition < 3) {
                    isGameOver = true;
                }
                break;
            case down:
                snake.get(0).yPosition++;
                if (snake.get(0).yPosition > 29) {
                    isGameOver = true;
                }
                break;
            case left:
                snake.get(0).xPosition--;
                if (snake.get(0).xPosition < 0) {
                    isGameOver = true;
                }
                break;
            case right:
                snake.get(0).xPosition++;
                if (snake.get(0).xPosition > 39) {
                    isGameOver = true;
                }
                break;
            default:
                snake.get(0).xPosition--;
                break;
        }

    }
}

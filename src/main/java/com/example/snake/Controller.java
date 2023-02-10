package com.example.snake;

import java.util.Arrays;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

enum Direction {
    up, down, left, right
}

public class Controller {
    private static final Direction[] POSSIBLE_DIRECTIONS = {Direction.left, Direction.right, Direction.up, Direction.down};
    public static Direction direction = Direction.down;

    void controlFilter(KeyEvent key) {
        Direction newDirection = null;
        if (key.getCode() == KeyCode.W || key.getCode() == KeyCode.UP) {
            newDirection = Direction.up;
        } else if (key.getCode() == KeyCode.A || key.getCode() == KeyCode.LEFT) {
            newDirection = Direction.left;
        } else if (key.getCode() == KeyCode.S || key.getCode() == KeyCode.DOWN) {
            newDirection = Direction.down;
        } else if (key.getCode() == KeyCode.D || key.getCode() == KeyCode.RIGHT) {
            newDirection = Direction.right;
        }
        if (newDirection != null && isValidDirection(newDirection)) {
            direction = newDirection;
        }

        if (SnakeGame.isGameOver && key.getCode() == KeyCode.SPACE) {
            new Game().restart();
        }
        if (key.getCode() == KeyCode.ESCAPE) {
            System.exit(0);
        }
    }

    private boolean isValidDirection(Direction newDirection) {
        return Arrays.asList(POSSIBLE_DIRECTIONS).contains(newDirection)
                && newDirection != getOppositeDirection(direction);
    }

    private Direction getOppositeDirection(Direction direction) {
        switch (direction) {
            case up:
                return Direction.down;
            case down:
                return Direction.up;
            case left:
                return Direction.right;
            case right:
                return Direction.left;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    public static void move() {

        switch (direction) {
            case up:
                SnakeGame.snake.get(0).yPosition--;
                if (SnakeGame.snake.get(0).yPosition < 3) {
                    SnakeGame.isGameOver = true;
                }
                break;
            case down:
                SnakeGame.snake.get(0).yPosition++;
                if (SnakeGame.snake.get(0).yPosition > 31) {
                    SnakeGame.isGameOver = true;
                }
                break;
            case left:
                SnakeGame.snake.get(0).xPosition--;
                if (SnakeGame.snake.get(0).xPosition < 0) {
                    SnakeGame.isGameOver = true;
                }
                break;
            case right:
                SnakeGame.snake.get(0).xPosition++;
                if (SnakeGame.snake.get(0).xPosition > 47) {
                    SnakeGame.isGameOver = true;
                }
                break;
            default:
                SnakeGame.snake.get(0).xPosition--;
                break;
        }

    }
}

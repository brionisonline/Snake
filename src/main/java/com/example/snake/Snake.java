package com.example.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Snake {

    int xPosition;
    int yPosition;

    public Snake(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    static void generateSnake() {
        // Generate snake
        for (int x = 0; x < 3; x++) {
            SnakeGame.snake.add(new Snake(20, 15));
        }
    }

    static void drawChunks(GraphicsContext graphicsContext) {
        SnakeGame.snake.forEach(chunk -> {
            graphicsContext.setFill(Color.web("#254F43"));
            graphicsContext.fillRect(chunk.xPosition * 25, chunk.yPosition * 25, 24, 24);
        });
    }

}

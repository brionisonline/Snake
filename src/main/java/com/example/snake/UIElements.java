package com.example.snake;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class UIElements {

        private static final String FONT_PATH = "/EarlyGameBoy.ttf";
        private static final Font EarlyGameboy = Font.loadFont(UIElements.class.getResource(FONT_PATH).toExternalForm(),
                        30);

        private static GraphicsContext titleContext;
        public static Canvas title;
        private static final Color backgroundColor = Color.web("#E4FCD4");
        private static final Color headerColor = Color.web("#254F43");
        private static final Color scoreColor = Color.web("#8CC474");
        private static final Color scoreBackgroundColor = Color.web("#E4FCD4");

        public void title() {
                
                title = new Canvas(SnakeGame.WIDTH, SnakeGame.HEIGHT);
                SnakeGame.root.getChildren().remove(SnakeGame.PLAY_CANVAS);
                SnakeGame.root.getChildren().add(title);

                titleContext = title.getGraphicsContext2D();
                background(titleContext);

                
                gameInstructions();
                scoreboard(titleContext);

                SnakeGame.isGameOver = true;
                SnakeGame.snake.removeAll(SnakeGame.snake);
                SnakeGame.frame.stop();
                Score.exportScore();
        }

        
        private void gameInstructions() {
                titleContext.setTextAlign(TextAlignment.CENTER);
                titleContext.setFill(headerColor);
                titleContext.setFont(EarlyGameboy);
                titleContext.fillText("SPACEBAR", SnakeGame.WIDTH / 2, 350);
                titleContext.fillText("TO START",  SnakeGame.WIDTH / 2, 485);
                titleContext.fillText("W,A,S,D TO MOVE",  SnakeGame.WIDTH / 2, 735);
        }

        public static void background(GraphicsContext graphicsContext) {
                graphicsContext.setFill(backgroundColor);
                graphicsContext.fillRect(0, 0, SnakeGame.WIDTH, SnakeGame.HEIGHT);
        }
        public static void scoreboard(GraphicsContext graphicsContext) {

                graphicsContext.setFill(headerColor);
                graphicsContext.fillRect(0, 0, SnakeGame.WIDTH, 75);

                graphicsContext.setTextAlign(TextAlignment.LEFT);
                graphicsContext.setFill(scoreColor);
                graphicsContext.setFont(EarlyGameboy);
                
                int xPos = 10;
                int yPos = 30;
                graphicsContext.fillText(String.valueOf(Score.highScore), xPos, yPos);
                
                graphicsContext.setTextAlign(TextAlignment.CENTER);
                graphicsContext.fillText("High Score", SnakeGame.WIDTH / 2, yPos);
                
                graphicsContext.setTextAlign(TextAlignment.LEFT);
                yPos = 60;
                graphicsContext.setFill(scoreBackgroundColor);
                graphicsContext.fillText(String.valueOf(Score.score), xPos, yPos);
                
                graphicsContext.setTextAlign(TextAlignment.CENTER);
                graphicsContext.fillText("Current Score", SnakeGame.WIDTH / 2, yPos);
                
        }

}

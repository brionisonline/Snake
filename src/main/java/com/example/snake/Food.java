package com.example.snake;

import java.util.Random;
public class Food {
    //new random number generator
    static int xPosition = new Random().nextInt(37) + 3;
    static int yPosition = new Random().nextInt(27) + 3;

    //randomly generates random location for initial food location
    public static void generateFood() {

        newFood:
        while (true) {
            //randomly generates xPosition and yPosition values for food
            xPosition = new Random().nextInt(37) + 3;
            yPosition = new Random().nextInt(27) + 3;

            //if any part of the snake overlays the food, restart the loop from
            //the label location
            for (Snake chunk : SnakeGame.snake) {
                if (chunk.xPosition == xPosition && chunk.yPosition == yPosition) {
                    continue newFood;
                }
            }
            break;
        }

    }
    public static void eat(){
        if (Food.xPosition == SnakeGame.snake.get(0).xPosition && Food.yPosition == SnakeGame.snake.get(0).yPosition) {
            new Audio().playEatAudio();
            Frame.speed -= 1;
            SnakeGame.snake.add(new Snake(-1, -1));
            Score.score += 50;
            generateFood();
        }
    }
}

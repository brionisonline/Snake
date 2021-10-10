package com.example.snake;

import java.util.Random;
import static com.example.snake.Audio.eatAudioPlay;
import static com.example.snake.Main.snake;
import static com.example.snake.Score.score;
public class Food {
    //new random number generator
    static Random random = new Random();
    static int xPosition = random.nextInt(37) + 3;
    static int yPosition = random.nextInt(27) + 3;

    //randomly generates random location for initial food location
    public static void generateFood() {

        newFood:
        while (true) {
            //randomly generates xPosition and yPosition values for food
            xPosition = random.nextInt(37) + 3;
            yPosition = random.nextInt(27) + 3;

            //if any part of the snake overlays the food, restart the loop from
            //the label location
            for (Snake chunk : snake) {
                if (chunk.xPosition == xPosition && chunk.yPosition == yPosition) {
                    continue newFood;
                }
            }
            break;
        }

    }
    public static void eat(){
        if (Food.xPosition == snake.get(0).xPosition && Food.yPosition == snake.get(0).yPosition) {
            eatAudioPlay();
            Frame.speed -= 1;
            snake.add(new Snake(-1, -1));
            score += 50;
            generateFood();
        }
    }
}

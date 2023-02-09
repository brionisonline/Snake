package com.example.snake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Score {
    public static int score;
    public static int highScore;

    public static void importScore(){
        try(Scanner x = new Scanner(new File("scores.txt"))) {
            highScore = x.nextInt();
        } catch(FileNotFoundException e) {
            System.out.println("Error opening file.");
        }
    }
    public static void exportScore(){
        try(Formatter y = new Formatter("scores.txt")) {
            y.format("%d", highScore);
        } catch(FileNotFoundException e) {
            System.out.println("Error opening file.");
        }
    }
}

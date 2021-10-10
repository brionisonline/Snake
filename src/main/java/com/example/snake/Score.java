package com.example.snake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Score {
    public static int score;
    public static int highScore;

    private static Scanner x;
    private static Formatter y;
    public static void importScore(){
        try{
            x = new Scanner(new File("scores.txt"));
            while(x.hasNext()){
                highScore = x.nextInt();
            }
        }
        catch(FileNotFoundException e){

        }

    }
    public static void exportScore(){
        try{
            y = new Formatter("scores.txt");
            y.format(String.valueOf(highScore));
            y.close();
        }
        catch(FileNotFoundException e){

        }
    }

}

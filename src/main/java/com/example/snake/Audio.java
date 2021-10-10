package com.example.snake;
import javafx.scene.media.AudioClip;

public class Audio {
    static AudioClip eatAudio = new AudioClip(Audio.class.getResource("/eat.wav").toString());
    static AudioClip gameAudio = new AudioClip(Audio.class.getResource("/game.wav").toString());

    static void gameAudioPlay() {

        gameAudio.play();
    }

    static void eatAudioPlay() {

        eatAudio.play();
    }
}

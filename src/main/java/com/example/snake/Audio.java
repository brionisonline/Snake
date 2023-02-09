package com.example.snake;

import javafx.scene.media.AudioClip;

public class Audio {
    final AudioClip eatAudio = new AudioClip(Audio.class.getResource("/eat.wav").toString());
    final static AudioClip gameAudio = new AudioClip(Audio.class.getResource("/game.wav").toString());

    public static void playGameAudio() {
        gameAudio.setVolume(0.5);
        gameAudio.play();
    }

    public void playEatAudio() {
        eatAudio.setVolume(0.5);
        eatAudio.play();
    }
}

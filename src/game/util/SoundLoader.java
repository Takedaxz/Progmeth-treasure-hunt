package game.util;

import javafx.scene.media.AudioClip;

public class SoundLoader {
    private static final String CRASH_SOUND = "/crash.mp3";
    private static final String MOVE_SOUND = "/oui.mp3";
    private static final String WIN_SOUND = "/win.mp3";

    private static final String FREEZE_SOUND = "/freeze.mp3";
    private static final String LOSE_SOUND = "/lose.mp3";
    private static final String CLICK_SOUND = "/click.mp3";
    private static AudioClip audioClipCrash;
    private static AudioClip audioClipMove;
    private static AudioClip audioClipWin;
    private static AudioClip audioClipLose;
    private static AudioClip audioClick;


    static {
        audioClipCrash = new AudioClip(SoundLoader.class.getResource(CRASH_SOUND).toExternalForm());
        audioClipMove = new AudioClip(SoundLoader.class.getResource(MOVE_SOUND).toExternalForm());
        audioClipWin = new AudioClip(SoundLoader.class.getResource(WIN_SOUND).toExternalForm());
        audioClipLose = new AudioClip(SoundLoader.class.getResource(LOSE_SOUND).toExternalForm());
        audioClick = new AudioClip(SoundLoader.class.getResource(CLICK_SOUND).toExternalForm());


        audioClipCrash.setVolume(0);
        audioClipCrash.play();
        audioClipMove.setVolume(0);
        audioClipMove.play();
        audioClipWin.setVolume(0);
        audioClipWin.play();
        audioClipLose.setVolume(0);
        audioClipLose.play();
        audioClick.setVolume(0);
        audioClick.play();
    }

    public static void playCrashSound() {
        audioClipCrash.setVolume(1);
        audioClipCrash.play();
    }

    public static void playWinSound() {
        audioClipWin.setVolume(1);
        audioClipWin.play();
    }

    public static void playLoseSound() {
        audioClipLose.setVolume(1);
        audioClipLose.play();
    }

    public static void playClickSound() {
        audioClick.setVolume(1);
        audioClick.play();
    }


    public static void playMoveSound() {
        audioClipMove.setVolume(0.5);
        audioClipMove.play();
    }
}

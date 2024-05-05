package game;


import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public interface SokobanGame {
    StackPane getScene();
    void startTimer();
    void pauseGame();
    void resumeGame();
}

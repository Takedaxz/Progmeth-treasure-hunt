package game.menu;

import game.GameEvent;
import game.util.SoundLoader;
import javafx.scene.layout.StackPane;

public class MenuItemRestartLevel extends MenuItem{
    public MenuItemRestartLevel(StackPane boardStackPane) {
    setMenuItemName("Restart Level");

    setOnMouseClicked(event ->
    {
        SoundLoader.playClickSound();
        boardStackPane.fireEvent(new GameEvent(GameEvent.RESTART_LEVEL));
    });
}
}

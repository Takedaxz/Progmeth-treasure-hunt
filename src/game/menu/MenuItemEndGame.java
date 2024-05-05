package game.menu;

import game.GameEvent;
import game.util.SoundLoader;
import javafx.scene.layout.StackPane;

public class MenuItemEndGame extends MenuItem{
    public MenuItemEndGame(StackPane boardStackPane)
    {
        setMenuItemName("End Game");

        setOnMouseClicked(event ->
        {
            SoundLoader.playClickSound();
            boardStackPane.fireEvent(new GameEvent(GameEvent.END_GAME_LEVEL));
        });
    }
}

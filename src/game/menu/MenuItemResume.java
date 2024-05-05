package game.menu;

import game.Board;
import game.util.SoundLoader;
import javafx.scene.layout.StackPane;

public class MenuItemResume extends MenuItem{
    public MenuItemResume(StackPane boardStackPane)
    {
        setMenuItemName("Resume");
        setOnMouseClicked(event ->
        {
            SoundLoader.playClickSound();
            Board.setPauseMenuFalse();
            boardStackPane.getChildren().remove(boardStackPane.getChildren().size()-1);
        });
    }
}

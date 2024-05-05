package game.menu;

import game.Main;
import game.util.SoundLoader;
import javafx.scene.layout.StackPane;

import static game.Main.getMainStage;

class MenuItemPlay extends MenuItem
{
    public MenuItemPlay()
    {
        setMenuItemName("PLAY");

        setOnMouseClicked(event ->
        {
            SoundLoader.playClickSound();
            StackPane stackPane = (StackPane) getMainStage().getScene().getRoot();
            stackPane.getChildren().add(new MenuLevelSelector().createLevelSelectorStackPane());
        });
    }
}

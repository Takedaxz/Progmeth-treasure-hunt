package game.menu;

import game.Main;
import game.util.SoundLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import static game.Main.getMainStage;

class MenuItemHowToPlay extends MenuItem
{
    public MenuItemHowToPlay()
    {
        setMenuItemName("HOW TO PLAY");

        setOnMouseClicked(event ->
        {
            SoundLoader.playClickSound();
            StackPane stackPane = (StackPane) getMainStage().getScene().getRoot();
            stackPane.getChildren().add(new MenuHowToPlay().createHowToPlayScene());
        });
    }
}

package game.menu;

import game.util.ImageLoader;
import game.util.SoundLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class GameStatusMenu{
    private StackPane rootStackPane;

    public GameStatusMenu()
    {
        rootStackPane = new StackPane();
        rootStackPane.setPrefSize(1050 - 600, 600 - 200);

        Rectangle background = new Rectangle(1050-600, 600-200);
        background.setFill(Color.BLACK);
        background.setOpacity(0.8);
        background.setArcWidth(20); // Set the horizontal corner radius
        background.setArcHeight(20);
        rootStackPane.getChildren().add(background);
    }

    public Parent createLoseMenu(StackPane boardStakePane)
    {
        Title title = new Title("You lose!",50);
        title.setTranslateY(-100);
        SoundLoader.playLoseSound();
        MenuVBox vBoxMenuBox = new MenuVBox(
                new MenuItemRestartLevel(boardStakePane),
                new MenuItemEndGame(boardStakePane)
        );

        vBoxMenuBox.setAlignment(Pos.CENTER);

        rootStackPane.getChildren().addAll(title, vBoxMenuBox);

        return rootStackPane;
    }

    public Parent createVictoryMenu(StackPane boardStakePane)
    {
        Title title = new Title("Victory",50);
        title.setTranslateY(-100);
        SoundLoader.playWinSound();

        MenuVBox vBoxMenuBox = new MenuVBox(
                new MenuItemEndGame(boardStakePane)
        );

        vBoxMenuBox.setAlignment(Pos.CENTER);

        rootStackPane.getChildren().addAll(title, vBoxMenuBox);

        return rootStackPane;
    }
}

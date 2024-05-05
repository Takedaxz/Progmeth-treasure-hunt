package game.menu;

import game.util.ImageLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GamePauseMenu {
    public Parent createContent(StackPane boardStackPane)
    {
        StackPane root = new StackPane();

        root.setPrefSize(1050, 600);

        ImageView imageView = new ImageView(ImageLoader.getImageBackground());
        imageView.setFitWidth(root.getPrefWidth());
        imageView.setFitHeight(root.getPrefHeight());
        root.getChildren().add(imageView);

        Rectangle background = new Rectangle(1050, 600);
        background.setFill(Color.BLACK);
        background.setOpacity(0.5);
        root.getChildren().add(background);

        Title title = new Title("Pause",50);
        title.setTranslateY(-200);

        MenuVBox vBoxMenuBox = new MenuVBox(
                new MenuItemResume(boardStackPane),
                new MenuItemRestartLevel(boardStackPane),
                new MenuItemEndGame(boardStackPane)
        );

        vBoxMenuBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(title, vBoxMenuBox);


        return root;
    }
}

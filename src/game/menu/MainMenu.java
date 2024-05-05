package game.menu;

import game.Main;
import game.util.ImageLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainMenu {

    public Parent createContent(){
        StackPane root = new StackPane();
        root.setPrefSize(1050,600);

        ImageView imageView = new ImageView(ImageLoader.getImageBackground());
        imageView.setFitWidth(root.getPrefWidth());
        imageView.setFitHeight(root.getPrefHeight());
        root.getChildren().add(imageView);

        Rectangle background = new Rectangle(1050, 600);
        background.setFill(Color.BLACK);
        background.setOpacity(0.5);
        root.getChildren().add(background);

        Title menuTitle=new Title("PREGMOTH TREASURE HUNT",50);
        menuTitle.setTranslateY(-100);


        MenuVBox vBoxMenuBox = new MenuVBox(
                new MenuItemPlay(),
                new MenuItemHowToPlay(),
                new MenuItemExit());
        vBoxMenuBox.setTranslateY(100);
        vBoxMenuBox.setAlignment(Pos.CENTER);

        root.getChildren().addAll(menuTitle,vBoxMenuBox);

        ImageView musicOnImage = new ImageView(ImageLoader.getSoundOn());
        ImageView musicOffImage = new ImageView(ImageLoader.getSoundOff());
        ImageView musicImageView = new ImageView();
        musicImageView.setImage(musicOnImage.getImage());
        musicImageView.setFitWidth(70);
        musicImageView.setFitHeight(70);
        musicImageView.setTranslateY(250);
        musicImageView.setTranslateX(-400);
        musicImageView.setStyle("-fx-background-color: black;");

        musicImageView.setOnMouseClicked(event -> {
            if (Main.backgroundMusicPlayer.isMute()) {
                Main.backgroundMusicPlayer.setMute(false);
                musicImageView.setImage(musicOnImage.getImage());
            } else {
                Main.backgroundMusicPlayer.setMute(true);
                musicImageView.setImage(musicOffImage.getImage());
            }
        });

        root.getChildren().add(musicImageView);


        return root;
    }
}

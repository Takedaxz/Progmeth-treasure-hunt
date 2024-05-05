package game.menu;

import game.Main;
import game.util.ImageLoader;
import game.util.SoundLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Pos;

import static game.Main.getMainStage;

public class MenuHowToPlay {
    public StackPane createHowToPlayScene() {

        StackPane stackPaneHowToPlay = new StackPane();
        stackPaneHowToPlay.setPrefSize(1050, 600);

        ImageView imageViewBackground = new ImageView(ImageLoader.getImageBackground());
        imageViewBackground.setFitWidth(stackPaneHowToPlay.getPrefWidth());
        imageViewBackground.setFitHeight(stackPaneHowToPlay.getPrefHeight());

        Rectangle background = new Rectangle(1050, 600);
        background.setFill(Color.BLACK);
        background.setOpacity(0.5);

        stackPaneHowToPlay.getChildren().addAll(imageViewBackground, background);

        ImageView backButtonImage = new ImageView(ImageLoader.getImageBackButton());
        backButtonImage.setFitWidth(60);
        backButtonImage.setFitHeight(60);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        Title menuTitle = new Title("HOW TO PLAY INSTRUCTIONS",40);

        Text instructionText1 = new Text("1. Arrow buttons are used to control the direction you want to move.");
        Text instructionText2 = new Text("2. You have to take a coins to reach the heart.");
        Text instructionText3 = new Text("3. The maximum move is 200 moves.");
        Font font = Font.font("Pixellari",FontWeight.SEMI_BOLD, 28);
        instructionText1.setFont(font);
        instructionText2.setFont(font);
        instructionText3.setFont(font);
        instructionText1.setFill(Color.WHITE);
        instructionText2.setFill(Color.WHITE);
        instructionText3.setFill(Color.WHITE);
        instructionText1.setTextAlignment(TextAlignment.CENTER);
        instructionText2.setTextAlignment(TextAlignment.CENTER);
        instructionText3.setTextAlignment(TextAlignment.CENTER);

        Button backButtonToMainMenu = new Button();
        backButtonToMainMenu.setGraphic(backButtonImage);
        backButtonToMainMenu.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");


        VBox.setMargin(menuTitle, new Insets(80, 0, 40, 0));
        VBox.setMargin(instructionText1, new Insets(10, 0, 10, 0));
        VBox.setMargin(instructionText2, new Insets(10, 0, 10, 0));
        VBox.setMargin(instructionText3, new Insets(10, 0, 40, 0));
        VBox.setMargin(backButtonToMainMenu, new Insets(20, 0, 0, 20));

        vBox.getChildren().addAll(menuTitle ,instructionText1,instructionText2,instructionText3,backButtonToMainMenu);

        backButtonToMainMenu.setOnAction(e -> {
            SoundLoader.playClickSound();
            backToMainMenu();}
        );

        stackPaneHowToPlay.getChildren().addAll(vBox);

        return stackPaneHowToPlay;
    };


    private void backToMainMenu()
    {
        StackPane stackPane = (StackPane) getMainStage().getScene().getRoot();
        stackPane.getChildren().remove(stackPane.getChildren().size() - 1);
    }
}
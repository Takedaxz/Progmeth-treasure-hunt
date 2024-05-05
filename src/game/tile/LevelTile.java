package game.tile;

import game.Board;
import game.GameEvent;
import game.Main;
import game.menu.MenuLevelSelector;
import game.util.ImageLoader;
import game.util.SoundLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static game.Main.getMainStage;

public class LevelTile extends StackPane {
    private int levelNumber;

    public LevelTile(String value,double translateX,double translateY) {
        setAlignment(Pos.CENTER);

        setPrefWidth(100);
        setPrefHeight(100);

        setTranslateX(translateX);
        setTranslateY(translateY);

        levelNumber = Integer.parseInt(value);

        Button button = new Button();
        button.setPrefHeight(100);
        button.setPrefWidth(100);
        button.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 20;");


        Font preferredFont = Font.font("Pixellari", FontWeight.BOLD, 24);

        if (levelNumber - 1 > Main.getPlayerInfo().getLastPassedLevel())
        {
            ImageView imageViewLockedLevel = new ImageView(ImageLoader.getImageLock());
            imageViewLockedLevel.setFitHeight(20);
            imageViewLockedLevel.setFitWidth(20);
            button.setGraphic(imageViewLockedLevel);
        } else
        {
            button.setText(value);
            button.setTextFill(Color.BLACK);
            button.setFont(preferredFont);
            button.setOnAction(e -> {
                SoundLoader.playClickSound();
                createAndShowBoardStage();
            });
            setOnMouseEntered(event ->{
                button.setTextFill(Color.DARKGREY);});
            setOnMouseExited(event -> button.setTextFill(Color.BLACK));
        }

        getChildren().addAll(button);
    }

    private void createAndShowBoardStage(){
        Board boardGame = new Board(levelNumber);
        StackPane boardStackPane = boardGame.getScene();

        boardStackPane.addEventFilter(GameEvent.END_GAME_LEVEL, event ->
        {
            StackPane stackPane = (StackPane) getMainStage().getScene().getRoot();
            stackPane.getChildren().remove(stackPane.getChildren().size() - 1);
            stackPane.getChildren().add(new MenuLevelSelector().createLevelSelectorStackPane());
        });

        boardStackPane.addEventFilter(GameEvent.RESTART_LEVEL, event ->
        {
            createAndShowBoardStage();
        });

        StackPane stackPane = (StackPane) getMainStage().getScene().getRoot();
        stackPane.getChildren().remove(stackPane.getChildren().size() - 1);
        stackPane.getChildren().add(boardStackPane);
        boardGame.startTimer();
    }
}

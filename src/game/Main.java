package game;

import game.menu.MainMenu;
import game.util.ImageLoader;
import game.util.PlayerInfoWriterReader;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class Main extends Application
{
    public static Stage mainStage;
    public static PlayerInfo playerInfo;
    public static MediaPlayer backgroundMusicPlayer;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        initializePlayerInfo();
        initializeBackgroundMusic();
        Image appIcon = ImageLoader.getImageLogo();
        primaryStage.getIcons().add(appIcon);

        // Set the app title
        primaryStage.setTitle("Pregmoth Treasure Hunt");

        Scene scene = new Scene(new MainMenu().createContent());

        Cursor customCursor = new ImageCursor(new Image("/pointer.png"));

        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.getScene().setCursor(customCursor);
        setMainStage(primaryStage);
    }

    public static void setPlayerInfo(PlayerInfo playerInfo) {
        Main.playerInfo = playerInfo;
    }

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage mainStage) {
        Main.mainStage = mainStage;
    }

    public void initializePlayerInfo(){
        PlayerInfoWriterReader playerInfoWriterReader=new PlayerInfoWriterReader();
        PlayerInfo playerInfo=playerInfoWriterReader.read();
        if(playerInfo==null){
            playerInfo=new PlayerInfo();
            playerInfoWriterReader.write(playerInfo);
        }

        setPlayerInfo(playerInfo);
    }

    private void initializeBackgroundMusic() {
        String musicFile = "/music.mp3";
        Media sound = new Media(Objects.requireNonNull(getClass().getResource(musicFile)).toExternalForm());
        backgroundMusicPlayer = new MediaPlayer(sound);
        backgroundMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        backgroundMusicPlayer.setVolume(0.2);
        backgroundMusicPlayer.play();
    }

    public static PlayerInfo getPlayerInfo(){
        return playerInfo;
    }
}

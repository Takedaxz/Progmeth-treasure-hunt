package game.util;

import javafx.scene.image.Image;

public class ImageLoader {

    private static Image imageBackground = new Image("/mainbackground.png");
    private static  Image imageWall = new Image("/dirt.png");
    private static  Image imageBox = new Image("/box.gif");
    private static Image imageTime = new Image("extra-time.png");
    private static  Image imageTarget = new Image("/target.gif");
    private static  Image imageLock = new Image("/lock.png");
    private static Image imageBackButton = new Image("/back-button.png");
    private static Image soundOn = new Image("/transparentDark11.png");
    private static Image soundOff = new Image("/transparentDark13.png");
    private static Image imageLogo = new Image("/logo.png");
    public static Image getImageBackground(){
        return imageBackground;
    }

    public static Image getImageWall(){
        return imageWall;
    }

    public static Image getImageBox(){
        return imageBox;
    }

    public static Image getImageTime() { return imageTime;}

    public static Image getImageTarget(){
        return imageTarget;
    }

    public static Image getImageLock(){
        return imageLock;
    }

    public static Image getImageBackButton(){
        return imageBackButton;
    }

    public static Image getImageLogo(){
        return imageLogo;
    }

    public static Image getSoundOn() {
        return soundOn;
    }
    public static Image getSoundOff() {
        return soundOff;
    }
}

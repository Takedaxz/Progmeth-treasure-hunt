package game.token;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SokobanToken extends ImageView {
    private int row;
    private int column;
    private static int characterSelected;
    private Image imageLeft1 = new Image("/player1.gif");
    private Image imageLeft2 = new Image("/player2.gif");

    public SokobanToken(int row, int column)
    {
//        System.out.println(getCharacterSelected());
        if(getCharacterSelected()==0){
            setImage(imageLeft1);
        }
        else{
            setImage(imageLeft2);
        }
        setFitHeight(30);
        setFitWidth(30);

        this.row = row;
        this.column = column;
    }

    public int getCharacterSelected() {
        return characterSelected;
    }

    public static void selectCharacter(int characterIndex) {
        characterSelected=characterIndex;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getColumn()
    {
        return column;
    }

    public void setColumn(int column)
    {
        this.column = column;
    }

    public void changeImageToUp()
    {
        if(getCharacterSelected()==0){
            setImage(imageLeft1);
        }
        else{
            setImage(imageLeft2);
        }
    }

    public void changeImageToDown()
    {
        if(getCharacterSelected()==0){
            setImage(imageLeft1);
        }
        else{
            setImage(imageLeft2);
        }
    }

    public void changeImageToLeft()
    {
        if(getCharacterSelected()==0){
        setImage(imageLeft1);
    }
    else{
        setImage(imageLeft2);
    }
    }

    public void changeImageToRight()
    {
        if(getCharacterSelected()==0){
            setImage(imageLeft1);
        }
        else{
            setImage(imageLeft2);
        }
    }
}

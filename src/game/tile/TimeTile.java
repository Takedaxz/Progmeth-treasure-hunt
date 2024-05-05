package game.tile;

import game.Board;
import game.token.BoxToken;
import game.token.SokobanToken;
import game.util.ImageLoader;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class TimeTile extends PathTile implements WalkThroughAble{

    private SokobanToken sokobanToken = null;
    private ImageView imageView;
    private BoxToken boxToken = null;

    public TimeTile(int row, int column, double translateX, double translateY) {
        super(row, column, translateX, translateY);

        imageView = new ImageView(ImageLoader.getImageTime());
        imageView.setFitHeight(25);
        imageView.setFitWidth(25);

        getChildren().addAll(imageView);
    }


    public boolean removeSokoban()
    {
        if (getChildren().size() > 1)
        {
            getChildren().remove(1);
            sokobanToken = null;
            setTokenOnIt(false);
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    public boolean addSokobanToken(SokobanToken sokobanToken)
    {
        this.sokobanToken = sokobanToken;
        sokobanToken.setColumn(getColumn());
        sokobanToken.setRow(getRow());
        getChildren().addAll(sokobanToken);
        setTokenOnIt(true);

        if (getChildren().size() > 1 && this.sokobanToken != null)
            return true;
        return false;
    }


    @Override
    public boolean addBoxToken(BoxToken boxToken)
    {
        this.boxToken = boxToken;
        this.boxToken.setColumn(getColumn());
        this.boxToken.setRow(getRow());
        getChildren().addAll(this.boxToken);
        setTokenOnIt(true);

        if (getChildren().size() > 1 && this.boxToken != null)
            return true;
        return false;
    }


    @Override
    public boolean removeBoxToken()
    {
        if (getChildren().size() > 1)
        {
            getChildren().remove(1);
            boxToken = null;
            setTokenOnIt(false);
            return true;
        } else
        {
            return false;
        }
    }


    public SokobanToken getSokobanToken()
    {
        return sokobanToken;
    }

    public void setSokobanToken(SokobanToken sokobanToken)
    {
        this.sokobanToken = sokobanToken;
    }

    @Override
    public BoxToken getBoxToken()
    {
        return boxToken;
    }

    public void setBoxToken(BoxToken boxToken)
    {
        this.boxToken = boxToken;
    }

    @Override
    public boolean canWalkThrough() {
        return true;
    }

}
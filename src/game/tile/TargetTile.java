package game.tile;

import game.token.BoxToken;
import game.token.SokobanToken;
import game.util.ImageLoader;
import javafx.scene.image.ImageView;

public class TargetTile extends AbstractTile implements WalkThroughAble {
    private SokobanToken sokobanToken = null;
    private BoxToken boxToken = null;


    public TargetTile(int row, int column, double translateX, double translateY)
    {
        super(row, column, translateX, translateY);

        imageView = new ImageView(ImageLoader.getImageTarget());
        imageView.setFitHeight(49.5);
        imageView.setFitWidth(49.5);

        getChildren().addAll(imageView);
    }

    @Override
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

    @Override
    public BoxToken getBoxToken()
    {
        return boxToken;
    }


    @Override
    public boolean canWalkThrough() {
        return true;
    }
}

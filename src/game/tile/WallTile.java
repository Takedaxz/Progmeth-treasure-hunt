package game.tile;

import game.token.BoxToken;
import game.token.SokobanToken;
import game.util.ImageLoader;
import javafx.scene.image.ImageView;

public class WallTile extends AbstractTile implements WalkThroughAble{
    public WallTile(int row, int column, double translateX, double translateY)
    {
        super(row, column, translateX, translateY);

        imageView = new ImageView(ImageLoader.getImageWall());
        imageView.setFitHeight(49.5);
        imageView.setFitWidth(49.5);

        getChildren().addAll(imageView);
    }

    @Override
    public boolean removeSokoban()
    {
        return false;
    }

    @Override
    public boolean addSokobanToken(SokobanToken sokobanToken)
    {
        return false;
    }

    @Override
    public boolean addBoxToken(BoxToken boxToken)
    {
        return false;
    }

    @Override
    public boolean removeBoxToken()
    {
        return false;
    }

    @Override
    public BoxToken getBoxToken()
    {
        return null;
    }

    @Override
    public boolean canWalkThrough() {
        return false;
    }
}

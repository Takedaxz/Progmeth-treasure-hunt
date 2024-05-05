package game.menu;

import game.util.SoundLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class MenuItem extends StackPane {
    private String menuItemName;
    private Text text;

    public MenuItem()
    {
        Rectangle moderateCorners = new Rectangle(260, 50);
        moderateCorners.setFill(Color.WHITE);
        moderateCorners.setArcWidth(20);
        moderateCorners.setArcHeight(20);
        moderateCorners.setOpacity(0.4);

        text = new Text();
        text.setFill(Color.WHITE);
        text.setFont(Font.font("Pixellari", 30));

        getChildren().addAll(moderateCorners, text);

        setOnMouseEntered(event ->{
            text.setFill(Color.DARKGREY);});

        setOnMouseExited(event -> text.setFill(Color.WHITE));
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
        text.setText(menuItemName);
    }

}

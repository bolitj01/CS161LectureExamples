package javafx_inheritance;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ShoppingRow extends HBox {
    private String picURL;
    private String name;

    public ShoppingRow(String picURL, String name) {
        this.picURL = picURL;
        this.name = name;
        //TODO ImageView, Label, Button
        ImageView iv = new ImageView(new Image(picURL));
        iv.setPreserveRatio(true);
        iv.setFitHeight(100);
        Label nameLbl = new Label(name);
        Button addButton = new Button("Add");

        addButton.setOnAction(e -> {
            System.out.println("Added to cart");
        });

        getChildren().addAll(iv, nameLbl, addButton);

        setAlignment(Pos.CENTER);
        setSpacing(20);
    }


}

package javafx_inheritance;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ProductView extends HBox {

    private Label nameLabel;
    private Label priceLabel;
    private ImageView imageView;
    private Button addToCartButton;
    private Product product; // Reference to a Product object

    public ProductView(Product product, Label totalLbl) {
        this.product = product; // Initialize the product reference
        
        // Initialize components using the product details
        nameLabel = new Label(product.getName());
        priceLabel = new Label(String.format("$%.2f", product.getPrice()));
        imageView = new ImageView(new Image(product.getImageUrl()));
        addToCartButton = new Button("Add to Cart");

        configureComponents(); // Configure and add components to the HBox
        setupEventHandlers(totalLbl); // Setup event handlers
    }

    private void configureComponents() {
        // Configure ImageView
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        // Configure HBox properties
        this.setAlignment(Pos.CENTER_LEFT);
        this.setSpacing(10);
        this.setPadding(new Insets(5, 10, 5, 10));

        // Add components to the HBox
        getChildren().addAll(imageView, nameLabel, priceLabel, addToCartButton);
    }

    private void setupEventHandlers(Label totalLbl) {
        // Handle button click (example placeholder action)
        addToCartButton.setOnAction(event -> {
			double total = Double.parseDouble(totalLbl.getText());
			total += product.getPrice();
			totalLbl.setText(String.format("%.2f", total));
        });
    }
}

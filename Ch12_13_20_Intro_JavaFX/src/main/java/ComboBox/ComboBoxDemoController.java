package ComboBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ComboBoxDemoController {

    @FXML
    private ComboBox<String> sizeCB;

    @FXML
    private ImageView dogIV;

    @FXML
    private StackPane imgPane;
    
    @FXML
    public void initialize() {
    	dogIV.setPreserveRatio(true);
    	dogIV.setFitHeight(300);
    	
    	/*
    	 * ImageView cannot have a pref height or width
    	 * So it is wrapped in a StackPane and it's
    	 * width and height properties are bound to the StackPane
    	 */
    	dogIV.fitWidthProperty().bind(imgPane.widthProperty());
        dogIV.fitHeightProperty().bind(imgPane.heightProperty());
    	
        //To reference the StackPane in CSS with #image-pane
        imgPane.setId("image-pane");
    	
    	//Add items to the ListView
    	sizeCB.getItems().addAll(
      		  "Small", "Medium", "Large", "Ultra"
      		  );

    }
    
    @FXML
    void resizeImage(ActionEvent event) {
    	String size = sizeCB.getValue().toLowerCase();
        System.out.println(imgPane.getStyleClass());
    	imgPane.getStyleClass().clear();
    	imgPane.getStyleClass().add(size);
    }

}

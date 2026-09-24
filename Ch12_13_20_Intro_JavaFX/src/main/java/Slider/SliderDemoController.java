package Slider;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class SliderDemoController {

    @FXML
    private Slider sizeSlider;

    @FXML
    private ImageView dogIV;

    @FXML
    private StackPane imgPane;
    
    @FXML
    public void initialize() {
    	dogIV.setPreserveRatio(true);
    	dogIV.setFitWidth(200);
    	dogIV.setFitHeight(200);
    	
    	//Event for when the slider value changes
    	sizeSlider.valueProperty().addListener((observeable, oldValue, newValue) -> {
    		dogIV.setFitWidth(newValue.doubleValue());
        	dogIV.setFitHeight(newValue.doubleValue());
    	});
    }

}

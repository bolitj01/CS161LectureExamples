package CheckBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class CheckBoxEventController {

    @FXML
    private CheckBox myCheckBox;

    @FXML
    private Label outputLabel;

    @FXML
    void myCheckBoxListener(ActionEvent event) {
    	
    	if (myCheckBox.isSelected()) {
    		outputLabel.setText("Did you REALLY read it?");
    	}
    	else {
    		outputLabel.setText("Read the terms!");
    	}
    	
    }

}

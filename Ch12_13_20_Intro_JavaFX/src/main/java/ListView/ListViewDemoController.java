package ListView;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ListViewDemoController {

    @FXML
    private ListView<String> dogBreedLV;

    @FXML
    private ImageView dogIV;

    @FXML
    public void initialize() {
    	dogIV.setPreserveRatio(true);
    	dogIV.setFitHeight(300);
    	
    	//Add items to the ListView
    	dogBreedLV.getItems().addAll(
      		  "Australian Shepherd",
      		  "Samoyed", "Golden Retriever",
      		  "Schnoodle");
    	
    	//Add an event listener to the ListView
    	dogBreedLV.getSelectionModel().selectedItemProperty().addListener(event -> {
    		//Get the selected item, which is a String
    		String breed = dogBreedLV.getSelectionModel().getSelectedItem();
        	//Set the ImageView to the file of "[breed].jpg"
    		dogIV.setImage(new Image(getClass().getResourceAsStream(breed + ".jpg")));
    		//getClass().getResourceAsStream(path) will load the resource found in the resources folder
    	});
    }
    

}

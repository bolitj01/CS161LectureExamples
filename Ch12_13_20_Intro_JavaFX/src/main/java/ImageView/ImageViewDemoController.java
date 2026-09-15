package ImageView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class ImageViewDemoController 
{
	// Private fields for components 
	@FXML
	private ImageView myImage;

	@FXML
	private ToggleGroup myToggleGroup;

	@FXML
	private RadioButton dogRadioButton;

	@FXML
	private RadioButton catRadioButton;
	
	@FXML
	private HBox animalBox;

	// Private fields for the dog and cat images
	private Image dogImage;
	private Image catImage;

	// Initialize method
	public void initialize() 
	{
		// Load the dog and cat images
		dogImage = new Image("Dog.jpg");
		catImage = new Image("Cat.jpg");
		Image fishImage = new Image("https://cdn.mos.cms.futurecdn.net/4UdEs7tTKwLJbxZPUYR3hF-1200-80.jpg");

//		dogRadioButton.setOnAction(e -> {
//			if (dogRadioButton.isSelected()) {
//				myImage.setImage(dogImage);
//			}
//		});
		
		catRadioButton.setOnAction(e -> {
			if (catRadioButton.isSelected()) {
				myImage.setImage(catImage);
			}
		});
		
		RadioButton fishRadioButton = new RadioButton("Fish");
		fishRadioButton.setToggleGroup(myToggleGroup);
		fishRadioButton.setOnAction(e -> {
			if (fishRadioButton.isSelected()) {
				myImage.setImage(fishImage);
			}
		});
		
		fishRadioButton.setFont(catRadioButton.getFont());
		animalBox.getChildren().add(fishRadioButton);
		
	}

	@FXML
	public void showDog(ActionEvent e){
		if (dogRadioButton.isSelected()) {
			myImage.setImage(dogImage);
		}
	}
}


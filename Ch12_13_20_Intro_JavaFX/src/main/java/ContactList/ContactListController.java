package ContactList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContactListController {

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField phoneTxt;
    
    @FXML
    private TextField urlTxt;
    
    @FXML
    private VBox contacts;

    @FXML
    void addContact(ActionEvent event) {
    	System.out.println("check");
    	String name = nameTxt.getText();
    	String phone = phoneTxt.getText();
    	
    	Label phoneLbl = new Label(phone);
    	Label nameLbl = new Label(name);
    	
    	HBox contactBox = new HBox();
    	
    	//Contact picture
    	Image contactImg = new Image(urlTxt.getText());
    	ImageView contactIV = new ImageView(contactImg);
    	contactIV.setPreserveRatio(true);
    	contactIV.setFitHeight(40);
    	
    	Button deleteBtn = new Button("Delete");
    	
    	deleteBtn.setOnAction(e -> {
    		contacts.getChildren().remove(contactBox);
    	});
    	
    	contactBox.getChildren().addAll(nameLbl, phoneLbl, contactIV, deleteBtn);
    	
    	contactBox.setSpacing(100 - (4 * name.length()));
    	contactBox.setPadding(new Insets(0, 0, 0, 10)); //Left padding
    	contactBox.setAlignment(Pos.CENTER_LEFT);
    	
    	contacts.getChildren().add(contactBox);
    }
}

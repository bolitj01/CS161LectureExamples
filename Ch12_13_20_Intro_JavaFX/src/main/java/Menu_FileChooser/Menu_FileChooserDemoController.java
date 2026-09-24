package Menu_FileChooser;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class Menu_FileChooserDemoController {

    @FXML
    private TextArea fileText;

    private FileChooser fc;
    private File f;
    
    
    @FXML
    private RadioMenuItem largeRMI;

    @FXML
    private RadioMenuItem mediumRMI;

    @FXML
    private RadioMenuItem smallRMI;

    @FXML
    void changeFont(ActionEvent event) {
    	if (smallRMI.isSelected()) {
    		fileText.getStyleClass().remove("medium");
    		fileText.getStyleClass().remove("large");
    		fileText.getStyleClass().add("small");
    	}
    	if (mediumRMI.isSelected()) {
    		fileText.getStyleClass().clear();
    		fileText.getStyleClass().addAll("text-area", "medium");
    	}
    	if (largeRMI.isSelected()) {
    		fileText.getStyleClass().clear();
    		fileText.getStyleClass().addAll("text-area", "large");
    	}
    }
    
    @FXML
    public void initialize() {
    	fc = new FileChooser();
    	/*
    	 * Get the folder path of the src/main/resources/Menu_FileChooser folder
    	 * and make the FileChooser start here when it is used to open or save
    	 */
    	Path folderPath = Paths.get("src/main/resources/Menu_FileChooser");
    	fc.setInitialDirectory(folderPath.toFile());
    	fileText.setWrapText(true);
    }
    
    /**
     * Open a user-selected file
     * @param event
     */
    @FXML
    void readFile(ActionEvent event) {
    	/*
    	 * Putting the current Window as an argument will force the dialog
    	 * to be completed before interacting with the window further
    	 * (this is called a modal window)
    	 */
    	f = fc.showOpenDialog(fileText.getScene().getWindow());
    	Scanner reader = null;
    	try {
			reader = new Scanner(f);
			// This delimiter reads the entire file at once
			reader.useDelimiter("\\A");
			String content = reader.hasNext() ? reader.next() : "";
	        reader.close();
	        fileText.setText(content);
		} catch (IOException e) {
			System.err.println("Error reading file:");
			e.printStackTrace();
		}
    }

    /**
     * Overwrite the last opened file
     * @param event
     */
    @FXML
    void save(ActionEvent event) {
    	if (f != null) {
    		PrintWriter pw = null;
			try {
				pw = new PrintWriter(f);
				pw.write(fileText.getText());
			} catch (IOException e) {
				System.err.println("Error saving file:");
				e.printStackTrace();
			} finally {
				pw.close();
			}
    	}
    	else {
    		saveAs(event);
    	}
    }
    
    /**
     * Save to a user-selected file
     * @param event
     */
    @FXML
    public void saveAs(ActionEvent event) {
    	f = fc.showSaveDialog(fileText.getScene().getWindow());
    	if (f != null) {
    		PrintWriter pw = null;
			try {
				pw = new PrintWriter(f);
				pw.write(fileText.getText());
			} catch (IOException e) {
				System.err.println("Error saving file:");
				e.printStackTrace();
			} finally {
				pw.close();
			}
    	}
    }

}

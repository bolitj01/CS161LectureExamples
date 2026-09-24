package exercises.TranslatorThesaurus;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class TranslatorThesaurusController {

    @FXML
    private ComboBox<String> languageCB;

    @FXML
    private TextArea originalTA;

    @FXML
    private ListView<String> synonymLV;

    @FXML
    private TextArea translatedTA;

    @FXML
    private TextField wordTF;

    private Languages languages;
    
    @FXML
    void getSynonyms(ActionEvent event) {
    	//TODO
    	//Get the word from the GUI

    	//Use the Thesaurus class' static lookupSynonyms method to get the synonyms

    	//Add the synonyms to the GUI
    }

    @FXML
    void translate(ActionEvent event) {
    	//TODO
    	//Get text from the GUI

    	//Get selected language from the combobox

    	//Get language code from the languages object

    	//Translate the original text using Languages class' static translateTo method

    	//Put the translated text into the GUI

    }
    
    @FXML
    void save() {
    	FileChooser fc = new FileChooser();
    	Path folderPath = Paths.get("src/main/resources/exercise_solutions/");
    	fc.setInitialDirectory(folderPath.toFile());
    	File file = fc.showSaveDialog(originalTA.getScene().getWindow());
    	PrintWriter writer;
    	//TODO Save the original and translated message to a file
		
    }

    @FXML
    void initialize() {
    	languages = new Languages();
    	languages.addLanguage("English", "en");
    	languages.addLanguage("Spanish", "es");
    	languages.addLanguage("French", "fr");
    	languages.addLanguage("German", "de");
    	languages.addLanguage("Chinese", "zh");
    	languages.addLanguage("Arabic", "ar");
    	languages.addLanguage("Japanese", "ja");
    	languages.addLanguage("Russian", "ru");
    	languages.addLanguage("Italian", "it");
    	languages.addLanguage("Korean", "ko");
    	languages.addLanguage("Portuguese", "pt");
    	
    	languageCB.getItems().addAll(languages.getLanguages());
    }
    
}

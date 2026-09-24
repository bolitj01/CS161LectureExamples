package exercise_solutions.TranslatorThesaurus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import exercises.TranslatorThesaurus.Languages;
import exercises.TranslatorThesaurus.Thesaurus;
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
    	String word = wordTF.getText();
    	ArrayList<String> synonyms = Thesaurus.lookupSynonyms(word);
    	synonymLV.getItems().clear();
    	synonymLV.getItems().addAll(synonyms);
    }

    @FXML
    void translate(ActionEvent event) {
    	String text = originalTA.getText();
    	String lang = languageCB.getValue();
    	String code = languages.getLanguageCode(lang);
    	
    	String translation = Languages.translateTo(text, code);
    	translatedTA.setText(translation);
    }
    
    @FXML
    void save() {
    	FileChooser fc = new FileChooser();
    	try {
    		Path fxmlPath = Paths.get(getClass().getResource("TranslatorThesaurus.fxml").toURI());
    		fc.setInitialDirectory(fxmlPath.getParent().toFile());
    	} catch (URISyntaxException e) {
    		e.printStackTrace();
    	}
    	File file = fc.showSaveDialog(originalTA.getScene().getWindow());
    	PrintWriter writer;
		try {
			writer = new PrintWriter(file);
			writer.println("""
	    			Original message:
	    			%s
	    			Translated message:
	    			%s""".formatted(originalTA.getText(), translatedTA.getText()));
	    	writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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

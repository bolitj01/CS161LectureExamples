module main {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.net.http;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;
	requires async.http.client;
	requires org.reactivestreams;
	requires io.netty.buffer;

    opens ComboBox to javafx.fxml;
    exports ComboBox;
    
    opens ListView to javafx.fxml;
    exports ListView;
    
    opens Slider to javafx.fxml;
    exports Slider;    
    
    opens Menu_FileChooser to javafx.fxml;
    exports Menu_FileChooser;
    
    opens exercises.TranslatorThesaurus to javafx.fxml;
    exports exercises.TranslatorThesaurus;
    
    opens exercise_solutions.TranslatorThesaurus to javafx.fxml;
    exports exercise_solutions.TranslatorThesaurus;

    opens CheckBox to javafx.fxml;
    exports CheckBox;
    
    opens ImageView to javafx.fxml;
    exports ImageView;
    
    opens KilometerConverter to javafx.fxml;
    exports KilometerConverter;    
    
    opens RadioButton to javafx.fxml;
    exports RadioButton;
    
    opens ContactList to javafx.fxml;
    exports ContactList;

    opens exercises.MemoryGame to javafx.fxml;
    exports exercises.MemoryGame;

    opens exercise_solutions.MemoryGame to javafx.fxml;
    exports exercise_solutions.MemoryGame;
}

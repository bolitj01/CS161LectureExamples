module main {
    requires javafx.controls;
    requires javafx.fxml;

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
}

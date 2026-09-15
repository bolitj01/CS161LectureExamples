package KilometerConverter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class KilometerConverterController {

    @FXML
    private TextField kmT;

    @FXML
    private Label resultL;

    @FXML
    void convert(ActionEvent event) {
        //1.609 km / m
        double km = Double.parseDouble(kmT.getText());
        double miles = km / 1.609;
        String result = String.format("%.2f km is equivalent to %.2f miles", km, miles);
        resultL.setText(result);
    }

}

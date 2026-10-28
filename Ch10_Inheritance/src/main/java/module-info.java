module main {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens javafx_inheritance to javafx.fxml;
    exports javafx_inheritance;
}

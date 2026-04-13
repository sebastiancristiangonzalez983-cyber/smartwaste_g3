module org.divini.smartwaste_g3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens org.divini.smartwaste_g3 to javafx.fxml;
    opens org.divini.smartwaste_g3.controller to javafx.fxml;

    exports org.divini.smartwaste_g3;
    exports org.divini.smartwaste_g3.controller;
}

module com.example.shopvaycuoi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.shodienthoai to javafx.fxml;
    exports com.example.shodienthoai;
}
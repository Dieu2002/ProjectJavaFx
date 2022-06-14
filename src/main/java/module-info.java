module com.example.shopdienthoai {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.shopdienthoai to javafx.fxml;
    exports com.example.shopdienthoai;
}
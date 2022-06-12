package com.example.shopdienthoai;

import com.example.shopdienthoai.data.DBconnection;
import com.example.shopdienthoai.model.Phone;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Objects;
public class MainPhoneShop extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Scene scene;
    private static final String EMPTY = "";

    @Override
    public void start(Stage stage) {


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        DBconnection DB = new DBconnection();
        ArrayList<Phone> phoneList = DB.getPhone();


        grid.add(new Label("Name:"), 0, 0);
        var tfName = new TextField();
        grid.add(tfName, 0, 1);
        //
        grid.add(new Label("Image:"), 1, 0);
        var tfImage = new TextField();
        grid.add(tfImage, 1, 1);
        //
        grid.add(new Label("Price:"), 2, 0);
        var tfPrice = new TextField();
        grid.add(tfPrice, 2, 1);
        //

        grid.add(new Label("Quantity:"),3,  0);
        var tfQuantity= new TextField();
        grid.add(tfQuantity, 3, 1);
        //
        grid.add(new Label("description:"),4,  0);
        var tfdescription= new TextField();
        grid.add(tfdescription, 4, 1);
        // Thêm các sản phẩm mới
        var btnAdd = new Button("Add");
        btnAdd.setPadding(new Insets(5, 15, 5, 15));
        btnAdd.setOnAction(e -> {
            String name = tfName.getText();
            String image = tfImage.getText();
            float price = Float.valueOf(tfPrice.getText());
            Integer quantity = Integer.valueOf(tfQuantity.getText());
            String 	description = tfdescription.getText();
            if (!name.equals(EMPTY) && !image.equals(EMPTY) && !Objects.equals(price, EMPTY)
                    && !quantity.equals(EMPTY) && !description.equals(EMPTY) ){
                DB.insertPhone(new Phone(name, image, price,quantity,description));
                try {
                    start(stage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                return;
            }
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Bạn phải điền đầy đủ thông tin");
            alert.showAndWait();
        });
        grid.add(btnAdd, 6, 1);

        //Hiện thị các sản phẩm

            for(int i = 0; i < phoneList.size(); i++) {
                Image image = new Image(phoneList.get(i).getImage());
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                imageView.setFitWidth(110);
                imageView.setFitHeight(110);

                grid.add(new Label(phoneList.get(i).getName()), 0, i + 2);
                grid.add(imageView, 1, i + 2);
                grid.add(new Label(String.valueOf(phoneList.get(i).getPrice() + "VND")), 2, i + 2);
                grid.add(new Label(String.valueOf(phoneList.get(i).getQuantity())), 3, i + 2);
                grid.add(new Label(String.valueOf(phoneList.get(i).getDescription())), 4, i + 2);


                // Cập nhật lại sản phẩm
            var btnUpdate = new Button("Update");
            btnUpdate.setId(String.valueOf(i));
            btnUpdate.setOnAction(e -> {
                btnAdd.setVisible(false);
                int id1 = Integer.parseInt(btnUpdate.getId());
                TextField tfname = (TextField) grid.getChildren().get(1);
                tfname.setText("" + phoneList.get(id1).getName());

                TextField tfimage = (TextField) grid.getChildren().get(3);
                tfimage.setText("" + phoneList.get(id1).getImage());

                TextField tfprice = (TextField) grid.getChildren().get(5);
                tfprice.setText("" + phoneList.get(id1).getPrice());

                TextField tfquantity = (TextField) grid.getChildren().get(7);
                tfquantity.setText("" + phoneList.get(id1).getQuantity());

                TextField tfde = (TextField) grid.getChildren().get(9);
                tfdescription.setText("" + phoneList.get(id1).getDescription());

                var newbtnAdd = new Button("Update");
                newbtnAdd.setPadding(new Insets(5, 15, 5, 15));
                newbtnAdd.setOnAction(newe -> {
                    Integer id = phoneList.get(id1).id;
                    String name = tfname.getText();
                    String img = tfimage.getText();
                    float price = Float.valueOf(tfprice.getText());
                    int quantity = Integer.valueOf(tfQuantity.getText());
                    String 	description = tfdescription.getText();
                    if (!name.equals(EMPTY) && !image.equals(EMPTY) && !Objects.equals(price, EMPTY)
                            && !Objects.equals(quantity, EMPTY) && !Objects.equals(description, EMPTY)) {
                        DB.updatePhone(new Phone(id, name, img, price, quantity,description));
                        try {
                            start(stage);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        return;
                    }
                    var alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Bạn phải điền đầy đủ thông tin");
                    alert.showAndWait();
                });
                grid.add(newbtnAdd, 5, 1);
            });
            grid.add(btnUpdate, 5, i+2);

            // Xóa sản phẩm
            var btnDelete = new Button("Delete");
            btnDelete.setId(String.valueOf(phoneList.get(i).id));
            btnDelete.setOnAction(e -> {
                int id3 = Integer.parseInt(btnDelete.getId());
                DB.deletePhone(id3);
                var alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Deleted!");
                alert.showAndWait();
                try {
                    start(stage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
            grid.add(btnDelete, 6, i+2);
        }

        scene = new Scene(grid, 900, 400);
        stage.setTitle("Phone Shop");
        stage.setScene(scene);
        stage.show();
    }
}
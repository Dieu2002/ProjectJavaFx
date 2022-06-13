package com.example.shopdienthoai;

import java.util.ArrayList;
import java.util.Optional;

import com.example.shopdienthoai.data.DBconnection;
import com.example.shopdienthoai.model.Phone;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class HelloApplication extends Application {


    Button button;
    public static void main(String[] args) {
        launch(args);
    }
    private Scene scene;
    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        DBconnection DB = new DBconnection();

        stage.setTitle("Alert");
        button = new Button();
        button.setText("Wellcome to Phone Shop");
        button.setOnAction(e->{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Bạn có muốn ghé vào shop của chúng tôi không?");
            alert.setContentText("Choose your option");

            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
            ButtonType buttonTypeCancel = new ButtonType( "Cancel", ButtonBar. ButtonData. CANCEL_CLOSE);
            alert.getButtonTypes (). setAll(buttonTypeYes, buttonTypeNo, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeYes)
                getDisplayProducts(grid,DB, stage);
            else if (result.get().getButtonData() == ButtonBar.ButtonData.NO)
                System.out.println("No");
            else
                System.out.println("Cancel");
        });
        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();

    }


//Hiện thị các sản phẩm

    private void getDisplayProducts(GridPane grid, DBconnection DB, Stage stage) {

        grid.add(new Label("Name"), 1, 0);

        //
        grid.add(new Label("Image"), 3, 0);

        //
        grid.add(new Label("Price"), 5, 0);

        //
        grid.add(new Label("Quantity"),7,  0);
        //
        grid.add(new Label("description"),9,  0);


        ArrayList<Phone> productsList = DB.getPhone();

        for(int i = 0; i < productsList.size(); i++) {

            Image image = new Image(productsList.get(i).getImage());
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(110);
            imageView.setFitHeight(110);

            grid.add(new Label(productsList.get(i).getName()), 1, i + 2);
            grid.add(imageView, 3, i + 2);
            grid.add(new Label(String.valueOf(productsList.get(i).getPrice() + "VND")), 5, i + 2);
            grid.add(new Label(String.valueOf(productsList.get(i).getQuantity())), 7, i + 2);
            grid.add(new Label(String.valueOf(productsList.get(i).getDescription())), 9, i + 2);




    };

    scene = new Scene(grid, 900, 600);
        stage.setTitle("Shop điện thoại");
        stage.setScene(scene);
        stage.show();
}}
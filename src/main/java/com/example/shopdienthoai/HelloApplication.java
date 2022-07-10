//package com.example.shopdienthoai;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Optional;
//
//import com.example.shopdienthoai.data.DBconnection;
//import com.example.shopdienthoai.data.admin;
//import com.example.shopdienthoai.model.Phone;
////import com.sun.javafx.charts.Legend;
//import javafx.application.Application;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
///**
// *
// * @author admin
// */
//public class HelloApplication extends Application {
//    TextField name, pass;
//    public Scene screenLogin,hopages;
//
//
//
//    Button button;
//
//
//
//    @Override
//    public void start(Stage stage)  {
//
//        DBconnection DB = new DBconnection();
//    // LOGIN
//
//        VBox loginPage = new VBox();
//        this.showLogin(loginPage, DB,stage);
//        screenLogin = new Scene(loginPage, 400, 400);
//
////homepage
//        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        grid.setVgap(10);
//        grid.setHgap(10);
//        VBox vBoxhompage = new VBox();
//
////        homepage
//        vBoxhompage.setPadding(new Insets(150));
//        this.getDisplayProducts(grid,DB);
//        vBoxhompage.getChildren().add(grid);
//
//        // WELCOME PHONE SHOP
//        hopages = new Scene(vBoxhompage, 1000, 1000);
//
//
//
//        stage.setScene(screenLogin);
//        stage.show();
//
//    }
//
//    void  showLogin(VBox loginPage , DBconnection db,Stage stage){
//        Label labelLogin =new Label("LOGIN");
//        Label Aname = new Label("Name: ");
//        Label Apassword = new Label("Password: ");
//        name = new TextField();
//        pass= new TextField();
//        HBox fieldName = new HBox();
//        fieldName.getChildren().addAll(Aname,name);
//        fieldName.setSpacing(10);
//        fieldName.setAlignment(Pos.BASELINE_CENTER);
//        HBox fieldPass = new HBox();
//        fieldPass.getChildren().addAll(Apassword,pass);
//        fieldPass.setSpacing(10);
//        fieldPass.setAlignment(Pos.BASELINE_CENTER);
//        Button btnGoBack = new Button("Cancel");
//        btnGoBack.setOnAction(actionEvent -> {
//            stage.setScene(screenLogin);
//        });
//        Button btnLogin = new Button("LOGIN");
//        btnLogin.setOnAction(actionEvent -> {
//            this.checkLogin(db,stage);
//        });
//        HBox btnLoginPage = new HBox();
//        btnLoginPage.getChildren().addAll(btnLogin,btnGoBack);
//        btnLoginPage.setSpacing(10);
//        btnLoginPage.setAlignment(Pos.BASELINE_CENTER);
//        loginPage.getChildren().addAll(labelLogin,fieldName,fieldPass,btnLoginPage);
//        loginPage.setSpacing(15);
//        loginPage.setAlignment(Pos.BASELINE_CENTER);
//    }
//    void checkLogin(DBconnection db,Stage stage){
//        ArrayList<admin> ad = new ArrayList<admin>();
//        ad = (ArrayList<admin>) db.getAdmin();
//        String inputName = name.getText();
//        String inputPass = pass.getText();
//        if(inputName.equals(ad.get(0).name)&& inputPass.equals(ad.get(0).password)){
//            LoginSuccess();
//            System.out.println("success!");
//
//            stage.setScene(hopages);
//            //stage.show();
//
//        }else{
//            LoginError();
//        }
//    }
//
//     void LoginError() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("ERROR");
//        alert.setContentText("Login fail!");
//        alert.show();
//    }
//     void LoginSuccess() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Login");
//        alert.setHeaderText("Hi "+name.getText());
//        alert.setContentText("Login successfully!");
//        alert.show();
//    }
//
//     void getDisplayProducts(GridPane grid, DBconnection DB) {
//
//        grid.add(new Label("Name"), 1, 0);
//
//        //
//        grid.add(new Label("Image"), 3, 0);
//
//        //
//        grid.add(new Label("Price"), 5, 0);
//
//        //
//        grid.add(new Label("Quantity"),7,  0);
//        //
//        grid.add(new Label("description"),9,  0);
//
//
//        ArrayList<Phone> productsList = DB.getPhone();
//
//        for(int i = 0; i < productsList.size(); i++) {
//
//            Image image = new Image(productsList.get(i).getImage());
//            ImageView imageView = new ImageView();
//            imageView.setImage(image);
//            imageView.setFitWidth(110);
//            imageView.setFitHeight(110);
//
//            grid.add(new Label(productsList.get(i).getName()), 1, i + 2);
//            grid.add(imageView, 3, i + 2);
//            grid.add(new Label(String.valueOf(productsList.get(i).getPrice() + "VND")), 5, i + 2);
//            grid.add(new Label(String.valueOf(productsList.get(i).getQuantity())), 7, i + 2);
//            grid.add(new Label(String.valueOf(productsList.get(i).getDescription())), 9, i + 2);
//
//    };
//
//
//}
//    public static void main(String[] args) {
//        launch(args);
//    }}
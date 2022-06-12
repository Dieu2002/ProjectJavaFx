package com.example.shopdienthoai.data;

import com.example.shopdienthoai.model.Phone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBconnection {
    public Connection con;

    public DBconnection() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost/shop", "root", "");
            System.out.println("Successful");
        } catch (SQLException var2) {
            System.out.println(var2.getMessage());
        }
    }
    public ArrayList<Phone> getPhone() {
        ArrayList<Phone> list = new ArrayList();
        String sql = "SELECT * FROM phoneshop";

        try {
            ResultSet result = this.con.prepareStatement(sql).executeQuery();

            while(result.next()) {
                System.out.println("id: " + result.getInt("id"));
                System.out.println("phonename: " + result.getString("phonename"));
                System.out.println("img: " + result.getString("img"));
                System.out.println("phoneprice: " + result.getFloat("phoneprice"));
                System.out.println("quantity: " + result.getInt("quantity"));
                System.out.println("description: " + result.getString("description"));

                Phone phones = new Phone(result.getInt("id"),
                        result.getString("phonename"),
                        result.getString("img"),
                        result.getFloat("phoneprice"),
                        result.getInt("quantity"),
                        result.getString("description"));
                list.add(phones);
            }

            return list;
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }
    public void insertPhone(Phone phones){
        String sql = "INSERT INTO phoneshop (phonename, img,phoneprice, quantity,description) " +
                "VALUE ('"+phones.phonename+"','"+phones.img+"',"+phones.phoneprice+",'"+phones.quantity
                +"','"+ phones.description +"')";
        System.out.println(sql);
        try {
            con.prepareStatement(sql).executeUpdate();
            System.out.println("insert");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePhone(Phone phones) {
        String sql = "UPDATE phoneshop SET phonename ='" + phones.phonename + "', img ='"
                + phones.img + "',phoneprice="
                + phones.phoneprice +
                "', quantity=" +phones.quantity +
                ",description=" + phones.description +"  WHERE id = " + phones.id;
        System.out.println(sql);

        try {
            this.con.prepareStatement(sql).executeUpdate();
            System.out.println("Update successfully");
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }
    public void deletePhone(int id) {
        String sql = "DELETE FROM phoneshop WHERE id = " + id;
        System.out.println(sql);

        try {
            this.con.prepareStatement(sql).executeUpdate();
            System.out.println("DELETE successfully");
        } catch (SQLException var4) {
            throw new RuntimeException(var4);
        }
    }
}
package com.example.shodienthoai.model;

public class Phone {
    public int id;
    public String phonename;
    public String img;
    public float phoneprice;
    public int quantity;
    public String description;
    public Phone(int id, String phonename, String img, float phoneprice, int quantity, String description) {
        this.id = id;
        this.phonename = phonename;
        this.img = img;
        this.phoneprice = phoneprice;
        this.quantity = quantity;
        this.description = description;
    }
    public Phone(String phonename, String img, float phoneprice, int quantity, String description) {
        this.phonename = phonename;
        this.img = img;
        this.phoneprice = phoneprice;
        this.quantity = quantity;
        this.description = 	description;
    }

    public Phone(Integer id, String phonename, String img, float phoneprice, int quantity, String description) {
        this.id=id;
        this.phonename = phonename;
        this.img = img;
        this.phoneprice = phoneprice;
        this.quantity = quantity;
        this.description = description;
    }

    public Phone(String phonename, String img, float phoneprice, Integer quantity, String description) {
        this.phonename = phonename;
        this.img = img;
        this.phoneprice = phoneprice;
        this.quantity = quantity;
        this.description = 	description;
    }







    public int getId() {
        return id;
    }

    public void setId(int name) {
        this.id = id;
    }

    public String getName() {
        return phonename;
    }

    public void setName(String name) {
        this.phonename = phonename;
    }

    public String getImage() {
        return img;
    }

    public void setImage(String img) {
        this.img = img;
    }
    public float getPrice() {
        return phoneprice;
    }

    public void setPrice(float phoneprice) {
        this.phoneprice = phoneprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return 	description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

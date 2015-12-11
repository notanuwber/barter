package jsphdev.cmu.barter2.entities;

import java.io.Serializable;

/**
 * Created by Nan on 11/13/2015.
 */
public class Item implements Serializable {

    public Integer getId() {
        return id;
    }

    public Item setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Item setCategory(String category) {
        this.category = category;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Item setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public String getSeller() {
        return seller;
    }

    public Item setSeller(String seller) {
        this.seller = seller;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String details) {
        this.description = details;
        return this;
    }

    public byte[] getImage() {
        return image;
    }

    public Item setImage(byte[] image) {
        this.image = image;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Item setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    private Integer id;
    private String description;
    private byte[] image;
    private String category;
    private Integer price;
    private String seller;
    private String phone;
}

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

    public String getTitle() { return title; }

    public Item setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getCategaryId() {
        return categaryId;
    }

    public Item setCategaryId(Integer categaryId) {
        this.categaryId = categaryId;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Item setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public Item setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public Item setDetails(String details) {
        this.details = details;
        return this;
    }

    public byte[] getImage_1() {
        return image_1;
    }

    public void setImage_1(byte[] image_1) {
        this.image_1 = image_1;
    }

    public byte[] getImage_2() {
        return image_2;
    }

    public void setImage_2(byte[] image_2) {
        this.image_2 = image_2;
    }

    private Integer id;
    private String title;
    private Integer categaryId;
    private Integer price;
    private Integer sellerId;
    private String details;
    private byte[] image_1;
    private byte[] image_2;
}

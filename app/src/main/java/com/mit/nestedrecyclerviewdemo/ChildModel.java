package com.mit.nestedrecyclerviewdemo;

public class ChildModel {


    private String id;
    private String image;
    private String title;
    private String description;
    private String price;
    private String validtill;
    private String url;

    public ChildModel(String id, String image, String title, String description, String price, String validtill, String url) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.price = price;
        this.validtill = validtill;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getValidtill() {
        return validtill;
    }

    public void setValidtill(String validtill) {
        this.validtill = validtill;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

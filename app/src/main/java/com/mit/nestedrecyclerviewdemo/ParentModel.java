package com.mit.nestedrecyclerviewdemo;

import java.util.List;

public class ParentModel {



    private String categoryid;
    private String category;
    private String layout;
    private String type;
    private List<ChildModel> ChildItemList;

    public ParentModel(String categoryid, String category, String layout, String type, List<ChildModel> childItemList) {
        this.categoryid = categoryid;
        this.category = category;
        this.layout = layout;
        this.type = type;
        ChildItemList = childItemList;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ChildModel> getChildItemList() {
        return ChildItemList;
    }

    public void setChildItemList(List<ChildModel> childItemList) {
        ChildItemList = childItemList;
    }
}

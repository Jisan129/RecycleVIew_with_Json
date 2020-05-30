package com.example.recycleview_with_json;

public class ExampleItem {

    private String  mimageId;
    private String mimageName;
    private int mlikes;


    public ExampleItem(String mimageId, String mimageName, int mlikes) {
        this.mimageId = mimageId;
        this.mimageName = mimageName;
        this.mlikes = mlikes;
    }

    public String getMimageId() {
        return mimageId;
    }

    public String getMimageName() {
        return mimageName;
    }

    public int getMlikes() {
        return mlikes;
    }
}

package com.cita.wallet.app.models;

/**
 * Created by admin on 5/27/14.
 */
public class MainMenuItem {

    private int imgResource;
    private String title;

    public MainMenuItem() {
    }

    public MainMenuItem(int imgResource, String title) {
        this.imgResource = imgResource;
        this.title = title;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

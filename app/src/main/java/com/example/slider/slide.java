package com.example.slider;

public class slide {
    private int Image;
    private String Title;

    public slide(int Image, String Title){
        this.Image=Image;
        this.Title=Title;
    }

    public int getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setTitle(String title) {
        Title = title;
    }
}

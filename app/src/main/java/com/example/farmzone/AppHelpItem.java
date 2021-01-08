package com.example.farmzone;

public class AppHelpItem {

    String TItle,Content,Date;
    int farmPhoto;


    public AppHelpItem(String TItle, String content, String date, int farmPhoto) {
        this.TItle = TItle;
        Content = content;
        Date = date;
        this.farmPhoto = farmPhoto;
    }

    public String getTItle() {
        return TItle;
    }

    public void setTItle(String TItle) {
        this.TItle = TItle;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getFarmPhoto() {
        return farmPhoto;
    }

    public void setUserPhoto(int farmPhoto) {
        this.farmPhoto = farmPhoto;
    }

    public AppHelpItem(){

    }
}

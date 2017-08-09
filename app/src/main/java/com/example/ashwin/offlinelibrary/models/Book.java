package com.example.ashwin.offlinelibrary.models;

/**
 * Created by ashwin on 9/8/17.
 */

public class Book {

    public Book() { }

    public Book(String title, String filename) {
        this.title = title;
        this.filename = filename;
    }

    private String title = "", filename = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}

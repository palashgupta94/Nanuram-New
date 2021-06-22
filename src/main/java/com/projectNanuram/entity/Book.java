package com.projectNanuram.entity;



public class Book {

    private String title;
    private String author;
    private boolean bool;


    public Book() {
    }

    public Book(String title, String author, boolean bool) {
        this.title = title;
        this.author = author;
        this.bool = bool;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}

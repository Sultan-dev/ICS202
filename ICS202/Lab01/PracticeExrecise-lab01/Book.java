package com.company;

public class Book {
    private String title;
    private int pages;

    public Book(){

    }

    public Book(String title, int pages){
        this.title= title;
        this.pages= pages;
    }

    public String getTitle(){
        return title;
    }

    public int getPages(){
        return pages;
    }

    @Override
    public String toString(){
        return "Title: "+getTitle()+", Number of pages: "+getPages();
    }
}

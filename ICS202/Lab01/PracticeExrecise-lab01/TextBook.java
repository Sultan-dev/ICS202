package com.company;

public class TextBook extends Book {

    private String course;

    public TextBook(){
        super();
    }

    public TextBook(String title, int pages, String course){
        super(title, pages);
        this.course= course;
    }

    @Override
    public String getTitle(){
        return "Title: "+super.getTitle()+", Course: "+course;
    }

    public String getCourse(){
        return course;
    }
}

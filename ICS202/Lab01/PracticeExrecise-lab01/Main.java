package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb= new Scanner(System.in);
        String title, course; int pages, numPagesOfBooks= 0, numPagesOfTextBooks= 0;
        Book[] books= new Book[10];

        for(int i= 0; i < books.length; i++){
            if ((new Random().nextInt(2) + 1) == 1){
                System.out.println("Please enter the title of the book and its pages: ");
                title= kb.next();
                pages= kb.nextInt();
                books[i]= new Book(title, pages);
                numPagesOfBooks+= pages;
            }else{
                System.out.println("Please enter the title of the book and its pages and the course name: ");
                title= kb.next();
                pages= kb.nextInt();
                course= kb.next();
                books[i]= new TextBook(title, pages, course);
                numPagesOfTextBooks+= pages;
            }
        }

        for(int i= 0; i < books.length; i++){
            System.out.println(books[i].toString());
        }

        System.out.println("The number of pages of the books: "+numPagesOfBooks+"\nThe number of pages of textbooks: "+numPagesOfTextBooks);

    }
}

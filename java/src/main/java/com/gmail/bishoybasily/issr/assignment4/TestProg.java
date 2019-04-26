package com.gmail.bishoybasily.issr.assignment4;

public class TestProg {


    public static void main(String[] args) {

        Author author = new Author("author name", "author@domain", 'm');
        Book book = new Book("book name", author, 100.0);

        System.out.println(author.toString());
        System.out.println(book.toString());

    }

}

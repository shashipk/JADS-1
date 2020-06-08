package com.example.jadsjdbc.demojadsjdbc;

public class Book {

    private int id;
    private String book_name;
    private String author_name;
    private int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Book(int id, String book_name, String author_name, int cost) {
        this.id = id;
        this.book_name = book_name;
        this.author_name = author_name;
        this.cost = cost;
    }
}

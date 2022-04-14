/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.entity;

/**
 *
 * @author namng
 */
public class Book {
    String bookCode;
    String title;
    int price;
    String publisher;

    public Book() {
    }

    public Book(String bookCode, String title, int price, String publisher) {
        this.bookCode = bookCode;
        this.title = title;
        this.price = price;
        this.publisher = publisher;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
}

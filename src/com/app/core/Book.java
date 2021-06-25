package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;
import Exception.CustomExceptionHandler;
public class Book {
    public static SimpleDateFormat sdf;
    static{
        sdf = new SimpleDateFormat("dd-MM-yyyy");
    }
    private String title;
    Categories categories;
    double price;
    Date publishedDate;
    String authorName;
    int quantity;
    int fixedQuantity;

    public Book(String title, Categories categories, double price, Date publishedDate, String authorName, int quantity) {
        this.title = title;
        this.categories = categories;
        this.price = price;
        this.publishedDate = publishedDate;
        this.authorName = authorName;
        this.fixedQuantity = quantity;
        this.quantity=fixedQuantity;
    }

    public void issueBook()throws CustomExceptionHandler {
        if(this.quantity==0){
            throw new CustomExceptionHandler("Book not available");
        }
        else{
            this.quantity -=1;
        }
    }
    public void returnBook()throws CustomExceptionHandler {
        if(this.fixedQuantity<quantity+1){
            throw new CustomExceptionHandler("Book is full");
        }
        else{
            this.quantity +=1;
        }
    }




    @Override
    public String toString() {
        return "com.app.core.Book{" +
                "title='" + title + '\'' +
                ", categories=" + categories +
                ", price=" + price +
                ", publishedDate=" + sdf.format(publishedDate) +
                ", authorName='" + authorName + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getTitle() {
        return title;
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof Book){

            return this.title.equals(((Book) o).getTitle());
        }
        return false;
    }
    @Override
    public int hashCode() {
        return title.hashCode();
    }

}

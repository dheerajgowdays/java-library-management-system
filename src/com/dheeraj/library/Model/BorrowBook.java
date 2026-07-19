package com.dheeraj.library.Model;

import java.time.LocalDate;

public record BorrowBook(long recordId, String memberName, Book book, LocalDate borrowDate, LocalDate dueDate
                         ) {

    public LocalDate getDueDate() {
        return dueDate;
    }
    public LocalDate getBorrowDate(){
        return borrowDate;
    }

    public Book getBook() {
        return book;
    }
}

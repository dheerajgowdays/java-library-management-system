package com.dheeraj.library.Model;

import java.time.LocalDate;
public class BorrowBook extends Book {
    private long memberId;
    private LocalDate borrowDate;

    public BorrowBook(long bookId, String bookName, String authorName, LocalDate publishedDate, String bookType, boolean isAvailable, long memberId, LocalDate borrowDate) {
        super(bookId, bookName, authorName, publishedDate, bookType, isAvailable);
        this.memberId = memberId;
        this.borrowDate = borrowDate;
    }

    public void setborrowDate(LocalDate borrowDate){
        this.borrowDate = borrowDate;
    }
    public LocalDate getborrowDate(){
        return borrowDate;  
    }
    
    
}

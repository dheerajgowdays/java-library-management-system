package com.dheeraj.library.Model;

import java.time.LocalDate;

public record BorrowBook(long recordId, long memberId, Book book, LocalDate borrowDate, LocalDate dueDate,
                         LocalDate returnedDate) {


}

package com.dheeraj.library.Model;

import java.time.LocalDate;

public class Book {
        private final long BookId;
        private String BookName;
        private String AuthorName;
        private LocalDate PublishedDate;
        private String BookType;
        private boolean isAvailable;

        public Book(long bookId, String bookName, String authorName, LocalDate publishedDate, String bookType, boolean isAvailable) {
            this.BookId = bookId;
            this.BookName = bookName;
            this.AuthorName = authorName;
            this.PublishedDate = publishedDate;
            this.BookType = bookType;
            this.isAvailable = isAvailable;
        }

        public long getBookId() {
            return BookId;
        }
        public void setBookName(String bookName){
                this.BookName = bookName;
        }
        public String getBookName(){
                return BookName;
        }
        public void setAuthorName(String authorName){
                this.AuthorName = authorName;
        }
        public String getAuthorName(){
                return AuthorName;
        }
        public void setPublishedDate(LocalDate publishedDate){
                this.PublishedDate = publishedDate;
        }
        public LocalDate getPublishedDate(){
                return PublishedDate;
        }
        public void setBookType(String bookType){
                this.BookType = bookType;
        }
        public String getBookType(){
                return BookType;
        }
        public void setAvailable(boolean isAvailable){
                this.isAvailable = isAvailable;
        }
        public boolean isAvailable(){
                return isAvailable;
        }

}

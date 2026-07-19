package com.dheeraj.library.Model;

public class Book {
        private final long BookId;
        private final String BookName;
        private final String AuthorName;
        private final String PublishedYear;
        private final String BookType;
        private boolean isAvailable;

        public Book(long bookId, String bookName, String authorName, String publishedYear, String bookType, boolean isAvailable) {
            this.BookId = bookId;
            this.BookName = bookName;
            this.AuthorName = authorName;
            this.PublishedYear = publishedYear;
            this.BookType = bookType;
            this.isAvailable = isAvailable;
        }

        public long getBookId() {
            return BookId;
        }
        public String getBookName(){
                return BookName;
        }
        public String getAuthorName(){
                return AuthorName;
        }
        public String getPublishedYear(){
                return PublishedYear;
        }
        public String getBookType(){
                return BookType;
        }
        public void setAvailable(boolean isAvailable){
                this.isAvailable = isAvailable;
        }
        public String isAvailable(){
                if(isAvailable){
                        return "Yes";
                }else {
                        return "No";
                }
        }

}

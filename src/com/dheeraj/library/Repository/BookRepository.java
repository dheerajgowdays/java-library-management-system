package com.dheeraj.library.Repository;
import com.dheeraj.library.Model.Book;
import java.util.HashMap;
public class BookRepository {
    public static HashMap<Long,Book> books = new HashMap<>();
    public static void getBook(Book m){
        System.out.println("---------------------------------------------");
        System.out.println("Book Id: "+m.getBookId());
        System.out.println("Book Name: "+m.getBookName());
        System.out.println("Author Name: "+m.getAuthorName());
        System.out.println("Published Year: "+m.getPublishedYear());
        System.out.println("Book Type: "+m.getBookType());
        System.out.println("Available: "+m.isAvailable());
    }

    public void addBook(Long id, Book book){
        books.put(id,book);
        System.out.println("\nBook Added Successfully with ID: " + id);
    }
    
    public void getBookByName(String name){
        if(books.isEmpty()){
            System.out.println("The Book Shelf is Empty");
        }
        boolean found = false;
        for(Book book: books.values()){
            if(book.getBookName().equalsIgnoreCase(name)){
                getBook(book);
                found = true;
            }
        }
        if(!found){
            System.out.println("No Book Found of BookName: "+name);
        }
    }
    
    public void getBookByAuthor(String author){
        if(books.isEmpty()){
            System.out.println("The Book Shelf is Empty");
        }
        boolean found = false;
        for(Book book : books.values()){
            if(book.getAuthorName().equalsIgnoreCase(author)){
                getBook(book);
                found = true;
            }
        }
        if(!found){
            System.out.println("No Book Found of AuthorName: "+author);
        }
    }
    
    public void getBookByType(String type){
        if(books.isEmpty()){
            System.out.println("The Book Shelf is Empty");
        }
        boolean found  = false;
        for(Book book : books.values()){
            if(book.getBookType().equalsIgnoreCase(type)){
                getBook(book);
                found = true;
            }
        }
        if(!found){
            System.out.println("No Book Found of Type: "+type);
        }
    }

    public void getAllBooks(){
        if(books.isEmpty()){
            System.out.println("The Book Shelf is Empty");
        }
        for(Book book : books.values()){
            getBook(book);
        }
    }

    public static boolean getBookById(long id){
        for(Book book : books.values()){
            if(book.getBookId() == id && book.isAvailable().equalsIgnoreCase("yes")){
                return true;
            }
        }
        return false;
    }


}
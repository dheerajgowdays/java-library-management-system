package com.dheeraj.library.Service;
import com.dheeraj.library.Model.Book;
import com.dheeraj.library.Model.BorrowBook;
import com.dheeraj.library.Model.Librarian;
import com.dheeraj.library.Model.Member;
import com.dheeraj.library.Repository.BookRepository;
import com.dheeraj.library.Repository.BorrowRecordRepository;
import com.dheeraj.library.Repository.MemberRepository;
import com.dheeraj.library.Util.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
public class service {
    BookRepository bookRepository = new BookRepository();
    MemberRepository memberRepository = new MemberRepository();
    public static   ArrayList<Librarian> librarianList = new ArrayList<>();
    public void addBook(Book book){
        bookRepository.addBook(IdGenerator.generateBookId(),book);
    }

    public void getBookById(long BookId){ BookRepository.getBookById(BookId); }
    public void getBookByName(String bookName){ bookRepository.getBookByName(bookName);}
    public void getBookByAuthor(String authorName){bookRepository.getBookByAuthor(authorName);}
    public void getBookByType(String bookType){ bookRepository.getBookByType(bookType);}
    public void getAllBooks(){bookRepository.getAllBooks();}

    public void borrowBook(long BookId, String mName){
        for(Book book : BookRepository.books.values()){
            if(book.getBookId() == BookId){
                BorrowBook borrowBook = new BorrowBook(IdGenerator.generateRecordId(),mName,book, LocalDate.now(),LocalDate.now().plusDays(20));
                BorrowRecordRepository.addBorrowRecord(MemberRepository.getId(mName),borrowBook);
                book.setAvailable(false);
            }
        }
    }
    public void returnBook(long BookId, String mName){
        BorrowRecordRepository.returnBorrowBook(MemberRepository.getId(mName),BookId);
    }

    public void addMember(Member member){memberRepository.addMember(member.getMemberId(),member);}
    public void getMember(long memberId){memberRepository.getMember(memberId);}
    public void removeMember(long memberId){
        memberRepository.removeMember(memberId);
    }
    public void getAllMembers(){
        memberRepository.getAllMembers();
    }
    public void getFine(String name){memberRepository.getMemberByName(name);}
    public void LibrarianAssign(Librarian librarian){
        librarianList.add(librarian);
        System.out.println("Librarian Assigned Successfully with ID: " + librarian.getLibrarianId());
    }

}

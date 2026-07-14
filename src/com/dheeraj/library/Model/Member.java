package com.dheeraj.library.Model;
import java.util.ArrayList;

public class Member {
    private long memberId;
    private  String memberName;
    private int numberOfBooks;
    private ArrayList<Book> borrowedBooks;

    public Member(long memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.numberOfBooks = 0;
        this.borrowedBooks = new ArrayList<>();
    }

    public long getMemberId(){
        return memberId;
    }
    public void setMemberName(String memberName){
        this.memberName = memberName;
    }
    public String getMemberName(){
        return memberName;
    }
    public void setNumberOfBooks(int numberOfBooks){
        this.numberOfBooks = numberOfBooks;
    }
    public int getNumberOfBooks(){
        return numberOfBooks;
    }
    public void setBorrowedBooks(ArrayList<Book> borrowedBooks){
        this.borrowedBooks = borrowedBooks;
    }
    public ArrayList<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

}

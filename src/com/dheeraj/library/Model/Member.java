package com.dheeraj.library.Model;
import java.util.ArrayList;

public class Member {
    private final long memberId;
    private final String memberName;
    private final long phoneNumber;
    private final String password;
    private int numberOfBooks;
    private ArrayList<BorrowBook> borrowedBooks;
    private int fine ;

    public Member(long memberId, String memberName,long phoneNumber,String password,int fine) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.numberOfBooks = 0;
        this.borrowedBooks = new ArrayList<>();
        this.fine = fine;
    }

    public long getMemberId(){
        return memberId;
    }

    public String getPassword(){ return password;}

    public String getMemberName(){
        return memberName;
    }

    public long getPhoneNumber(){return phoneNumber;}

    public void setNumberOfBooks(int numberOfBooks){
        this.numberOfBooks += numberOfBooks ;
    }
    public int getNumberOfBooks(){
        return numberOfBooks;
    }
    public void setBorrowedBooks(ArrayList<BorrowBook> borrowedBooks){
        this.borrowedBooks = borrowedBooks;
    }
    public ArrayList<BorrowBook> getBorrowedBooks(){
        return borrowedBooks;
    }

    public void setFine(int fine){this.fine = fine;}
    public int getFine(){return fine;}

}

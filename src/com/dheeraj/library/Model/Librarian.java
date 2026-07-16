package com.dheeraj.library.Model;

public class  Librarian{
    private final long librarianId;
    private String librarianName;
    private String password;

    public Librarian(Long librarianId, String librarianName, String password){
        this.librarianId = librarianId;
        this.librarianName = librarianName;
        this.password = password;
    }

    public long getLibrarianId(){
        return librarianId;
    }

    public void setLibrarianName(String librarianName){
        this.librarianName = librarianName;
    }

    public String getLibrarianName(){
        return librarianName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
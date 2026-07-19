package com.dheeraj.library.Model;

public class  Librarian{
    private final long librarianId;
    private final String password;

    public Librarian(Long librarianId, String librarianName, String password){
        this.librarianId = librarianId;
        this.password = password;
    }

    public long getLibrarianId(){
        return librarianId;
    }

    public String getPassword(){
        return password;
    }
}
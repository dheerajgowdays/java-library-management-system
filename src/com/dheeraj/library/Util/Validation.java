package com.dheeraj.library.Util;
import com.dheeraj.library.Model.Librarian;
import com.dheeraj.library.Model.Member;
import com.dheeraj.library.Repository.MemberRepository;
import com.dheeraj.library.Service.service;
public class Validation {
    public static boolean LibrarianCodeValidation(String code){
        return code.equals(IdGenerator.code);
    }
    public static boolean Check(String validate){
        return validate.equalsIgnoreCase("yes");
    }
    public static boolean LibrarianValidation(long Id,String password){
        for(Librarian lib : service.librarianList){
            return(String.valueOf(Id).equals(String.valueOf(lib.getLibrarianId())) && password.equals(lib.getPassword()));
        }
        return false;
    }
    public static boolean MemberValidation(String mName,String mPassword){
        for(Member mem : MemberRepository.members.values()){
            return( mName.equalsIgnoreCase(mem.getMemberName()) && mPassword.equalsIgnoreCase(mem.getPassword()));
        }
        return false;
    }
    public static boolean FineValidation(String mName){
        for(Member mem:MemberRepository.members.values()){
            if(mName.equalsIgnoreCase(mem.getMemberName())){
                return mem.getFine() == 0;
            }
        }
        return false;
    }

}

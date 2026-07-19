package com.dheeraj.library.Repository;
import com.dheeraj.library.Model.BorrowBook;
import com.dheeraj.library.Model.Member;
import java.util.HashMap;
public class MemberRepository {
    public static HashMap<Long,Member> members = new HashMap<>();

    public void addMember(long id,Member member){
        members.put(id,member);
        System.out.println("Member Added Successfully");
        System.out.println("Your Member ID: "+id);
    }

    public void getMember(long id){
        Member m = members.get(id);
        if(m == null){
            System.out.println("Member Not Found ");
        }else{
            System.out.println("\n------------------------------------------------------");
            System.out.println("Member Id               : "+m.getMemberId());
            System.out.println("Member Name             : "+m.getMemberName());
            System.out.println("Phone Number            : "+m.getPhoneNumber());
            System.out.println("Number of Books Borrowed: "+m.getNumberOfBooks());
            System.out.println("Borrowed Books          : ");borrowedBooks(id);
            System.out.println("------------------------------------------------------\n");
        }

    }

    public void removeMember(long id){
        if(members.containsKey(id)){
            members.remove(id);
            System.out.println("Member Removed Successfully ");
        }else{
            System.out.println("Member Not Present With This ID: "+id);
        }

    }

    public void getAllMembers(){
        for( Member m : members.values()){
            System.out.println("\n------------------------------------------------------");
            System.out.println("Member Id               : "+m.getMemberId());
            System.out.println("Member Name             : "+m.getMemberName());
            System.out.println("Phone Number            : "+m.getPhoneNumber());
            System.out.println("Number of Books Borrowed: "+m.getNumberOfBooks());
            System.out.println("Borrowed Books          : ");borrowedBooks(m.getMemberId());
            System.out.println("------------------------------------------------------\n");
        }
    }

    public static long getId(String name){
        for(Member m : members.values()){
            if(m.getMemberName().equalsIgnoreCase(name)){
                return m.getMemberId();
            }
        }
        return -1;
    }

    public static Member getMemberById(long memberId) {
        return members.get(memberId);
    }

    public void borrowedBooks(long id) {

        Member member = members.get(id);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (member.getBorrowedBooks().isEmpty()) {
            System.out.println("No books borrowed.");
            return;
        }
        for (BorrowBook record : member.getBorrowedBooks()) {
            System.out.println("                           --------------------------------");
            System.out.println("                           Book Name      : " + record.getBook().getBookName());
            System.out.println("                           Borrow Date    : " + record.getBorrowDate());
            System.out.println("                           Due Date       : " + record.getDueDate());
        }
    }

    public static boolean bookPresent(String name,long bookId){
        long id = getMemberId(name);
        Member member = members.get(id);

        for (BorrowBook record : member.getBorrowedBooks()){
            if(record.getBook().getBookId() == bookId){
                return true;
            }
        }
        return false;
    }
    public void getMemberByName(String name){
        for(Member m : members.values()){
            if(m.getMemberName().equalsIgnoreCase(name)){
                System.out.println("Fine: "+m.getFine());
            }
        }
    }
    public static long getMemberId(String name){
        long id =0;
        for(Member m : members.values()){
            if(m.getMemberName().equalsIgnoreCase(name)){
                id = m.getMemberId();
            }
        }
        return id;
    }

}

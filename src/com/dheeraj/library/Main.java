package com.dheeraj.library;

import com.dheeraj.library.Model.Book;
import com.dheeraj.library.Model.BorrowBook;
import com.dheeraj.library.Model.Librarian;
import com.dheeraj.library.Model.Member;
import com.dheeraj.library.Repository.BookRepository;
import com.dheeraj.library.Repository.BorrowRecordRepository;
import com.dheeraj.library.Repository.MemberRepository;
import com.dheeraj.library.Service.service;
import com.dheeraj.library.Util.IdGenerator;
import com.dheeraj.library.Util.Validation;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        service service = new service();
        while(true){
            System.out.println("\n============= Library System ================");
            System.out.println("1. Add Book (Librarian Only)");
            System.out.println("2. Borrow Book ");
            System.out.println("3. Return Book");
            System.out.println("4. Search ");
            System.out.println("5. Fine Calculation ");
            System.out.println("6. Member Management (Librarian Only) ");
            System.out.println("7. Assign Librarian (Library Management)");
            System.out.println("8. Exit ");
            System.out.print("\n Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    //Add Book
                    System.out.println("\n================== ADD BOOK ===================");
                    System.out.print("Are you a Librarian ? (YES/NO): ");
                    String validate = sc.nextLine();

                    if (Validation.Check(validate)) {
                        System.out.print("Enter Librarian ID: ");
                        long librarianId = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Enter Librarian Password: ");
                        String librarianPassword = sc.nextLine();

                        if (Validation.LibrarianValidation(librarianId, librarianPassword)) {
                            System.out.print("How many books would you like to add?: ");
                            int many = sc.nextInt();
                            while (many > 0) {
                                System.out.println("\n---------- Adding "+many+ " Book --------------");
                                System.out.print("Enter the BookId: ");
                                long bookId = sc.nextLong();
                                sc.nextLine();

                                System.out.print("Enter the Book Name: ");
                                String bookName = sc.nextLine();

                                System.out.print("Enter the Author Name: ");
                                String authorName = sc.nextLine();

                                System.out.print("Enter the Published Year: ");
                                String publishedYear = sc.nextLine();

                                System.out.print("Enter the Book Type: ");
                                String bookType = sc.nextLine();

                                Book book = new Book(bookId, bookName, authorName, publishedYear, bookType, false);
                                service.addBook(book);

                                System.out.println("Book successfully added to the library!");
                                System.out.println("\n----------------------------------------------------");
                                many--;
                            }
                        } else {
                            System.out.println("Invalid ID or Password. Access Denied.");
                        }
                    } else {
                        System.out.println("Only Librarian Can Add Books");
                        break;
                    }
                    break;
                case 2:
                    //Borrow Book
                    System.out.println("----------------- Borrow Book ---------------------");
                    System.out.println("Are You a Member ? (YES/NO)");
                    String mValidate = sc.nextLine();
                    if(Validation.Check(mValidate)){
                        System.out.println("Enter Member Name: ");
                        String mName = sc.nextLine();
                        System.out.println("Enter Password: ");
                        String mPassword = sc.nextLine();
                        if(Validation.MemberValidation(mName,mPassword)){
                            if(Validation.FineValidation(mName)){
                                System.out.println("Enter the book Id: ");
                                long bBookId = sc.nextLong();
                                service.borrowBoook(bBookId,mName);
                            }else{
                                System.out.println("Clear the fine to Borrow Book");
                            }
                        }else {
                            System.out.println("Invalid ID or Password. Access Denied.");
                        }
                    }else {
                        System.out.println("Only Members can Borrow Books");
                    }
                    break;
                case 3:
                    //Return Book
                    break;
                case 4:
                    //Search
                    label:
                    while (true) {
                        System.out.println("\n================ Search Books ========================\n");
                        System.out.println("1. Search By Book ID: ");
                        System.out.println("2. Search By Book Name: ");
                        System.out.println("3. Search By Author Name: ");
                        System.out.println("4. Search By Book Type: ");
                        System.out.println("5. All BOOKs ");
                        System.out.println("6. Exit");
                        System.out.println("Enter Your Choice: ");
                        int sChoice = sc.nextInt();
                        sc.nextLine();

                        switch (sChoice) {
                            case 1:
                                System.out.print("Enter Book ID: ");
                                long sBookId = sc.nextLong();
                                sc.nextLine();
                                service.getBookById(sBookId);
                                break;
                            case 2:
                                System.out.print("Enter Book Name: ");
                                String sBookName = sc.nextLine();
                                service.getBookByName(sBookName);
                                break;
                            case 3:
                                System.out.print("Enter Author Name: ");
                                String sAuthorName = sc.nextLine();
                                service.getBookByAuthor(sAuthorName);
                                break;
                            case 4:
                                System.out.print("Enter Book Type: ");
                                String sBookType = sc.nextLine();
                                service.getBookByType(sBookType);
                                break;
                            case 5:
                                service.getAllBooks();
                                break;
                            default:
                                break label;
                        }
                    }
                    break;
                case 5:
                    //Fine Calculation
                    break;
                case 6:
                    //Member Management only for librarian
                    System.out.println("\n================== Member Management ================\n");
                    System.out.print("Are you a Librarian ? (YES/NO): ");
                    String lValidate = sc.nextLine();

                    if (Validation.Check(lValidate)) {
                        System.out.print("Enter Librarian ID: ");
                        long mLibrarianId = sc.nextLong();
                        sc.nextLine();
                        System.out.print("Enter Librarian Password: ");
                        String mLibrarianPassword = sc.nextLine();

                        if (Validation.LibrarianValidation(mLibrarianId, mLibrarianPassword)) {
                            label:
                            while (true) {
                                System.out.println("\n=================== Members ============================\n");
                                System.out.println("1. Register Member ");
                                System.out.println("2. Search Individual Member ");
                                System.out.println("3. Remove Member ");
                                System.out.println("4. View All Members ");
                                System.out.println("5. Exit ");
                                System.out.println("Enter Your Choice: ");
                                int libChoice = sc.nextInt();
                                sc.nextLine();
                                switch (libChoice) {
                                    case 1:
                                        System.out.print("Enter Member Name: ");
                                        String memberName = sc.nextLine();
                                        System.out.print("Enter Phone Number: ");
                                        long memberPNumber = sc.nextLong();
                                        sc.nextLine();
                                        System.out.println("Enter a Password: ");
                                        String memberPassword = sc.nextLine();
                                        Member member = new Member(IdGenerator.generateMemberId(), memberName, memberPNumber,memberPassword,0);
                                        service.addMember(member);
                                        break;
                                    case 2:
                                        System.out.print("Enter the MemberId: ");
                                        long sMemberId = sc.nextLong();
                                        service.getMember(sMemberId);
                                        break;
                                    case 3:
                                        System.out.print("Enter the Member Id: ");
                                        long rMemberId = sc.nextLong();
                                        service.removeMember(rMemberId);
                                        break;
                                    case 4:
                                        service.getAllMembers();
                                        break;
                                    default:
                                        break label;
                                }
                            }
                        } else {
                            System.out.println("Invalid ID or Password. Access Denied.");
                        }
                    } else {
                        System.out.println("Only Librarian can Manage Members");
                        break;
                    }
                    break;
                case 7:
                    //Librarian Creation
                    while (true) {

                        System.out.println("\n ================== Assigning Librarian =================== \n ");

                        System.out.print("Are you a Officials? (YES/NO): ");
                        String answer = sc.nextLine();
                        if (Validation.Check(answer)) {
                            System.out.print("Enter Librarian Assigning Code: ");
                            String code = sc.nextLine();

                            if (!Validation.LibrarianCodeValidation(code)) {
                                System.out.println("Invalid Code");
                                continue;
                            }

                            System.out.print("Enter Librarian Name: ");
                            String aLibrarianName = sc.nextLine();

                            System.out.print("Set Librarian Password: ");
                            String aLibrarianPassword = sc.nextLine();

                            Librarian librarian =
                                    new Librarian(
                                            IdGenerator.librarianId,
                                            aLibrarianName,
                                            aLibrarianPassword);

                            service.LibrarianAssign(librarian);
                            break;
                            }else{
                                System.out.println("Only Officials can assign librarians.");
                                break;
                            }
                    }
                    break;
                case 8:
                    //Exit
                    System.out.println("\n THANK  YOU \n");
                    System.exit(0);
                default:
                    System.out.println("\n INVALID CHOICE ! ");
            }
        }
    }
}

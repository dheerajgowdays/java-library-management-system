package com.dheeraj.library.Repository;

import com.dheeraj.library.Model.BorrowBook;
import com.dheeraj.library.Model.Member;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;


public class BorrowRecordRepository {
    static HashMap<Long, ArrayList<BorrowBook>> borrowRecords = new HashMap<>();
    public static void addBorrowRecord(Long memberId, BorrowBook borrowRecord) {
        if (!borrowRecords.containsKey(memberId)) {
            borrowRecords.put(memberId, new ArrayList<>());
        }
        borrowRecords.get(memberId).add(borrowRecord);
        Member member = MemberRepository.getMemberById(memberId);
        member.setBorrowedBooks(borrowRecords.get(memberId));
        member.setNumberOfBooks(1);

        System.out.println("Book is Borrowed Successfully");
    }
    public static void returnBorrowBook(Long memberId,long bookId){
        ArrayList<BorrowBook> records = borrowRecords.get(memberId);
        BorrowBook recordToRemove = null;

        for (BorrowBook record : records) {

            if (record.getBook().getBookId() == bookId) {
                recordToRemove = record;
                break;
            }
        }
        if (recordToRemove != null) {
            records.remove(recordToRemove);
        }
        Member member = MemberRepository.getMemberById(memberId);
        member.setBorrowedBooks(records);
        member.setNumberOfBooks(-1);
        LocalDate returnDate = LocalDate.now();
        assert recordToRemove != null;
        if (returnDate.isAfter(recordToRemove.getDueDate())) {

            long lateDays =
                    ChronoUnit.DAYS.between(
                            recordToRemove.getDueDate(),
                            returnDate
                    );

            int fine = (int) lateDays * 10;

            member.setFine(member.getFine() + fine);
        }
    }
}
package com.dheeraj.library.Util;

import java.util.concurrent.ThreadLocalRandom;

public class IdGenerator {

    static long  bookId = 0;
    static long memberId = 0;
    static long recordId = 0;
    public static long librarianId = ThreadLocalRandom.current().nextLong(10000,99999);
    static String code = "Lib456";
    public static long generateBookId(){
        return ++bookId;
    }

    public static long generateMemberId(){
        return ++memberId;
    }

    public static long generateRecordId(){return ++recordId;}
}

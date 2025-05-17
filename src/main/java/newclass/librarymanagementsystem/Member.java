/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newclass.librarymanagementsystem;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author moham
 */
public class Member {
    private final String name;
    private final String memberId;
    private LocalDate bannedUntil;
    private final ArrayList<Book> borrowedBooks;
    
    public Member(String name, String id){
        this.name = name;
        this.memberId = id;
        this.borrowedBooks = new ArrayList<>();
        this.bannedUntil = null;
    }

    public String getName() {
        return name;
    }

    public String getmemberId() {
        return memberId;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBannedUntil(LocalDate bannedUntil) {
        this.bannedUntil = bannedUntil;
    }

    
    
    public void borrowBook(Book book, Member member){
        if(bannedUntil == null){
            book.borrowBook(member);
            borrowedBooks.add(book);
            System.out.println(name +" borrowed the book " +book.getTitle());
        }else{
            System.out.println("This member is banned until: " +(bannedUntil));       
        }
    }
    
    public void returnBook(Book book, Member member){
        
        if(book.getBorrowedBy() == member){
            if(book.getDueDate() != null && LocalDate.now().isAfter(book.getDueDate())){
                long daysLate = ChronoUnit.DAYS.between(book.getDueDate(), LocalDate.now());      
                System.out.println("Returned late by " + daysLate + " days.");
                isBanned(member, daysLate);
            }else{
                book.returnBook(member);              
                borrowedBooks.remove(book);
                System.out.println(name +" returned the book " +book.getTitle());   
            }      
        }else{
            System.out.println("Error: This book was not borrowed by member with ID " + memberId);
        }
        
    }
    private void printMemberBorrowedBooks(){
        System.out.println("The books borrowed by " +name);
        if(!borrowedBooks.isEmpty()){
            for(Book book : borrowedBooks){
                System.out.print(book.getTitle() +" ");
            }
        }else{
            System.out.println("No Books Borrowed!");
        }
    }
    public void printMemberInfo(UserRole role){
        
        if(role == UserRole.ADMIN){
            System.out.println("Name: " +name);
            System.out.println("ID: " +memberId);
            printMemberBorrowedBooks();
        }else{
            System.out.println("Name: " +name);
            System.out.println("ID: " +memberId);
        }
        
    }
    
    
    public void isBanned(Member member, long daysLate){
        System.out.println("The total fine is: " +(daysLate * 5) +" and this member: " +member.getmemberId() +" is banned for 7 days");
        bannedUntil = LocalDate.now().plusDays(7);
        member.setBannedUntil(bannedUntil);
    }
}

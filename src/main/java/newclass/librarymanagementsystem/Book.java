/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newclass.librarymanagementsystem;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 *
 * @author moham
 */
public class Book {
    private final String title;
    private final String author;
    private final String id;
    private boolean isBorrowed;
    private Member borrowedBy;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private final ArrayList <String> borrowHistory = new ArrayList<>();
    
    public Book(String title, String author, String id){
        this.title = title;
        this.author = author;
        this.id = id;
        this.isBorrowed = false;
        this.borrowDate = null;
        this.dueDate = null;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
    
    

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }
    
    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook(Member member){
        if(!isBorrowed){
            isBorrowed = true;
            borrowedBy = member;
            borrowDate = LocalDate.now();// to assign the real life date to the borrowDate
            dueDate = borrowDate.plusDays(14);// to provide the member with a 14 days after this he had to get the book back.
            borrowHistory.add("Borrowed By:" +member.getmemberId() +" On "+LocalDate.now());
        }else{}
        
    }
    public void returnBook(Member member){
        if(isBorrowed && borrowedBy == member){
            isBorrowed = false;
            borrowedBy = null;
            borrowDate = null;
            dueDate = null;               
        }else{}
    }

    public void printBookInfo(UserRole role){
        
        if(role.equals(UserRole.USER)){
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Id: " + id);
            System.out.println("Status: " +(isBorrowed()? "Borrowed" : "Available"));
            System.out.println("----------------------------------------------");
        } else {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("Id: " + id);
            System.out.println("Is Borrowed: " + isBorrowed);
            System.out.println("Borrowed Date: " +borrowDate);
            System.out.println("Due Date: " +dueDate);
            System.out.println("The book is Borrowed by: " +borrowedBy.getmemberId());
            System.out.println("----------------------------------------------");
        }  
    }
    
    public void printBorrowHistory(){
        System.out.println("The History of Borrowing all Books:");
        for(String history : borrowHistory){
            System.out.println("-> " +history +" -<");
        }
    }
    
}

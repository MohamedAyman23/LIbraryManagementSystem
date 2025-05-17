/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newclass.librarymanagementsystem;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mohammed ayman
 */
public class Library {
    private final HashMap<String, Member> members;// final map to store the members are added
    private final HashMap<String, Book> books;// final hashmap to store all the books are added 
    
    public Library(){
        members = new HashMap<>();
        books = new HashMap<>();
    }
  /**
   * 
   * @return String with the status of adding the member
   */
    public String addMember(){
        Member member = addMembersWithDetails();
        if(!members.containsKey(member.getmemberId())){
            members.put(member.getmemberId(), member);
            return "Member added: " +member.getmemberId();
        }else{
            return "This member: " +member.getmemberId() +" is already existed";
        }        
    }
    
    private Member addMembersWithDetails(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Member name: ");
        String name = in.nextLine();
        System.out.println("");
        System.out.print("Enter the member ID: ");
        String memberID = in.nextLine();
        Member member = new Member(name, memberID);
        return member;
    }
    /**
     * 
     * @param memberID
     * @return String status of the method
     */
    public String removeMember(String memberID){
        Member member = members.get(memberID);
        if(!members.containsKey(member.getmemberId())){
            return "This member: " +member.getmemberId() +" is not exist";
        }else{
            members.remove(member.getmemberId());
            return "Member removed: " +member.getmemberId();
        }  
    }
    
/***
 * This method add a new book after check that the book doesn't exist using the bookId.
 * @return String
 * 
 */    
    public String addBook(){
        Book book = addBookWithDetails();
        if(!books.containsKey(book.getId())){
            books.put(book.getId(), book);
            return "Book add: " +book.getId();
        }else{
            return "This book: " +book.getId() +" is already existed";
        } 
    }
    
    private Book addBookWithDetails(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the book Title: ");
        String title = in.nextLine();
        System.out.println("");
        System.out.print("Enter the book Author: ");
        String author = in.nextLine();
        System.out.println("");
        System.out.print("Enter the book ID: ");
        String id = in.nextLine();
        Book book = new Book(title, author, id);
        return book;
    }
    /**
     * @since this method take a book id and remove it from the library list
     * @param bookId
     * @return a status 
     */
    public String removeBook(String bookId){
        Book book = books.get(bookId);
        if(books.containsKey(book.getId())){
            books.remove(book.getId());
            return "Book removed: " +book.getId();
        }else{
            return "This book: " +book.getId() +" doesn't exist";
        }
    }
    
    /**
     * 
     * @param memberId
     * @param bookId
     * @return method status
     */
    public String borrowBook(String memberId, String bookId){
        Member member = members.get(memberId);
        Book book = books.get(bookId);
        if(member == null){
            return "Member with ID " + memberId + " not found.";
        }

        if(book == null){
            return "Book with ID " + bookId + " not found.";
        }

        if(book.isBorrowed()){
            return "Error: This book is already borrowed.";
        }

        member.borrowBook(book, member); 
        return "Book borrowed successfully.";
        
    }
    
    /**
     * 
     * @param memberId
     * @param bookId
     * @return status
     */
    public String returnBook(String memberId, String bookId){
        Member member = members.get(memberId);
        Book book = books.get(bookId);
        if(member == null){
            return "Member with ID " + memberId + " not found.";
        }
        if(book == null){
            return "Book with ID " + bookId + " not found.";
        }
        if(book.isBorrowed()){
            member.returnBook(book, member);
            return "Thank you.";    
        }else {
            return "Error: This book was not borrowed by member with ID " + memberId;
        }         
    }
   
    /**
     * 
     * @param role
     */
    public void listMembers(UserRole role){
        System.out.println("All member in the Library");
        for(Member member : members.values()){
            member.printMemberInfo(role);
        }
    }
    /**
     * 
     * @param role 
     */
    public void listBooks(UserRole role){
        System.out.println("All books in the Library:");
        books.values().forEach(book -> {
            book.printBookInfo(role); 
        });
    }      
}

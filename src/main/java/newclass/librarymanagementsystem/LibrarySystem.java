/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package newclass.librarymanagementsystem;



/**
 * These are all methods in our app which you can use. 
 * public String addMember(); --> call this method to add a new member to your Library.
 * public String removeMember(String memberID); ---> Use this method to delete a member with his ID.
 * public String addBook(); ---> Use this method to add a new book to your Library.
 * public String removeBook(String bookId); ----> Use this method to delete a book using its ID.
 * public String borrowBook(String memberId, String bookId); ---> Use this one to borrow a book using Member Id and Book Id.
 * public String returnBook(String memberId, String bookId); ---> Use this method to return the book which the client had borrowed.
 * public void listMembers(UserRole role); ----> Use this method to print all members Information but according to the User Role.
 * public void listBooks(UserRole role); ---> Use this method to print all books Information according to the User Role.
 */

import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author Mohammed Ayman
 */
public class LibrarySystem {
    
    Scanner in = new Scanner(System.in);
    Library library = new Library();
    private final HashMap <String, UserAccount> accounts = new HashMap<>();
    /**
     * This method is the begin of our Library system app
     */
    public void startApp(){
        while(true){
            System.out.println("1. Sign up");
            System.out.println("2. Login as User");
            System.out.println("3. Login as Admin");
            System.out.println("4. Exit");
            System.out.println("5. print the user");
            String option = in.nextLine();
            
                switch(option){
                    case "1" ->{
                        singup();
                        break;
                    }
                    case "2" ->{
                        if(login("USER")){
                            userMenu(UserRole.USER);
                        }else{
                            System.out.println("Account not found");
                        }
                        break;
                    }
                    case "3" ->{
                        if(login("ADMIN")){
                            adminMenu(UserRole.ADMIN);
                        }else{
                            System.out.println("Account not found");
                        }
                        break;
                    }
                    case "4" ->{
                        exitProgram();
                        break;
                    }
                    case "5" ->{
                        UserAccount account1 = accounts.get("Mohammed_Admin");
                        if(account1 == null)
                            System.out.println("no account founded");
                        System.out.println(account1.getUserpassword());
                    }
                    default -> {
                        System.out.println("Please provide a valid choice...");
                        break;
                    }
                }    
        }
    }
    
    /**
     * 
     * @param role 
     */
    private void adminMenu(UserRole role){
        
        String option;
        do{
            System.out.println("1. ADD MEMBER");
            System.out.println("2. REMOVE MEMBER");
            System.out.println("3. LIST MEMBERS");
            System.out.println("4. ADD BOOK");
            System.out.println("5. REMOVE BOOK");
            System.out.println("6. BORROW BOOK");
            System.out.println("7. RETURN BOOK");
            System.out.println("8. LIST BOOKS");
            System.out.println("9. GO TO MAIN MENU");
            System.out.println("10. EXIT");
            //in.nextLine(); // fix to consume leftover newline from previous input
            option = in.nextLine();
            switch(option){
                case "1" ->{
                    System.out.println((String)library.addMember());
                    break;
                }
                case "2" ->{
                    System.out.println("Please, Provide the member ID you want to delete");
                    String memberID = in.nextLine();
                    System.out.println((String)library.removeMember(memberID));
                    break;
                }
                case "3" ->{
                    library.listMembers(role);
                    break;
                }
                case "4" ->{
                    System.out.println((String)library.addBook());
                    break;
                }
                case "5" ->{
                    System.out.println("Please, Provide the book ID you want to delete");
                    String bookId = in.nextLine();
                    System.out.println((String)library.removeBook(bookId));
                    break;
                }
                case "6" ->{
                    System.out.println("Please, Provide the memberId and BookId you want to Borrow...");
                    System.out.print("Member Id: ");
                    String memberId = in.nextLine();
                    System.out.println("Book Id: ");
                    String bookId = in.nextLine();
                    System.out.println((String)library.borrowBook(memberId, bookId));
                    break;
                }
                case "7" ->{
                    System.out.println("Please, Provide the memberId and BookId for Book you want to return");
                    System.out.print("Member Id: ");
                    String memberId = in.nextLine();
                    System.out.println("Book Id: ");
                    String bookId = in.nextLine();
                    System.out.println((String)library.returnBook(memberId, bookId));
                    break;
                }
                case "8" ->{
                    library.listBooks(role);
                    break;
                }
                case "9" ->{
                    return; 
                }
                case "10" ->{
                   exitProgram();
                   break;
                }
                default ->{
                    System.out.println("Please provide a valid choice...");
                    break;
                }
            }
            System.out.println("DO YOU WANT TO SELECT ANOTHER OPTION...(YES/NO)");
            option = in.nextLine();
            
        }while(option.equalsIgnoreCase("yes"));
    
    }    
    
    private void exitProgram(){
        System.out.println("System is shutting down...GoodBye");
        System.exit(0);
    }
    
    
    private void singup(){
        System.out.println("Enter username: ");
        String username = in.nextLine();
        if(accounts.containsKey(username)){
            System.out.println("username is already exist");
            return;
        }
        System.out.println("Enter password: ");
        String password = in.nextLine();
        System.out.println("Enter role  (ADMIN / USER): ");
        String role = in.nextLine().toUpperCase();
        UserAccount account = new UserAccount(username, password, role);
        accounts.put(username, account);
        System.out.println("Account created successfully");               
    }
    
    private boolean login(String role){
        System.out.print("Enter username: ");       
        String username = in.nextLine();
        System.out.print("Enter password: ");
        String password = in.nextLine();
        UserAccount account = accounts.get(username);
        return account != null && account.getUserpassword().equals(password)                
                && account.getUserrole().equals(role);
    }
    
    private void userMenu(UserRole role){
        String option;
        do{
            System.out.println("1. LIST BOOKS");
            System.out.println("2. BORROW BOOK");
            System.out.println("3. RETURN BOOK"); 
            System.out.println("4. GO TO MAIN MENU");
            System.out.println("5. EXIT");
            in.nextLine(); 
            
            option = in.nextLine();
            switch(option){
                case "1" ->{
                    library.listBooks(role);
                    break;
                }
                case "2" ->{
                    System.out.println("Please, Provide the memberId and BookId...");
                    System.out.print("Member Id: ");
                    String memberId = in.nextLine();
                    System.out.println("Book Id: ");
                    String bookId = in.nextLine();
                    System.out.println((String)library.borrowBook(memberId, bookId));
                    break;
                }
                case "3" ->{
                    System.out.println("Please, Provide the memberId and BookId...");
                    System.out.print("Member Id: ");
                    String memberId = in.nextLine();
                    System.out.println("Book Id: ");
                    String bookId = in.nextLine();
                    System.out.println((String)library.returnBook(memberId, bookId));
                    break;
                }
                case "4" ->{
                    return;
                }
                default ->{
                    exitProgram();
                    break;
                }
            }
            System.out.println("DO YOU WANT TO SELECT ANOTHER OPTION...(YES/NO)");
            option = in.nextLine();
            
        }while(option.equalsIgnoreCase("yes"));  
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package newclass.librarymanagementsystem;

/**
 *
 * @author Mohammed Ayman
 */
public class UserAccount {
    private final String userName;
    private final String userPassword;
    private final String userRole;
    public UserAccount(String userName, String userPassword, String userRole){
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }
    public String getUsername(){
        return this.userName;
    }
    
    public String getUserpassword(){
        return this.userPassword;
    }
    
    public String getUserrole(){
        return this.userRole;
    }
}

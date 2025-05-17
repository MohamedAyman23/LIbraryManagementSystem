/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package newclass.librarymanagementsystem;

/**
 *
 * @author moham
 */
public class Main {

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        welcomeMessege();
        system.startApp();
        
    }
    private static void  welcomeMessege(){
        System.out.println("====================================");
        System.out.println("Welcome to the Library System ");
        System.out.println("Your gateway to a world of knowledge!");
        System.out.println("====================================");
        System.out.println("\nStarting system, please wait...\n");

        try {
            Thread.sleep(1500); // 1.5 ثانية
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // معالجة الخطأ لو حصل
        }

        System.out.println("System is ready!\n");
        }
}

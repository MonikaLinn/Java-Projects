// Ajito, Monika

import java.util.Scanner;

public class Project2 {    
    public static void main(String[] args) {
        
        String firstName;
        String middleName;
        String lastName;
        int space, secondSpace;
        
        //Scanner
        Scanner scanner1 = new Scanner (System.in);
        
        //User Input
        System.out.println("Please enter your Full Name:"); 
        String fullName = scanner1.nextLine();
        
        //Calculations
        space = fullName.indexOf(' ');
        firstName = fullName.substring(0, space);
        
        secondSpace = fullName.indexOf(" ", space + 1);
        
        if (secondSpace < 0 ) {
            System.out.println("Document's Correct Format:");
            lastName = fullName.substring(space);
            System.out.println(lastName + ", " + firstName.charAt(0) + ". ");
        }
        else {
            middleName = fullName.substring(space, secondSpace);
            System.out.println("Document's Correct Format:");
            lastName = fullName.substring(secondSpace);
            System.out.println(lastName + ", " + firstName.charAt(0) + ". " + middleName.charAt(1) + ". ");
        }
  
    }
}
    

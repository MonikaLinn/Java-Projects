//Ajito, Monika 

import java.util.Scanner;

public class Findseason {
     public static void main(String[] args)
     {  
         
         //Scanner
         Scanner scanner = new Scanner(System.in);
         
        boolean run = true;
        
       while (run) { 
           
           //User input
        System.out.println("Please enter a Date: "); 
        String month = scanner.next();
        int monthNum = scanner.nextInt();
        month = month.toLowerCase(); 
           
        //Calculations
       switch (month) {
         case "march":
           if (monthNum >= 20 && monthNum <= 31) {
            System.out.println("The Season is Spring");
           } else if (monthNum >= 1 && monthNum <=19) {
            System.out.println("The Season is Winter");
           } else {
            System.out.println("Invalid Date");  
           }
           break;
           
         case "april":
           if (monthNum >= 31 || monthNum <= 0) {
            System.out.println("Invalid Date");             
           } else {
            System.out.println("The Season is Spring");
           }
           break;
           
         case "may":
           if (monthNum > 31 || monthNum <= 0) {
            System.out.println("Invalid Date");             
           } else {  
            System.out.println("The Season is Spring");
           }
            break;
           
         case "june":
           if (monthNum <= 20 && monthNum >= 1) {
            System.out.println("The Season is Spring");
           } else if (monthNum >= 31 || monthNum <= 0) {
            System.out.println("Invalid Date");     
           } else {
            System.out.println("The Season is Summer");
           }
            break;
            
         case "july":   
           if (monthNum > 31 || monthNum <= 0) {
            System.out.println("Invalid Date");             
           } else {
            System.out.println("The Season is Summer");        
           }
            break;
            
         case "august":
           if (monthNum > 31 || monthNum <= 0) {
            System.out.println("Invalid Date");             
           } else {  
            System.out.println("The Season is Summer");   
           }
            break;
            
         case "september":
           if (monthNum <= 21 && monthNum >= 1) {
            System.out.println("The Season is Summer");
           } else if (monthNum >= 31 || monthNum <= 0) {
            System.out.println("Invalid Date");     
           } else {
            System.out.println("The Season is Autumn");
           }
            break;
            
         case "october":
           if (monthNum > 31 || monthNum <= 0) {
            System.out.println("Invalid Date");             
           } else {  
            System.out.println("The Season is Autumn");
           }
            break;
            
         case "november":  
           if (monthNum >= 31 || monthNum <= 0) {
            System.out.println("Invalid Date");     
           } else {
            System.out.println("The Season is Autumn");
           }
           break;
           
         case "december":
           if (monthNum <= 20 && monthNum >= 1) {
            System.out.println("The Season is Autumn");
           } else if (monthNum > 31 || monthNum <= 0) {
            System.out.println("Invalid Date");
           } else {
            System.out.println("The Season is Winter");
           }
           break;
           
         case "january":
             if (monthNum >= 31 || monthNum <= 0) {
            System.out.println("Invalid Date");             
           } else {
            System.out.println("The Season is Winter");
             }
            break;
           
         case "february":
           if (monthNum > 28 || monthNum <= 0) {
            System.out.println("Invalid Date");     
           } else {
            System.out.println("The Season is Winter");
           }
           break;
           
         case "quit":  
           if (monthNum > 0) {
            System.out.println("Invalid Date");     
           } else if (monthNum < 0) {
            System.out.println("Invalid Date");
           } else {
            System.out.println("You have stopped the program.");
           }
           run = false;  
           break;  
         
         default: 
            System.out.println("Invalid Date");
           break;
           
           }
       }
    }      
} 
            

   



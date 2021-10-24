//Ajito, Monika 
import java.io.IOException;
import java.util.Scanner;
import java.net.*;
import java.io.*;


import java.util.Scanner; 
public class rankedNames {
    
    private static void loopYear(String [][] boy, String[][] girl) {
  int baseYear = 200;
  
 for (int i = 1; i <= 10; i++) {     
 int group = 0;
     if(i == 10){
    baseYear = 20;
 }
    String babyNamesLink = "http://liveexample.pearsoncmg.com/data/babynamesranking" + Integer.toString(baseYear) + Integer.toString(i) + ".txt";
    
     try {
         URL babyNamesURL = new URL(babyNamesLink); 
            
        Scanner rankedNames = new Scanner(babyNamesURL.openStream());
            
            while (rankedNames.hasNext()) {
             String fileLine = rankedNames.nextLine();
            
             String fileLine1 = fileLine.replaceAll("\\s+", " ");  
             
             String [] array = fileLine1.split(" ", 5);
             
             girl[i - 1][group] = array[3];
             boy[i - 1][group] = array[1];
             
             
             group++;
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
 
 } 
 

    }
    
    
    private static int numRank(int year, String gender, String name, String  [][] boy, String [][] girl) {
        if (year < 2001 || year > 2010) return -1; 
        if (!gender.equals("M") && !gender.equals("F")) return -2; 

        int ranking = -0; 
    int index = year - 2001; 
    if (gender.equals("F")) {
        for ( int i = 0; i < girl[index].length; i++) {
            if(girl[index][i].equals(name))
                return i + 1;
        }
    }
    if (gender.equals ("M")) {
        for ( int k = 0; k < boy[index].length; k++) {
            if(boy[index][k].equals(name))
                return k + 1;
        }
    }
        return 0;
    }
    
    public static void main(String[] args) {  
             
        String[][] boyNames = new String[10][1000];
        String[][] girlNames = new String[10][1000];
   
        loopYear(boyNames, girlNames);      
    
        
        Scanner myObj = new Scanner(System.in);
            
            System.out.println("Enter the year: ");
            int year = myObj.nextInt();
          
            System.out.println("\nEnter the gender: ");
            String gender = myObj.next().trim();
            
            System.out.println("\nEnter the name: ");
            String name = myObj.next();
            
            int ranking = numRank(year, gender, name, boyNames, girlNames); 
            
            if (ranking == 0) {
                System.out.println("Invalid choice: " + name + " is not on the list for that year.");
            }
            else if (ranking == -1){
                System.out.println("Invalid choice: " + year + " is not a valid year");
            }   
              else if (ranking == -2){
                System.out.println("Invalid choice: " + gender + " is not a valid choice");
            }   
            else { 
            System.out.print("\n" + name + " is ranked #" + ranking + " in year " + year);
                }
        
    }
}
  
  

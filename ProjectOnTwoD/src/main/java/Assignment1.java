
import java.util.Scanner;

public class Assignment1 {
    
    public static void main(String[] args) {
     System.out.println("Enter row size: ");
         Scanner sc = new Scanner(System.in);
         int rows = sc.nextInt();
         
     System.out.println("Enter column size: ");
       int columns = sc.nextInt();  
       
       int arr[][] =new int [rows] [columns];
     
       System.out.println();
       
       for (rows = 0;  rows < arr.length;  rows++) {
     
          for ( columns = 0; columns < arr[rows].length; columns++) {
         
            arr[rows][columns] = ( (int) (Math.random() * 9));
          }
       }
            
         for (rows = 0;  rows < arr.length;  rows++) {
     
          for ( columns = 0; columns < arr[rows].length; columns++) {
      
               System.out.print(arr[rows][columns]+ "   ");
             
          }
            
      System.out.println();
          }
         
    System.out.println(isConsecutiveFour(arr));
    }
      public static boolean isConsecutiveFour(int[][] values) {
             
       for (int row = 0;  row < values.length;  row++) { //horizontal 
     
          for (int  column = 0; column < values[row].length - 3 ; column++) {
         
              if (values[column][row] == values[column +1][row] &&
                    values[column][row] == values[column +2][row] &&
                    values[column][row] == values[column +3][row]) {
                   return true;
              }
          }
       }
       
        for (int row = 3;  row < values.length;  row++) { //diagonal left
     
          for (int  column = 0; column < values[row].length - 3 ; column++) {
         
              if (values[column][row] == values[column +1][row -1] &&
                    values[column][row] == values[column +2][row -2] &&
                    values[column][row] == values[column +3][row -3])  {
                 return true;
              }
          }
       }
        
         for (int row = 0;  row < values.length -3;  row++) { //diagonal right
     
          for (int  column = 0; column < values[row].length - 3 ; column++) {
         
              if (values[column][row] == values[column +1][row + 1] &&
                    values[column][row] == values[column +2][row + 2] &&
                    values[column][row] == values[column +3][row + 3]) {
                    return true;
              }
          }
       }
         
          for (int row = 0;  row < values.length -3;  row++) { //vertical
     
          for (int  column = 0; column < values[row].length ; column++) {
         
              if (values[column][row] == values[column][row + 1] &&
                    values[column][row] == values[column][row +2] &&
                    values[column][row] == values[column][row+3]) {
                    return true;
              }
          }
       }
       return false;
     }
}


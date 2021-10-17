//Ajito, Monika

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

   public static void main(String[] args) {
       String choice;

       Scanner sc = new Scanner(System.in);

       ArrayList<Coffee> printList = new ArrayList<>();
      
       while (true) {
           
           System.out.println("\n1.White Chocolate Mocha");
           System.out.println("2.Dark Chocolate Mocha");
           System.out.println("3.Coffee Mocha");
           System.out.println("4.Peppermint Mocha");
           System.out.println("5.Display All Orders");
           System.out.println("6.Exit");
           System.out.println("Enter Choice : ");
           choice = sc.nextLine();
         
           switch (choice) {
               
           case "1": { //White Chocolate Mocha
               System.out.println("Enter Price: ");
               double price = sc.nextDouble();
               sc.nextLine();
               
               System.out.println("Enter Store Name: ");
               String storeName = sc.nextLine();
               
               System.out.println("Enter Chocolate Amount: ");
               double chocolate1 = sc.nextDouble();
                sc.nextLine();
                
               System.out.println("Enter in a comma seperated line, ie. (Marshmallows, Whipped Cream)"); 
               System.out.println("Enter Ingredients: "); 
               
               String ingredients = sc.nextLine();
               
               WhiteChocolateMocha wcm = new WhiteChocolateMocha("White Chocolate Mocha", price, storeName, ingredients, chocolate1);
               printList.add(wcm);
           
                
               continue;
               }
           
           
           case "2": { //Dark Chocolate Mocha
               System.out.println("Enter Price: ");
               double price = sc.nextDouble();
               sc.nextLine();
               
               System.out.println("Enter Store Name: ");
               String storeName = sc.nextLine();
               
                System.out.println("Enter Chocolate Amount: ");
               double chocolate1 = sc.nextDouble();
                sc.nextLine();
               
               System.out.println("Enter in a comma seperated line, ie. (Chocolate, Marshmallows)"); 
               System.out.println("Enter Ingredients: "); 
               String ingredients = sc.nextLine();
               
               DarkChocolateMocha dcm = new DarkChocolateMocha("Dark Chocolate Mocha", price, storeName, ingredients, chocolate1);
               printList.add(dcm);
               continue;
           }
           
           
           case "3": { //Coffee Mocha
               System.out.println("Enter Price: ");
               double price = sc.nextDouble();
               sc.nextLine();
               
               System.out.println("Enter Store Name: ");
               String storeName = sc.nextLine();
               
               System.out.println("Enter in a comma seperated line, ie. (Chocolate, Marshmallows)"); 
               System.out.println("Enter Ingredients: ");
               String ingredients = sc.nextLine();
               
               CoffeeMocha cm = new CoffeeMocha("Coffee Mocha", price, storeName, ingredients);
               printList.add(cm);
               continue;
           }
           
           
           case "4": {//Peppermint Mocha
               System.out.println("Enter Price: ");
               double price = sc.nextDouble();
               sc.nextLine();
               
               System.out.println("Enter Store Name: ");
               String storeName = sc.nextLine();
               
               System.out.println("Peppermint Syrup Amount: ");
               double syrup = sc.nextDouble();
               sc.nextLine();
               
               System.out.println("Enter in a comma seperated line, ie. (Chocolate, Marshmallows)"); 
               System.out.println("Enter Ingredients: ");
               String ingredients = sc.nextLine();
               
               PeppermintMocha pm = new PeppermintMocha("Peppermint Mocha", price, storeName, ingredients, syrup);
               printList.add(pm);
               continue;
           }
           
            case "5": {
               displayAll(printList);
               continue;
           }
            case "6": {
                System. exit(0);
            }
           default :{
               System.out.println("** Invalid Choice **");
           }
          
       }

   }
   }
   
   private static void displayAll(ArrayList<Coffee> printList) {
       for(int i=0;i<printList.size();i++)
       {
           printList.get(i).prepare();
           System.out.println("Price:$ "+printList.get(i).getPrice());
           printList.get(i).ingredient();
      
           System.out.println("_____________________________");
           System.out.println("\n");
       }
      
   }
  
}

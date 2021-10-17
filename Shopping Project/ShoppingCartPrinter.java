//Ajito, Monika Project 4 Part 2

import java.util.Scanner;

public class ShoppingCartPrinter {

    public static void main(String[] args) {
        
        //Variable Set
        String name;
        int price;
        int quantity;
        
        Scanner scnr = new Scanner(System.in);
        
        ItemToPurchase itemA= new ItemToPurchase();
        ItemToPurchase itemB= new ItemToPurchase();
        //User Input
        System.out.println("Item 1");
        System.out.println("Enter the item name: ");
        String nameA = scnr.nextLine();
          
        System.out.println("Enter the item price: ");
        int priceA = scnr.nextInt();
        
        System.out.println("Enter the item quantity: ");
        int quantityA = scnr.nextInt();
     	//Taking User Input & inputting
        itemA.setName(nameA);
        itemA.setQuantity(quantityA);
        itemA.setPrice(priceA);
        
        scnr.nextLine();
        //User Input
        System.out.println("Item 2");
        System.out.println("Enter the item name: ");
        String nameB = scnr.nextLine();
        
        System.out.println("Enter the item price: ");
        int priceB = scnr.nextInt();
      
        System.out.println("Enter the item quantity: ");
        int quantityB = scnr.nextInt();
      	//Taking User Input & inputting
        itemB.setName(nameB);
        itemB.setQuantity(quantityB);
        itemB.setPrice(priceB);
        
        //Printing out Cart
        System.out.println("TOTAL COST");
      
        int itemATotal = itemA.getPrice() * itemA.getQuantity();
        int itemBTotal = itemB.getPrice() * itemB.getQuantity();
       
        System.out.println(itemA.getName()+" "+itemA.getQuantity()+" @ $"+itemA.getPrice()+" = $"+itemATotal);
        System.out.println(itemB.getName()+" "+itemB.getQuantity()+" @ $"+itemB.getPrice()+" = $"+itemBTotal);
        System.out.println();
        System.out.println("Total: $"+(itemATotal + itemBTotal));


      }
    
}


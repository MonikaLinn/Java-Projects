//Ajito, Monika Project 4 Part 2

import java.util.Scanner;

public class ShoppingCartManager {

    public static void main(String[] args) { //Getting Customer Info
        
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter Customer's Name: ");
    String customerName = scan.nextLine();

    System.out.println("Enter Today's Date: ");
    String currentDate = scan.nextLine();
    
    ShoppingCart s = new ShoppingCart(customerName, currentDate);
    System.out.println();
    
    System.out.println("Customer Name: "+s.getCustomerName());
    System.out.println("Today's Date: "+currentDate);
    printMenu(s);
  
}
public static void printMenu(ShoppingCart s){ //Main Menu
while(true){
    System.out.println("MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\nChoose an option: ");
    Scanner scan = new Scanner(System.in);
    char ch = scan.next().charAt(0);
scan.nextLine();
if(ch == 'a' || ch == 'A' ){ //Adding Items to Cart
    System.out.println("ADD ITEM TO CART");

    System.out.println("Enter Item Name: ");
    String itemName = scan.nextLine();

    System.out.println("Enter Item Description: ");
    String itemDescription = scan.nextLine();
    
    System.out.println("Enter Item Price: ");
    int itemPrice = scan.nextInt();

    System.out.println("Enter Item Quantity: ");
    int itemQuantity = scan.nextInt();

    scan.nextLine();
    ItemToPurchase item = new ItemToPurchase(itemName, itemDescription, itemPrice, itemQuantity);
    s.addItem(item);
}
else if(ch == 'd' || ch == 'D'){ //Removing Items from Cart
    System.out.println("REMOVE ITEM FROM CART");
    System.out.println("Enter name of item to remove: ");
    String itemName = scan.nextLine();
    s.removeItem(itemName);
}
else if(ch == 'c' || ch == 'C'){ //Changing Item Quantity
    System.out.println("CHANGE ITEM QUANTITY");
    System.out.println("Enter the item name: ");
    String itemName = scan.nextLine();
    System.out.println("Enter the new quantity: ");
    int itemQuantity = scan.nextInt();
    
    ItemToPurchase item = new ItemToPurchase();
    item.setName(itemName);
    item.setQuantity(itemQuantity);
    s.modifyItem(item);
}
else if(ch == 'I' || ch == 'i'){ //Output Items' Descriptions
    System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
    s.printItemDescriptions();
}
else if(ch == 'O' || ch == 'o'){
    System.out.println("OUTPUT SHOPPING CART");
    s.printTotal();
}
else if(ch == 'q' || ch == 'Q'){ //Quitting Program
break;
}
}
}
}
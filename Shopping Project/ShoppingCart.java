//Ajito, Monika Project 4 Part 2
import java.util.ArrayList;
        
public class ShoppingCart {
    private String customerName; 
    private String currentDate;
    //Creating Shopping Cart
    ArrayList < ItemToPurchase > cartItems = new ArrayList < ItemToPurchase>();;

public ShoppingCart(){
    customerName = "none";
    currentDate = "January 1, 2016";    
}

public ShoppingCart(String name , String date) {
    this.customerName = name;
    this.currentDate = date;
}

public String getCustomerName() {
    return customerName;
}

public void setCustomerName(String customerName) {
    this.customerName = customerName;
}

public String getDate() {
    return currentDate;
}

public void setCurrentDate(String currentDate) {
    this.currentDate = currentDate;
}

public void addItem(ItemToPurchase i) {
    cartItems.add(i);
}

public void removeItem(String name) {
boolean found = false;;

for(ItemToPurchase i: cartItems){
    if(i.getName().equalsIgnoreCase(name)) {
    cartItems.remove(i);
    found = true;
        break;
    }
}
    if(!found)
System.out.println("Item not found in cart. Nothing removed");
}

public void modifyItem(ItemToPurchase item) {
boolean found = false;;

for(ItemToPurchase i: cartItems){
    if(i.getName().equalsIgnoreCase(item.getName())) {
    if(i.getQuantity()!=0){
    i.setQuantity(item.getQuantity());
}
    found = true;
        break;
    }
}
    if(!found)
System.out.println("Item not found in cart. Nothing removed");
}

public int getNumItemsInCart() {
int sum = 0;

for(ItemToPurchase i: cartItems){
    sum = sum + i.getQuantity();
}
return sum;
}

public double getCostOfCart() {
double sum = 0;
    
for(ItemToPurchase i: cartItems){
    sum = sum + i.getPrice();
}
return sum;
}  

public void printTotal() { //priting out the total
    if(cartItems!=null&& cartItems.size() >0 ){
        System.out.println();
    System.out.println(customerName+"'s Shopping Cart - "+currentDate);
    System.out.println("Number of Items: "+cartItems.size());
    System.out.println();
for(ItemToPurchase i: cartItems){
    i.printItemCost();
    }
}
else{
    System.out.println("SHOPPING CART IS EMPTY");   
    }
}

public void printItemDescriptions() { //printing out the description
    if(cartItems!=null&& cartItems.size() >0 ){
        System.out.println();
    System.out.println(customerName+"'s Shopping Cart - "+currentDate);
    System.out.println("Number of Items: "+cartItems.size());
    System.out.println();
    System.out.println("Item Descriptions");
for(ItemToPurchase i: cartItems){  
    i.printItemDescription();
    }
}
else{
    System.out.println("SHOPPING CART IS EMPTY");   
        }

    }
}

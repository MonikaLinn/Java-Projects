//Ajito, Monika Project 4 Part 1
public class ItemToPurchase {
    private String itemName;
    private int itemQuantity;
    private int itemPrice;
    private String itemDescription;
    
public ItemToPurchase(){
    itemName = "none";
    itemQuantity = 0;
    itemPrice = 0;
    itemDescription = "none";
    
}

public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity){
    this.itemDescription = itemDescription;
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.itemQuantity = itemQuantity;
}

public String getName(){
    return itemName;
}       

public void setName(String itemName){
    this.itemName = itemName;
}
                
public int getPrice(){
    return itemPrice;
}
                        
public void setPrice(int itemPrice){
    this.itemPrice =  itemPrice;
}

public int getQuantity(){
    return itemQuantity;
}
                    
public void setQuantity(int itemQuantity){
    this.itemQuantity = itemQuantity;
  
}

public String getItemDesc() {
return itemDescription;
}

public void setItemDesc(String itemDescription) {
this.itemDescription= itemDescription;
}

public void printItemCost() {
System.out.println(itemName +" "+ itemQuantity +" @ "+ itemPrice +" = $"+( itemQuantity * itemPrice ) );
}

public void printItemDescription() {
System.out.println(itemName +": "+ itemDescription);
}
                    
}

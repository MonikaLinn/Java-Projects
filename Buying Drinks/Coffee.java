//Ajito, Monika Polymorphic 

abstract class Coffee implements HowToMakeDrink {
private String type;
private double price;
private String storeName;
private String ingredients;

abstract void ingredient ();

public Coffee(String type, double price, String storeName, String ingredients) {
    this.type = type;
    this.price = price;
    this.storeName=storeName;
    this.ingredients=ingredients;

}

public String getType() {
return type;
}

public void setType(String type) {
 this.type = type;   
}

public double getPrice() {
return price;
}

public void setPrice(double price) {
 this.price = price;   
}

public String getName() {
return storeName;
}

public void setName(String storeName) {
 this.storeName = storeName;   
}

public String getIngredients() {
return ingredients;
}

public void setIngredients(String ingredients) {
 this.ingredients = ingredients;   
}

@Override
public void prepare() {
    
    System.out.println("Coffee Type : " +type );

}
}
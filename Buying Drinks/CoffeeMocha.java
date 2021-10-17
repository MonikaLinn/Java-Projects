//Ajito, Monika

public class CoffeeMocha extends Coffee {

   public CoffeeMocha(String type, double price, String storeName, String ingredients) {
       super(type, price, storeName, ingredients);
   }

     @Override
   public void prepare() {
       System.out.println("Coffee Type: " + super.getType());

   }

   @Override
   public void ingredient() {
    
       System.out.println("Ingredients: " +super.getIngredients());

   }
}

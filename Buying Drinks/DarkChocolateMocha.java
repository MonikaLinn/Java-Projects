//Ajito, Monika

public class DarkChocolateMocha extends Coffee {

    private double chocolate1;
    
   public DarkChocolateMocha(String type, double price, String storeName, String ingredients, double chocolate1) {
       super(type, price, storeName, ingredients);
   }
  
   public double getChoco() {
return chocolate1;
}

public void setChoco(double chocolate1) {
 this.chocolate1 = chocolate1;   
}

   @Override
   public void prepare() {
       System.out.println("Coffee Type: "+super.getType());
   }

   @Override
   public void ingredient() {
       
       System.out.println("Ingredients: " +super.getIngredients());

   }

   public void choco() {
    System.out.println("Chocolate Amount: " + getChoco());
   }
}

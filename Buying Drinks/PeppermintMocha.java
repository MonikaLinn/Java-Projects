//Ajito, Monika

public class PeppermintMocha extends Coffee {
   private double syrup;

   public PeppermintMocha(String type, double price, String storeName, String ingredients, double syrup) {
       super(type, price, storeName, ingredients);
       
     
   }

    public double getSyrup() {
        return syrup;
   }

     public void setSyrup(double syrup) {
        this.syrup = syrup;   
    }
     
@Override
   public void ingredient() {
    
       System.out.println("Ingredients: " +super.getIngredients());

   }
   
   public void syrup() {
    System.out.println("Chocolate Amount: " + getSyrup());
   }

}
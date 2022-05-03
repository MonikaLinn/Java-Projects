
package Store;

import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
  
public class StoreMain {

    
    public static void main(String[] args) {
//Populate Customers
      FurnitureBusiness MochaFurniture = new FurnitureBusiness();
      ArrayList<Customer> Consumer = new ArrayList();
      ArrayList<Furniture> Items = new ArrayList();
      
      Customer Perry = new Customer(145879, "Perry the Playtpus", "Doofenshmirtz Tower"); //Populated Customer 1
      Customer Snoopy = new Customer(484713, "Snoopy the Peanut", "Charlie Brown Lane"); //Populated Customer 2
      Customer Xayah = new Customer(781432, "Xayah the Rebel", "Lhotlan Tribe"); //Populated Customer 3
      
      Sofa fluffySofa = new Sofa();
      Chair pinkChair = new Chair();
      Recliner rockinRecliner = new Recliner();  
      Table ovalTable = new Table();
      Table squareTable = new Table("Square");
      
      Items.add(fluffySofa);
      Items.add(pinkChair);
      Items.add(rockinRecliner);
      Items.add(ovalTable);
      Items.add(squareTable);
      
      MochaFurniture.purchase(Perry, fluffySofa); //1
      MochaFurniture.purchase(Perry, rockinRecliner); //2
      MochaFurniture.purchase(Perry, squareTable); //3 

      MochaFurniture.purchase(Snoopy, ovalTable); //1
      
      MochaFurniture.purchase(Xayah, pinkChair); //1 
      
      Consumer.add(Perry);
      Consumer.add(Snoopy);
      Consumer.add(Xayah);
      
 for(int i = 0; i < 3; i ++) {
  System.out.println("ID: " + Consumer.get(i).getID());
    System.out.println("Name: " + Consumer.get(i).getName());
      System.out.println("Address: " + Consumer.get(i).getAddress());
      System.out.print("\n");
      
      for(int k = 0; k < 5; k ++){
          System.out.println("Furniture Brand: " + Items.get(k).modelNr);
          System.out.println("Furniture Name: " + Items.get(k).name);
          System.out.println("Furniture Price: " + Items.get(k).price);
          
          MochaFurniture.hasBought(Consumer.get(i), Items.get(k));
          
          System.out.print("\n");
      }
      System.out.println(".................................................."); 
   
 }
      List<Furniture> tempList;
      for(int f = 0; f < 3; f++) {
            tempList = MochaFurniture.getPurchase(Consumer.get(f));
            System.out.println(Consumer.get(f).getName() + "'s bought items are: ");
            for(int m = 0; m < tempList.size(); m++) {
                System.out.println(tempList.get(m).name());
            
            }
     System.out.println(".................................................."); 
      }
    
  }

}
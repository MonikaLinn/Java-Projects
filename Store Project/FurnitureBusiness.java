package Store;

import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.ArrayList;
  

public class FurnitureBusiness {

HashMap<Customer, List<Furniture>> map = new HashMap<>(); //Map of Customers

public boolean CustomerCheck(Customer c) {
    Iterator<Map.Entry<Customer, List<Furniture>>> iterator = map.entrySet().iterator(); //Creating Map
while(iterator.hasNext()) {
    Map.Entry<Customer, List<Furniture>> entry = iterator.next();
    
    if ( c == entry.getKey()) {
        return true; //Does Exist
    }
}
return false; //Doesn't Exist
}

public void purchase(Customer c, Furniture f) { 
    if(!CustomerCheck(c)) { //New Customer, create new list 
        List<Furniture> mocha = new ArrayList();
            mocha.add(f);
                map.put(c, mocha);
    } else { // Old Customer,  access old list 
    map.get(c).add(f);
    }
}
   public boolean hasBought(Customer c, Furniture f) { //Checks if Customer has bought furniture
    for (int i = 0; i < map.get(c).size(); i ++) {  //if customer made purchase then return true
        if((map.get(c).get(i)).equals(f)) {
      System.out.println("Has Bought");
            return true; 
        }
    }
        System.out.println("Has Not Bought");
        return false;   //if not return false
} 

   public List<Furniture> getPurchase(Customer c) {

    return map.get(c);

}
}



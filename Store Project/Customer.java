package Store;

import java.util.HashMap;
import java.util.List;
import java.util.*;
  
public class Customer {

      int ID;
      String name;
      String address; 
         
Customer(int id, String Name, String Address) {
    this.ID = id;
    
    this.name = Name;
    
     this.address = Address;
}
    
public int getID() {
    return ID;
}

public String getName() {
    return name;
}

public String getAddress() {
    return address;
}

@Override
public int hashCode() {
    int hash = 11;
    
    hash = 11 * hash + (name == null ? 0 : name.hashCode());
    
    hash = 11  * hash + (address == null ? 0 : address.hashCode()); 
 
    hash = 11 * hash + ID;
    
    return hash;
}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
       Customer con = (Customer) obj;
        
        return (con.name.equals(this.name)  && con.ID == this.ID && con.address.equals(this.address));
    }

     }

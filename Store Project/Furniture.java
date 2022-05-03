package Store;

import java.util.HashMap;
import java.util.List;
import java.util.*;
  

public abstract class Furniture {
    
    String name;
    
   String modelNr;
    
    float price;
    
    public String modelNr()
    {
        return this.modelNr;
    }
    
    public float price() 
    {
        return this.price;
    }
    
    public String name() 
    {
        return this.name;
    }
    
    
  @Override
public int hashCode() {
    int hash = 11;
    
    hash = 11 * hash + (name == null ? 0 : name.hashCode());
    
    hash = 11  * hash + (modelNr == null ? 0 : modelNr.hashCode()); 
 
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
       Furniture f = (Furniture) obj;
        
        return (f.name.equals(this.name)  && f.price == this.price && f.modelNr.equals(this.modelNr));
    }
    
}

import java.util.*;

// 10-1,2 PowerSet & methods
public class PowerSet
{
    public ArrayList<String> store;

    public PowerSet()
    {
        store = new ArrayList<>();
    }

    public int size()
    {
        return store.size();
    }

    public void put(String value)
    {
        if (!get(value)) {
            store.add(value);
        }
    }

    public boolean get(String value)
    {
        return store.contains(value);
    }

    public boolean remove(String value) { 
        return store.remove(value);
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet result = new PowerSet();
        for (String el: store) {
            if (set2.get(el)) {
                result.put(el);
            }
        }

        return result;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet result = new PowerSet();
        for (String el: store) {
            result.put(el);
        }
        for (String elem: set2.store) {
            if (!result.get(elem)){
                result.put(elem);
            }
        }

        return result;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet result = new PowerSet();
        for (String el: store) {
            if (!set2.get(el)) {
                result.put(el);
            }
        }

        return result;
    }

    public boolean isSubset(PowerSet set2)
    {
        for (String el: set2.store) {
            if (!get(el)) {
                return false;
            }
        }

        return true;
    }

    // 10-4 Cartesian Product
    public PowerSet cartesianMultiply(PowerSet set2){
        PowerSet result = new PowerSet();
        for (String el: store) {
            for (String innerElem: set2.store) {
                result.put(el + "|" + innerElem);
            }
        }

        return result;
    }

    public boolean equals(PowerSet set2)
    {
        if (set2.size() != this.size()){
            return false;
        }

        for (String el: store) {
            if (!set2.get(el)) {
                return false;
            }
        }

        return true;
    }

}



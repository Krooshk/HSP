import java.util.*;

// 10-1,2 PowerSet & methods
public class PowerSet<T>
{
    HashTable<T> store;
    private int _count;

    public PowerSet()
    {
        _count = 0;
        store = new HashTable(20000, 3);
    }

    public int size()
    {
        return _count;
    }

    public void put(String value)
    {
        if (store.find(value) >= 0) return;
        store.put(value);
        _count++;

    }

    public boolean get(String value)
    {
        return store.find(value) >= 0;
    }

    public boolean remove(String value)
    {
        int pos = store.find(value);
        if (pos < 0) return false;
        store.slots[pos] = null;
        _count--;
        return true;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet result = new PowerSet();
        for (String el: store.slots) {
            if (el == null) continue;
            if (set2.get(el)) {
                result.put(el);
            }
        }

        if (result.size() == 0) return null;
        return result;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet result = new PowerSet();
        for (String el: store.slots) {
            if (el == null) continue;
            result.put(el);
        }
        for (String elem: set2.store.slots) {
            if (elem == null) continue;
            if (!result.get(elem)){
                result.put(elem);
            }
        }

        if (result.size() == 0) return null;

        return result;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet result = new PowerSet();
        for (String el: store.slots) {
            if (el == null) continue;
            if (!set2.get(el)) {
                result.put(el);
            }
        }

        if (result.size() == 0) return null;
        return result;
    }

    public boolean isSubset(PowerSet set2)
    {
        for (String el: set2.store.slots) {
            if (el == null) continue;
            if (!this.get(el)) {
                return false;
            }
        }

        return true;
    }

    // 10-4 Cartesian Product
    public PowerSet<T> cartesianMultiply(PowerSet set2){
        PowerSet result = new PowerSet();
        for (String el: store.slots) {
            if (el == null) continue;
            for (String innerElem: set2.store.slots) {
                if (innerElem == null) continue;
                result.put(el + "|" + innerElem);
            }
        }

        if (result.size() == 0) return null;

        return result;
    }

    public boolean equals(PowerSet<T> set2)
    {
        if (set2.size() != this.size()){
            return false;
        }

        for (String el: store.slots) {
            if (el == null) continue;
            if (!set2.get(el)) {
                return false;
            }
        }

        return true;
    }

}

class HashTable<T>
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += (int) value.charAt(i);
        }

        return sum % size;
    }

    public int seekSlot(String value)
    {
        int count = step;
        int index = hashFun(value);
        if (slots[index] == null) {
            return index;
        }
        for (;count >= 1;) {
            for (int i = 0; i < size; i++) {
                int pretendent = index + i * step;
                int position = pretendent;
                if (pretendent >= size) {
                    position = pretendent % size;
                    if (position >= index) break;
                }
                if (slots[position] == null) {
                    return position;
                }
            }
            count--;
        }

        return -1;
    }

    public int put(String value)
    {
        int place = seekSlot(value);
        if (place >= 0){
            slots[place] = value;
            return place;
        }

        return -1;
    }

    public int find(String value)
    {
        int count = step;
        int index = hashFun(value);
        if (value == slots[index]) {
            return index;
        }
        for (;count >= 1;) {
            for (int i = 0; i < size; i++) {
                int pretendent = index + i * step;
                int position = pretendent;
                if (pretendent >= size) {
                    position = pretendent % size;
                    if (position >= index) break;
                }
                if (slots[position] == value) {
                    return position;
                }
            }
            count--;
        }

        return -1;
    }
}


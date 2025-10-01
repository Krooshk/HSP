import java.util.HashMap;

//10-6 Bag
public class Bag {
    HashMap<String, Integer> _store ;

    public Bag() {
        _store = new HashMap<String, Integer>();
    }
    public void put(String el){
        Integer quantity = _store.get(el);
        if (quantity != null) {
            _store.put(el, 1);
        } else {
            _store.put(el, quantity + 1);
        }
    }

    public boolean remove(String el) {
        Integer quantity = _store.get(el);
        if (quantity == 1) {
            _store.remove(el);
            return true;
        } else {
            _store.put(el, quantity - 1);
            return false;
        }
    }

    public HashMap<String, Integer> getAll(){
        return _store;
    }
}


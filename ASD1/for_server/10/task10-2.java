import java.util.List;

public class AdditionalPowerSet {
    public PowerSet intersectionManySets(List<PowerSet> list){
        if (list.size() == 0) return null;
        PowerSet result = new PowerSet();
        PowerSet main = list.get(0);

        for (String el: main.store) {
            if (el == null) continue;

            boolean everywhere = true;
            for (int i = 1; i < list.size(); i++) {
                if (!list.get(i).get(el)){
                    everywhere = false;
                    break;
                }
            }

            if (everywhere) {
                result.put(el);
            }
        }

        if (result.size() == 0) return null;
        return result;
    }

}

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




import java.util.List;

public class AdditionalPowerSet {
    public PowerSet intersectionManySets(List<PowerSet<String>> list){
        if (list.size() == 0) return null;
        PowerSet result = new PowerSet();
        PowerSet main = list.get(0);

        for (String el: main.store.slots) {
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

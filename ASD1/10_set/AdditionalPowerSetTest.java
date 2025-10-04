import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalPowerSetTest {

    @Test void cartesianProductTest() {
        PowerSet mySet1 = new PowerSet();
        PowerSet mySet2 = new PowerSet();
        PowerSet mySet3 = new PowerSet();
        AdditionalPowerSet additionalPS = new AdditionalPowerSet();
        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("2");
        mySet2.put("3");
        mySet2.put("4");
        mySet3.put("3");
        mySet3.put("4");
        mySet3.put("5");
        List list = new LinkedList();
        list.add(mySet1);
        list.add(mySet2);
        list.add(mySet3);

        PowerSet result = additionalPS.intersectionManySets(list);

        assertEquals(result.size(), 1);
    }

}
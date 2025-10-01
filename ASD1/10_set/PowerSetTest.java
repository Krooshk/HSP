import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// 10-3 Tests
class PowerSetTest {
    @Test public void addValue(){
        PowerSet<String> mySet = new PowerSet<>();

        mySet.put("example");

        assertEquals(mySet.size(), 1);
    }

    @Test public void addExistValue(){
        PowerSet<String> mySet = new PowerSet<>();

        mySet.put("example");
        mySet.put("example");

        assertEquals(mySet.size(), 1);
    }

    @Test public void removeExistValue(){
        PowerSet<String> mySet = new PowerSet<>();

        mySet.put("example");
        mySet.remove("example");

        assertEquals(mySet.size(), 0);
    }

    @Test public void intersectionNull(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("4");
        mySet2.put("5");
        mySet2.put("6");

        assertEquals(mySet1.intersection(mySet2), null);
    }

    @Test public void intersection(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("2");
        mySet2.put("3");
        mySet2.put("4");

        assertEquals(mySet1.intersection(mySet2).size(), 2);
    }

    @Test public void union(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("1");
        mySet2.put("2");
        mySet2.put("3");
        mySet2.put("4");

        assertEquals(mySet1.union(mySet2).size(), 4);
    }

    @Test public void unionEmtySet(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");

        assertEquals(mySet1.union(mySet2).equals(mySet1), true);
    }

    @Test public void differenceEmpty(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("1");
        mySet2.put("2");
        mySet2.put("3");

        assertEquals(mySet1.difference(mySet2), null);
    }

    @Test public void difference(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("1");
        mySet2.put("2");

        assertEquals(mySet1.difference(mySet2).size(), 1);
    }

    @Test public void isSubsetAll(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("1");
        mySet2.put("2");
        mySet2.put("3");

        assertEquals(mySet1.isSubset(mySet2), true);
    }

    @Test public void isSubsetPart(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("1");
        mySet2.put("2");

        assertEquals(mySet1.isSubset(mySet2), true);
    }

    @Test public void isSubsetWrong(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("1");
        mySet2.put("2");
        mySet2.put("4");

        assertEquals(mySet1.isSubset(mySet2), false);
    }

    @Test public void notEquals(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("1");
        mySet2.put("2");
        mySet2.put("4");

        assertEquals(mySet1.equals(mySet2), false);
    }

    @Test public void equals(){
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("1");
        mySet2.put("2");
        mySet2.put("3");

        assertEquals(mySet1.equals(mySet2), true);
    }

    @Test void quickPerformanceTest() {
        int testSize = 10000;
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();
        for (int i = 0; i < testSize; i++) {
            mySet1.put("v1_" + i);
            mySet2.put("v2_" + i);
        }
        for (int i = 0; i < 2000; i++) {
            String common = "v_" + i;
            mySet1.put(common);
            mySet2.put(common);
        }
        long startTime = System.currentTimeMillis();

        mySet1.intersection(mySet2);
        mySet1.union(mySet2);
        mySet1.difference(mySet2);
        mySet1.isSubset(mySet2);

        long totalTime = System.currentTimeMillis() - startTime;
        assertTrue(totalTime < 2000);
    }

    @Test void cartesianProductTest() {
        PowerSet<String> mySet1 = new PowerSet<>();
        PowerSet<String> mySet2 = new PowerSet<>();

        mySet1.put("1");
        mySet1.put("2");
        mySet1.put("3");
        mySet2.put("1");
        mySet2.put("2");
        mySet2.put("3");

        assertEquals(mySet1.cartesianMultiply(mySet2).size(), 9);
    }
}
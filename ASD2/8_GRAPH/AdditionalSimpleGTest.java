import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalSimpleGTest {
    @Test public void testNotCyclicEasyGraph(){
        int size = 3;
        AdditionalSimpleG sg = new AdditionalSimpleG(size);
        for (int i = 0; i < size; i++){
            sg.AddVertex(33);
        }
        sg.m_adjacency = new int[][]{{0, 1, 0}, {0, 0, 1}, {0, 0, 0}};

        assertFalse(sg.isCyclical());
    }

    @Test public void testLinkedGraph(){
        int size = 5;
        AdditionalSimpleG sg = new AdditionalSimpleG(size);
        for (int i = 0; i < size; i++){
            sg.AddVertex(33);
        }
        sg.m_adjacency = new int[][]{{0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 1, 0, 0, 1}, {0, 0 , 0, 0, 0}};


        assertTrue(sg.isCyclical());
    }

    @Test public void testTwoSeparateGraphOneCycl(){
        int size = 5;
        AdditionalSimpleG sg = new AdditionalSimpleG(size);
        for (int i = 0; i < size; i++){
            sg.AddVertex(33);
        }
        sg.m_adjacency = new int[][]{{0, 1, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};


        assertTrue(sg.isCyclical());
    }

    @Test public void testFiveSeparateGraph(){
        int size = 5;
        AdditionalSimpleG sg = new AdditionalSimpleG(size);
        for (int i = 0; i < size; i++){
            sg.AddVertex(33);
        }
        sg.m_adjacency = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};

        assertFalse(sg.isCyclical());
    }

    @Test public void testFiveSeparateGraphOneCycl(){
        int size = 5;
        AdditionalSimpleG sg = new AdditionalSimpleG(size);
        for (int i = 0; i < size; i++){
            sg.AddVertex(33);
        }
        sg.m_adjacency = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}};

        assertTrue(sg.isCyclical());
    }

}
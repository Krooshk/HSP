import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {
    @Test public void testAddVertex(){
        SimpleGraph sg = new SimpleGraph(3);
        sg.AddVertex(33);
        sg.AddVertex(33);
        sg.AddVertex(33);

        assertEquals(sg.vertex[0].Value, 33);
        assertEquals(sg.vertex[1].Value, 33);
        assertEquals(sg.vertex[2].Value, 33);
    }

    @Test public void testAddVertexSize(){
        SimpleGraph sg = new SimpleGraph(3);
        sg.AddVertex(33);
        sg.AddVertex(33);
        sg.AddVertex(33);

        assertEquals(sg.vertex.length, 3);
    }

    @Test public void testAdjacency(){
        SimpleGraph sg = new SimpleGraph(3);
        int[][] adj = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertArrayEquals(sg.m_adjacency, adj);

        sg.AddVertex(33);
        sg.AddVertex(33);
        sg.AddVertex(33);

        assertArrayEquals(sg.m_adjacency, adj);
    }

    @Test public void testAdjacencyAfterAddEdge(){
        SimpleGraph sg = new SimpleGraph(3);
        sg.AddVertex(33);
        sg.AddVertex(33);
        sg.AddVertex(33);
        int[][] adjBefore = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertArrayEquals(sg.m_adjacency, adjBefore);

        sg.AddEdge(0, 1);
        sg.AddEdge(0, 2);

        int[][] adjAfter = {{0, 1, 1}, {1, 0, 0}, {1, 0, 0}};
        assertArrayEquals(sg.m_adjacency, adjAfter);
    }

    @Test public void testAdjacencyAfterRemoveEdge(){
        SimpleGraph sg = new SimpleGraph(3);
        sg.AddVertex(33);
        sg.AddVertex(33);
        sg.AddVertex(33);
        sg.AddEdge(0, 1);
        sg.AddEdge(0, 2);

        sg.RemoveEdge(0, 2);

        int[][] adj = {{0, 1, 0}, {1, 0, 0}, {0, 0, 0}};
        assertArrayEquals(sg.m_adjacency, adj);
    }

    @Test public void testAdjacencyAfterRemoveVertex(){
        SimpleGraph sg = new SimpleGraph(3);
        sg.AddVertex(33);
        sg.AddVertex(33);
        sg.AddVertex(33);
        sg.AddEdge(0, 1);
        sg.AddEdge(0, 2);

        sg.RemoveVertex(1);

        int[][] adj = {{0, 0, 1}, {0, 0, 0}, {1, 0, 0}};
        assertArrayEquals(sg.m_adjacency, adj);
    }
}

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



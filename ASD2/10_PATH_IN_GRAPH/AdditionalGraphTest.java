import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalGraphTest {
    @Test public void testRegresHardPathConnected(){
        int size = 7;
        AdditionalGraph sg = new AdditionalGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddVertex(44);
        sg.AddVertex(55);
        sg.AddVertex(66);
        sg.AddEdge(0, 1);
        sg.AddEdge(0, 2);
        sg.AddEdge(1, 2);
        sg.AddEdge(2, 3);
        sg.AddEdge(3, 4);
        sg.AddEdge(3, 5);
        sg.AddEdge(4, 5);
        sg.AddEdge(5, 6);

        ArrayList<Vertex> list = new ArrayList<>();
        list.add(sg.vertex[0]);
        list.add(sg.vertex[1]);
        list.add(sg.vertex[2]);
        list.add(sg.vertex[3]);
        list.add(sg.vertex[4]);
        list.add(sg.vertex[5]);
        list.add(sg.vertex[6]);

        assertTrue(sg.isConnectedGraph());
    }

    @Test public void testRegresHardPathNotConnected(){
        int size = 7;
        AdditionalGraph sg = new AdditionalGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddVertex(44);
        sg.AddVertex(55);
        sg.AddVertex(66);
        sg.AddEdge(0, 1);
        sg.AddEdge(0, 2);
        sg.AddEdge(1, 2);
        sg.AddEdge(3, 4);
        sg.AddEdge(3, 5);
        sg.AddEdge(4, 5);
        sg.AddEdge(5, 6);

        ArrayList<Vertex> list = new ArrayList<>();
        list.add(sg.vertex[0]);
        list.add(sg.vertex[1]);
        list.add(sg.vertex[2]);
        list.add(sg.vertex[3]);
        list.add(sg.vertex[4]);
        list.add(sg.vertex[5]);
        list.add(sg.vertex[6]);

        assertFalse(sg.isConnectedGraph());
    }

    @Test public void testRegresLongest(){
        int size = 5;
        AdditionalGraph sg = new AdditionalGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddVertex(44);
        sg.m_adjacency = new int[][]{{0,1,0,0,0}, {0,0,1,1,0},{1,0,0,0,0},{0,0,0,0,1},{0,0,0,0,0}};

        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        result.add(3);
        result.add(4);
        assertEquals(sg.longest(), result);
    }
}
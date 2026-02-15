import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimpleGraphTest {
    @Test
    public void testRegres(){
        int size = 4;
        SimpleGraph sg = new SimpleGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddEdge(0, 1);
        sg.AddEdge(1, 3);
        sg.AddEdge(1, 2);

        ArrayList<Vertex> list = new ArrayList<>();
        list.add(sg.vertex[0]);
        list.add(sg.vertex[1]);
        list.add(sg.vertex[2]);

        assertEquals(sg.DepthFirstSearch(0, 2), list);
    }

    @Test public void testRegres2(){
        int size = 4;
        SimpleGraph sg = new SimpleGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddEdge(0, 1);
        sg.AddEdge(1, 3);
        sg.AddEdge(3, 2);

        ArrayList<Vertex> list = new ArrayList<>();
        list.add(sg.vertex[0]);
        list.add(sg.vertex[1]);
        list.add(sg.vertex[3]);
        list.add(sg.vertex[2]);

        assertEquals(sg.DepthFirstSearch(0, 2), list);
    }

    @Test public void testRegresHardPath(){
        int size = 7;
        SimpleGraph sg = new SimpleGraph(size);
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

        assertEquals(sg.DepthFirstSearch(0, 6), list);
    }

    @Test public void testNotPath(){
        int size = 4;
        SimpleGraph sg = new SimpleGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddEdge(0, 1);
        sg.AddEdge(1, 3);

        ArrayList<Vertex> list = new ArrayList<>();

        assertEquals(sg.DepthFirstSearch(0, 2), list);
    }


}
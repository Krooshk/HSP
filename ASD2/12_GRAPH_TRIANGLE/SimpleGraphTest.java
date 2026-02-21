import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class SimpleGraphTest {
    @Test public void testNoEdges(){
        int size = 4;
        SimpleGraph sg = new SimpleGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        ArrayList<Vertex> list = new ArrayList<>();
        list.add(sg.vertex[0]);
        list.add(sg.vertex[1]);
        list.add(sg.vertex[2]);
        list.add(sg.vertex[3]);

        assertEquals(sg.WeakVertices(), list);
    }

    @Test public void testEmpty(){
        int size = 0;
        SimpleGraph sg = new SimpleGraph(size);
        ArrayList<Vertex> list = new ArrayList<>();

        assertEquals(sg.WeakVertices(), list);
    }

    @Test public void testSeparateOne(){
        int size = 4;
        SimpleGraph sg = new SimpleGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddEdge(0,1);
        sg.AddEdge(0,2);
        sg.AddEdge(1,2);
        ArrayList<Vertex> list = new ArrayList<>();
        list.add(sg.vertex[3]);

        assertEquals(sg.WeakVertices(), list);
    }

    @Test public void testConnectedOne(){
        int size = 4;
        SimpleGraph sg = new SimpleGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddEdge(0,1);
        sg.AddEdge(0,2);
        sg.AddEdge(1,2);
        sg.AddEdge(2,3);
        ArrayList<Vertex> list = new ArrayList<>();
        list.add(sg.vertex[3]);

        assertEquals(sg.WeakVertices(), list);
    }

    @Test public void testNoWeak(){
        int size = 3;
        SimpleGraph sg = new SimpleGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddEdge(0,1);
        sg.AddEdge(0,2);
        sg.AddEdge(1,2);
        ArrayList<Vertex> list = new ArrayList<>();

        assertEquals(sg.WeakVertices(), list);
    }

    @Test public void testRegres(){
        int size = 9;
        SimpleGraph sg = new SimpleGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddVertex(44);
        sg.AddVertex(55);
        sg.AddVertex(66);
        sg.AddVertex(77);
        sg.AddVertex(88);
        sg.AddEdge(0,1);
        sg.AddEdge(0,2);
        sg.AddEdge(0,3);
        sg.AddEdge(2,3);
        sg.AddEdge(2,7);
        sg.AddEdge(3,7);
        sg.AddEdge(1,4);
        sg.AddEdge(3,4);
        sg.AddEdge(4,5);
        sg.AddEdge(4,6);
        sg.AddEdge(5,6);
        sg.AddEdge(6,8);
        ArrayList<Vertex> list = new ArrayList<>();
        list.add(sg.vertex[1]);
        list.add(sg.vertex[8]);

        assertEquals(sg.WeakVertices(), list);
    }
}
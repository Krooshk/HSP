import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdditonalGraphTest {
    @Test public void testRegresNotEdges(){
        int size = 4;
        AdditonalGraph sg = new AdditonalGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);

        assertEquals(sg.getMaxRemoteNode(), 0);
    }

    @Test public void testRegresEmpty(){
        int size = 0;
        AdditonalGraph sg = new AdditonalGraph(size);

        assertEquals(sg.getMaxRemoteNode(), 0);
    }

    @Test public void testRegres(){
        int size = 8;
        AdditonalGraph sg = new AdditonalGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddVertex(44);
        sg.AddVertex(55);
        sg.AddVertex(66);
        sg.AddVertex(77);
        sg.AddEdge(0, 1);
        sg.AddEdge(0, 2);
        sg.AddEdge(1, 3);
        sg.AddEdge(1, 4);
        sg.AddEdge(1, 5);
        sg.AddEdge(2, 6);
        sg.AddEdge(2, 7);

        assertEquals(sg.getMaxRemoteNode(), 4);
    }

    @Test public void testRegres2(){
        int size = 6;
        AdditonalGraph sg = new AdditonalGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddVertex(33);
        sg.AddVertex(44);
        sg.AddVertex(55);
        sg.AddEdge(0, 1);
        sg.AddEdge(0, 2);
        sg.AddEdge(0, 3);
        sg.AddEdge(1, 4);
        sg.AddEdge(1, 5);

        assertEquals(sg.getMaxRemoteNode(), 3);
    }

    @Test public void testCycleRegres(){
        int size = 3;
        AdditonalGraph sg = new AdditonalGraph(size);
        sg.AddVertex(00);
        sg.AddVertex(11);
        sg.AddVertex(22);
        sg.AddEdge(0, 1);
        sg.AddEdge(0, 2);
        sg.AddEdge(1, 2);

        assertEquals(sg.getCycles().size(), 1);
    }
}
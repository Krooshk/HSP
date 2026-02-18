import java.util.*;

class Vertex
{
    public int Value;
    public boolean Hit;
    public Vertex(int val)
    {
        Value = val;
        Hit = false;
    }
}

class SimpleGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;

    public SimpleGraph(int size)
    {
        max_vertex = size;
        m_adjacency = new int [size][size];
        vertex = new Vertex[size];
    }

    public void AddVertex(int value)
    {
        int index = find();
        if (index < 0) return;
        vertex[index] = new Vertex(value);
    }

    private int find(){
        for (int i = 0; i < max_vertex; i++){
            if (vertex[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void RemoveVertex(int v)
    {
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[v][i] = 0;
            m_adjacency[i][v] = 0;
        }
        vertex[v] = null;
    }

    public boolean IsEdge(int v1, int v2)
    {
        return m_adjacency[v1][v2] == 1;
    }

    public void AddEdge(int v1, int v2)
    {
        m_adjacency[v1][v2] = 1;
        m_adjacency[v2][v1] = 1;
    }

    public void RemoveEdge(int v1, int v2)
    {
        m_adjacency[v1][v2] = 0;
        m_adjacency[v2][v1] = 0;
    }

    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo)
    {
        ArrayList<Vertex> stack = new ArrayList<>();
        return helperDFS(VFrom, VTo, stack);
    }

    private ArrayList<Vertex> helperDFS(int start, int end, ArrayList<Vertex> stack){
        if (!vertex[start].Hit) stack.add(vertex[start]);
        vertex[start].Hit = true;

        int[] currentV = m_adjacency[start];
        for (int i = 0; i < currentV.length; i++) {
            if (currentV[i] == 1 && i == end) {
                stack.add(vertex[i]);
                return stack;
            }
        }

        for (int i = 0; i < currentV.length; i++) {
            ArrayList<Vertex> list = null;
            if (currentV[i] == 1 && !vertex[i].Hit) {
                list = helperDFS(i, end, stack);
            }
            if (list != null && list.size() > 0) return list;
        }

        if (stack.isEmpty()) return new ArrayList<Vertex>();

        Vertex elem = stack.removeLast();
        int indx = Arrays.asList(vertex).indexOf(elem);
        return helperDFS(indx, end, stack);
    }

    // Task 1 BreadthFirstSearch Time - O(N), Space - O(N)
    public ArrayList<Vertex> BreadthFirstSearch(int VFrom, int VTo)
    {
        for (int i = 0; i < vertex.length; i++){
            if (vertex[i] != null) vertex[i].Hit = false;
        }
        ArrayList<Integer> queue = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        vertex[VFrom].Hit = true;
        return helperBFS(VFrom, VTo, queue, map);
    }

    private ArrayList<Vertex> helperBFS(int start, int end, ArrayList<Integer> queue, HashMap<Integer, Integer> map){

        int[] currentV = m_adjacency[start];
        for (int i = 0; i < currentV.length; i++) {
            boolean isSuit = currentV[i] == 1 && !vertex[i].Hit;
            if (isSuit && i == end) {
                map.put(i, start);
                return buildPath(end, map);
            }
            if (isSuit) {
                vertex[i].Hit = true;
                queue.addLast(i);
                map.put(i, start);
                return helperBFS(start, end, queue, map);
            }
        }

        if (queue.isEmpty()) return new ArrayList<Vertex>();

        Integer elem = queue.removeFirst();
        return helperBFS(elem, end, queue, map);
    }

    private ArrayList<Vertex> buildPath(int end, HashMap<Integer, Integer> map){
        ArrayList<Integer> result = new ArrayList<>();
        Integer curr = end;

        for (;curr != null;) {
            result.addFirst(curr);
            curr = map.get(curr);
        }

        List<Vertex> list = result.stream().map(el -> vertex[el]).toList();
        return new ArrayList<>(list);
    }

}
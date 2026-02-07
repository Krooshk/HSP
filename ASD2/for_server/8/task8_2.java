import java.util.ArrayList;
import java.util.HashSet;

public class AdditionalSimpleG {
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;

    public AdditionalSimpleG(int size)
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

    // Task 1 RemoveVertex Time - O(1), Space - O(1)
    public void RemoveVertex(int v)
    {
        for (int i = 0; i < max_vertex; i++) {
            m_adjacency[v][i] = 0;
            m_adjacency[i][v] = 0;
        }
        vertex[v] = null;
    }

    // Task 1 IsEdge Time - O(1), Space - O(1)
    public boolean IsEdgeOneSide(int from, int to)
    {
        return m_adjacency[from][to] == 1;
    }

    // Task 1 AddEdge Time - O(1), Space - O(1)
    public void AddEdgeOneSide(int from, int to)
    {
        m_adjacency[from][to] = 1;
    }

    // Task 1 RemoveEdge Time - O(1), Space - O(1)
    public void RemoveEdgeOneSide(int from, int to )
    {
        m_adjacency[from][to] = 0;
    }

    // Task 2*, Time - O(N^2), Space - O(N)
    public boolean isCyclical(){
        ArrayList list = new ArrayList();
        HashSet visited = new HashSet<>();
        return helperCyclical(list, 0, visited);
    }

    private boolean helperCyclical(ArrayList prev, int index, HashSet set){
        set.add(index);
        ArrayList copy = new ArrayList<>(prev);
        copy.add(index);
        for (int i = 0; i < max_vertex; i++){
            if (m_adjacency[index][i] == 1 && prev.contains(i)){
                return true;
            }
            if (m_adjacency[index][i] == 1) {
                return helperCyclical(copy, i, set);
            }
        }

        for (int i = 0; i < max_vertex; i++){
            if (set.contains(i)) continue;
            ArrayList list = new ArrayList();
            return helperCyclical(list, i, set);
        }

        return false;
    }
}

// ## Рекомендации по решению задач задания 6.
//
//### 2.  Проверка, правильно ли распределены значения в двоичном дереве .
//    Сделал аналогичным образом.
//
//### 3. Проверка, сбалансировано ли двоичное дерево .
//    Сделал аналогичным образом.




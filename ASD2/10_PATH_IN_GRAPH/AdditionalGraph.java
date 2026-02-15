import java.util.*;

class AdditionalGraph
{
    Vertex [] vertex;
    int [][] m_adjacency;
    int max_vertex;

    public AdditionalGraph(int size)
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

    // Task 0 DepthFirstSearch, Time - O(N), Space - O(N)
    public ArrayList<Vertex> DepthFirstSearch(int VFrom, int VTo)
    {
        for (Vertex v: vertex){
            v.Hit = false;
        }
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

    // Task 1* isConnectedGraph, Time - O(N), Space - O(N)
    boolean isConnectedGraph() {
        HashSet set = new HashSet();
        return helperConnected(0, set).size() == max_vertex;

    }

    private HashSet<Vertex> helperConnected(int start, HashSet<Vertex> set){
        set.add(vertex[start]);

        int[] currentV = m_adjacency[start];
        for (int i = 0; i < currentV.length; i++) {
            if (currentV[i] == 1 && !set.contains(vertex[i])) {
                helperConnected(i, set);
            }
        }

        return set;
    }

    // Task 2* longest, Time - O(N), Space - O(N)
    ArrayList<Integer> longest() {
        ArrayList<Integer> list = new ArrayList<>();
        return helperLongest(0, list);
    }

    private ArrayList<Integer> helperLongest(int start,ArrayList<Integer> list) {
        ArrayList copy = new ArrayList<>(list);
        copy.add(start);
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        int[] currentV = m_adjacency[start];
        for (int i = 0; i < currentV.length; i++) {
            if (currentV[i] == 1 && copy.contains(i)) {
                paths.add(copy);
                continue;
            }
            if (currentV[i] == 1) {
                paths.add(helperLongest(i, copy));
            }
        }

        if (paths.size() == 0) {
            return copy;
        }

        if (paths.size() == 1) {
            return paths.get(0);
        }

        ArrayList<Integer> first = paths.get(0);
        ArrayList<Integer> second = paths.get(1);

        return first.size() > second.size() ? first : second;
    }
}

// _Рекомендации по решению задач задания 8.
// __Направленный граф, представленный матрицей смежности.
// Реализовал методы, чтобы добавить связь только в одном направлении, но в реализации так же мог задать направление и в другую сторону, если бы поменял аргументы местами.
// Сделал аналогичным образом для проверки на цикличность. Множество мне нужно было в случае, если граф несвязный, чтобы запустить дальше проверку на цикличность в другом "куске".
// Список служил для хранение посещенных вершин, если там уже была вершина, то цикличность присутствует.
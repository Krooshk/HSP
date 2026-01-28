import java.util.*;

class BSTNode
{
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок
    public int     Level; // глубина узла

    public BSTNode(int key, BSTNode parent)
    {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST
{
    public BSTNode Root; // корень дерева

    public BalancedBST()
    {
        Root = null;
    }

    public void GenerateTree(int[] a)
    {
        int[] copyArray = Arrays.copyOf(a, a.length);
        Arrays.sort(copyArray);


        helperGenerate(null, copyArray);
    }

    BSTNode helperGenerate(BSTNode parent, int[] arr) {
        if (arr.length == 0) return null;

        int index = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, index);
        int[] right = Arrays.copyOfRange(arr, index + 1, arr.length);
        BSTNode node = new BSTNode(arr[index], parent);
        if (parent == null) Root = node;
        node.Level = parent == null ? 0 : parent.Level + 1;
        node.LeftChild = helperGenerate(node, left);
        node.RightChild = helperGenerate(node, right);

        return node;
    }

    // Для тестирования
    ArrayList<Integer> WideAllNodes() {
        ArrayList<Integer> list = new ArrayList<>();
        List<BSTNode> workList = new ArrayList<>();
        workList.add(Root);

        while (!workList.isEmpty()) {
            BSTNode node = workList.removeFirst();
            if (node == null) continue;
            list.add(node.NodeKey);
            workList.add(node.LeftChild);
            workList.add(node.RightChild);
        }

        return list;
    }

    public boolean IsBalanced(BSTNode root_node)
    {
        return false; // сбалансировано ли дерево с корнем root_node
    }
}
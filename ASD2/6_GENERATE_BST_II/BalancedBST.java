import java.util.*;

class BSTNode
{
    public int NodeKey;
    public BSTNode Parent;
    public BSTNode LeftChild;
    public BSTNode RightChild;
    public int     Level;

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
    public BSTNode Root;

    public BalancedBST()
    {
        Root = null;
    }

    // Task 1 , Time - O(N), Space - O(N)
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

    // For test
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

    // Task 2* , Time - O(N), Space - O(1)
    public boolean IsProperBST(BSTNode root_node) {
        ArrayList<Boolean> checks = new ArrayList<Boolean>();
        if (root_node == null) {
            return true;
        }

        boolean isExistRight = root_node.RightChild != null;
        boolean isExistLeft = root_node.LeftChild != null;
        boolean isNodeBiggerRight = isExistRight && root_node.NodeKey > root_node.RightChild.NodeKey;
        boolean isLeftBiggerOrEqNode = isExistLeft && root_node.NodeKey <= root_node.LeftChild.NodeKey;

        if (isNodeBiggerRight || isLeftBiggerOrEqNode) {
            return false;
        }

        checks.add(IsProperBST(root_node.LeftChild));
        checks.add(IsProperBST(root_node.RightChild));

        return checks.stream().filter(el -> !el).toArray().length == 0;
    };

    // Task 3* , Time(O(N^2)), Space(1)
    public boolean IsBalanced(BSTNode root_node)
    {
        if (root_node == null) return true;

        int left = root_node.LeftChild != null ? maxLevel(root_node.LeftChild) : root_node.Level;
        int right = root_node.RightChild != null ? maxLevel(root_node.RightChild): root_node.Level;
        if (Math.abs(right - left) >= 2) {
            return false;
        }

        boolean isLeftBalance = IsBalanced(root_node.LeftChild);
        boolean isRightBalance = IsBalanced(root_node.RightChild);

        return isLeftBalance && isRightBalance;
    }

    Integer maxLevel(BSTNode node) {
        Integer max = node.Level;
        if (node.LeftChild == null && node.RightChild == null) {
            return max;
        }

        if (node.LeftChild != null) {
            max = Math.max(max, maxLevel(node.LeftChild));
        }

        if (node.RightChild != null) {
            max = Math.max(max, maxLevel(node.RightChild));
        }

        return max;
    }
}
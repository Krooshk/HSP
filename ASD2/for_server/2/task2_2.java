import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class BSTAdditional<T>
{
    BSTNode<T> Root; // корень дерева, или null

    public BSTAdditional(BSTNode<T> node)
    {
        Root = node;
    }

    // FindNodeByKey, Time - O(logN), Space - O(1)
    public BSTFind<T> FindNodeByKey(int key)
    {

        if (Root == null) {
            return null;
        }

        return traverseFindNodeByKey(key, Root);
    }

    private BSTFind<T> traverseFindNodeByKey(int key, BSTNode<T> node){
        if (node.NodeKey == key) {
            BSTFind<T> bstFind = new BSTFind<>();
            bstFind.Node = node;
            bstFind.NodeHasKey = true;
            return bstFind;
        }

        if (key < node.NodeKey && node.LeftChild == null) {
            BSTFind<T> bstFind = new BSTFind<>();
            bstFind.Node = node;
            bstFind.NodeHasKey = false;
            bstFind.ToLeft = true;
            return bstFind;
        }

        if (key > node.NodeKey && node.RightChild == null) {
            BSTFind<T> bstFind = new BSTFind<>();
            bstFind.Node = node;
            bstFind.NodeHasKey = false;
            bstFind.ToLeft = false;
            return bstFind;
        }

        BSTFind<T> result = key < node.NodeKey ? traverseFindNodeByKey(key, node.LeftChild) : traverseFindNodeByKey(key, node.RightChild);
        return result;

    }

    // AddKeyValue, Time - O(logN), Space - O(1)
    public boolean AddKeyValue(int key, T val)
    {
        BSTFind<T> interimResultFindKey = FindNodeByKey(key);
        if (interimResultFindKey == null) {
            Root = new BSTNode<>(key, val, null);
            return true;
        }
        if (interimResultFindKey.NodeHasKey) return false;
        BSTNode<T> newNode = new BSTNode<>(key, val, interimResultFindKey.Node);

        if (interimResultFindKey.ToLeft) {
            interimResultFindKey.Node.LeftChild = newNode;
            return true;
        }

        interimResultFindKey.Node.RightChild = newNode;
        return true;
    }

    // FinMinMax, Time - O(logN), Space - O(1)
    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax)
    {
        if (FromNode == null) return null;

        return traverseExtremum(FindMax, FromNode);
    }

    private BSTNode<T> traverseExtremum(boolean isMax, BSTNode<T> node) {
        if (isMax && node.RightChild == null){
            return node;
        }

        if (!isMax && node.LeftChild == null){
            return node;
        }

        if (isMax) {
            return traverseExtremum(isMax, node.RightChild);
        }

        return traverseExtremum(isMax, node.LeftChild);
    }

    // DeleteNodeByKey, Time - O(logN), Space - O(1)
    public boolean DeleteNodeByKey(int key)
    {
        BSTFind<T> interimResultFindKey = FindNodeByKey(key);
        BSTNode<T> toDeletedNode = interimResultFindKey.Node;
        if (!interimResultFindKey.NodeHasKey) return false;

        boolean isHasRightChild = toDeletedNode.RightChild != null;
        boolean isHasLeftChild = toDeletedNode.LeftChild != null;
        boolean isHasOneChild = ((isHasRightChild && !isHasLeftChild) || (!isHasRightChild && isHasLeftChild));

        if (!isHasRightChild && !isHasLeftChild && toDeletedNode.Parent == null) {
            Root = null;
            return true;
        }

        if (!isHasRightChild && !isHasLeftChild) {
            removeConnectionWithParent(toDeletedNode);
            return true;
        }

        if (isHasOneChild) {
            BSTNode<T> child = toDeletedNode.RightChild != null ? toDeletedNode.RightChild : toDeletedNode.LeftChild;
            connectParentNode(child, toDeletedNode.Parent);
            return true;
        }

        BSTNode<T> replacement = FinMinMax(toDeletedNode.RightChild, false);
        connectParentNode(replacement.RightChild, replacement.Parent);

        replacement.RightChild = toDeletedNode.RightChild == replacement ? null : toDeletedNode.RightChild;
        replacement.LeftChild = toDeletedNode.LeftChild == replacement ? null : toDeletedNode.LeftChild;

        removeConnectionWithParent(replacement);
        connectParentNode(replacement, toDeletedNode.Parent);

        return true;
    }

    private void removeConnectionWithParent(BSTNode<T> node){
        if (node.Parent.NodeKey > node.NodeKey) {
            node.Parent.LeftChild = null;
            return;
        }

        node.Parent.RightChild = null;
    }

    private void connectParentNode(BSTNode<T> node, BSTNode<T> parent){
        if (node == null) return;

        node.Parent = parent;

        if (parent == null) {
            Root = node;
            return;
        }
        if (parent.NodeKey > node.NodeKey) {
            node.Parent.LeftChild = node;
            return;
        }
        node.Parent.RightChild = node;
    }

    // Count, Time - O(N), Space - O(1)
    public int Count()
    {
        return traverse(Root);
    }

    private int traverse(BSTNode<T> node) {
        if (node == null) {
            return 0;
        }

        int left = traverse(node.LeftChild);
        int right = traverse(node.RightChild);

        return 1 + left + right;
    }

    // Задание 1, isIdentical, Time - O(N), Space - O(1)
    public boolean isIdentical(BSTNode<T> node) {
        return traverseTwoNode(Root, node);
    }

    public boolean traverseTwoNode(BSTNode<T> node1, BSTNode<T> node2) {
        if ((node1 == null && node2 != null) || (node2 == null && node1 != null)) {
            return false;
        }
        boolean isIdentical = node1.NodeKey == node2.NodeKey && node1.NodeValue == node2.NodeValue;

        if (!isIdentical) {
            return false;
        }
        boolean isLeaf1 = node1.LeftChild == null && node1.RightChild == null;
        boolean isLeaf2 = node2.LeftChild == null && node2.RightChild == null;
        boolean left = true;
        boolean right = true;

        if (isLeaf1 &&  isLeaf2 && isIdentical) {
            return true;
        }

        if (node1.LeftChild != null) {
            left = traverseTwoNode(node1.LeftChild, node2.LeftChild);
        }

        if (node1.RightChild != null) {
            right = traverseTwoNode(node1.RightChild, node2.RightChild);
        }

        return left && right;
    }

    // Задание 2, getAllPath, Time - O(N), Space - O(1)
    public ArrayList<int []> getAllPath(int left) {
        int [] array = new int[left];
        return traverseAllPath(0, left, Root , array);
    }

    public ArrayList<int []> traverseAllPath(int level, int left, BSTNode<T> node, int [] array) {
        ArrayList<int []> result = new ArrayList<>();
        int[] copyArray = Arrays.copyOf(array, array.length);
        copyArray[level] = node.NodeKey;
        if (left == 1 && node.LeftChild == null && node.RightChild == null) {
            ArrayList<int []> list = new ArrayList<>();
            list.add(copyArray);
            return list;
        }

        if (left == 1) {
            ArrayList<int []> list = new ArrayList<>();
            return list;
        }

        if (node.LeftChild != null) {
            ArrayList<int []> leftPath = traverseAllPath(level + 1, left - 1, node.LeftChild, copyArray);
            result.addAll(leftPath);
        }

        if (node.RightChild != null) {
            ArrayList<int []> leftPath = traverseAllPath(level + 1, left - 1, node.RightChild, copyArray);
            result.addAll(leftPath);
        }

        return result;
    }

    // Задание 3, getMaxPath, Time - O(N), Space - O(1)
    public ArrayList<ArrayList<Integer>> getMaxPath() {
        ArrayList<Integer> initialList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = traverseMaxPath( Root, initialList);

        int maxLength = lists.stream()
                .mapToInt(ArrayList::size)
                .max()
                .orElse(0);

        ArrayList<ArrayList<Integer>> result = lists.stream()
                .filter(list -> list != null && list.size() == maxLength)
                .collect(Collectors.toCollection(ArrayList::new));

        return result;
    }

    public ArrayList<ArrayList<Integer>> traverseMaxPath(BSTNode<T> node, ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> copyList = new ArrayList<>(list);
        copyList.add(node.NodeKey);
        if (node.LeftChild == null && node.RightChild == null) {
            result.add(copyList);
            return result;
        }

        if (node.LeftChild != null) {
            ArrayList<ArrayList<Integer>> leftPath = traverseMaxPath(node.LeftChild, copyList);
            result.addAll(leftPath);
        }

        if (node.RightChild != null) {
            ArrayList<ArrayList<Integer>> leftPath = traverseMaxPath(node.RightChild, copyList);
            result.addAll(leftPath);
        }

        return result;
    }

    // Задание 4, isSymmetric, Time - O(N), Space - O(1)
    public boolean isSymmetric() {
        return traverseSym(Root.LeftChild, Root.RightChild);
    }

    public boolean traverseSym(BSTNode<T> left, BSTNode<T> right) {
        if ((left == null && right != null) || (left == null && right != null)) {
            return false;
        }

        boolean leftPath = true;
        boolean rightPath = true;

        if (left.RightChild == null && left.RightChild == null && right.RightChild == null && right.LeftChild == null) {
            return true;
        }

        if (left.LeftChild != null) {
            leftPath = traverseTwoNode(left.LeftChild, right.RightChild);
        }

        if (left.RightChild != null) {
            rightPath = traverseTwoNode(left.RightChild, right.LeftChild);
        }

        return leftPath && rightPath;
    }
}


import java.io.*;
import java.util.*;


class BSTNode<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode<T> Parent; // родитель или null для корня
    public BSTNode<T> LeftChild; // левый потомок
    public BSTNode<T> RightChild; // правый потомок

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если в дереве вообще нету узлов
    public BSTNode<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode<T> Root; // корень дерева, или null

    public BST(BSTNode<T> node)
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

}


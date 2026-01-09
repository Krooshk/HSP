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

    public boolean DeleteNodeByKey(int key)
    {
        BSTFind<T> interimResultFindKey = FindNodeByKey(key);
        if (!interimResultFindKey.NodeHasKey) return false;

        boolean isRoot = interimResultFindKey.Node.Parent == null;
        boolean isHasRightChild = interimResultFindKey.Node.Parent == null;
        boolean isHasLeftChild = interimResultFindKey.Node.Parent == null;
        boolean isRootHasOneChild = isRoot && ((isHasRightChild && !isHasLeftChild) || (!isHasRightChild && isHasLeftChild));


        if (isRootHasOneChild) {
            Root = interimResultFindKey.Node;
            interimResultFindKey.Node.Parent = null;
            return true;
        }

        if (isHasRightChild && isHasLeftChild) {
            BSTNode<T> min = FinMinMax(interimResultFindKey.Node.RightChild, false);

            if (min.RightChild == null) {
                min.RightChild = interimResultFindKey.Node.RightChild;
                min.LeftChild = interimResultFindKey.Node.LeftChild;
                interimResultFindKey.Node.RightChild.Parent = min;
                interimResultFindKey.Node.LeftChild.Parent = min;
                min.Parent.LeftChild = null;
                if(isRoot) {
                    min.Parent = null;
                    Root = min;
                    return true;
                } else {
                    min.Parent = interimResultFindKey.Node.Parent;
                    if (min.NodeKey < interimResultFindKey.Node.Parent.NodeKey) {
                        interimResultFindKey.Node.Parent.LeftChild = min;
                    } else {
                        interimResultFindKey.Node.Parent.RightChild = min;
                    }
                    return true;
                }

            } else {
                interimResultFindKey.Node.RightChild.Parent = min;
                interimResultFindKey.Node.LeftChild.Parent = min;
                min.Parent.RightChild = min.RightChild;
                min.RightChild.Parent = min.Parent;
                min.RightChild = interimResultFindKey.Node.RightChild;
                min.LeftChild = interimResultFindKey.Node.LeftChild;
                if(isRoot) {
                    min.Parent = null;
                    Root = min;
                    return true;
                } else {
                    min.RightChild.Parent = min.Parent;
                    min.Parent = interimResultFindKey.Node.Parent;
                    if (min.NodeKey < interimResultFindKey.Node.Parent.NodeKey) {
                        interimResultFindKey.Node.Parent.LeftChild = min;
                    } else {
                        interimResultFindKey.Node.Parent.RightChild = min;
                    }
                    return true;
                }
            }
        }




        return true;
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
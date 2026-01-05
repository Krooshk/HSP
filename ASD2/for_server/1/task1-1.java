import java.util.*;

public class SimpleTreeNode<T>
{
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null
    public int level;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T>
{
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        NewChild.Parent = ParentNode;
        if (ParentNode.Children == null) {
            List<SimpleTreeNode<T>> list = new ArrayList<>();
            list.add(NewChild);
            ParentNode.Children = list;
        } else {
            ParentNode.Children.add(NewChild);
        }
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        if (NodeToDelete.Parent.Children.size() == 1) {
            NodeToDelete.Parent.Children = null;
        } else {
            NodeToDelete.Parent.Children = NodeToDelete.Parent.Children.stream().filter(el -> el != NodeToDelete).toList();
        }
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        List<SimpleTreeNode<T>> currentNodes = new ArrayList<>();
        List<SimpleTreeNode<T>> list = new ArrayList<>();
        currentNodes.add(Root);

        while (currentNodes.size() != 0) {
            SimpleTreeNode<T> currentNode = currentNodes.removeLast();
            list.add(currentNode);
            if (currentNode.Children != null) {
                for (SimpleTreeNode<T> el : currentNode.Children) {
                    currentNodes.add(el);
                }
            }
        }

        if (list.size() == 0) {
            return null;
        }

        return list;
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        List<SimpleTreeNode<T>> list = new ArrayList<>();
        List<SimpleTreeNode<T>> nodes = new ArrayList<>();
        nodes.add(Root);

        while (nodes.size() != 0) {
            SimpleTreeNode<T> currentNode = nodes.removeLast();
            if (currentNode.NodeValue == val) {
                list.add(currentNode);
            }
            if (currentNode.Children != null) {
                for (SimpleTreeNode<T> el : currentNode.Children) {
                    nodes.add(el);
                }
            }
        }
        if (list.size() == 0) {
            return null;
        }

        return list;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
    {
        if (OriginalNode.Parent.Children.size() == 1) {
            OriginalNode.Parent.Children = null;
        } else {
            OriginalNode.Parent.Children = OriginalNode.Parent.Children.stream().filter(el -> el != OriginalNode).toList();
        }

        if (NewParent.Children == null) {
            List<SimpleTreeNode<T>> list = new ArrayList<>();
            list.add(OriginalNode);
            NewParent.Children = list;
        } else {
            List<SimpleTreeNode<T>> list = new ArrayList<>();
            list.addAll(NewParent.Children);
            list.add(OriginalNode);
            NewParent.Children = list;
        }
        OriginalNode.Parent = NewParent;
    }

    public int Count()
    {
        List<SimpleTreeNode<T>> nodes = new ArrayList<>();
        nodes.add(Root);
        int count = 0;

        while (nodes.size() != 0) {
            SimpleTreeNode<T> currentNode = nodes.removeLast();
            if (currentNode != null) count++;
            if (currentNode.Children != null) {
                for (SimpleTreeNode<T> el : currentNode.Children) {
                    nodes.add(el);
                }
            }
        }

        return count;
    }

    public int LeafCount()
    {
        List<SimpleTreeNode<T>> nodes = new ArrayList<>();
        nodes.add(Root);
        int count = 0;

        while (nodes.size() != 0) {
            SimpleTreeNode<T> currentNode = nodes.removeLast();
            if (currentNode != null && currentNode.Children == null) count++;
            if (currentNode.Children != null) {
                for (SimpleTreeNode<T> el : currentNode.Children) {
                    nodes.add(el);
                }
            }
        }

        return count;
    }

    public void Level()
    {
        setLevel(Root, 1);
    }

    public void setLevel(SimpleTreeNode<T> node, int lev){
        node.level = lev;

        if (node.Children == null) return;

        for (SimpleTreeNode<T> child : node.Children) {
            setLevel(child, lev + 1);
        }
    }
}
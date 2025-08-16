import java.util.ArrayList;

public class LinkedList2WithDummy
{
    private Node2 headDummy;
    private Node2 tailDummy;

    public LinkedList2WithDummy()
    {
        headDummy = new Node2(null);
        tailDummy = new Node2(null);
        headDummy.next = tailDummy;
        tailDummy.prev = headDummy;
    }

    public void addInTail(Node2 _item)
    {
        Node2 prev = tailDummy.prev;
        tailDummy.prev = _item;
        _item.next = tailDummy;
        _item.prev = prev;
        prev.next = _item;
    }

    public Node2 find(int _value)
    {
        Node2 node = headDummy.next;
        while(node.value != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node2> findAll(int _value)
    {
        ArrayList<Node2> nodes = new ArrayList<Node2>();
        Node2 node = headDummy.next;
        while (node.value != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node2 node = headDummy.next;

        while (node.value != null) {
            if (node.value == _value) {
                Node2 prev = node.prev;
                prev.next = node.next;
                node.next.prev = prev;
                return true;
            }

            node = node.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        Node2 node = headDummy.next;

        while (node.value != null) {
            if (node.value == _value) {
                Node2 prev = node.prev;
                prev.next = node.next;
                node.next.prev = prev;
            }
            node = node.next;
        }
    }

    public void clear()
    {
        headDummy.next = tailDummy;
        tailDummy.prev = headDummy;
    }

    public int count()
    {
        int count = 0;
        Node2 node = headDummy.next;
        while (node.value != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node2 _nodeAfter, Node2 _nodeToInsert)
    {
        if (_nodeAfter == null) {
            Node2 next = headDummy.next;
            headDummy.next = _nodeToInsert;
            _nodeToInsert.prev = headDummy;
            _nodeToInsert.next = next;
            next.prev = _nodeToInsert;
            return;
        }

        Node2 node = headDummy.next;
        while (node.value != null) {
            if (_nodeAfter == node) {
                Node2 next = node.next;
                node.next = _nodeToInsert;
                _nodeToInsert.prev = node;
                _nodeToInsert.next = next;
                next.prev = _nodeToInsert;
            }
            node = node.next;
        }
    }
}

class Node2
{
    public Integer value;
    public Node2 next;
    public Node2 prev;

    public Node2(Integer _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
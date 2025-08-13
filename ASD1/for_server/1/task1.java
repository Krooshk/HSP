import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    // 1-4 FindAll, time-O(n), space-O(1)
    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }

        return nodes;
    }

    // 1-1 Remove, time-O(n), space-O(1)
    public boolean remove(int _value)
    {
        Node node = this.head;
        Node prev = null;

        while (node != null) {
            boolean isFit = node.value == _value;
            boolean isNextNull = node.next == null;
            boolean isPrevNull = prev == null;
            if (isFit && isNextNull && !isPrevNull) {
                prev.next = null;
                this.tail = prev;
                return true;
            }
            if (isFit && !isPrevNull) {
                prev.next = node.next;
                return true;
            }
            if (isFit && isPrevNull && !isNextNull) {
                this.head = node.next;
                return true;
            }
            if (isFit && isPrevNull) {
                this.head = null;
                this.tail = null;
                return true;
            }

            prev = node;
            node = node.next;
        }

        return false;
    }

    // 1-2 RemoveAll, time-O(n), space-O(1)
    public void removeAll(int _value)
    {
        Node node = this.head;
        Node prev = null;

        while (node != null) {
            boolean isFit = node.value == _value;
            boolean isNextNull = node.next == null;
            boolean isPrevNull = prev == null;
            if (isFit && isNextNull && !isPrevNull) {
                prev.next = null;
                this.tail = prev;
                return;
            }
            if (isFit && !isPrevNull) {
                prev.next = node.next;
                node = node.next;
                continue;
            }
            if (isFit && isPrevNull && !isNextNull) {
                this.head = node.next;
                node = node.next;
                continue;
            }
            if (isFit && isPrevNull) {
                this.head = null;
                this.tail = null;
                return;
            }

            prev = node;
            node = node.next;
        }
    }

    // 1-3 Cler, time-O(1), space-O(1)
    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    // 1-5 Count, time-O(n), space-O(1)
    public int count()
    {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    // 1-6 Insert, time-O(n), space-O(1)
    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            Node node = this.head;
            this.head = _nodeToInsert;
            this.head.next = node;
            if (this.tail == null) {
                this.tail = this.head;
            }
            return;
        }

        Node node = this.head;
        while (node != null) {
            if (_nodeAfter == node) {
                Node next = node.next;
                node.next = _nodeToInsert;
                _nodeToInsert.next = next;
                if (next == null) {
                    this.tail = _nodeToInsert;
                }
            }
            node = node.next;
        }
    }

}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}



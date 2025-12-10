import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node node = this.head;
        while(node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;

        while (node != null) {
            boolean isFit = node.value == _value;
            boolean isNextNull = node.next == null;
            boolean isPrevNull = node.prev == null;
            if (isFit && isNextNull && !isPrevNull) {
                node.prev.next = null;
                this.tail = node.prev;
                return true;
            }
            if (isFit && !isPrevNull) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                return true;
            }
            if (isFit && isPrevNull && !isNextNull) {
                this.head = node.next;
                node.next.prev = null;
                return true;
            }
            if (isFit && isPrevNull) {
                this.head = null;
                this.tail = null;
                return true;
            }

            node = node.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;

        while (node != null) {
            boolean isFit = node.value == _value;
            boolean isNextNull = node.next == null;
            boolean isPrevNull = node.prev == null;
            // Важно обрабатываеть все случаи:
            // Когда элемент в начале, в конце, в середине, когда элемент один
            if (isFit && isNextNull && !isPrevNull) {
                node.prev.next = null;
                this.tail = node.prev;
                return;
            }
            if (isFit && !isPrevNull) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node = node.next;
                continue;
            }
            if (isFit && isPrevNull && !isNextNull) {
                this.head = node.next;
                node.next.prev = null;
                node = node.next;
                continue;
            }
            if (isFit && isPrevNull) {
                this.head = null;
                this.tail = null;
                return;
            }
            node = node.next;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

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

    public String getStringView()
    {
        String str = "";
        Node node = this.head;
        while (node != null) {
            str += node.value;
            node = node.next;
        }

        return str;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null) {
            Node node = this.head;
            if (node != null) {
                this.head.prev = _nodeToInsert;
            }

            _nodeToInsert.next = node;
            this.head = _nodeToInsert;

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
                _nodeToInsert.prev = node;
                _nodeToInsert.next = next;
                if (next == null) {
                    this.tail = _nodeToInsert;
                } else {
                    next.prev = _nodeToInsert;
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
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}
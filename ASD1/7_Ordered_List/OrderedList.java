import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    // 7-1 ascending
    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    // 7-2 Compare
    // 7-5 CompareGeneric
    public int compare(T v1, T v2)
    {
        if (v1 instanceof Integer && v2 instanceof Integer) {
            return ((Integer) v1) - ((Integer) v2);
        }
        if (v1 instanceof String && v2 instanceof String) {
            String str1 = ((String) v1).trim();
            String str2 = ((String) v2).trim();
            return str1.compareTo(str2);
        }
        return 0;
    }

    // 7-3 add
    public void add(T value)
    {
        if (head == null) {
            this.head = new Node<>(value);
            this.tail = this.head;
        }

        Node<T> curr = this.head;
        for (; curr != null; curr = curr.next ){
            if (this._ascending && compare(curr.value, value) > 0) {
                append(curr, value);
                return;
            }
            if (!this._ascending && compare(curr.value, value) < 0) {
                append(curr, value);
                return;
            }
        }

        if (this._ascending) {
            append(this.tail, value);
        }

        if (!this._ascending) {
            append(this.head, value);
        }


    }

    public void append(Node<T> pretendent, T value) {
        Node<T> newNode = new Node(value);
        if (this._ascending && this.tail == pretendent) {
            Node<T> last = this.tail;
            last.next = newNode;
            newNode.prev = last;
            this.tail = newNode;
            return;
        }
        if (this._ascending) {
            if (pretendent == this.head) {
                this.head = newNode;
                newNode.next = pretendent;
                pretendent.prev = newNode;
                return;
            }
            Node<T> prev = pretendent.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = pretendent;
            pretendent.prev = newNode;
            return;
        }

        if (!this._ascending && this.tail == pretendent) {
            Node<T> first = this.head;
            first.prev = newNode;
            newNode.next = first;
            this.head = newNode;
            return;
        }

        if (!this._ascending) {
            if (pretendent == this.head) {
                this.head = newNode;
                newNode.next = pretendent;
                pretendent.prev = newNode;
                return;
            }
            Node<T> prev = pretendent.prev;
            prev.next = newNode;
            newNode.prev = prev;
            newNode.next = pretendent;
            pretendent.prev = newNode;
        }
    }

    // 7-6 find
    public Node<T> find(T val)
    {
        Node<T> curr = this.head;
        for (; curr != null; curr = curr.next ){
            if (curr.value == val) {
                return curr;
            }
            if (this._ascending && compare(curr.value, val) > 0) {
                return null;
            }
            if (!this._ascending && compare(curr.value, val) < 0) {
                return null;
            }
        }

        return null;
    }

    //  7-4 delete
    public void delete(T val)
    {
        Node<T> curr = this.head;
        for (; curr != null; curr = curr.next ){
            if (curr.value != val) continue;

            if (curr.prev == null && curr.next == null) {
                clear(this._ascending);
                return;
            }
            if (curr.next == null) {
                Node<T> prev = curr.prev;
                prev.next = null;
                this.tail = prev;
                return;
            }
            if (curr.prev == null) {
                Node<T> next = curr.next;
                next.prev = null;
                this.head = next;
                return;
            }

            Node<T> prev = curr.prev;
            Node<T> next = curr.next;
            prev.next = next;
            next.prev = prev;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count()
    {
        int amount = 0;
        Node<T> curr = this.head;
        for (; curr != null; curr = curr.next ){
            amount++;
        }
        return amount;

    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
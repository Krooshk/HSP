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
    boolean isAsc(){
        return this._ascending;
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
    public void add(T value) {
        Node<T> curr = this.head;
        for (;curr != null;){
            int cmpNum = compare(curr.value, value);
            if ((_ascending && cmpNum > 0) || (!_ascending && cmpNum < 0)) {
                insertBefore(curr, value);
                return;
            }
            curr = curr.next;
        }

        insertBefore(null, value);
    }

    private void insertBefore(Node<T> node, T value) {
        Node<T> newNode = new Node<>(value);
        if (node == null) {
            if (tail == null) {
                this.head = tail = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = tail;
                this.tail = newNode;
            }
        } else if (node.prev == null) {
            newNode.next = node;
            node.prev = newNode;
            this.head = newNode;
        } else {
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev.next = newNode;
            node.prev = newNode;
        }
    }

    // 7-6 find
    public Node<T> find(T val) {
        Node<T> curr = this.head;
        for (;curr != null;) {
            int cmp = compare(curr.value, val);
            if (curr.value.equals(val)) return curr;
            if ((this._ascending && cmp > 0) || (!this._ascending && cmp < 0)) break;
            curr = curr.next;
        }
        return null;
    }

    //  7-4 delete
    public void delete(T val) {
        Node<T> node = find(val);
        if (node == null) return;

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            this.head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            this.tail = node.prev;
        }
    }

    public void clear(boolean asc)
    {
        this._ascending = asc;
        this.head = null;
        this.tail = null;
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

    // 7-8* removeDuplicate
    public void removeDuplicate(){
        HashMap<T, Integer> map = new HashMap<>();
        Node<T> curr = this.head;
        for (; curr != null; curr = curr.next ){
            if (map.containsKey(curr.value)) {
                T key = curr.value;
                delete(key);
                map.remove(key);
            } else {
                map.put(curr.value, 1);
            }
        }
    }

    // 7-11* mostFrequently
    public T mostFrequently() {
        HashMap<T, Integer> map = new HashMap<>();
        Node<T> curr = this.head;
        Integer maxCount = null;
        T max = null;

        for (; curr != null; curr = curr.next ){
            T key = curr.value;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (T key : map.keySet()){
            if (maxCount == null) {
                max = key;
                maxCount = map.get(key);
            }
            Integer pretendent = map.get(key);
            if (pretendent > maxCount) {
                max = key;
                maxCount = pretendent;
            }
        }

        return max;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<>();
        Node<T> node = head;
        for (;node != null;)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}



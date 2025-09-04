import java.util.*;

// 7-12*
public class OrderedListV2<T> {
    private ArrayList<T> _store;

    public OrderedListV2(boolean asc) {
        this._store = new ArrayList<>();
    }

    private int compare(T v1, T v2)
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

    private Integer binarySearch(ArrayList<T> list, T value) {
        int low = 0;
        int high = list.size() - 1;

        for ( ;low <= high;) {
            int mid = (low + high) / 2;
            T pretendent = list.get(mid);
            int guess = compare(pretendent, value);

            if (guess == 0) {
                return mid;
            }

            if (guess < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -(low + 1);
    }

    public void add(T value) {
        int pos = binarySearch(_store, value);
        if (pos < 0) pos = -pos - 1;
        _store.add(pos, value);
    }

    public int indexOf(T value) {
        int pos = binarySearch(_store, value);
        return pos >= 0 ? pos : -1;
    }

    public T find(T value) {
        int pos = indexOf(value);
        return pos >= 0 ? _store.get(pos) : null;
    }

    public void delete(T value) {
        int pos = indexOf(value);
        if (pos >= 0) {
            _store.remove(pos);
        }
    }

}

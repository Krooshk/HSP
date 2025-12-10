public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    // TODO: исправить на более оптимальный вариант решения коллизий
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += (int) value.charAt(i);
        }

        return sum % size;
    }

    public int seekSlot(String value)
    {
        int count = step;
        int index = hashFun(value);
        if (slots[index] == null) {
            return index;
        }
        for (;count >= 1;) {
            for (int i = 0; i < size; i++) {
                int pretendent = index + i * step;
                int position = pretendent;
                if (pretendent >= size) {
                    position = pretendent % size;
                    if (position >= index) break;
                }
                if (slots[position] == null) {
                    return position;
                }
            }
            count--;
        }

        return -1;
    }

    public int put(String value)
    {
        int place = seekSlot(value);
        if (place >= 0){
            slots[place] = value;
            return place;
        }

        return -1;
    }

    public int find(String value)
    {
        int count = step;
        int index = hashFun(value);
        if (value == slots[index]) {
            return index;
        }
        for (;count >= 1;) {
            for (int i = 0; i < size; i++) {
                int pretendent = index + i * step;
                int position = pretendent;
                if (pretendent >= size) {
                    position = pretendent % size;
                    if (position >= index) break;
                }
                if (slots[position] == value) {
                    return position;
                }
            }
            count--;
        }

        return -1;
    }
}
public class AdditionalHashTable
{
    public int size;
    public int step;
    private int amount = 0;
    public String [] slots;

    public AdditionalHashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    // 8-4 hashFunctions
    public int hashFun(String value)
    {
        return value.length() % size;
    }

    public int hashFun2(String value)
    {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += (int) value.charAt(i);
        }

        return sum % size;
    }

    // 8-3 increase
    public void increase(){
        String[] oldSlots = slots;
        int oldSize = size;

            size = oldSize * 2;
            slots = new String[size];

            for (int i = 0; i < oldSize; i++) {
                put(oldSlots[i]);
            }
    }

    public int seekSlot(String value)
    {
        int count = step;
        int index = hashFun(value);
        if (slots[index] == null) {
            return index;
        }
        index = hashFun2(value);

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
            amount++;
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
        index = hashFun2(value);

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

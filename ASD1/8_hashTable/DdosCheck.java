public class DdosCheck {
    public int size;
    public int step;
    boolean withSalt;
    public String [] slots;
    final statc int SALT_NUMBER_ONE = 42;

    public DdosCheck(int sz, int stp, boolean ws)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        withSalt = ws;
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        String salt = addSalt(value);
        String saltWithValue = salt + value;
        String finalStr = withSalt ? saltWithValue : value;
        int sum = 0;
        for (int i = 0; i < finalStr.length(); i++) {
            sum += (int) finalStr.charAt(i);
        }

        return sum % size;
    }

    public String addSalt(String value){
        return String.valueOf(SALT_NUMBER_ONE - value.length() + 13);
    }

    public int seekSlot(String value)
    {
        int index = hashFun(value);
        if (slots[index] == null) {
            return index;
        }

        int count = step;
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

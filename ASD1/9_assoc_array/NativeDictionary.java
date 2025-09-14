import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String value)
    {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            sum += (int) value.charAt(i);
        }
        int resultHashFun = sum % size;

        int index = resultHashFun;
        if (slots[index] == null || slots[index] == value) {
            return index;
        }

        index = index == size - 1 ? 0 : index + 1;

        for (;index != resultHashFun;) {
            if (slots[index] == null || slots[index] == value) {
                return index;
            }
            index = index == size - 1 ? 0 : index + 1;
        }

        return - 1;
    }

    // 9-3 isKey
    public boolean isKey(String key)
    {
        for (String slotKey : slots){
            if (key == slotKey) {
                return true;
            }
        }
        return false;
    }

    // 9-3 put
    public void put(String key, T value)
    {
        int index = hashFun(key);
        if (index >=0){
            slots[index] = key;
            values[index] = value;
        }
    }

    // 9-3 get
    public T get(String key)
    {
        if (!isKey(key)) {
            return null;
        }

        int index = hashFun(key);
        return values[index];
    }
}




//11-3 CountBlumFilter
public class CountBlumFilter {
    public int filter_len;
    public int[] bitArray;

    public CountBlumFilter(int f_len)
    {
        filter_len = f_len;
        bitArray = new int[f_len];
    }

    public int hash1(String str1)
    {
        int magicNumber = 17;
        int result = 0;
        for(int i=0; i < str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            result = (code + magicNumber * result) % filter_len;
        }

        return result;
    }
    public int hash2(String str1)
    {
        int magicNumber = 223;
        int result = 0;
        for(int i=0; i < str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            result = (code + magicNumber * result) % filter_len;
        }

        return result;
    }

    public void add(String str1)
    {
        int index1 = hash1(str1);
        int index2 = hash1(str1);

        setBit(index1);
        setBit(index2);
    }

    public void delete(String str1) {
        int index1 = hash1(str1);
        int index2 = hash1(str1);

        unsetBit(index1);
        unsetBit(index2);
    }

    public void unsetBit(int index){
        bitArray[index] -= 1;
    }

    public void setBit(int index){
        bitArray[index] += 1;
    }

    public boolean hasBit(int index){
        return bitArray[index] > 0;
    }

    public boolean isValue(String str1)
    {
        int index1 = hash1(str1);
        int index2 = hash1(str1);

        return hasBit(index1) && hasBit(index2);
    }
}

//11-4 Методом подбора

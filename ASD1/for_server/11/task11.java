public class BloomFilter
{
    public int filter_len;
    public int bitArray;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        bitArray = 0;
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

    public void setBit(int index){
        int pos = 1 << index;
        bitArray = bitArray | pos;
    }

    public boolean hasBit(int index){
        int pos = 1 << index;
        return (pos & bitArray) != 0;
    }

    public boolean isValue(String str1)
    {
        int index1 = hash1(str1);
        int index2 = hash1(str1);

        return hasBit(index1) && hasBit(index2);
    }
}


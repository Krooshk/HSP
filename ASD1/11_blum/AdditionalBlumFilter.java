import java.util.List;

public class AdditionalBlumFilter extends BloomFilter {
    AdditionalBlumFilter(int size){
        super(size);
    }

    // 11-2 unionFilter
    public void unionFilter(List<BloomFilter> list){
        for (BloomFilter filter: list) {
            bitArray = bitArray | filter.bitArray;
        }
    }
}

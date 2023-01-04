package aki.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterT {
    BloomFilter<Integer> friends =
            BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);
}

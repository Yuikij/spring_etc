package aki.cs.cs61b.class9;

import java.util.Arrays;

/**
 * 用值表示父级的下标，-1为根元素
 */
public class QuickUnionDS implements DisjointSets{
    private int[] parent;

    public QuickUnionDS(int num) {
        parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = -1;
        }
    }

    /**
     * 根据下标找到根元素
     */
    private int find(int p) {
        while (parent[p] >= 0) {
            p = parent[p];
        }
        return p;
    }

    /**
     * 连接，找到两个元素的父节点，将其中一个指向另一个
     */
    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j= find(q);
        parent[i] = j;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        QuickUnionDS quickUnionDS = new QuickUnionDS(5);
        System.out.println(Arrays.toString(quickUnionDS.parent));
        quickUnionDS.connect(1,3);
        System.out.println(Arrays.toString(quickUnionDS.parent));
    }
}

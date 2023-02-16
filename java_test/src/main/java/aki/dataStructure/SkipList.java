package aki.dataStructure;

public class SkipList<T>{

    private SkipNode header;

    private SkipNode data;

    private class SkipNode {
        int key;
        T value;
        SkipNode[] next;
    }

    public SkipList() {

    }

    public T get(int key) {
        return null;
    }

    public boolean insert(int key,T v) {

        return false;
    }

}

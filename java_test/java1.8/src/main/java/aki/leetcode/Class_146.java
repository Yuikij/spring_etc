package aki.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

//LUR
public class Class_146 {
    class Node {
        Node prev;
        Node next;
        Integer value;
        Integer key;

        public Node(Integer value, Integer key) {
            this.value = value;
            this.key = key;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();
    Node header;
    Node tail;
    int size;
    int capacity;


    public Class_146(int capacity) {
        this.capacity = capacity;
        size = 0;

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        Node prev = node.prev;

        if (prev != null) {
            if (node.next == null) {
                tail = prev;
            }
            node.prev = null;
            prev.next = node.next;
            if (node.next!=null){
                node.next.prev=prev;
            }
            node.next = header;
            header.prev = node;
            header = node;
        }

        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(value, key);
        Node mapNode = map.get(key);
        if (mapNode != null) {
            mapNode.value = value;
            get(key);
            return;
        }
        if (tail == null) {
            header = tail = node;
            map.put(key, node);
            return;
        }

        node.next = header;
        header.prev = node;
        header = node;


        if (map.size() == capacity) {
            Integer tailKey = this.tail.key;
            map.remove(tailKey);
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
        }
        map.put(key, node);
    }

    //[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
    public static void main(String[] args) {
        Class_146 class146 = new Class_146(3);
        class146.put(1,1);
        class146.put(2, 2);
        class146.put(3, 3);
        class146.put(4, 4);
        System.out.println(class146.get(4));
        System.out.println(class146.get(3));
        System.out.println(class146.get(2));
        System.out.println(class146.get(1));
        class146.put(5, 5);
        System.out.println(class146.get(1));
        System.out.println(class146.get(2));
        System.out.println(class146.get(3));
        System.out.println(class146.get(4));
        System.out.println(class146.get(5));

    }
}

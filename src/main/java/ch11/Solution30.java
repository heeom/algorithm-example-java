package ch11;

public class Solution30 {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 1);
        myHashMap.get(1);
        myHashMap.get(3);
    }

    public static class Node {
        private int key;
        private int value;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static class MyHashMap {

        Node [] map;

        public MyHashMap() {
            this.map = new Node[10000];
        }

        public void put(int key, int value) {
            int idx = key % map.length;
            if (map[idx] == null) {
                map[idx] = new Node(key, value);
                return;
            }
            Node node = map[idx];
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                if (node.next == null) {
                    break;
                }
                node = node.next;
            }
            node.next = new Node(key, value);
        }

        public int get(int key) {
            int idx = key % map.length;
            if (map[idx] == null) {
                return -1;
            }
            Node node = map[idx];
            while (node != null) {
                if (node.key == key) {
                    return node.value;
                }
                node = node.next;
            }
            return -1;
        }

        public void remove(int key) {
            int idx = key % map.length;
            if (map[idx] == null) {
                return;
            }
            Node node = map[idx];
            // 첫번째 노드일 때
            if (node.key == key) {
                map[idx] = node.next; // node.next를 Head로 변경
                return;
            }

            // 첫번째 노드가 아닐때
            Node prev = node;
            while (node != null) {
                if (node.key == key) {
                    prev.next = node.next;
                    return;
                }
                prev = node;
                node = node.next;
            }
        }
    }
}

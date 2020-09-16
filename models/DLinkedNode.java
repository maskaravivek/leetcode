package models;

public class DLinkedNode {
    public int key;
    public int val;
    public DLinkedNode next;
    public DLinkedNode previous;

    public DLinkedNode() {

    }

    public DLinkedNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

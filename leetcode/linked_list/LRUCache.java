package leetcode.linked_list;

import java.util.Hashtable;

import models.DLinkedNode;

public class LRUCache {
    Hashtable<Integer, DLinkedNode> cache;

    int count;
    int capacity;

    DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        cache = new Hashtable<>();

        head = new DLinkedNode();
        head.previous = null;

        tail = new DLinkedNode();
        tail.next = null;
        head.next = tail;
        tail.previous = head;
    }

    private void addNode(DLinkedNode node) {
        node.previous = head;
        node.next = head.next;

        head.next.previous = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        DLinkedNode previous = node.previous;
        DLinkedNode next = node.next;

        previous.next = next;
        next.previous = previous;
    }

    private void moveNodeToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTail() {
        DLinkedNode previous = tail.previous;
        this.removeNode(previous);
        return previous;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        this.moveNodeToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            this.addNode(newNode);
            cache.put(key, newNode);
            count++;

            if (count > capacity) {
                DLinkedNode staleNode = this.popTail();
                cache.remove(staleNode.key);
                --count;
            }
        } else {
            node.val = value;
            this.moveNodeToHead(node);
        }
    }
}

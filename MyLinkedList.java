public class MyLinkedList {
    public ListNode head;

    public void append(int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(data);
    }

    public void prepend(int data) {
        ListNode newHead = new ListNode(data);
        newHead.next = head;
        head = newHead;
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.val == data) {
            head = head.next;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

    }
}
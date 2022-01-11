package FastAndSlowPointers;

//Given the head of a LinkedList with a cycle, find the length of the cycle.
public class LengthOfCycle {

    //TC: O[n], SC: O[1]
    public static int findLengthOfCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = head.next;
            fast = head.next.next;
            while (slow == fast) {
                calculateLength(slow);
            }
        }
        return 0;
    }

    public static int calculateLength(ListNode head) {
        int length = 0;
        ListNode curr = head;
        do {
            curr = curr.next;
            length++;
        } while (curr != head);
        return length;
    }
}

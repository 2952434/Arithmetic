package leetcode.year23.month07;

import until.ListNode;

/**
 * @Author: Ljx
 * @Date: 2023/7/30 22:38
 * @role:
 */
public class 环形链表II {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || slow == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}

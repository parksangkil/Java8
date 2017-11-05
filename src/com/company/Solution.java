package com.company;

import java.util.Stack;

public class Solution {
    public static void main(String... args) {
        /*ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode result = addTwoNumbers(l1, l4);
        System.out.println("result => " + result.val);*/

        /*LinkedListNode l1 = new LinkedListNode(3);
        LinkedListNode l2 = new LinkedListNode(5);
        LinkedListNode l3 = new LinkedListNode(8);
        LinkedListNode l4 = new LinkedListNode(5);
        LinkedListNode l5 = new LinkedListNode(10);
        LinkedListNode l6 = new LinkedListNode(2);
        LinkedListNode l7 = new LinkedListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        LinkedListNode result = partition(l1, 5);
        System.out.println("result => " + result.data); */

        /*LinkedListNode l1 = new LinkedListNode(0);
        LinkedListNode l2 = new LinkedListNode(1);
        LinkedListNode l3 = new LinkedListNode(2);
        LinkedListNode l4 = new LinkedListNode(1);
        LinkedListNode l5 = new LinkedListNode(0);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        System.out.println("result => " + isPalindromeNew(l1));*/

        LinkedListNode l1 = new LinkedListNode(0);
        LinkedListNode l2 = new LinkedListNode(1);
        LinkedListNode l3 = new LinkedListNode(2);
        LinkedListNode l4 = new LinkedListNode(3);
        LinkedListNode l5 = new LinkedListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l3;

        System.out.println("result => " + FindBeginning(l1).data);
    }

    //순환 연결 리스트(circular linked list)
    public static LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    //

    //LinkedList 회문
    static boolean isPalindromeNew(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack stack = new Stack();

        while ( fast != null && fast.next != null ) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while ( slow != null ) {
            int top = (int)stack.pop();
            if (top != slow.data) return false;
            slow = slow.next;
        }
        return true;
    }

    static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    static LinkedListNode reverseAndClone(LinkedListNode node) {
        LinkedListNode head = null;
        while (node != null) {
            LinkedListNode n = new LinkedListNode(node.data);
            n.next = head;
            head = n;
            node = node.next;
        }
        return head;
    }

    static boolean isEqual(LinkedListNode one, LinkedListNode two) {
        while (one != null && two != null) {
            if (one.data != two.data) return false;
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }
    //

    public static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while ( node != null ) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

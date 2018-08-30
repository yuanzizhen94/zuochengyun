package zuochengyun_123;

import java.util.Stack;

/*
判断一个链表是否为回文结构
【题目】 给定一个链表的头节点head， 请判断该链表是否为回
文结构。 例如： 1->2->1， 返回true。 1->2->2->1， 返回true。
15->6->15， 返回true。 1->2->3， 返回false。
进阶： 如果链表长度为N， 时间复杂度达到O(N)， 额外空间复杂
度达到O(1)。
 */
public class Code_11_IsPalindromeList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //遍历链表然后压栈，然后再次遍历链表，判断链表的值是否与出栈的值相等
    public static boolean IsPalindrome1(Node head) {
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //找到链表的中间位置，然后把后面的元素全部压栈，然后对比链表从头到中点位置是否与出栈的元素相等
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        while (!stack.isEmpty()) {
            if (stack.pop().value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {//寻找中间节点
            n1 = n1.next;//n1指向中间节点
            n2 = n2.next.next;//n2指向末尾节点
        }
        n2 = n2.next;//n2指向右边第一个节点
        n1.next = null;//mid.next->null
        Node n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}

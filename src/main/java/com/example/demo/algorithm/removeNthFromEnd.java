package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author czy
 * @description
 * @date 2023/8/18
 */
public class removeNthFromEnd {


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //原有的链表基础上再添加一个头结点
        ListNode tmp = new ListNode(0, head);
        //快指针
        ListNode cur = head;
        //慢指针
        ListNode pre = tmp;
        //存储的是原有基础上添加了头结点的链表

        //通过循环把快指针先指到n的位置去，此时，快指针和慢指针中间的距离，就是目标元素到最后一个节点的距离
        for (int i = 0; i < n; i++) {
            cur = cur.next;
        }
        //快慢指针一起动，直到快的指针指到了最后一个元素，那么 此时慢指针肯定 处于目标元素前面的一个节点（因为tmp在原有的头结点前面加了一个节点），指向的下个节点是目标节点
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        //然后把慢指针指向的的下一个目标节点，往后挪一个，就达到了删除目标节点的目的
        pre.next = pre.next.next;
        //舍弃掉我们刚开始 多加的一个头节点
        ListNode node = tmp.next;
        return node;
    }
}























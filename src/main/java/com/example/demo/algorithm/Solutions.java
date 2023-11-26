package com.example.demo.algorithm;

/**
 * @author czy
 * @summary
 * 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 *
 * @date 2023-11-25 17:56
 */
public class Solutions {

    public ListNode swapPairs(ListNode head) {
        //实例化一个头节点,把他置于联表最前面
        ListNode pre = new ListNode(0);
        pre.next = head;
        //实例化一个临时节点
        ListNode temp = pre;
        //一直到临时节点挪到  下个节点没有（联表偶数个）或者后面只剩一个节点的时候结束（奇数个）
        while (temp.next!=null && temp .next.next !=null){
            //第一个节点
            ListNode start = temp.next;
            //第二个节点
            ListNode end = temp.next.next;
            //临时节点的下个节点从第一个节点变成了第二个 、 第一个节点的下个节点变成了第三个，第二个的下个节点变成了第一个，这样就实现了第一个节点和第二个节点互换位置
            temp.next = end;
            start.next = end.next;
            end.next = start;
            //把临时节点往前挪动两位到第二节点上，然后对第3、4节点进行重复操作
            temp = start;
        }
        return pre.next;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}





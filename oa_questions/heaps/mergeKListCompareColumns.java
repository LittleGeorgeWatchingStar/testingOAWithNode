public ListNode mergeKLists(ListNode[] lists) {
    int min_index = 0;
    ListNode head = new ListNode(0);
    ListNode h = head;
    while (true) {
        boolean isBreak = true;//标记是否遍历完所有链表
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                //找出最小下标
                if (lists[i].val < min) {
                    min_index = i;
                    min = lists[i].val;
                }
                //存在一个链表不为空，标记改完 false
                isBreak = false;
            }

        }
        if (isBreak) {
            break;
        }
        //加到新链表中
        ListNode a = new ListNode(lists[min_index].val);
        h.next = a;
        h = h.next;
        //链表后移一个元素
        lists[min_index] = lists[min_index].next;
    }
    h.next = null;
    return head.next;
}

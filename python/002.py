class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        res = ListNode(0)
        cur = res
        add = 0
        
        while l1 or l2 or add:
            val = (l1.val if l1 else 0) + (l2.val if l2 else 0) + add
            add = val // 10
            cur.next = ListNode(val % 10)
            cur = cur.next
            l1 = l1.next if l1 else None;
            l2 = l2.next if l2 else None;
        
        return res.next
        

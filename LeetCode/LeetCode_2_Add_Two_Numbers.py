class Solution:
    def add_two_numbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        l1_str: str = ''
        l2_str: str = ''
        while l1 is not None or l2 is not None:
            if l1 is not None:
                l1_str += str(l1.val)
                l1 = l1.next
            if l2 is not None:
                l2_str += str(l2.val)
                l2 = l2.next

        l1_int: int = int(''.join(reversed(l1_str)))
        l2_int: int = int(''.join(reversed(l2_str)))

        answer_str: str = ''.join(reversed(str(l1_int + l2_int)))

        answer: ListNode = ListNode()
        cur_node: ListNode = ListNode()
        for idx, num in enumerate(answer_str):
            if idx == 0:
                answer = ListNode(num)
                cur_node = answer
            else:
                new_node: ListNode = ListNode(num)
                if cur_node.next is not None:
                    cur_node = cur_node.next
                cur_node.next = new_node
        return answer

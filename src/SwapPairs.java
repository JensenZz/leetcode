public class SwapPairs {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode temp = swapPairs(head);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode swapPairs(ListNode head) {
        int count = 1;
        ListNode temp = head;
        ListNode preTemp = head;
        while (temp != null && temp.next != null) {
            //swap
            ListNode tempNode = temp.next;
            temp.next = tempNode.next;
            tempNode.next = temp;
            //record head
            if (count == 1) {
                head = tempNode;
            } else {
                preTemp.next = tempNode;
            }
            count++;
            preTemp = tempNode.next;
            temp = temp.next;
        }
        return head;
    }
}

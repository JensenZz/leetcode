/**
 * <p>Title: 类的名称</p>
 * <p>Description: 类的实现描述<p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company:个推 </p>
 *
 * @author JensenZz
 * @version 1.0
 * @date 2018/5/22
 */

public class TwoAdd {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode1 = null;
        ListNode listNode2 = null;
        ListNode result = null;
        ListNode next = null;
        int addNum = 0;
        int count = 1;

        do {
            int a;
            if (count == 1) {
                a = l1.val + l2.val;
                if (a >= 10) {
                    addNum = 1;
                    a = a % 10;
                }
                result = new ListNode(a);
                listNode1 = l1;
                listNode2 = l2;
                next = result;
            } else {
                a = (listNode1 == null ? 0 : listNode1.val) + (listNode2 == null ? 0 : listNode2.val) + addNum;
                if (a >= 10) {
                    addNum = 1;
                    a = a % 10;
                } else {
                    addNum = 0;
                }
                next.next = new ListNode(a);
                next = next.next;
            }
            if (null != listNode1) {
                listNode1 = listNode1.next;
            }
            if (null != listNode2) {
                listNode2 = listNode2.next;
            }
            count++;
        } while (null != listNode1 || null != listNode2);

        if (addNum == 1) {
            next.next = new ListNode(1);
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(5);
//        ListNode a2 = new ListNode(4);
//        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(5);
//        ListNode a5 = new ListNode(6);
//        a2.next = a3;
//        a1.next = a2;
//        a4.next = a5;


        ListNode aa = addTwoNumbers(a1, a4);
        do {
            System.out.println(aa.val);

        } while ((aa = aa.next) != null);

    }
}

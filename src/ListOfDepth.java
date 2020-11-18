import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfDepth {


    public static void main(String[] args) {
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode4.left = treeNode8;
        treeNode2.left = treeNode4;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.right = treeNode7;
        treeNode2.right = treeNode5;

        ListNode[] zz=  listOfDepth(treeNode1);


    }

    static Map<Integer, ListNode> res = new HashMap<>();

    public static ListNode[] listOfDepth(TreeNode tree) {
        traverse(tree, 1);
        List<ListNode> collect = new ArrayList<>(res.values());
        return collect.toArray(new ListNode[collect.size()]);
    }

    public static void traverse(TreeNode root, int dep) {
        if (root == null) {
            return;
        }
        if (res.containsKey(dep)) {
            ListNode listNode = res.get(dep);
            while (listNode.next != null) {
                listNode = listNode.next;
            }
            listNode.next = new ListNode(root.val);
        } else {
            res.put(dep, new ListNode(root.val));
        }
        int nextDep = dep + 1;
        traverse(root.left, nextDep);
        traverse(root.right, nextDep);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}

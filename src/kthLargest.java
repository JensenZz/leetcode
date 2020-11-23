import java.util.ArrayList;
import java.util.List;

public class kthLargest {
    List<Integer> integers = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        traverse(root);
        return integers.get(integers.size() - k);

    }


    void traverse(TreeNode root) {
        if (root == null) return;
        // 前序遍历
        traverse(root.left);
        integers.add(root.val);
        traverse(root.right);
        // 后序遍历
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

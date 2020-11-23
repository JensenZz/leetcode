import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {

    List<Integer> aa = new ArrayList<>();
    TreeNode newtree = new TreeNode();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        traverse(root);
        newtree.val = aa.get(0);
        TreeNode index = newtree;

        for (int i = 1; i < aa.size(); i++) {
            index.right = new TreeNode(aa.get(i));
            index = index.right;
        }
        return newtree;
    }

    void traverse(TreeNode root) {
        if (root == null) return;
        // 前序遍历
        traverse(root.left);
        aa.add(root.val);
        traverse(root.right);
        // 后序遍历
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

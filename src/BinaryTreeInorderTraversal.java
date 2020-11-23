import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    List<Integer> integers = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return integers;
        inorderTraversal(root.left);
        integers.add(root.val);
        inorderTraversal(root.right);
        return integers;
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

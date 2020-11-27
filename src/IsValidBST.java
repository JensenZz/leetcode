import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    List<Integer> integers = new ArrayList<>();
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {

        traverse(root);
        return flag;
    }

    void traverse(TreeNode root) {
        if (root == null) return;
        // 前序遍历
        traverse(root.left);
        // 使用中序遍历从小到大排序 判断后面的数字要比当前数字大才可以
        if (integers.size() != 0 && integers.get(integers.size() - 1) >= root.val) {
            flag = false;
            return;
        }
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

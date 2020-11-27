import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DelNodes {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> collect = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        TreeNode treeNode = dfs(root, collect);
        if (treeNode != null) {
            treeNodes.add(treeNode);
        }
        return treeNodes;
    }

    List<TreeNode> treeNodes = new ArrayList<>();

    public TreeNode dfs(TreeNode root, Set<Integer> to_delete) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left, to_delete);
        TreeNode right = dfs(root.right, to_delete);
        root.left = left;
        root.right = right;
        if (to_delete.contains(root.val)) {
            if (root.left != null) {
                treeNodes.add(root.left);
            }
            if (root.right != null) {
                treeNodes.add(root.right);
            }
            return null;
        }

        return root;
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

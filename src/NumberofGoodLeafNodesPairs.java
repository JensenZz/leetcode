import java.util.ArrayList;
import java.util.List;

public class NumberofGoodLeafNodesPairs {
    private int ans = 0;

    public int countPairs(TreeNode root, int distance) {
        traverse(root,distance);

        return ans;

    }

    List<Integer> traverse(TreeNode root, int distance) {
        if (root == null) return new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root.left == null && root.right == null) {
            temp.add(0);
            return temp;
        }
        // 前序遍历 存储左子树的节点到本节点的距离
        List<Integer> left = traverse(root.left, distance);
        for (Integer integer : left) {
            integer++;
            temp.add(integer);
        }
        List<Integer> right = traverse(root.right, distance);
        for (Integer integer : right) {
            integer++;
            temp.add(integer);
        }
        //对左右比对 左边到本节点的距离+右边到本节点距离+本身2各节点 《=距离
        for (Integer integer : right) {
            for (Integer integer1 : left) {
                if (integer + integer1 + 2 <= distance) {
                    ans++;
                }
            }
        }
        return temp;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelOrderTree {

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

        levelOrder(treeNode1);


    }



    public static List<List<Integer>> levelOrder(TreeNode tree) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        traverse(tree, 1,res);
        List<List<Integer>> collect = new ArrayList<>(res.values());
        return collect;
    }

    public static void traverse(TreeNode root, int dep,Map<Integer, List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.containsKey(dep)) {
            res.get(dep).add(root.val);
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.put(dep, temp);
        }
        int nextDep = dep + 1;
        traverse(root.left, nextDep,res);
        traverse(root.right, nextDep,res);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}

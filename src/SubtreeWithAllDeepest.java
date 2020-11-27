import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubtreeWithAllDeepest {

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.right = treeNode1;
        treeNode3.left = treeNode5;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;


        subtreeWithAllDeepest(treeNode3);
    }


    static Map<TreeNode, Integer> depth = new HashMap<>();
    static int dep = 1;


    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        //利用dfs 先找出所有的叶子节点的深度
        dfs(root, dep);
        //获取最大深度
        List<TreeNode> aa = new ArrayList<>();
        Integer maxd = depth.values().stream().max(Integer::compareTo).get();
        //再找出所有最大的深度的叶子节点
        for (Map.Entry<TreeNode, Integer> treeNodeIntegerEntry : depth.entrySet()) {
            if (treeNodeIntegerEntry.getValue().equals(maxd)) aa.add(treeNodeIntegerEntry.getKey());
        }
        if (aa.size() == 1) {
            return aa.get(0);
        }
        //再利用最小公共父亲的方式 遍历即可
        TreeNode treeNode = subtreeWithAllDeepest(root, aa);
        System.out.println(treeNode.val);
        return treeNode;
    }


    public static void dfs(TreeNode node, int dep) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            depth.put(node, dep);
        }
        int nextDep = dep + 1;
        dfs(node.left, nextDep);
        dfs(node.right, nextDep);
    }


    public static TreeNode subtreeWithAllDeepest(TreeNode root, List<TreeNode> treeNodes) {
        if (root == null) return null;
        //有任意一个节点与root相等 就返回root
        for (TreeNode treeNode : treeNodes) {
            if (root == treeNode) return root;
        }
        TreeNode left = subtreeWithAllDeepest(root.left, treeNodes);
        TreeNode right = subtreeWithAllDeepest(root.right, treeNodes);
        //左右子树都不为空说明这个节点就是最小父节点
        if (null != left && null != right) return root;
        if (null == left && null == right) return null;
        //返回左右节点一个即可
        return left == null ? right : left;
    }


    public static class TreeNode {
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

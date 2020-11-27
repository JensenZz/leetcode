import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, LinkedList<Integer>> res = new HashMap<>();
        traverse(root, 1, res);
        return new ArrayList<>(res.values());
    }


    void traverse(TreeNode root, int dep, Map<Integer, LinkedList<Integer>> res) {
        if (root == null) return;
        if (res.containsKey(dep)) {
            if (dep % 2 == 1) {
                res.get(dep).add(root.val);
            } else {
                res.get(dep).addFirst(root.val);
            }
        } else {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(root.val);
            res.put(dep, temp);
        }
        int nextDep = dep + 1;
        traverse(root.left, nextDep, res);
        traverse(root.right, nextDep, res);
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

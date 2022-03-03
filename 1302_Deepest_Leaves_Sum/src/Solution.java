import java.util.ArrayList;

class Solution {

    int maxDepth = 0;
    ArrayList<Integer> values = new ArrayList<Integer>();

    public void findNode(TreeNode node, int depth) {
        if (node == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            values = new ArrayList<Integer>();
            values.add(node.val);
        }
        else if (depth == maxDepth) values.add(node.val);

        findNode(node.left, depth + 1);
        findNode(node.right, depth + 1);
    }

    public int deepestLeavesSum(TreeNode root) {

        values.add(root.val);
        findNode(root.left, 1);
        findNode(root.right, 1);

        int sum = 0;
        for (int value : values) sum += value;
        return sum;
    }
}
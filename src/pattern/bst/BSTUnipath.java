package pattern.bst;

public class BSTUnipath {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        int counter = 0;
        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) return 0;
            isUni(root);
            return counter;
        }
        boolean isUni(TreeNode root) {
            if (root.left == null && root.right == null) {
                counter++;
                return true;
            }
            boolean left = true, right = true;
            if (root.left != null) {
                left = isUni(root.left) && root.val == root.left.val;
            }
            if (root.right != null) {
                right = isUni(root.right) && root.val == root.right.val;
            }

            if (left && right) counter++;

            return left && right;
        }
}

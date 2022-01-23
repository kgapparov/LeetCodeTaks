package pattern.bst;

public class BST_Merge_LeetCode617 {
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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            }
            TreeNode newRoot;
            if (root1 == null)
                newRoot = root2;
            else if (root2 == null)
                newRoot = root1;
            else
                newRoot = new TreeNode(root1.val + root2.val);

            if (root1 == null) {
                newRoot.left = mergeTrees(root1, root2.left);
                newRoot.right = mergeTrees(root1, root2.right);
            } else if (root2 == null) {
                newRoot.left = mergeTrees(root1.left, root2);
                newRoot.right = mergeTrees(root1.right, root2);
            } else {
                newRoot.left = mergeTrees(root1.left, root2.left);
                newRoot.right = mergeTrees(root1.right, root2.right);
            }
            return newRoot;
        }
}

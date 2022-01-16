package pattern.bst;

import java.util.HashMap;

public class ConstructBSTInorderPreorder {
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
        public TreeNode buildTree(int[] preorder, int[] inorder)
        {
            int n = inorder.length;
            if (n == 0) return null;
            HashMap<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < n; i++)
            {
                inorderMap.put(inorder[i], i);
            }
            return  buildTreeDFS(inorderMap, 0, n, preorder, 0, n);
        }

    private TreeNode buildTreeDFS(HashMap<Integer, Integer> inorderMap, int i1, int i2, int[] preorder, int p1, int p2)
    {
        if (i1 >= i2 || p1 >= p2) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p1]);
        int rootIndex = inorderMap.get(preorder[p1]);
        int offset = rootIndex - i1;
        root.right = buildTreeDFS(inorderMap, i1+offset+1, i2, preorder, p1+1, p2);
        root.left = buildTreeDFS(inorderMap, i1, i1 + offset, preorder, p1+1, p1 + offset);
        return root;
    }

    private void print(TreeNode root) {

    }
    public static void main(String[] args) {
        ConstructBSTInorderPreorder test = new ConstructBSTInorderPreorder();
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        TreeNode root = test.buildTree(preorder, inorder);
    }
}

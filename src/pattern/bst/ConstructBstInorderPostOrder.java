package pattern.bst;


import java.util.HashMap;

public class ConstructBstInorderPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) return null;
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeDFS(inorderMap, 0, n, postorder, 0, n);
    }
    public TreeNode buildTreeDFS(HashMap<Integer, Integer> inorder, int i1, int i2, int[] postorder, int p1, int p2) {
        if (i1 >= i2 || p1 >= p2) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[p2-1]);
        int rootIndex = inorder.get(postorder[p2-1]);
        int diff = rootIndex - i1;
        TreeNode left = buildTreeDFS(inorder, i1, i1 + diff, postorder, p1, p1 + diff);
        TreeNode right = buildTreeDFS(inorder,i1 + diff+1, i2, postorder, p1 + diff, p2 - 1);
        return root;
    }
}

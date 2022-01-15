package pattern.bst;

import java.util.LinkedList;
import java.util.List;
/*
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).



Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]

Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class TraversalBST {
    static List<List<Integer>> ans = new LinkedList<>();

    public static  List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<TreeNode> treeList = new LinkedList<>();
        treeList.add(root);
        bfs(treeList);
        return ans;
    }
    static void bfs(List<TreeNode> children) {
        List<TreeNode> newChildren = new LinkedList<>();
        List<Integer> values = new LinkedList<>();
        children.stream().forEach(x -> {
            values.add(x.val);
            if (x.left != null) {
                newChildren.add(x.left);
            }
            if (x.right != null) {
                newChildren.add(x.right);
            }
        });
        ans.add(values);
        if (!newChildren.isEmpty()) bfs(newChildren);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        levelOrder(tree).forEach(System.out::println);
    }
}

package pattern.bst;

import java.util.ArrayList;
import java.util.List;

/*
113. Path Sum II
Medium

4150

99

Add to List

Share
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 */
public class PathSumII {
    private List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        preOrder(root, targetSum, new ArrayList<>() );
        return answer;
    }
    void preOrder(TreeNode root, int targetSum, List<Integer> path) {
        List<Integer> newPath = new ArrayList(path);
        if (root == null) return;

        if (root.left == null && root.right == null && root.val == targetSum) {
            answer.add(newPath);
        }

        newPath.add(root.val);
        preOrder(root.left, targetSum - root.val, newPath);
        preOrder(root.right, targetSum - root.val, newPath);
    }
}
